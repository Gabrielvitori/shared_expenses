package service;

import model.Despesa;
import model.DivisaoDespesa;
import model.Grupo;
import model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    private List<Usuario> usuarios = new ArrayList<>();
    private List<Grupo> grupos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            // opções
            opcao = scanner.nextInt(); // lê o número digitado
            scanner.nextLine(); // limpa a quebra de linha

            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> criarGrupo();
                case 3 -> adicionarUsuarioAoGrupo();
                case 4 -> cadastrarDespesa();
                case 5 -> verResumoGrupo();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void cadastrarUsuario() {
        System.out.print("Nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Email do usuário: ");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso.");
    }

    private void criarGrupo() {
        System.out.print("Nome do grupo: ");
        String nome = scanner.nextLine();

        Grupo grupo = new Grupo(nome);
        grupos.add(grupo);
        System.out.println("Grupo criado com sucesso.");
    }

    private void adicionarUsuarioAoGrupo() {
        Grupo grupo = selecionarGrupo();
        Usuario usuario = selecionarUsuario();

        if (grupo != null && usuario != null) {
            grupo.adicionarMembro(usuario);
            System.out.println("Usuário adicionado ao grupo.");
        }
    }

    private void cadastrarDespesa() {
        Grupo grupo = selecionarGrupo();
        Usuario pagador = selecionarUsuario();

        System.out.print("Descrição da despesa: ");
        String descricao = scanner.nextLine();

        System.out.print("Valor total: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Despesa despesa = new Despesa(descricao, valor, LocalDate.now(), pagador, grupo);

        for (Usuario u : grupo.getMembros()) {
            System.out.print("Quanto " + u.getNome() + " deve pagar? ");
            double valorInd = scanner.nextDouble();
            scanner.nextLine();
            despesa.adicionarDivisao(new DivisaoDespesa(u, valorInd));
        }

        grupo.adicionarDespesa(despesa);
        System.out.println("Despesa adicionada ao grupo.");
    }

    private void verResumoGrupo() {
        Grupo grupo = selecionarGrupo();

        if (grupo != null) {
            for (Despesa d : grupo.getDespesas()) {
                System.out.println("\nDespesa: " + d.getDescricao() + " (R$" + d.getValorTotal() + ")");
                for (DivisaoDespesa div : d.getDivisoes()) {
                    System.out.println("- " + div.getUsuario().getNome() + " deve R$" + div.getValorDevido());
                }
            }
        }
    }

    private Usuario selecionarUsuario() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return null;
        }

        System.out.println("Usuários disponíveis:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(i + " - " + usuarios.get(i).getNome());
        }

        System.out.print("Escolha o número do usuário: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        return usuarios.get(escolha);
    }

    private Grupo selecionarGrupo() {
        if (grupos.isEmpty()) {
            System.out.println("Nenhum grupo cadastrado.");
            return null;
        }

        System.out.println("Grupos disponíveis:");
        for (int i = 0; i < grupos.size(); i++) {
            System.out.println(i + " - " + grupos.get(i).getNome());
        }

        System.out.print("Escolha o número do grupo: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        return grupos.get(escolha);
    }







}
