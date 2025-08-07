package main;

import model.*;

import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        // Criar usuários
        Usuario jose = new Usuario("José", "jose@email.com");
        Usuario ana = new Usuario("Ana", "ana@email.com");

        // Criar grupo e adicionar usuários
        Grupo viagem = new Grupo("Viagem para praia");
        viagem.adicionarMembro(jose);
        viagem.adicionarMembro(ana);

        // Criar despesa
        Despesa hospedagem = new Despesa(
                "Hospedagem",
                100.0,
                LocalDate.now(),
                jose,         // José pagou
                viagem        // Despesa de grupo
        );

        // Divisão personalizada
        hospedagem.adicionarDivisao(new DivisaoDespesa(jose, 60.0));
        hospedagem.adicionarDivisao(new DivisaoDespesa(ana, 40.0));

        // Adicionar despesa ao grupo
        viagem.adicionarDespesa(hospedagem);

        // Mostrar resumo da despesa
        System.out.println("Resumo da despesa: " + hospedagem.getDescricao());
        for (DivisaoDespesa d : hospedagem.getDivisoes()) {
            System.out.println(d.getUsuario().getNome() + " deve R$" + d.getValorDevido());
        }
    }
}
