package com.trabalho;

import com.trabalho.controller.PessoaController;
import com.trabalho.model.CadastroModel;
import com.trabalho.view.PessoaView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Instanciando as classes 
        CadastroModel model = new CadastroModel();
        PessoaView view = new PessoaView();
        
        // Criando a conexão do Controller 
        new PessoaController(model, view);

        Scene scene = new Scene(view.getRoot(), 500, 600);
        primaryStage.setTitle("Cadastro de Pessoas - MVC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}