package ambiente;

import item.*;
import personagem.Personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Caverna extends Ambiente {

    public Caverna() {
        super(
                "Caverna",
                "Ambiente escuro e misterioso.",
                2.0,
                gerarRecursosIniciais(),
                0.5,
                "Úmido e escuro"
        );
    }

    private static List<Item> gerarRecursosIniciais() {
        List<Item> recursos = new ArrayList<>();
        recursos.add(new Materiais(2, 3.0, "pedra", 60));
        recursos.add(new Agua(1, 1.0, "gotejamento", 0.5));
        recursos.add(new Alimentos(1, 1.2, 10, "fungos", false));
        return recursos;
    }

    // Lógica de exploração
    @Override
    public void explorar(Personagem jogador) {
        System.out.println("Você explora a caverna com cuidado... é escuro e silencioso.");
        System.out.println(this.getDescricao());

    }


    @Override
    public void gerarEvento(Personagem jogador) {
        Random rand = new Random();
        int evento = rand.nextInt(3);
        switch (evento) {
            case 0:
                System.out.println("Um desmoronamento parcial atingiu você");
                jogador.sofrerDano(40);
                break;
            case 1:
                System.out.println("A caverna não tem animais, você pode se abrigar por um tempo");
                jogador.recuperarEnergia(10);
                break;
            case 2:
                System.out.println("A cavera desmoronou totalmente e você ficou soterrado");
                jogador.sofrerDano(200);
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
        System.out.println("A umidade aumenta e o ar fica mais pesado dentro da caverna.");
    }
}