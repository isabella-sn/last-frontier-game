package ambiente.ambientes;

import item.itens.Item;
import item.itens.Agua;
import java.util.*;

import personagem.personagens.Personagem;

public class LagoERio extends Ambiente {

    public LagoERio() {
        super(
                "Lago e Rio",
                "Corpos d'água que oferecem abundância de recursos aquáticos.",
                2,
                gerarRecursos(),
                0.5,
                "Úmido e sujeito a tempestades"
        );
    }

    private static List<Item> gerarRecursos() {
        List<Item> recursos = new ArrayList<>();
        recursos.add(new Agua(2, 1.0, "potável", 1.5));
        return recursos;
    }

    @Override
    public void explorar(Personagem jogador) {
        System.out.println("Você tenta pescar no rio...");
        jogador.perderEnergia(10);
        System.out.println("Energia consumida: 10");
    }

    @Override
    public void gerarEvento(Personagem jogador) {
        Random rand = new Random();
        int evento = rand.nextInt(3);
        switch (evento) {
            case 0:
                System.out.println("Um jacaré aparece repentinamente! Você se fere ao escapar.");
                jogador.sofrerDano(20);
                break;
            case 1:
                System.out.println("Tempestade! O nível da água sobe rapidamente.");
                jogador.perderEnergia(10);
                break;
            case 2:
                System.out.println("Você encontra um barco abandonado com suprimentos.");
                jogador.recuperarEnergia(10);
                break;
        }
    }

    @Override
    public void modificarClima() {
        System.out.println("Chuva forte cai sobre o rio, tornando-o perigoso.");
    }
}
