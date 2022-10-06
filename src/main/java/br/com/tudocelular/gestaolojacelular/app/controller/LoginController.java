package br.com.tudocelular.gestaolojacelular.app.controller;

import br.com.tudocelular.gestaolojacelular.domain.model.Login;
import br.com.tudocelular.gestaolojacelular.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = "auth")
@Tag(name = "Autenticação Controller", description = "Controladora que gere o login de login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cadastra um usuario", responses = {@ApiResponse(description = "Sucesso ao cadastrar", responseCode = "201", content = @Content)})
    ResponseEntity<Login> save(@RequestBody Login login) {
        return new ResponseEntity<>(loginService.save(login), CREATED);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Efetua o usuario de um login", responses = {@ApiResponse(description = "Sucesso ao efetuar o login", responseCode = "200", content = @Content)})
    ResponseEntity<Login> login(@RequestBody Login login) {
        return new ResponseEntity<>(loginService.login(login), OK);
    }

    @GetMapping(value = "/logoff/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Desconecta um usuario pelo ID", responses = {@ApiResponse(description = "Sucesso ao efetuar o logoff", responseCode = "204")})
    ResponseEntity<?> findById(@PathVariable UUID id) {
        loginService.logoff(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @PatchMapping(value = "/active/{id}")
    @Operation(summary = "atualiza um usuario", responses = {@ApiResponse(description = "Sucesso ao atualizar", responseCode = "204")})
    ResponseEntity<?> active(@PathVariable UUID id) {
        loginService.active(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @PatchMapping(value = "/disable/{id}")
    @Operation(summary = "atualiza um usuario", responses = {@ApiResponse(description = "Sucesso ao atualizar", responseCode = "204")})
    ResponseEntity<?> disable(@PathVariable UUID id) {
        loginService.disable(id);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Exclui um usuario pelo ID", responses = {@ApiResponse(description = "Sucesso ao apagar", responseCode = "204")})
    ResponseEntity<?> deleteById(@PathVariable UUID id) {
        loginService.deleteById(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
