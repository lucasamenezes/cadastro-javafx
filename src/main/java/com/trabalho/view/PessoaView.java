package com.trabalho.view;

import com.trabalho.model.Pessoa;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import java.util.List;

public class PessoaView {
    private VBox root;
    private TextField nomeField;
    private TextField cpfField;
    private TextField emailField;
    private TextField telefoneField;
    private TableView<Pessoa> tabela;
    private Label mensagemLabel;

    // Interfaces funcionais para ações dos botões
    private Runnable onSalvarButtonClicked;
    private Runnable onLimparButtonClicked;

    public PessoaView() {
        criarComponentes();
    }

    private void criarComponentes() {
        root = new VBox(10);
        root.setPadding(new Insets(15));

        nomeField = new TextField();
        nomeField.setPromptText("Digite o Nome");
        cpfField = new TextField();
        cpfField.setPromptText("Digite o CPF");
        emailField = new TextField();
        emailField.setPromptText("Digite o E-mail");
        telefoneField = new TextField();
        telefoneField.setPromptText("Digite o Telefone");

        Button btnSalvar = new Button("Salvar");
        btnSalvar.setOnAction(e -> {
            if (onSalvarButtonClicked != null) onSalvarButtonClicked.run();
        });

        Button btnLimpar = new Button("Limpar / Cancelar");
        btnLimpar.setOnAction(e -> {
            if (onLimparButtonClicked != null) onLimparButtonClicked.run();
        });

        mensagemLabel = new Label("");

        // Configurando a exibição dos dados na TableView
        tabela = new TableView<>();
        
        TableColumn<Pessoa, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Pessoa, String> colCpf = new TableColumn<>("CPF");
        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        TableColumn<Pessoa, String> colEmail = new TableColumn<>("E-mail");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Pessoa, String> colTel = new TableColumn<>("Telefone");
        colTel.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        tabela.getColumns().addAll(colNome, colCpf, colEmail, colTel);
        tabela.setPrefHeight(200);

        HBox botoes = new HBox(10, btnSalvar, btnLimpar);
        
        root.getChildren().addAll(
            new Label("Nome:"), nomeField,
            new Label("CPF:"), cpfField,
            new Label("E-mail:"), emailField,
            new Label("Telefone:"), telefoneField,
            botoes, mensagemLabel, tabela
        );
    }

    public VBox getRoot() { return root; }

    // Leem os dados que o usuário digitou e retornam para o Controller
    public String getNomeInput() { return nomeField.getText(); }
    public String getCpfInput() { return cpfField.getText(); }
    public String getEmailInput() { return emailField.getText(); }
    public String getTelefoneInput() { return telefoneField.getText(); }

    // Recebem as ações do Controller e armazenam nos Runnables
    public void setOnSalvarButtonClicked(Runnable handler) { this.onSalvarButtonClicked = handler; }
    public void setOnLimparButtonClicked(Runnable handler) { this.onLimparButtonClicked = handler; }

    public void atualizarTabela(List<Pessoa> lista) {
        tabela.getItems().clear();
        tabela.getItems().addAll(lista);
    }

    public void mostrarErro(String msg) {
        mensagemLabel.setText("❌ " + msg);
        mensagemLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
    }

    public void mostrarSucesso(String msg) {
        mensagemLabel.setText("✅ " + msg);
        mensagemLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
    }

    public void limparCampos() {
        nomeField.clear();
        cpfField.clear();
        emailField.clear();
        telefoneField.clear();
        mensagemLabel.setText("");
    }
}