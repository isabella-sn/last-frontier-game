package ambiente;

import ambiente.ambientes.*;
import personagem.personagens.Personagem;
import java.util.*;

public class GerenciadorDeAmbientes {

    private Ambiente ambienteAtual;
    private List<Ambiente> todosAmbientes;

    public GerenciadorDeAmbientes() {
        // Inicializa todos os ambientes disponíveis
        todosAmbientes = new ArrayList<>();
        todosAmbientes.add(new Floresta());
        todosAmbientes.add(new Montanha());
        todosAmbientes.add(new Caverna());
        todosAmbientes.add(new LagoERio());
        todosAmbientes.add(new Ruinas());

        // Define um ambiente inicial
        ambienteAtual = todosAmbientes.get(0); // Começa na floresta, por exemplo
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

    public void explorarAmbiente(Personagem jogador) {
        System.out.println("\n--- Exploração do Ambiente: " + ambienteAtual.getNome() + " ---");
        ambienteAtual.explorar(jogador);
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
        for (var recurso : ambienteAtual.getRecursosDisponiveis()) {
            System.out.println("- " + recurso.getNome());
        }
    }
}