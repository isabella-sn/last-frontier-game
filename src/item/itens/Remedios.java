package item.itens;

public class Remedios extends Item {

    public Remedios(int quantidade, double peso) {
        super("Remédios", quantidade, peso);
    }

    @Override
    public void usar() {
        System.out.println("Você usou remédios. Vida recuperada.");
    }
}
