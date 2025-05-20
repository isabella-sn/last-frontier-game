package criatura;

import personagem.Personagem;

public abstract class Criatura {
    protected String nome;
    protected int forca;

    public Criatura(String nome, int forca) {
        this.nome = nome;
        this.forca = forca;
    }

    public String getNome() {
        return nome;
    }

    public int getForca() {
        return forca;
    }

    public abstract void interagir(Personagem personagem);
}
