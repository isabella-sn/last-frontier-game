package evento;

public class EventosDeDoencasEFerimentos extends EventoAleatorio {

    public EventosDeDoencasEFerimentos(String nome, String descricao) {
        super(nome, descricao);
    }

    @Override
    public void executar() {
        System.out.println("Evento de Doenças e Ferimentos: " + nome);
        System.out.println(descricao);
        // Implementar efeitos negativos no personagem (doenças, ferimentos)
    }
}
