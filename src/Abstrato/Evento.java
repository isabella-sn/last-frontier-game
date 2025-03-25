package Abstrato;

public class Evento {
    private String descricao;

    public Evento(String descricao) {
        this.descricao = descricao;
    }

    public void executarEvento(Personagem personagem) {
        System.out.println("Evento ocorreu: " + descricao);
    }
}


