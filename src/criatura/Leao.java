package criatura;

import personagem.Personagem;


public class Leao extends Criatura {
    public Leao() {
        super("Leão", 100, 200);
    }

    @Override
    public void interagir(Personagem personagem) {
        System.out.println("O leão ruge e avança contra " + personagem.getNome() + "!");
        personagem.sofrerDano(forca + 5);
    }
}