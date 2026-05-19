package com.trabalho;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class App extends Application {

    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cadastro de Pessoas");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        TextField txtNome = new TextField();
        TextField txtCpf = new TextField();
        TextField txtEmail = new TextField();
        TextField txtTelefone = new TextField();

        grid.add(new Label("Nome:"), 0, 0);
        grid.add(txtNome, 1, 0);
        
        grid.add(new Label("CPF:"), 0, 1);
        grid.add(txtCpf, 1, 1);
        
        grid.add(new Label("E-mail:"), 0, 2);
        grid.add(txtEmail, 1, 2);
        
        grid.add(new Label("Telefone:"), 0, 3);
        grid.add(txtTelefone, 1, 3);

        Button btnSalvar = new Button("Salvar");
        Button btnCancelar = new Button("Cancelar");
        Button btnListar = new Button("Listar");

        HBox hboxBotoes = new HBox(10);
        hboxBotoes.getChildren().addAll(btnSalvar, btnCancelar, btnListar);
        grid.add(hboxBotoes, 1, 4);

        // Ações dos botões
        btnSalvar.setOnAction(e -> {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String email = txtEmail.getText();
            String telefone = txtTelefone.getText();

            if (!nome.isEmpty() && !cpf.isEmpty()) {
                Pessoa novaPessoa = new Pessoa(nome, cpf, email, telefone);
                listaPessoas.add(novaPessoa);
                System.out.println("✅ Pessoa salva com sucesso! ✅");
                limparCampos(txtNome, txtCpf, txtEmail, txtTelefone);
            } else {
                System.out.println("⚠️ Preencha pelo menos Nome e CPF. ⚠️");
            }
        });

        btnCancelar.setOnAction(e -> limparCampos(txtNome, txtCpf, txtEmail, txtTelefone));

        btnListar.setOnAction(e -> {
            System.out.println("LISTA DE CADASTRADOS");
            if (listaPessoas.isEmpty()) {
                System.out.println("Nenhum registro encontrado.");
            } else {
                for (Pessoa p : listaPessoas) {
                    System.out.println(p.toString());
                }
            }
        });

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void limparCampos(TextField nome, TextField cpf, TextField email, TextField telefone) {
        nome.clear();
        cpf.clear();
        email.clear();
        telefone.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}