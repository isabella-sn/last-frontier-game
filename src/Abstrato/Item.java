package Abstrato;

public class Item {
    private String nome;
    private String tipo;

    public Item(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }
}

}
