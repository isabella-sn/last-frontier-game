package ambiente.ambientes;

import item.itens.Item;
import item.itens.Materiais;
import java.util.*;

import personagem.personagens.Personagem;

public class Ruinas extends Ambiente {

    public Ruinas() {
        super(
                "Ruínas",
                "Restos de construções antigas, cheias de mistérios e perigos.",
                1,
                gerarRecursos(),
                0.6,
                "Ambiente protegido das condições climáticas"
        );
    }

    private static List<Item> gerarRecursos() {
        List<Item> recursos = new ArrayList<>();
        recursos.add(new Materiais(1, 2.0, "Metal Enferrujado", 40));
        return recursos;
    }

    @Override
    public void explorar(Personagem jogador) {
        System.out.println("Você explora as ruínas...");
        jogador.perderEnergia(5);
        System.out.println("Você se move com cautela. Energia consumida: 5");
    }

    @Override
    public void gerarEvento(Personagem jogador) {
        Random rand = new Random();
        int evento = rand.nextInt(3);
        switch (evento) {
            case 0:
                System.out.println("Você encontra sobreviventes hostis! É atacado.");
                jogador.sofrerDano(15);
                break;
            case 1:
                System.out.println("Uma armadilha antiga é acionada! Você se fere levemente.");
                jogador.sofrerDano(10);
                break;
            case 2:
                System.out.println("Você descobre uma passagem secreta com suprimentos.");
                jogador.recuperarEnergia(15);
                break;
        }
    }

    @Override
    public void modificarClima() {
        System.out.println("Apesar do tempo lá fora, as ruínas continuam secas e abrigadas.");
    }
    @Override
    public void removerItem(Item item) {
        if (this.getItensDisponiveis() != null) {
            this.getItensDisponiveis().remove(item);
        }
    }


}
