package evento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ControladorDeEventos {
    private List<EventoAleatorio> eventos;
    private Random random;

    public ControladorDeEventos() {
        eventos = new ArrayList<>();
        random = new Random();
        inicializarEventos();
    }

    private void inicializarEventos() {
        // Eventos Climáticos
        eventos.add(new EventosClimaticos("Chuva Ácida", "Chuva tóxica que danifica alguns itens."));
        eventos.add(new EventosClimaticos("Tempestade", "Tempestade forte que atrasa seu progresso."));

        // Eventos de Criaturas
        eventos.add(new EventosDeCriaturas("Ataque de Lobos", "Um bando de lobos te cerca e ataca."));
        eventos.add(new EventosDeCriaturas("Encontro com Águia", "Uma águia observa seus movimentos."));

        // Eventos de Descoberta
        eventos.add(new EventosDeDescoberta("Descoberta de Ruínas", "Você encontra ruínas antigas com suprimentos."));
        eventos.add(new EventosDeDescoberta("Fonte de Água", "Encontra uma fonte de água potável."));

        // Eventos de Doenças e Ferimentos
        eventos.add(new EventosDeDoencasEFerimentos("Febre", "Você contraiu febre, perdendo energia."));
        eventos.add(new EventosDeDoencasEFerimentos("Ferimento na Perna", "Você se machucou e não pode correr."));
    }

    public void dispararEventoAleatorio() {
        double chance = random.nextDouble();
        if (chance < 0.5) { // 50% de chance de ocorrer evento
            EventoAleatorio evento = eventos.get(random.nextInt(eventos.size()));
            evento.executar();
        } else {
            System.out.println("Nada de especial aconteceu desta vez.");
        }
    }
}
