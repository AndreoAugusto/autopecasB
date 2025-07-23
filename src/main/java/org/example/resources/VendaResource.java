package org.example.resources;

import org.example.entities.Vendas;
import org.example.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/vendas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VendaResource {

    @Autowired
    private VendaService service;

    @GetMapping
    public ResponseEntity<List<Vendas>> findAll() {
        List<Vendas> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vendas> findById(@PathVariable Long id) {
        Vendas obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Vendas> insert(@Valid @RequestBody Vendas obj) {
        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Vendas> update(@Valid @RequestBody Vendas obj, @PathVariable Long id) {
        obj.setId_venda(obj.getId_venda());
        service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteVendas(@PathVariable Long id) {
        service.deleteVendas(id);
        return ResponseEntity.noContent().build();
    }
}