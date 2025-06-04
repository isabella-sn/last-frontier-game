package personagem;

public class Jogador extends Personagem {
    public Jogador(String nome) {
        super(nome, 100, 100);
    }

    @Override
    public void habilidadeEspecial() {
        System.out.println(nome + " não tem habilidade especial.");
    }
}