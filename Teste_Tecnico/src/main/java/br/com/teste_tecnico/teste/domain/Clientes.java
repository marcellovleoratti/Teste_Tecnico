package br.com.teste_tecnico.teste.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="clientes", catalog="Teste_Tecnico")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private Number cpf;

    @NotNull
    private String cidade;

    @NotNull
    private char uf;

    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Number cliente_apolice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Number getCpf() {
        return cpf;
    }

    public void setCpf(Number cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public char getUf() {
        return uf;
    }

    public void setUf(char uf) {
        this.uf = uf;
    }

    public Number getCliente_apolice() {
        return cliente_apolice;
    }

    public void setCliente_apolice(Number cliente_apolice) {
        this.cliente_apolice = cliente_apolice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clientes)) return false;
        Clientes clientes = (Clientes) o;
        return getCliente_apolice().equals(clientes.getCliente_apolice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCliente_apolice());
    }

    public Clientes(String nome, Number cpf, String cidade, char uf, Number cliente_apolice) {
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
        this.uf = uf;
        this.cliente_apolice = cliente_apolice;
    }
}