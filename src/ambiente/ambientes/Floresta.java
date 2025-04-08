package ambiente.ambientes;

import item.itens.*;
import java.util.*;

public class Floresta extends Ambiente {

    public Floresta() {
        super(
                "Floresta",
                "Uma área rica em recursos naturais, mas com presença de predadores.",
                1.2, // dificuldade de exploração
                gerarRecursos(), // lista de itens
                0.5, // probabilidade de eventos
                "Clima úmido com chuvas frequentes."
        );
    }

    private static List<Item> gerarRecursos() {
        List<Item> recursos = new ArrayList<>();
        recursos.add(new Alimentos(1, 0.5, 15, "Fruta silvestre", false));
        recursos.add(new Materiais(2, 2.0, "Madeira", 60));
        recursos.add(new Armas(1, 3.0, "Lança improvisada", 25, 1));
        return recursos;
    }

    @Override
    public void explorar(personagem.personagens.Personagem jogador) {
        System.out.println("Você está explorando a floresta...");
        // Aqui pode adicionar lógica de exploração com base no personagem
    }

    @Override
    public void gerarEvento(personagem.personagens.Personagem jogador) {
        System.out.println("Um evento da floresta ocorreu!");
        // Aqui você pode sortear entre ataque de animal, chuva, etc.
    }

    @Override
    public void modificarClima() {
        System.out.println("Uma chuva intensa começa a cair na floresta.");
    }
}
