package item.itens;

public class Alimentos extends Item {
    private int valorNutricional;
    private String tipo; // fruta, carne, enlatado, etc.
    private boolean estraga;

    public Alimentos(int quantidade, double peso, int valorNutricional, String tipo, boolean estraga) {
        super("Alimentos", quantidade, peso);
        this.valorNutricional = valorNutricional;
        this.tipo = tipo;
        this.estraga = estraga;
    }

    public void consumir() {
        System.out.println("Consumindo " + tipo + " que restaura " + valorNutricional + " pontos de fome.");
        if (estraga) {
            System.out.println("Cuidado! O alimento está estragado. Pode causar intoxicação.");
        }
    }

    @Override
    public void usar() {
        consumir();
    }
}
