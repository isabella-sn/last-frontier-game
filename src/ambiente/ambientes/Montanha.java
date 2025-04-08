package ambiente.ambientes;

import item.itens.Item;
import item.itens.Agua;
import java.util.*;

import personagem.personagens.Personagem;

public class Montanha extends Ambiente {

    public Montanha() {
        super(
                "Montanha",
                "Região alta com terreno acidentado e clima instável.",
                3,
                gerarRecursos(),
                0.4,
                "Frio intenso e ventos fortes"
        );
    }

    private static List<Item> gerarRecursos() {
        List<Item> recursos = new ArrayList<>();
        recursos.add(new Agua(1, 0.5, "degelo", 1.5));
        // Você pode adicionar outros itens como minérios se tiver classe
        return recursos;
    }

    @Override
    public void explorar(Personagem jogador) {
        System.out.println("Explorando a montanha...");
        jogador.perderEnergia(20);
        System.out.println("Terreno difícil. Energia consumida: 20");
    }

    @Override
    public void gerarEvento(Personagem jogador) {
        Random rand = new Random();
        int evento = rand.nextInt(3);
        switch (evento) {
            case 0:
                System.out.println("Uma nevasca repentina te atinge! Você perde 15 de energia.");
                jogador.perderEnergia(15);
                break;
            case 1:
                System.out.println("Deslizamento de pedras! Você sofre ferimentos leves.");
                jogador.sofrerDano(10);
                break;
            case 2:
                System.out.println("Você encontrou uma caverna segura para descanso.");
                jogador.recuperarEnergia(10);
                break;
        }
    }

    @Override
    public void modificarClima() {
        System.out.println("O clima da montanha mudou: Ventos fortes estão soprando.");
    }
}
