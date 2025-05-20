package criatura;

import personagem.Personagem;


public class Leao extends Criatura {
    public Leao() {
        super("Leão", 20);
    }

    @Override
    public void interagir(Personagem personagem) {
        System.out.println("O leão ruge e avança contra " + personagem.getNome() + "!");
        personagem.sofrerDano(forca + 5);
    }
}
