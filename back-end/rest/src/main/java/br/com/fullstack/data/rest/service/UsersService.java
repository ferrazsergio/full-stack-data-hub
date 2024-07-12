package br.com.fullstack.data.rest.service;

import br.com.fullstack.data.rest.model.entities.Users;
import br.com.fullstack.data.rest.model.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository repository;

    @Autowired
    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public String saveUser(List<Users> users) {
        if (users.size() == 1) {
            repository.save(users.getFirst());
            return "Added user with id : " + users.getFirst().getId();
        } else {
            repository.saveAll(users);
            return "Added " + users.size() + " users";
        }
    }

    public List<Users> getUsers() {
        return repository.findAll();
    }

    public Optional<Users> getUserById(String id) {
        return repository.findById(id);
    }

    public String deleteUserById(String id) {
        repository.deleteById(id);
        return "User deleted with id : " + id;
    }
}
