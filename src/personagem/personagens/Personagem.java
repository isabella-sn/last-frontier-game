package personagem.personagens;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int energia;

    public Personagem(String nome, int vida, int energia) {
        this.nome = nome;
        this.vida = vida;
        this.energia = energia;
    }

    public void exibirStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Energia: " + energia);
    }

    public abstract void habilidadeEspecial(); // Cada personagem terá uma habilidade única
}
