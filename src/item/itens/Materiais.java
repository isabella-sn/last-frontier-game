package item.itens;

public class Materiais extends Item {
    private String tipo; // madeira, pedra, metal
    private int resistencia;

    public Materiais(int quantidade, double peso, String tipo, int resistencia) {
        super("Material", quantidade, peso);
        this.tipo = tipo;
        this.resistencia = resistencia;
    }

    public void combinar(Materiais outro) {
        System.out.println("Combinando " + this.tipo + " com " + outro.tipo);
        int novaResistencia = (this.resistencia + outro.resistencia) / 2;
        System.out.println("Novo material criado com resistência média: " + novaResistencia);
    }

    @Override
    public void usar() {
        System.out.println("Usando material do tipo " + tipo + " com resistência " + resistencia);
    }
}
