package evento;

public class EventosDeDescoberta extends EventoAleatorio {

    public EventosDeDescoberta(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void executar() {
        System.out.println("Evento de Descoberta: " + nome);
        System.out.println(descricao);

    }
}
