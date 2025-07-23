package org.example.services;

import org.example.entities.Produtos;
import org.example.repositories.FornecedorRepository;
import org.example.repositories.ProdutoRepository;
import org.example.services.exceptions.ResourceNotFoundException;
import org.example.services.exceptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produtos> findAll() {
        return repository.findAll();
    }

    public Produtos findById(Long id) {
        Produtos produtos = repository.findById(id).orElse(null);
        if (produtos == null) {
            throw new ResourceNotFoundException(id);
        }
        return produtos;
    }

    public Produtos insert(Produtos obj) {
        try {
            return obj = repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Produtos update(Long id, Produtos obj) {
        try {
            Produtos produtos = findById(id);

            produtos.setNome_prod(obj.getNome_prod());
            produtos.setMarca_prod(obj.getMarca_prod());
            produtos.setQtde_prod(obj.getQtde_prod());
            produtos.setPreco_prod(obj.getPreco_prod());
            produtos.setDescricao_prod(obj.getDescricao_prod());

            return repository.save(produtos);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteProdutos(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
