package item;

public class Armas extends Item {
    private String tipo;
    private int dano;
    private int alcance;

    public Armas(int quantidade, double peso, String tipo, int dano, int alcance) {
        super("Arma", quantidade, peso);
        this.tipo = tipo;
        this.dano = dano;
        this.alcance = alcance;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDano() {
        return dano;
    }

    public int getAlcance() {
        return alcance;
    }

    public void atacar(String alvo) {
        System.out.println("Atacando " + alvo + " com uma arma " + tipo +
                " causando " + dano + " de dano. Alcance: " + alcance);
    }

    @Override
    public void usar() {
        atacar("inimigo");
    }
}