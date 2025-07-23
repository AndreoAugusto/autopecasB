package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Funcionarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long id_funcionario;

    @OneToMany(mappedBy = "funcionarios")
    private List<Vendas> vendas;

    @NotBlank(message = "Obrigatório preencher nome")
    @Size(max = 100, message = "Nome deve conter 100 caracteres máximo.")
    @Column(name = "nome_func", nullable = false, length = 100)
    private String nome_func;

    @NotBlank(message = "CPF inválido")
    @Size(max = 11, message = "CPF deve conter 11 caracteres máximo")
    @Column(name = "cpf_func", nullable = false, length = 14)
    private String cpf_func;

    @NotBlank(message = "Obrigatório preencher telefone")
    @Size(max = 14, message = "Telefone deve conter 14 caracteres máximo")
    @Column(name = "telefone_func", nullable = false, length = 15)
    private String telefone_func;

    @NotBlank(message = "Obrigatório preencher email")
    @Size(max = 100, message = "Email deve conter 100 caracteres máximo")
    @Column(name = "email_func", nullable = false, length = 100)
    private String email_func;

    public Funcionarios() {
    }

    public Funcionarios(Long id_funcionario, String nome_func, String cpf_func, String telefone_func, String email_func) {
        this.id_funcionario = id_funcionario;
        this.nome_func = nome_func;
        this.cpf_func = cpf_func;
        this.telefone_func = telefone_func;
        this.email_func = email_func;
    }

    public Long getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Long id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome_func() {
        return nome_func;
    }

    public void setNome_func(String nome_func) {
        this.nome_func = nome_func;
    }

    public String getCpf_func() {
        return cpf_func;
    }

    public void setCpf_func(String cpf_func) {
        this.cpf_func = cpf_func;
    }

    public String getTelefone_func() {
        return telefone_func;
    }

    public void setTelefone_func(String telefone_func) {
        this.telefone_func = telefone_func;
    }

    public String getEmail_func() {
        return email_func;
    }

    public void setEmail_func(String email_func) {
        this.email_func = email_func;
    }
}
