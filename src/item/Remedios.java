package item;

public class Remedios extends Item {
    private String tipo;
    private String efeito;

    public Remedios(int quantidade, double peso, String tipo, String efeito) {
        super("Remédios", quantidade, peso);
        this.tipo = tipo;
        this.efeito = efeito;
    }

    @Override
    public void usar() {
        System.out.println("Usando " + tipo + ": " + efeito);
    }
}