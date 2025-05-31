package criatura;

import personagem.Personagem;

public abstract class Criatura {
    protected String nome;
    protected int forca;
    protected int dano;

    public Criatura(String nome, int forca, int dano) {
        this.nome = nome;
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }
    public int getForca() {
        return forca;
    }

    public int getDano(){
        return dano;
    }
    public abstract void interagir(Personagem personagem);
}
