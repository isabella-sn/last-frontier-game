package item;

import java.util.ArrayList;
import java.util.Iterator;
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
    public boolean estaVazio() {
        return listaDeItens.isEmpty();
    }



    public boolean removerItem(String nomeItem) {
        Iterator<Item> iter = listaDeItens.iterator();
        while (iter.hasNext()) {
            Item item = iter.next();
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                pesoTotal -= item.getPesoTotal();
                iter.remove();
                System.out.println(nomeItem + " removido do inventário.");
                return true;
            }
        }
        System.out.println(nomeItem + " não encontrado no inventário.");
        return false;
    }

    public boolean usarItem(String nomeItem) {
        for (int i = 0; i < listaDeItens.size(); i++) {
            Item item = listaDeItens.get(i);
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                item.usar();
                pesoTotal -= item.getPesoTotal();
                listaDeItens.remove(i);
                System.out.println(nomeItem + " foi usado e removido do inventário.");
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
                System.out.println("Item no inventário: " + item.getNome());
                item.exibirInfo();
                System.out.println("------------------------");
            }
            System.out.println("Peso total: " + pesoTotal + " / " + espacoDisponivel);
        }

        System.out.println("=======================\n");
    }

    public boolean contemItem(String nomeItem) {
        for (Item item : listaDeItens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return true;
            }
        }
        return false;
    }
}
