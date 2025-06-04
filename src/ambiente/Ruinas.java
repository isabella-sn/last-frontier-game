package ambiente;

import criatura.Cobra;
import item.Item;
import item.Materiais;
import java.util.*;

import personagem.Personagem;

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
        System.out.println("Você adentra as ruínas. O lugar é silencioso e empoeirado, com vestígios de uma civilização antiga.");
        System.out.println(this.getDescricao());
        jogador.perderEnergia(5);
        System.out.println("Você se move com cautela. Energia consumida: 5.");

    }


    @Override
    public void gerarEvento(Personagem jogador) {
        double chance = Math.random();
        if (chance < 0.05) {

            System.out.println("Você encontrou um baú antigo entre os escombros!");
            jogador.adicionarAgua(2);
            jogador.adicionarComida(1);
            jogador.recuperarEnergia(10);

        } else if (chance < 0.5) {
            System.out.println("Uma armadilha antiga é acionada! Você se feriu.");
            jogador.sofrerDano(40);
        } else {
            Cobra cobra = new Cobra();
            System.out.println("Você pisou sem querer em uma cobra venenosa, foi picado e morreu");
            jogador.sofrerDano(cobra.getDano());
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
        if (this.recursosDisponiveis != null) {
            this.recursosDisponiveis.remove(item);
        }
    }
}