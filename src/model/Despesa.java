package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Despesa {
    private String descricao;
    private double valorTotal;
    private LocalDate data;
    private Usuario pagador;
    private Grupo grupo; // Pode ser null para despesas pessoais
    private List<DivisaoDespesa> divisoes = new ArrayList<>();

    public Despesa(String descricao, double valorTotal, LocalDate data, Usuario pagador, Grupo grupo) {
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.data = data;
        this.pagador = pagador;
        this.grupo = grupo;
    }

    public void adicionarDivisao(DivisaoDespesa divisao) {
        divisoes.add(divisao);
    }

    public String getDescricao() {
        return descricao;
    }

    public List<DivisaoDespesa> getDivisoes() {
        return divisoes;
    }

    // Getters e Setters
}
