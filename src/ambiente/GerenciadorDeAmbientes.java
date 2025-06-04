package ambiente;

import personagem.Personagem;
import item.Item;
import item.Inventario;
import excecoes.AmbienteInacessivelException;

import java.util.*;

public class GerenciadorDeAmbientes {

    private Ambiente ambienteAtual;
    private List<Ambiente> todosAmbientes;

    public GerenciadorDeAmbientes() {
        todosAmbientes = new ArrayList<>();
        todosAmbientes.add(new Floresta());
        todosAmbientes.add(new Montanha());
        todosAmbientes.add(new Caverna());
        todosAmbientes.add(new LagoERio());
        todosAmbientes.add(new Ruinas());

        ambienteAtual = todosAmbientes.get(0); // Começa na floresta
    }

    public Ambiente getAmbienteAtual() {
        return ambienteAtual;
    }

    public void mostrarAmbientesDisponiveis() {
        System.out.println("Ambientes disponíveis para se mover:");
        for (int i = 0; i < todosAmbientes.size(); i++) {
            Ambiente amb = todosAmbientes.get(i);
            System.out.println(i + " - " + amb.getNome() + ": " + amb.getDescricao());
        }
    }

    public void mudarAmbiente(int escolha) throws AmbienteInacessivelException {
        if (escolha < 0 || escolha >= todosAmbientes.size()) {
            throw new AmbienteInacessivelException("Escolha inválida. O ambiente selecionado não existe.");
        }

        Ambiente proximoAmbiente = todosAmbientes.get(escolha);


        ambienteAtual = proximoAmbiente;
        System.out.println("Você se moveu para: " + ambienteAtual.getNome());
    }

    private void processarColetaDeItem(Personagem jogador, Scanner scanner, List<Item> itensDisponiveis) {

        if (itensDisponiveis.isEmpty()) {
            System.out.println("Nenhum item para coletar encontrado neste local.");
            return;
        }

        System.out.println("\nItens disponíveis para coleta:");
        for (int i = 0; i < itensDisponiveis.size(); i++) {
            System.out.println((i + 1) + ". " + itensDisponiveis.get(i).getNome());
        }

        System.out.print("Digite o número do item que deseja pegar (0 para nenhum): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha > 0 && escolha <= itensDisponiveis.size()) {
            Item itemEscolhido = itensDisponiveis.get(escolha - 1);
            try {
                jogador.getInventario().adicionarItem(itemEscolhido);
                ambienteAtual.removerItem(itemEscolhido);
                System.out.println("Você pegou o(a) " + itemEscolhido.getNome() + ".");
            } catch (excecoes.InventarioCheioException e) {
                System.out.println("Não foi possível pegar o item. " + e.getMessage());
            }
        } else {
            System.out.println("Você decidiu não pegar nenhum item.");
        }
    }

    public void explorarAmbiente(Personagem jogador, Inventario inventario, Scanner scanner) {
        System.out.println("\n--- Exploração do Ambiente: " + ambienteAtual.getNome() + " ---");
        ambienteAtual.explorar(jogador);

        processarColetaDeItem(jogador, scanner, ambienteAtual.getRecursosDisponiveis());
    }


    public void explorarAmbiente(Personagem jogador) {
        explorarAmbiente(jogador, jogador.getInventario(), new Scanner(System.in));
    }

    public void executarEventoDoAmbiente(Personagem jogador) {
        System.out.println("\n--- Evento Aleatório no Ambiente ---");
        ambienteAtual.gerarEvento(jogador);
    }

    public void modificarCondicoesClimaticas() {
        System.out.println("\n--- Mudança Climática no Ambiente ---");
        ambienteAtual.modificarClima();
    }

    public void listarRecursosDisponiveis(Personagem jogador, Scanner scanner) {
        System.out.println("\n--- Recursos disponíveis no ambiente atual ---");
        List<Item> recursos = ambienteAtual.getRecursosDisponiveis();

        if (recursos.isEmpty()) {
            System.out.println("Nenhum recurso listado no momento.");
        } else {
            for (Item recurso : recursos) {
                System.out.println("- " + recurso.getNome());
            }
        }

        System.out.print("Deseja coletar algum desses itens? (s/n): ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            processarColetaDeItem(jogador, scanner, recursos);
        } else {
            System.out.println("Você decidiu não coletar nenhum item neste momento.");
        }
    }
}