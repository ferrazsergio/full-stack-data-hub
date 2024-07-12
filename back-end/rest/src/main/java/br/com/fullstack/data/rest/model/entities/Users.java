package br.com.fullstack.data.rest.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "users")
public class Users {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String salary;
}
