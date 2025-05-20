package src;

import ambiente.GerenciadorDeAmbientes;
import evento.ControladorDeEventos;
import item.itens.*;
import personagem.personagens.*;
import sistema.ControladorDeTurnos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorDeAmbientes gerenciador = new GerenciadorDeAmbientes();
        ControladorDeTurnos controlador = new ControladorDeTurnos();
        ControladorDeEventos controladorEventos = new ControladorDeEventos(); // <--- Instancia o controlador de eventos

        // Criando personagens
        Medico medico = new Medico("Doutor Vida");
        Rastreador rastreador = new Rastreador("Olhos de Águia");
        SobreviventeNato sobrevivente = new SobreviventeNato("Lobo Solitário");

        // Inventários
        Inventario inventarioMedico = new Inventario(50);
        Inventario inventarioRastreador = new Inventario(60);
        Inventario inventarioSobrevivente = new Inventario(70);

        // Itens iniciais
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
            System.out.println("8. Evento aleatório no ambiente");
            System.out.println("9. Voltar ao menu principal");
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
                    controladorEventos.dispararEventoAleatorio(); // <--- Dispara evento após mover
                    break;
                case 5:
                    gerenciador.explorarAmbiente(personagem);
                    controlador.executarTurno(personagem, gerenciador);
                    controladorEventos.dispararEventoAleatorio(); // <--- Dispara evento após explorar
                    break;
                case 6:
                    gerenciador.listarRecursosDisponiveis();
                    break;
                case 7:
                    gerenciador.modificarCondicoesClimaticas();
                    break;
                case 8:
                    gerenciador.executarEventoDoAmbiente(personagem);
                    controlador.executarTurno(personagem, gerenciador);
                    controladorEventos.dispararEventoAleatorio(); // <--- Evento adicional após evento do ambiente
                    break;
                case 9:
                    emPersonagem = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
