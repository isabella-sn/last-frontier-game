package item.itens;

public class Ferramentas extends Item {
    private String tipo; // machado, faca, etc.
    private int eficiencia; // quanto maior, mais eficiente

    public Ferramentas(int quantidade, double peso, String tipo, int eficiencia) {
        super("Ferramenta", quantidade, peso);
        this.tipo = tipo;
        this.eficiencia = eficiencia;
    }

    @Override
    public void usar() {
        System.out.println("Usando " + tipo + " com eficiência " + eficiencia + ".");
        // Aqui você pode adicionar efeitos, como reduzir durabilidade, etc.
    }
}
