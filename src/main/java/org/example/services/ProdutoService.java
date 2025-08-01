package org.example.services;

import org.example.entities.Fornecedores;
import org.example.entities.Produtos;
import org.example.repositories.FornecedorRepository;
import org.example.repositories.ProdutoRepository;
import org.example.services.exceptions.ResourceNotFoundException;
import org.example.services.exceptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Produtos> findAll() {
        return produtoRepository.findAll();
    }

    public Produtos findById(Long id) {
        Produtos produtos = produtoRepository.findById(id).orElse(null);
        if (produtos == null) {
            throw new ResourceNotFoundException(id);
        }
        return produtos;
    }


    public Produtos insert(Produtos obj) {
        try {
            Long id_fornecedor = (obj.getFornecedores() != null) ? obj.getFornecedores().getId_fornecedor() : null;

            if (id_fornecedor == null) {
                throw new IllegalArgumentException("fornecedor não informado.");
            }

            Fornecedores fornecedor = fornecedorRepository.findById(id_fornecedor)
                    .orElseThrow(() -> new ResourceNotFoundException(id_fornecedor));

            obj.setFornecedores(fornecedor);

            return produtoRepository.save(obj);

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

            if (obj.getFornecedores() != null && obj.getFornecedores().getId_fornecedor() != null)  {
                produtos.setFornecedores(
                        fornecedorRepository.findById(obj.getFornecedores().getId_fornecedor())
                                .orElseThrow(() -> new ResourceNotFoundException(obj.getFornecedores().getId_fornecedor()))
                );
            }

            return produtoRepository.save(produtos);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteProdutos(Long id) {
        try {
            produtoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
