package br.com.fullstack.data.batch;

import br.com.fullstack.data.batch.model.entities.Users;
import br.com.fullstack.data.batch.model.entities.UsersRead;
import br.com.fullstack.data.batch.model.repository.UsersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@SpringBootApplication
public class BatchApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BatchApplication.class);

	// Injeção de dependência do repositório de usuários
	private final UsersRepository usersRepository;

	// Objeto ObjectMapper para fazer a serialização e desserialização de objetos JSON
	private final ObjectMapper objectMapper = new ObjectMapper();

	// Formatos de data e hora usados no código
	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Autowired
	public BatchApplication(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		deleteAllPreviousData();
		storeData();
		displayUserData();
		printOperationCompletionMessage();
	}

	private void deleteAllPreviousData() {
		usersRepository.deleteAll();
		logger.info("Deleted all previous data.");
	}

	private void storeData() throws Exception {
		String jsonPath = System.getenv("USER_JSON_PATH");
		ArrayList<Users> userList = loadUsersData(jsonPath);
        usersRepository.saveAll(userList);
		logger.info("Data stored successfully.");
	}

	private void displayUserData() {
		logger.info("Total number of users: {}", usersRepository.count());
		logger.info("List of users:");
		usersRepository.findAll().forEach(user -> logger.info("{}: {} {}", user.getId(), user.getFirstName(), user.getLastName()));
	}

	private void printOperationCompletionMessage() {
		LocalDateTime now = LocalDateTime.now();
		logger.info("Operation completed on {} at {}.", now.format(dateFormatter), now.format(timeFormatter));
	}

	private ArrayList<Users> loadUsersData(String local) throws Exception {
		UsersRead usersRead = objectMapper.readValue(new File(local), UsersRead.class);
		return usersRead.getUsers();
	}
}
