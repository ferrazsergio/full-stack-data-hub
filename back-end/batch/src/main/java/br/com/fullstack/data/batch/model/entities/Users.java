package br.com.fullstack.data.batch.model.entities;
/*Este código define uma classe Java chamada Users, que representa uma entidade de usuário. A anotação @Document("Users") indica que essa classe será mapeada para um documento MongoDB com o nome "users".
A anotação @Id identifica o campo "id" como a chave primária do documento.
A classe Users possui seis campos de dados: id, firstName, lastName, email, mobile e salary, todos eles representando informações de um usuário. Há dois construtores para a classe, um sem argumentos e outro que inicializa todos os campos de dados.
Além disso, há getters e setters para todos os campos, permitindo o acesso e modificação dos dados de um usuário.
Essa classe é geralmente usada em conjunto com outras classes que lidam com o acesso e manipulação de dados no MongoDB, como um repositório que gerencia o acesso a um conjunto de documentos "Users".*/

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("users")
public class Users {
    @Id
    String id;

    String firstName;
    String lastName;
    String email;
    String mobile;
    String salary;
}
