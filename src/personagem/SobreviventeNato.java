package personagem;

public class SobreviventeNato extends Personagem {

    public SobreviventeNato(String nome) {
        super(nome, 120, 90);
    }

    @Override
    public void habilidadeEspecial() {
        System.out.println(nome + " se adaptou ao ambiente! Resistência aumentada.");
    }
}
