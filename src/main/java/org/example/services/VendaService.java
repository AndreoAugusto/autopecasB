package org.example.services;

import org.example.entities.Vendas;
import org.example.repositories.FornecedorRepository;
import org.example.repositories.VendaRepository;
import org.example.services.exceptions.ResourceNotFoundException;
import org.example.services.exceptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public List<Vendas> findAll() {
        return repository.findAll();
    }

    public Vendas findById(Long id) {
        Vendas vendas = repository.findById(id).orElse(null);
        if (vendas == null) {
            throw new ResourceNotFoundException(id);
        }
        return vendas;
    }

    public Vendas insert(Vendas obj) {
        try {
            return obj = repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Vendas update(Long id, Vendas obj) {
        try {
            Vendas vendas = findById(id);

            vendas.setData_venda(obj.getData_venda());
            vendas.setTotal_venda(obj.getTotal_venda());
            vendas.setDesconto_venda(obj.getDesconto_venda());
            vendas.setFormaPagamento_venda(obj.getFormaPagamento_venda());

            return repository.save(vendas);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteVendas(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
