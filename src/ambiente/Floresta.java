package ambiente;

import item.Item;
import personagem.Personagem;

import java.util.List;
import java.util.Scanner;

public class Floresta extends Ambiente {

    public Floresta() {
        super("Floresta", "Uma floresta densa com muitos recursos.", 1.0,
                List.of(/* itens iniciais */), 0.3, "Clima ameno");
    }

    @Override
    public void explorar(Personagem jogador) {
        Scanner scanner = new Scanner(System.in);
        List<Item> itens = this.recursosDisponiveis;

        if (itens.isEmpty()) {
            System.out.println("Nenhum item encontrado na floresta.");
            return;
        }

        System.out.println("Você encontrou os seguintes itens na floresta:");

        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i + 1) + ". " + itens.get(i).getNome());
        }

        System.out.print("Digite o número do item que deseja pegar (0 para nenhum): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha > 0 && escolha <= itens.size()) {
            Item itemEscolhido = itens.get(escolha - 1);

            boolean conseguiuAdicionar = jogador.getInventario().adicionarItem(itemEscolhido);

            if (conseguiuAdicionar) {
                itens.remove(itemEscolhido);
                System.out.println("Você pegou o item: " + itemEscolhido.getNome());
            } else {
                System.out.println("Não foi possível pegar o item (inventário cheio ou sem espaço).");
            }
        } else {
            System.out.println("Você decidiu não pegar nenhum item.");
        }
    }

    @Override
    public void gerarEvento(Personagem jogador) {
        // Implementar eventos específicos da floresta
    }

    @Override
    public void modificarClima() {
        // Implementar mudança de clima da floresta
    }
    @Override
    public void removerItem(Item item) {
        if (this.getItensDisponiveis() != null) {
            this.getItensDisponiveis().remove(item);
        }
    }


}