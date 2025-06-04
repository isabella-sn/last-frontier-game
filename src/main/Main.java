package main;

import ambiente.GerenciadorDeAmbientes;
import evento.ControladorDeEventos;
import item.*;
import personagem.*;
import sistema.ControladorDeTurnos;
import personagem.Jogador;
import excecoes.InventarioCheioException;
import excecoes.AmbienteInacessivelException;
import excecoes.MortePorFomeOuSedeException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mostrarIntroducao();

        Scanner scanner = new Scanner(System.in);
        GerenciadorDeAmbientes gerenciador = new GerenciadorDeAmbientes();
        ControladorDeTurnos controlador = new ControladorDeTurnos();
        ControladorDeEventos controladorEventos = new ControladorDeEventos();

        // Adicionar nome do jogador
        System.out.print("Digite o nome do seu personagem (pressione Enter para usar o nome padrão): ");
        String nomeJogador = scanner.nextLine();
        if (nomeJogador.isEmpty()) {
            nomeJogador = "Sobrevivente";
        }
        Jogador jogadorPrincipal = new Jogador(nomeJogador);

        System.out.println("Bem-vindo, " + jogadorPrincipal.getNome() + "! Prepare-se para sobreviver.");



        // Outros personagens (para seleção, mas suas instâncias de inventário são separadas)
        Medico medico = new Medico("Doutor Vida");
        Rastreador rastreador = new Rastreador("Olhos de Águia");
        SobreviventeNato sobrevivente = new SobreviventeNato("Lobo Solitário");

        boolean jogando = true;

        while (jogando) {
            System.out.println("\n=== Escolha um personagem ===");
            System.out.println("1. Médico");
            System.out.println("2. Rastreador");
            System.out.println("3. Sobrevivente Nato");
            System.out.println("4. Sair do jogo");
            System.out.print("Digite sua opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            Personagem personagemSelecionado = null;
            Inventario inventarioSelecionado = null;


            try {
                switch (escolha) {
                    case 1:
                        if (medico.getInventario().estaVazio()) {
                            try {
                                medico.getInventario().adicionarItem(new Remedios(2, 1.5, "Bandagem", "Cura ferimentos leves"));
                                medico.getInventario().adicionarItem(new Agua(1, 0.5, "potável", 1.0));
                            } catch (InventarioCheioException e) {
                                System.out.println("Erro ao adicionar item inicial para o Médico: " + e.getMessage());
                            }
                        }
                        personagemSelecionado = medico;
                        inventarioSelecionado = medico.getInventario();
                        break;
                    case 2:
                        if (rastreador.getInventario().estaVazio()) {
                            try {
                                rastreador.getInventario().adicionarItem(new Alimentos(2, 2.0, 20, "fruta", false));
                                rastreador.getInventario().adicionarItem(new Ferramentas(1, 5.0, "lanterna", 80));
                            } catch (InventarioCheioException e) {
                                System.out.println("Erro ao adicionar item inicial para o Rastreador: " + e.getMessage());
                            }
                        }
                        personagemSelecionado = rastreador;
                        inventarioSelecionado = rastreador.getInventario();
                        break;
                    case 3:
                        if (sobrevivente.getInventario().estaVazio()) {
                            try {
                                sobrevivente.getInventario().adicionarItem(new Armas(1, 10.0, "corpo a corpo", 30, 1));
                                sobrevivente.getInventario().adicionarItem(new Materiais(4, 3.0, "madeira", 70));
                            } catch (InventarioCheioException e) {
                                System.out.println("Erro ao adicionar item inicial para o Sobrevivente Nato: " + e.getMessage());
                            }
                        }
                        personagemSelecionado = sobrevivente;
                        inventarioSelecionado = sobrevivente.getInventario();
                        break;
                    case 4:
                        System.out.println("Encerrando o jogo...");
                        jogando = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

                if (personagemSelecionado != null) {

                    menuPersonagem(scanner, personagemSelecionado, inventarioSelecionado, gerenciador, controlador, controladorEventos);
                }


            } catch (MortePorFomeOuSedeException e) {
                System.out.println("\n" + e.getMessage());
                System.out.println("------ FIM DE JOGO ------");
                jogando = false;
            }
        }

        scanner.close();
    }

    public static void mostrarIntroducao() {
        System.out.println("===============================================");
        System.out.println("          🧭 LAST FRONTIER GAME");
        System.out.println("===============================================");
        System.out.println("Gênero: Jogo de Sobrevivência");
        System.out.println("Plataforma: Desktop (Java - Console)");
        System.out.println("Conceito Principal:");
        System.out.println("Um jogo de sobrevivência onde o jogador deve gerenciar");
        System.out.println("recursos, explorar o ambiente e enfrentar perigos para");
        System.out.println("sobreviver em um mundo pós-apocalíptico ou selvagem.");
        System.out.println();
        System.out.println("Público-alvo:");
        System.out.println("Jogadores interessados em desafios de sobrevivência,");
        System.out.println("gerenciamento de recursos e exploração.");
        System.out.println("===============================================\n");
    }

    public static void menuPersonagem(Scanner scanner, Personagem personagem, Inventario inventario,
                                      GerenciadorDeAmbientes gerenciador, ControladorDeTurnos controlador,
                                      ControladorDeEventos controladorEventos) {
        boolean emPersonagem = true;

        while (emPersonagem) {
            System.out.println("\n--- Menu de " + personagem.getNome() + " ---");
            System.out.println("Turno: " + controlador.getTurnoAtual());
            System.out.println("Ambiente atual: " + gerenciador.getAmbienteAtual().getNome());
            System.out.println("1. Ver status");
            System.out.println("2. Ver inventário");
            System.out.println("3. Usar item");
            System.out.println("4. Mover para outro ambiente");
            System.out.println("5. Explorar ambiente");
            System.out.println("6. Ver recursos disponíveis");
            System.out.println("7. Ver clima do ambiente");
            System.out.println("8. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        personagem.exibirStatus();
                        personagem.habilidadeEspecial();
                        break;
                    case 2:
                        inventario.mostrarInventario();
                        break;
                    case 3:
                        System.out.print("Digite o nome do item que deseja usar: ");
                        String nomeItem = scanner.nextLine();
                        inventario.usarItem(nomeItem);
                        break;
                    case 4:
                        gerenciador.mostrarAmbientesDisponiveis();
                        System.out.print("Digite o número do ambiente para se mover: ");
                        int escolhaAmbiente = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            gerenciador.mudarAmbiente(escolhaAmbiente);
                            controlador.executarTurno(personagem, gerenciador);
                            controladorEventos.dispararEventoAleatorio();
                        } catch (AmbienteInacessivelException e) {
                            System.out.println("Não foi possível mudar de ambiente: " + e.getMessage());
                        }
                        break;
                    case 5:
                        gerenciador.explorarAmbiente(personagem);
                        controlador.executarTurno(personagem, gerenciador);
                        controladorEventos.dispararEventoAleatorio();
                        break;
                    case 6:
                        gerenciador.listarRecursosDisponiveis(personagem, scanner);
                        break;
                    case 7:
                        gerenciador.modificarCondicoesClimaticas();
                        break;
                    case 8:
                        emPersonagem = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
                personagem.verificarMorte();
            } catch (MortePorFomeOuSedeException e) {
                System.out.println("\n" + e.getMessage());
                System.out.println("------ FIM DE JOGO ------");
                emPersonagem = false;
            }
        }
    }
}