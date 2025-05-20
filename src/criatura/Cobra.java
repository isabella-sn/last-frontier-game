package criatura;

import personagem.Personagem;

public class Cobra extends Criatura {
    public Cobra() {
        super("Cobra", 10); // força 10
    }

    @Override
    public void interagir(Personagem personagem) {
        System.out.println("Uma cobra venenosa morde " + personagem.getNome() + "!");
        personagem.sofrerDano(forca);
        personagem.perderEnergia(5);
    }
}
