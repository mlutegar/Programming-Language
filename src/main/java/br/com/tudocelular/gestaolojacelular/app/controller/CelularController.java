package br.com.tudocelular.gestaolojacelular.app.controller;

import br.com.tudocelular.gestaolojacelular.domain.model.Celular;
import br.com.tudocelular.gestaolojacelular.service.CelularService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = "rh")
@Tag(name = "RH Controller", description = "Controladora que gere o cadastro de celulares")
public class CelularController {
    private final CelularService celularService;

    public CelularController(CelularService celularService){
        this.celularService = celularService;
    }

    @PostMapping(value = "/celular", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cadastra um celular", responses = {@ApiResponse(description = "Sucesso ao cadastrar", responseCode = "201", content = @Content)})
    ResponseEntity<Celular> save(@RequestBody Celular celular) {
        return new ResponseEntity<>(celularService.save(celular), CREATED);
    }

    @GetMapping(value = "/celular", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lista celulares", responses = {@ApiResponse(description = "Sucesso ao listar os celulares", responseCode = "200", content = @Content)})
    ResponseEntity<List<Celular>> findAll() {
        return new ResponseEntity<>(celularService.findAll(), OK);
    }

    @GetMapping(value = "/celular/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Localiza um celular pelo ID", responses = {@ApiResponse(description = "Sucesso ao consultar o celular", responseCode = "200", content = @Content)})
    ResponseEntity<Celular> findById(@PathVariable UUID id) {
        return new ResponseEntity<>(celularService.findById(id), OK);
    }

    @PutMapping(value = "/celular", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "atualiza um celular", responses = {@ApiResponse(description = "Sucesso ao atualizar", responseCode = "201", content = @Content)})
    ResponseEntity<?> update(@RequestBody Celular celular) {
        celularService.save(celular);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @DeleteMapping(value = "/celular/{id}")
    @Operation(summary = "Exclui um celular pelo ID", responses = {@ApiResponse(description = "Sucesso ao apagar o celular", responseCode = "204")})
    ResponseEntity<?> deleteById(@PathVariable UUID id) {
        celularService.deleteById(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
    @PatchMapping(value = "/celular/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualizar preço do celular", responses = {@ApiResponse(description = "Preço do produto celular", responseCode = "201", content = @Content)})
    ResponseEntity<?> updatePreco(@PathVariable UUID id, @RequestBody float preco) {
        celularService.update(id, preco);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
