package item.itens;

public class Armas extends Item {
    public Armas(int quantidade, double peso) {
        super("Arma", quantidade, peso);
    }

    @Override
    public void usar() {
        System.out.println("Você usou uma arma. Inimigo ferido!");
    }
}
