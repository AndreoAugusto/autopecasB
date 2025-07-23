package org.example.services;

import org.example.entities.Clientes;
import org.example.repositories.ClienteRepository;
import org.example.services.exceptions.ResourceNotFoundException;
import org.example.services.exceptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Clientes> findAll() {
        return repository.findAll();
    }

    public Clientes findById(Long id) {
        Clientes clientes = repository.findById(id).orElse(null);
        if (clientes == null) {
            throw new ResourceNotFoundException(id);
        }
        return clientes;
    }

    public Clientes insert(Clientes obj) {
        try {
            return obj = repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Clientes update(Long id, Clientes obj) {
        try {
            Clientes clientes = findById(id);

            clientes.setNome_cli(obj.getNome_cli());
            clientes.setCpf_cli(obj.getCpf_cli());
            clientes.setTelefone_cli(obj.getTelefone_cli());
            clientes.setEmail_cli(obj.getEmail_cli());

            return repository.save(clientes);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteClientes(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
