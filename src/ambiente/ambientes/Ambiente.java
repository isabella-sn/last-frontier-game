package ambiente.ambientes;

import item.itens.Item;
import personagem.personagens.Personagem;

import java.util.List;

public abstract class Ambiente {
    protected String nome;
    protected String descricao;
    protected double dificuldadeExploracao;
    protected List<Item> recursosDisponiveis;
    protected double probabilidadeEventos;
    protected String condicoesClimaticas;
    protected List<Item> itensDisponiveis;




    public Ambiente(String nome, String descricao, double dificuldadeExploracao,
                    List<Item> recursosDisponiveis, double probabilidadeEventos,
                    String condicoesClimaticas) {
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldadeExploracao = dificuldadeExploracao;
        this.recursosDisponiveis = recursosDisponiveis;
        this.probabilidadeEventos = probabilidadeEventos;
        this.condicoesClimaticas = condicoesClimaticas;
    }
    public List<Item> getItensDisponiveis() {
        return itensDisponiveis;

    }
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Item> getRecursosDisponiveis() {
        return recursosDisponiveis;
    }

    public abstract void explorar(Personagem jogador);

    public abstract void gerarEvento(Personagem jogador);

    public abstract void modificarClima();

    public abstract void removerItem(Item item);
}