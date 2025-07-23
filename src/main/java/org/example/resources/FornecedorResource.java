package org.example.resources;

import org.example.entities.Fornecedores;
import org.example.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/fornecedores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FornecedorResource {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<Fornecedores>> findAll() {
        List<Fornecedores> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Fornecedores> findById(@PathVariable Long id) {
        Fornecedores obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Fornecedores> insert(@Valid @RequestBody Fornecedores obj) {
        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Fornecedores> update(@Valid @RequestBody Fornecedores obj, @PathVariable Long id) {
        obj.setId_fornecedor(obj.getId_fornecedor());
        service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFornecedores(@PathVariable Long id) {
        service.deleteFornecedores(id);
        return ResponseEntity.noContent().build();
    }
}