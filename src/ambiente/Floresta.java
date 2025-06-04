package ambiente;

import item.Item;
import item.Alimentos;
import item.Materiais;
import item.Agua;
import personagem.Personagem;
import java.util.ArrayList;
import java.util.List;

public class Floresta extends Ambiente {

    public Floresta() {
        super("Floresta", "Uma floresta densa com muitos recursos.", 1.0,
                gerarRecursosIniciais(),
                0.3, "Clima ameno");
    }

    //Método para gerar recursos iniciais da floresta
    private static List<Item> gerarRecursosIniciais() {
        List<Item> recursos = new ArrayList<>();
        recursos.add(new Alimentos(2, 0.5, 15, "berries", false));
        recursos.add(new Materiais(3, 1.0, "madeira", 50));
        recursos.add(new Agua(1, 0.7, "orvalho", 0.5));
        return recursos;
    }


    @Override
    public void explorar(Personagem jogador) {

        System.out.println("Você se aprofunda na floresta. O ar é fresco e o som de pássaros ecoa.");
        System.out.println(this.getDescricao());

    }

    @Override
    public void gerarEvento(Personagem jogador) {
        double chance = Math.random(); // valor entre 0.0 e 1.0

        if (chance < 0.4) {
            // 40% de chance
            System.out.println("Você encontrou frutinhas no caminho e decidiu comer, elas eram venenosas");
            jogador.sofrerDano(80);
        } else if (chance < 0.8) {
            // 40% de chance (de 0.4 a 0.8)
            System.out.println("Você encontrou frutinhas no caminho e decidiu comer, elas não eram venenosas");
            jogador.recuperarEnergia(40);
        } else {
            // 20% de chance (de 0.8 a 1.0)
            System.out.println("Você tentou subir em uma árvore para ter uma visualização melhor do ambiente, caiu e morreu!");
            jogador.sofrerDano(200);
        }
    }

    @Override
    public void modificarClima() {
        String[] climas = {"Ensolarado e Calmo", "Nebuloso com garoa", "Ventos suaves", "Chuva leve"};
        int randomIndex = (int) (Math.random() * climas.length);
        this.condicoesClimaticas = climas[randomIndex];
        System.out.println("O clima na floresta mudou para: " + this.condicoesClimaticas);
    }


    @Override
    public void removerItem(Item item) {
        if (this.getItensDisponiveis() != null) {
            this.getItensDisponiveis().remove(item);
        }

        if (this.recursosDisponiveis != null) {
            this.recursosDisponiveis.remove(item);
        }
    }
}