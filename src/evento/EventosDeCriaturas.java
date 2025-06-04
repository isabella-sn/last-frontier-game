package evento;

public class EventosDeCriaturas extends EventoAleatorio {

    public EventosDeCriaturas(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void executar() {
        System.out.println("Evento de Criaturas: " + nome);
        System.out.println(descricao);

    }
}