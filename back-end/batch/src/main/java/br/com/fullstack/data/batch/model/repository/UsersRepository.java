package br.com.fullstack.data.batch.model.repository;

import br.com.fullstack.data.batch.model.entities.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends MongoRepository<Users, String> {
    // Obter todos os usuários
    List<Users> findAll();

    // Obter um usuário pelo ID
    Optional<Users> findById(String id);

    // Obter usuários pelo firstName
    List<Users> findByFirstName(String firstName);

    // Obter usuários pelo lastName
    List<Users> findByLastName(String lastName);

    // Excluir um usuário pelo ID
    void deleteById(String id);
}
