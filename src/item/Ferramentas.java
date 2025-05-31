package item;

public class Ferramentas extends Item {
    private String tipo;
    private int eficiencia;

    public Ferramentas(int quantidade, double peso, String tipo, int eficiencia) {
        super("Ferramenta", quantidade, peso);
        this.tipo = tipo;
        this.eficiencia = eficiencia;
    }

    @Override
    public void usar() {
        System.out.println("Usando " + tipo + " com eficiência " + eficiencia + ".");

    }
}