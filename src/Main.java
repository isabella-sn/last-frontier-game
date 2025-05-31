
import ambiente.GerenciadorDeAmbientes;
import evento.ControladorDeEventos;
import item.*;
import personagem.*;
import sistema.ControladorDeTurnos;
import personagem.Jogador;
import java.util.Scanner;
/**
 * ==================================================
 *                  Last Frontier Game
 * ==================================================
 * Gênero: Jogo de Sobrevivência
 * Plataforma: Desktop (Java)
 * Conceito Principal:
 * Um jogo de sobrevivência onde o jogador deve gerenciar recursos,
 * explorar o ambiente e enfrentar perigos para sobreviver em um
 * mundo pós-apocalíptico/selvagem.

 * Público-alvo:
 * Jogadores interessados em desafios de sobrevivência,
 * gerenciamento de recursos e exploração.
 * ==================================================
 */

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
        Jogador jogador = new Jogador(nomeJogador);
        System.out.println("Bem-vindo, " + jogador.getNome() + "! Prepare-se para sobreviver.");


        // Outros personagens
        Medico medico = new Medico("Doutor Vida");
        Rastreador rastreador = new Rastreador("Olhos de Águia");
        SobreviventeNato sobrevivente = new SobreviventeNato("Lobo Solitário");

        // Inventários
        Inventario inventarioProtagonista = new Inventario(70);
        Inventario inventarioMedico = new Inventario(50);
        Inventario inventarioRastreador = new Inventario(60);
        Inventario inventarioSobrevivente = new Inventario(70);

        // Itens iniciais para protagonista (pode ajustar conforme quiser)
        inventarioProtagonista.adicionarItem(new Armas(1, 10.0, "corpo a corpo", 30, 1));
        inventarioProtagonista.adicionarItem(new Materiais(3, 3.0, "corda", 50));

        // Itens iniciais para outros personagens
        inventarioMedico.adicionarItem(new Remedios(2, 1.5, "Bandagem", "Cura ferimentos leves"));
        inventarioMedico.adicionarItem(new Agua(1, 0.5, "potável", 1.0));

        inventarioRastreador.adicionarItem(new Alimentos(2, 2.0, 20, "fruta", false));
        inventarioRastreador.adicionarItem(new Ferramentas(1, 5.0, "lanterna", 80));

        inventarioSobrevivente.adicionarItem(new Armas(1, 10.0, "corpo a corpo", 30, 1));
        inventarioSobrevivente.adicionarItem(new Materiais(4, 3.0, "madeira", 70));

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

            switch (escolha) {
                case 1:
                    menuPersonagem(scanner, medico, inventarioMedico, gerenciador, controlador, controladorEventos);
                    break;
                case 2:
                    menuPersonagem(scanner, rastreador, inventarioRastreador, gerenciador, controlador, controladorEventos);
                    break;
                case 3:
                    menuPersonagem(scanner, sobrevivente, inventarioSobrevivente, gerenciador, controlador, controladorEventos);
                    break;
                case 4:
                    System.out.println("Encerrando o jogo...");
                    jogando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
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
                    gerenciador.mudarAmbiente(escolhaAmbiente);
                    controlador.executarTurno(personagem, gerenciador);
                    controladorEventos.dispararEventoAleatorio();
                    break;
                case 5:
                    gerenciador.explorarAmbiente(personagem);
                    controlador.executarTurno(personagem, gerenciador);
                    controladorEventos.dispararEventoAleatorio();
                    break;
                case 6:
                    gerenciador.listarRecursosDisponiveis();
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
        }
    }
}
