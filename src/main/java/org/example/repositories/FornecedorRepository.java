package org.example.repositories;

import org.example.entities.Clientes;
import org.example.entities.Fornecedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedores, Long> {
}
