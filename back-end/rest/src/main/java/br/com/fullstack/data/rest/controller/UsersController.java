package br.com.fullstack.data.rest.controller;

import br.com.fullstack.data.rest.config.SwaggerConfig;
import br.com.fullstack.data.rest.model.entities.Users;
import br.com.fullstack.data.rest.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController implements SwaggerConfig {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @Override
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody List<Users> users) {
        String result = usersService.saveUser(users);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


    @Override
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = usersService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable String id) {
        Optional<Users> user = usersService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id) {
        String result = usersService.deleteUserById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
