package org.example.repositories;

import org.example.entities.Fornecedores;
import org.example.entities.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Vendas, Long> {
}
