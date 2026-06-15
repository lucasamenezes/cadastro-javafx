package com.trabalho.controller;

import com.trabalho.model.CadastroModel;
import com.trabalho.model.Pessoa;
import com.trabalho.view.PessoaView;

public class PessoaController {
    private CadastroModel model;
    private PessoaView view;

    public PessoaController(CadastroModel model, PessoaView view) {
        this.model = model;
        this.view = view;

        // Passa os métodos como ações para a View executar [cite: 976, 1023]
        this.view.setOnSalvarButtonClicked(this::handleSalvar);
        this.view.setOnLimparButtonClicked(this::handleLimpar);

        // Registra o listener no Model para atualizar a View automaticamente [cite: 1099, 1103]
        this.model.addListener(() -> this.view.atualizarTabela(this.model.getPessoas()));
    }

    private void handleSalvar() {
        String nome = view.getNomeInput();
        String cpf = view.getCpfInput();
        String email = view.getEmailInput();
        String telefone = view.getTelefoneInput();

        // Validação simples
        if (nome == null || nome.trim().isEmpty() || cpf == null || cpf.trim().isEmpty()) {
            view.mostrarErro("Os campos Nome e CPF são obrigatórios!");
            return;
        }

        Pessoa novaPessoa = new Pessoa(nome, cpf, email, telefone);
        model.adicionarPessoa(novaPessoa); // Atualizar model [cite: 965]
        
        view.mostrarSucesso("Pessoa cadastrada com sucesso!");
        view.limparCampos();
    }

    private void handleLimpar() {
        view.limparCampos();
    }
}