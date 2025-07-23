package org.example.services;

import org.example.entities.Funcionarios;
import org.example.repositories.FornecedorRepository;
import org.example.repositories.FuncionarioRepository;
import org.example.services.exceptions.ResourceNotFoundException;
import org.example.services.exceptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionarios> findAll() {
        return repository.findAll();
    }

    public Funcionarios findById(Long id) {
        Funcionarios funcionarios = repository.findById(id).orElse(null);
        if (funcionarios == null) {
            throw new ResourceNotFoundException(id);
        }
        return funcionarios;
    }

    public Funcionarios insert(Funcionarios obj) {
        try {
            return obj = repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Funcionarios update(Long id, Funcionarios obj) {
        try {
            Funcionarios funcionarios = findById(id);

            funcionarios.setNome_func(obj.getNome_func());
            funcionarios.setCpf_func(obj.getCpf_func());
            funcionarios.setTelefone_func(obj.getTelefone_func());
            funcionarios.setEmail_func(obj.getEmail_func());

            return repository.save(funcionarios);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteFuncionarios(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
