package org.example.resources;

import org.example.entities.Funcionarios;
import org.example.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ResponseEntity<List<Funcionarios>> findAll() {
        List<Funcionarios> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionarios> findById(@PathVariable Long id) {
        Funcionarios obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Funcionarios> insert(@Valid @RequestBody Funcionarios obj) {
        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Funcionarios> update(@Valid @RequestBody Funcionarios obj, @PathVariable Long id) {
        obj.setId_funcionario(obj.getId_funcionario());
        service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFuncionarios(@PathVariable Long id) {
        service.deleteFuncionarios(id);
        return ResponseEntity.noContent().build();
    }
}