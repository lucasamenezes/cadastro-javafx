package com.trabalho.model;

import java.util.ArrayList;
import java.util.List;

public class CadastroModel {
    private List<Pessoa> listaPessoas = new ArrayList<>();
    
    // Listeners para notificar mudanças
    private List<ModelListener> listeners = new ArrayList<>();

    // Define um contrato que qualquer observador deve seguir
    public interface ModelListener {
        void onModelChanged();
    }

    // Registra um novo observador na lista
    public void addListener(ModelListener listener) {
        listeners.add(listener);
    }

    // Notifica todos os observadores que algo mudou
    private void notifyListeners() {
        for (ModelListener listener : listeners) {
            listener.onModelChanged();
        }
    }

    public void adicionarPessoa(Pessoa p) {
        listaPessoas.add(p);
        notifyListeners(); // Avisa a View para se atualizar
    }

    public List<Pessoa> getPessoas() {
        return listaPessoas;
    }
}