package criatura;

import personagem.Personagem;

public class Lebre extends Criatura {
    public Lebre() {
        super("Lebre", 0, 0);
    }

    @Override
    public void interagir(Personagem personagem) {
        System.out.println("Uma lebre aparece... parece inofensiva.");
        System.out.println(personagem.getNome() + " se distrai e perde um turno observando o animal.");
        personagem.perderEnergia(2); // leve distração
    }
}
