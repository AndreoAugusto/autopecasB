package org.example.services;

import org.example.entities.Fornecedores;
import org.example.repositories.ClienteRepository;
import org.example.repositories.FornecedorRepository;
import org.example.services.exceptions.ResourceNotFoundException;
import org.example.services.exceptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedores> findAll() {
        return repository.findAll();
    }

    public Fornecedores findById(Long id) {
        Fornecedores fornecedores = repository.findById(id).orElse(null);
        if (fornecedores == null) {
            throw new ResourceNotFoundException(id);
        }
        return fornecedores;
    }

    public Fornecedores insert(Fornecedores obj) {
        try {
            return obj = repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Fornecedores update(Long id, Fornecedores obj) {
        try {
            Fornecedores fornecedores = findById(id);

            fornecedores.setNome_for(obj.getNome_for());
            fornecedores.setCnpj_for(obj.getCnpj_for());
            fornecedores.setTelefone_for(obj.getTelefone_for());
            fornecedores.setEmail_for(obj.getEmail_for());

            return repository.save(fornecedores);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteFornecedores(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
