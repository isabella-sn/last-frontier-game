package item.itens;

public class Alimentos extends Item {

    public Alimentos(int quantidade, double peso) {
        super("Alimentos", quantidade, peso);
    }

    @Override
    public void usar() {
        System.out.println("Você comeu alimentos. Energia restaurada.");
    }
}
