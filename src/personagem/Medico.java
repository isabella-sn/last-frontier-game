package personagem;

public class Medico extends Personagem {

    public Medico(String nome) {
        super(nome, 100, 80); // Vida e energia iniciais
    }

    @Override
    public void habilidadeEspecial() {
        System.out.println(nome + " usou Curar! Recuperou a vida de um aliado.");
    }
}