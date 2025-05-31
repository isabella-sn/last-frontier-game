package criatura;

import personagem.Personagem;

public class Crocodilo extends Criatura {
    public Crocodilo() {
        super("Crocodilo", 100, 200);
    }

    @Override
    public void interagir(Personagem personagem) {
        System.out.println("Um crocodilo salta da água e ataca " + personagem.getNome() + "!");
        personagem.sofrerDano(forca + 10);
    }
}
