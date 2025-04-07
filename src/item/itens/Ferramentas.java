package item.itens;

public class Ferramentas extends Item {
    public Ferramentas(int quantidade, double peso) {
        super("Ferramenta", quantidade, peso);
    }

    @Override
    public void usar() {
        System.out.println("Você usou uma ferramenta. Reparos realizados.");
    }
}
