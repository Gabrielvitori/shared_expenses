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

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    public List<Usuario> getMembros() {
        return membros;
    }

    public void setMembros(List<Usuario> membros) {
        this.membros = membros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
