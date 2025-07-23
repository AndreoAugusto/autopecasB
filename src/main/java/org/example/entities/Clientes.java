package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id_cliente;

    @OneToMany(mappedBy = "clientes")
    private List<Vendas> vendas;

    @NotBlank(message = "Obrigatório preencher nome")
    @Size(max = 100, message = "Nome deve conter menos de 100 caracteres")
    @Column(name = "nome_cli", nullable = false, length = 100)
    private String nome_cli;

    @NotBlank(message = "Obrigatório preencher o CPF")
    @Size(max = 11, message = "CPF inválido")
    @Column(name = "cpf_cli", nullable = false, length = 14)
    private String cpf_cli;

    @NotBlank(message = "Obrigatório preencher telefone")
    @Size(max = 14, message = "Telefone deve conter 14 caracteres máximo")
    @Column(name = "telefone_cli", nullable = false, length = 15)
    private String telefone_cli;

    @Size(max = 100, message = "Email muito longo")
    @Column(name = "email_cli", length = 100)
    private String email_cli;

    public Clientes() {
    }

    public Clientes(Long id_cliente, String nome_cli, String cpf_cli, String telefone_cli, String email_cli) {
        this.id_cliente = id_cliente;
        this.nome_cli = nome_cli;
        this.cpf_cli = cpf_cli;
        this.telefone_cli = telefone_cli;
        this.email_cli = email_cli;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cli() {
        return nome_cli;
    }

    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }

    public String getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli = cpf_cli;
    }

    public String getTelefone_cli() {
        return telefone_cli;
    }

    public void setTelefone_cli(String telefone_cli) {
        this.telefone_cli = telefone_cli;
    }

    public String getEmail_cli() {
        return email_cli;
    }

    public void setEmail_cli(String email_cli) {
        this.email_cli = email_cli;
    }
}
