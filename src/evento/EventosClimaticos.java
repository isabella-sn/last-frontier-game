package evento;

public class EventosClimaticos extends EventoAleatorio {

    public EventosClimaticos(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void executar() {
        System.out.println("Evento Climático: " + nome);
        System.out.println(descricao);
        // Implementar efeito climático (ex: chuva ácida, tempestade)
    }
}
