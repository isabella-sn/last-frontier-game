package ambiente.ambientes;

import item.itens.*;
import personagem.personagens.Personagem;

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

    @Override
    public void explorar(Personagem jogador) {
        System.out.println("Você explora a caverna com cuidado... é escuro e silencioso.");
        // lógica de exploração
    }

    @Override
    public void gerarEvento(Personagem personagem) {
        Random rand = new Random();
        int evento = rand.nextInt(3);
        switch (evento) {
            case 0 -> System.out.println("Você encontrou uma criatura hostil!");
            case 1 -> System.out.println("Você descobriu um túnel oculto.");
            case 2 -> System.out.println("Um desmoronamento parcial bloqueou parte da saída.");
        }
    }
    @Override
    public void removerItem(Item item) {
        if (this.getItensDisponiveis() != null) {
            this.getItensDisponiveis().remove(item);
        }
    }


    @Override
    public void modificarClima() {
        System.out.println("A umidade aumenta e o ar fica mais pesado dentro da caverna.");
    }
}
