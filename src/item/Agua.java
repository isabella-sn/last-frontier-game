
package item;

public class Agua extends Item {
    private String pureza;  // potável, contaminada
    private double volume;

    public Agua(int quantidade, double peso, String pureza, double volume) {
        super("Água", quantidade, peso);
        this.pureza = pureza;
        this.volume = volume;
    }

    public void beber() {
        System.out.println("Bebendo água (" + pureza + ") - Volume: " + volume + "L");
        if (pureza.equalsIgnoreCase("contaminada")) {
            System.out.println("Você pode ficar doente!");
        }
    }

    @Override
    public void usar() {
        beber();
    }
}
