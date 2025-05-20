package personagem;

public class Rastreador extends Personagem {

    public Rastreador(String nome) {
        super(nome, 90, 100);
    }

    @Override
    public void habilidadeEspecial() {
        System.out.println(nome + " usou Rastrear! Encontrou suprimentos escondidos.");
    }
}
