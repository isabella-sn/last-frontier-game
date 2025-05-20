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

    // Método que executa o efeito do evento (deve ser implementado nas subclasses)
    public abstract void executar();
}
