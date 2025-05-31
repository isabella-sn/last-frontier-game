package ambiente;

import ambiente.ambientes.*;
import personagem.personagens.Personagem;
import item.itens.Item;
import item.itens.Inventario;

import java.util.*;

public class GerenciadorDeAmbientes {

    private Ambiente ambienteAtual;
    private List<Ambiente> todosAmbientes;

    public GerenciadorDeAmbientes() {
        todosAmbientes = new ArrayList<>();
        todosAmbientes.add(new Floresta());
        todosAmbientes.add(new Montanha());
        todosAmbientes.add(new Caverna());
        todosAmbientes.add(new LagoERio());
        todosAmbientes.add(new Ruinas());

        ambienteAtual = todosAmbientes.get(0); // Começa na floresta
    }

    public Ambiente getAmbienteAtual() {
        return ambienteAtual;
    }

    public void mostrarAmbientesDisponiveis() {
        System.out.println("Ambientes disponíveis para se mover:");
        for (int i = 0; i < todosAmbientes.size(); i++) {
            Ambiente amb = todosAmbientes.get(i);
            System.out.println(i + " - " + amb.getNome() + ": " + amb.getDescricao());
        }
    }

    public void mudarAmbiente(int escolha) {
        if (escolha >= 0 && escolha < todosAmbientes.size()) {
            ambienteAtual = todosAmbientes.get(escolha);
            System.out.println("Você se moveu para: " + ambienteAtual.getNome());
        } else {
            System.out.println("Escolha inválida. Tente novamente.");
        }
    }

    // Versão completa com todos os parâmetros
    public void explorarAmbiente(Personagem jogador, Inventario inventario, Scanner scanner) {
        System.out.println("\n--- Exploração do Ambiente: " + ambienteAtual.getNome() + " ---");
        System.out.println(ambienteAtual.getDescricao());

        List<Item> itensDisponiveis = ambienteAtual.getRecursosDisponiveis();

        if (itensDisponiveis.isEmpty()) {
            System.out.println("Nenhum item encontrado no ambiente.");
            return;
        }

        System.out.println("Você encontrou os seguintes itens:");
        for (int i = 0; i < itensDisponiveis.size(); i++) {
            System.out.println((i + 1) + ". " + itensDisponiveis.get(i).getNome());
        }

        System.out.print("Digite o número do item que deseja pegar (0 para nenhum): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha > 0 && escolha <= itensDisponiveis.size()) {
            Item itemEscolhido = itensDisponiveis.get(escolha - 1);
            boolean adicionado = inventario.adicionarItem(itemEscolhido);

            if (adicionado) {
                ambienteAtual.removerItem(itemEscolhido);
                System.out.println("Você pegou o(a) " + itemEscolhido.getNome() + ".");
            } else {
                System.out.println("Não foi possível pegar o item. Inventário cheio ou sem espaço.");
            }
        } else {
            System.out.println("Você decidiu não pegar nenhum item.");
        }
    }

    // Versão simples só com o jogador
    public void explorarAmbiente(Personagem jogador) {
        explorarAmbiente(jogador, jogador.getInventario(), new Scanner(System.in));
    }

    public void executarEventoDoAmbiente(Personagem jogador) {
        System.out.println("\n--- Evento Aleatório no Ambiente ---");
        ambienteAtual.gerarEvento(jogador);
    }

    public void modificarCondicoesClimaticas() {
        System.out.println("\n--- Mudança Climática no Ambiente ---");
        ambienteAtual.modificarClima();
    }

    public void listarRecursosDisponiveis() {
        System.out.println("\n--- Recursos disponíveis no ambiente atual ---");
        for (Item recurso : ambienteAtual.getRecursosDisponiveis()) {
            System.out.println("- " + recurso.getNome());
        }
    }
}