package item.itens;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> listaDeItens;
    private double pesoTotal;
    private double espacoDisponivel;

    public Inventario(double espacoMaximo) {
        this.listaDeItens = new ArrayList<>();
        this.pesoTotal = 0.0;
        this.espacoDisponivel = espacoMaximo;
    }

    public boolean adicionarItem(Item item) {
        double pesoDoItem = item.getPesoTotal();

        if (pesoTotal + pesoDoItem <= espacoDisponivel) {
            listaDeItens.add(item);
            pesoTotal += pesoDoItem;
            System.out.println(item.getNome() + " adicionado ao inventário.");
            return true;
        } else {
            System.out.println("Sem espaço suficiente para adicionar " + item.getNome());
            return false;
        }
    }

    public boolean removerItem(String nomeItem) {
        for (Item item : listaDeItens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                listaDeItens.remove(item);
                pesoTotal -= item.getPesoTotal();
                System.out.println(nomeItem + " removido do inventário.");
                return true;
            }
        }
        System.out.println(nomeItem + " não encontrado no inventário.");
        return false;
    }

    public boolean usarItem(String nomeItem) {
        for (Item item : listaDeItens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                item.usar();
                return true;
            }
        }
        System.out.println(nomeItem + " não encontrado no inventário.");
        return false;
    }

    public void mostrarInventario() {
        System.out.println("\n===== Inventário =====");

        if (listaDeItens.isEmpty()) {
            System.out.println("O inventário está vazio.");
        } else {
            for (Item item : listaDeItens) {
                item.exibirInfo();
                System.out.println("------------------------");
            }
            System.out.println("Peso total: " + pesoTotal + " / " + espacoDisponivel);
        }

        System.out.println("=======================\n");
    }
}
