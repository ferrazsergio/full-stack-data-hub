package br.com.fullstack.data.rest.config;

import br.com.fullstack.data.rest.model.entities.Users;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface SwaggerConfig {

    @Operation(summary = "Cria um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping
    ResponseEntity<String> createUser(@RequestBody List<Users> users);

    @Operation(summary = "Retorna a lista de todos os usuários")
    @GetMapping
    ResponseEntity<List<Users>> getAllUsers();

    @Operation(summary = "Retorna um usuário específico pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<Users> getUserById(@PathVariable String id);

    @Operation(summary = "Deleta um usuário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteUserById(@PathVariable String id);
}
