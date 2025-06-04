package evento;

public abstract class EventoAleatorio {
    protected String nome;
    protected String descricao;

    public EventoAleatorio(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }


    public abstract void executar();
}