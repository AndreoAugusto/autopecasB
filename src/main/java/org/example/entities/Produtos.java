package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id_produto;

    @ManyToMany(mappedBy = "produtos")
    private Set<Vendas> vendas;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedores fornecedores;

    @NotBlank(message = "Obrigatório preencher nome")
    @Size(max = 100, message = "Nome deve conter 100 caracteres máximo")
    @Column(name = "nome_prod", nullable = false, length = 100)
    private String nome_prod;

    @NotBlank(message = "Obrigatório preencher marca")
    @Size(max = 100, message = "Marca deve conter 100 caracteres máximo")
    @Column(name = "marca_prod", nullable = false, length = 100)
    private String marca_prod;

    @NotBlank(message = "Obrigatório preencer quantidade")
    @Column(name = "qtde_prod", nullable = false, length = 3)
    private int qtde_prod;

    @NotBlank(message = "Obrigatório preencher preço")
    @Column(name = "preco_prod", nullable = false, length = 10)
    private double preco_prod;

    @Column(name = "descricao_prod")
    private String descricao_prod;

    public Produtos() {
    }

    public Produtos(Long id_produto, String nome_prod, String marca_prod, int qtde_prod, double preco_prod, String descricao_prod) {
        this.id_produto = id_produto;
        this.nome_prod = nome_prod;
        this.marca_prod = marca_prod;
        this.qtde_prod = qtde_prod;
        this.preco_prod = preco_prod;
        this.descricao_prod = descricao_prod;
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_prod() {
        return nome_prod;
    }

    public void setNome_prod(String nome_prod) {
        this.nome_prod = nome_prod;
    }

    public String getMarca_prod() {
        return marca_prod;
    }

    public void setMarca_prod(String marca_prod) {
        this.marca_prod = marca_prod;
    }

    public int getQtde_prod() {
        return qtde_prod;
    }

    public void setQtde_prod(int qtde_prod) {
        this.qtde_prod = qtde_prod;
    }

    public double getPreco_prod() {
        return preco_prod;
    }

    public void setPreco_prod(double preco_prod) {
        this.preco_prod = preco_prod;
    }

    public String getDescricao_prod() {
        return descricao_prod;
    }

    public void setDescricao_prod(String descricao_prod) {
        this.descricao_prod = descricao_prod;
    }
}