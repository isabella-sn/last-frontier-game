package ambiente;

import criatura.Crocodilo;
import item.Item;
import item.Agua;
import java.util.*;

import personagem.Personagem;

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
        double chance = Math.random();
        if (chance < 0.2) {
            Crocodilo crocodilo = new Crocodilo();
            System.out.println("Um crocodilo aparece repentinamente! Você foi atacado e não sobreviveu");
            jogador.sofrerDano(crocodilo.getDano());

        } else if (chance < 0.5) {
            System.out.println("Tempestade! O nível da água sobe rapidamente.");
            jogador.perderEnergia(60);
        } else if (chance <0.8){
            System.out.println("Você encontra um barco abandonado com suprimentos.");
            jogador.recuperarEnergia(5);
        } else {
            System.out.println("Você tentou atravessar o rio e foi pego por uma correnteza");
            jogador.sofrerDano(200);

    }
    }

    @Override
    public void modificarClima() {
        System.out.println("Chuva forte cai sobre o rio, tornando-o perigoso.");
    }
    @Override
    public void removerItem(Item item) {
        if (this.getItensDisponiveis() != null) {
            this.getItensDisponiveis().remove(item);
        }
    }


}