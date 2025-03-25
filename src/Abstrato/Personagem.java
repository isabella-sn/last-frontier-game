package Abstrato;

public class Personagem {

private String nome;
private int saude;
private int fome;
private int sede;

public Personagem(String nome) {
    this.nome = nome;
    this.saude = 100;
    this.fome = 50;
    this.sede = 50;
}

public void comer(int quantidade) {
    fome = Math.max(0, fome - quantidade);
}

public void beber(int quantidade) {
    sede = Math.max(0, sede - quantidade);
}

public void receberDano(int dano) {
    saude = Math.max(0, saude - dano);
}

public String getNome() {
    return nome;
}

public int getSaude() {
    return saude;
}
}

