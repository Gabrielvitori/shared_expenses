package model;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nome;
    private List<Usuario> membros = new ArrayList<>();
    private List<Despesa> despesas = new ArrayList<>();

    public Grupo(String nome) {
        this.nome = nome;
    }

    public void adicionarMembro(Usuario usuario) {
        membros.add(usuario);
        usuario.adicionarGrupo(this);
    }

    public void adicionarDespesa(Despesa despesa) {
        despesas.add(despesa);
    }

    // Getters e Setters
}
