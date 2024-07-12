package br.com.fullstack.data.rest.model.repository;

import br.com.fullstack.data.rest.model.entities.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String> {
}
