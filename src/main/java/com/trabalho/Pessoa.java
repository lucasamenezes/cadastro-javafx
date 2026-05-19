package com.trabalho;

public class Pessoa {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public Pessoa(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | CPF: " + cpf + " | E-mail: " + email + " | Tel: " + telefone;
    }
}