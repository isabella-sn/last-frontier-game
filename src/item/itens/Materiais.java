package item.itens;

public class Materiais extends Item {
    public Materiais(int quantidade, double peso) {
        super("Materiais", quantidade, peso);
    }

    @Override
    public void usar() {
        System.out.println("Você utilizou materiais. Estrutura construída.");
    }
}
