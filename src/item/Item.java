package item;

public abstract class Item {
    protected String nome;
    protected int quantidade;
    protected double peso;

    public Item(String nome, int quantidade, double peso) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.peso = peso;
    }

    public double getPesoTotal() {
        return peso * quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void exibirInfo() {
        System.out.println("Item: " + nome);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Peso Total: " + getPesoTotal());
    }

    public abstract void usar();
}