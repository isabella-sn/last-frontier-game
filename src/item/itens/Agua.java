package item.itens;

public class Agua extends Item {

    public Agua() {
        super("Água", 1, 1.0); // nome, quantidade, peso
    }

    @Override
    public void usar() {
        System.out.println("Você bebeu água. Hidratação aumentada.");
    }
}
