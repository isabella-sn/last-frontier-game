package personagem.personagens;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int energia;
    protected int saude;


    public Personagem(String nome, int vida, int energia) {
        this.nome = nome;
        this.vida = vida;
        this.energia = energia;
    }

    public String getNome() {
        return nome;
    }

    public void exibirStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Energia: " + energia);
    }
    public void perderEnergia(int quantidade) {
        this.energia -= quantidade;
        if (this.energia < 0) {
            this.energia = 0;
        }
        System.out.println(nome + " perdeu " + quantidade + " de energia. Energia atual: " + energia);
    }
    public void sofrerDano(int dano) {
        this.saude -= dano;
        if (this.saude < 0) {
            this.saude = 0;
        }
        System.out.println(nome + " sofreu " + dano + " de dano. Saúde atual: " + saude);
    }
    public void recuperarEnergia(int valor) {
        energia += valor;
        if (energia > 100) energia = 100; // limite máximo de energia
        System.out.println(nome + " recuperou " + valor + " de energia. Energia atual: " + energia);
    }


    public abstract void habilidadeEspecial(); // Cada personagem terá uma habilidade única
}