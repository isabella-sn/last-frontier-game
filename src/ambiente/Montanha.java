package ambiente;

import criatura.Leao;
import item.Item;
import item.Agua;
import java.util.*;
import personagem.Personagem;

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

        return recursos;
    }


    @Override
    public void explorar(Personagem jogador) {
        System.out.println("Você escala a montanha. O terreno é traiçoeiro e o vento é cortante.");
        System.out.println(this.getDescricao());
        jogador.perderEnergia(20);
        System.out.println("Terreno difícil. Energia consumida: 20.");

    }


    @Override
    public void gerarEvento(Personagem jogador) {
        double chance = Math.random();
        if (chance < 0.3) {

            System.out.println("Deslizamento de pedras! Você sofre ferimentos leves.");
            jogador.sofrerDano(20);

        } else if (chance < 0.6) {
            System.out.println("Você tropeçou do alto da montanha e rolou morro a baixo.");
            jogador.sofrerDano(40);
        } else if (chance < 0.8){
            Leao leao = new Leao();
            System.out.println("Um leão das montanhas te atacou, você morreu");
            jogador.sofrerDano(leao.getDano());
        } else {
            System.out.println("Você encontrou ervas medicinais raras e fez um chá revigorante.");
            jogador.sofrerDano(-15); // Curar
            jogador.recuperarEnergia(10);

        }
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


    @Override
    public void modificarClima() {
        System.out.println("O clima da montanha mudou: Ventos fortes estão soprando.");
    }
}