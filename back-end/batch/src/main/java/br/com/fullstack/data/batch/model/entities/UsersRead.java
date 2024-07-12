package br.com.fullstack.data.batch.model.entities;
/*Esse código é responsável por mapear os dados de um arquivo JSON para uma lista de objetos da classe Users.
 * A classe Users_read possui um atributo do tipo ArrayList de Users, anotado com @JsonProperty("Users"),
 * indicando que o atributo será mapeado para a chave "Users" no arquivo JSON. A classe também possui os métodos getUsers e setUsers para acessar e alterar essa lista de usuários.
 * A anotação @JsonIgnoreProperties(ignoreUnknown = true) indica que propriedades desconhecidas no arquivo JSON não devem ser tratadas como erros.*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersRead {

    @JsonProperty("users")
    ArrayList<Users> users;

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }
}
