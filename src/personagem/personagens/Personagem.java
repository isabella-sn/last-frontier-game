package personagem.personagens;

import item.itens.Inventario;  // Importa a classe Inventario (ajuste o pacote conforme seu projeto)

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int energia;
    protected int saude;

    // Recursos essenciais
    protected int comida;
    protected int agua;

    // Limites máximos
    private final int maxVida = 100;
    private final int maxEnergia = 100;
    private final int maxSaude = 100;
    private final int maxComida = 10;
    private final int maxAgua = 10;

    // Inventário do personagem
    protected Inventario inventario;

    public Personagem(String nome, int vida, int energia) {
        this.nome = nome;
        this.vida = Math.min(vida, maxVida);
        this.energia = Math.min(energia, maxEnergia);
        this.saude = maxSaude;

        this.comida = maxComida / 2; // Começa com metade dos recursos
        this.agua = maxAgua / 2;

        this.inventario = new Inventario(50.0); // Por exemplo, capacidade 50.0 (ajuste conforme sua classe Inventario)
    }

    public Inventario getInventario() {
        return inventario;
    }

    public String getNome() {
        return nome;
    }

    public void exibirStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida + "/" + maxVida);
        System.out.println("Energia: " + energia + "/" + maxEnergia);
        System.out.println("Saúde: " + saude + "/" + maxSaude);
        System.out.println("Comida: " + comida + "/" + maxComida);
        System.out.println("Água: " + agua + "/" + maxAgua);
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
        if (energia > maxEnergia) energia = maxEnergia; // limite máximo de energia
        System.out.println(nome + " recuperou " + valor + " de energia. Energia atual: " + energia);
    }

    // Métodos para comida e água
    public void consumirComida(int quantidade) {
        comida -= quantidade;
        if (comida < 0) comida = 0;
        System.out.println(nome + " consumiu " + quantidade + " de comida. Comida atual: " + comida);
    }

    public void consumirAgua(int quantidade) {
        agua -= quantidade;
        if (agua < 0) agua = 0;
        System.out.println(nome + " consumiu " + quantidade + " de água. Água atual: " + agua);
    }

    public void adicionarComida(int quantidade) {
        comida += quantidade;
        if (comida > maxComida) comida = maxComida;
        System.out.println(nome + " adicionou " + quantidade + " de comida. Comida atual: " + comida);
    }

    public void adicionarAgua(int quantidade) {
        agua += quantidade;
        if (agua > maxAgua) agua = maxAgua;
        System.out.println(nome + " adicionou " + quantidade + " de água. Água atual: " + agua);
    }

    // Método para consumir recursos a cada turno e aplicar penalidades
    public void consumirRecursosPorTurno() {
        consumirComida(1);
        consumirAgua(1);
        perderEnergia(2); // energia sempre cai a cada turno

        if (comida == 0) {
            sofrerDano(5);
            System.out.println(nome + " está morrendo de fome!");
        }
        if (agua == 0) {
            sofrerDano(7);
            System.out.println(nome + " está morrendo de sede!");
        }
        if (energia == 0) {
            System.out.println(nome + " está exausto e precisa descansar!");
            // Poderia adicionar efeito de perda de turno ou algo similar
        }
    }

    public abstract void habilidadeEspecial(); // Cada personagem terá uma habilidade única
}
