package personagem;

import item.Inventario;
import item.Armas;
import excecoes.MortePorFomeOuSedeException;

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

    //Combate
    protected String tipoCombate;
    protected Armas arma;

    public Personagem(String nome, int vida, int energia) {
        this.nome = nome;
        this.vida = Math.min(vida, maxVida);
        this.energia = Math.min(energia, maxEnergia);
        this.saude = maxSaude;
        this.comida = maxComida / 2;
        this.agua = maxAgua / 2;
        this.inventario = new Inventario(50.0);
        this.tipoCombate = "Corpo a corpo";
        this.arma = null;
    }

    public void setArma(Armas arma) {
        this.arma = arma;
        System.out.println(nome + " equipou uma arma do tipo: " + arma.getTipo());
    }

    public Armas getArma() {
        return arma;
    }

    public void atacar(String alvo) {
        if (arma != null) {
            arma.atacar(alvo);
        } else {
            System.out.println(nome + " não está equipado com nenhuma arma!");
        }
    }

    public Inventario getInventario() {
        return inventario;
    }

    public String getNome() {
        return nome;
    }

    public int getComida() {
        return comida;
    }

    public int getAgua() {
        return agua;
    }

    public int getVida() {
        return vida;
    }

    public int getEnergia() {
        return energia;
    }

    public int getSaude() {
        return saude;
    }


    public void exibirStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida + "/" + maxVida);
        System.out.println("Energia: " + energia + "/" + maxEnergia);
        System.out.println("Saúde: " + saude + "/" + maxSaude);
        System.out.println("Comida: " + comida + "/" + maxComida);
        System.out.println("Água: " + agua + "/" + maxAgua);
        System.out.println("Tipo de Combate: " + tipoCombate);
        if (arma != null) {
            System.out.println("Arma equipada: " + arma.getTipo() +
                    " | Dano: " + arma.getDano() +
                    " | Alcance: " + arma.getAlcance());
        } else {
            System.out.println("Arma equipada: Nenhuma");
        }
    }

    public void exibirBarrasDeStatus() {
        System.out.println("Comida: " + gerarBarra(comida, maxComida));
        System.out.println("Água: " + gerarBarra(agua, maxAgua));
    }

    private String gerarBarra(int valor, int max) {
        int total = 20;
        int preenchido = (valor * total) / max;
        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < total; i++) {
            barra.append(i < preenchido ? "█" : " ");
        }
        barra.append("] ").append(valor).append("/").append(max);
        return barra.toString();
    }

    public void perderEnergia(int quantidade) {
        this.energia -= quantidade;
        if (this.energia < 0) {
            this.energia = 0;
        }
        System.out.println(nome + " perdeu " + quantidade + " de energia. Energia atual: " + energia);
    }


    public void recuperarEnergia(int valor) {
        energia += valor;
        if (energia > maxEnergia) energia = maxEnergia;
        System.out.println(nome + " recuperou " + valor + " de energia. Energia atual: " + energia);
    }

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


    public void sofrerDano(int dano) {
        this.vida -= dano;

        if (this.vida <= 0) {
            this.vida = 0;
            System.out.println(nome + " sofreu " + dano + " de dano. Vida atual: " + vida);
            throw new MortePorFomeOuSedeException(nome + " morreu devido a ferimentos graves!");
        } else {
            System.out.println(nome + " sofreu " + dano + " de dano. Vida atual: " + vida);
        }
    }

    public void morrer() {
        throw new MortePorFomeOuSedeException(nome + "Você morreu. Fim de jogo."); // Lança a exceção
    }



    public void verificarMorte() {
        if (this.vida <= 0 || this.saude <= 0) {
            throw new MortePorFomeOuSedeException(nome + " não sobreviveu!");
        }
    }


    public void consumirRecursosPorTurno() {
        consumirComida(1);
        consumirAgua(1);
        perderEnergia(2);

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
        }

    }
    public abstract void habilidadeEspecial();
}