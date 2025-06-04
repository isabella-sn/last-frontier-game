package sistema;

import personagem.Personagem;
import ambiente.GerenciadorDeAmbientes;


public class ControladorDeTurnos {
    private int turnoAtual;

    public ControladorDeTurnos() {
        this.turnoAtual = 1;
    }

    public void executarTurno(Personagem personagem, GerenciadorDeAmbientes gerenciador) {
        System.out.println("\n--- Turno " + turnoAtual + " ---");


        personagem.recuperarEnergia(2);


        personagem.consumirRecursosPorTurno();



        gerenciador.executarEventoDoAmbiente(personagem);


        if (Math.random() < 0.3) {
            gerenciador.modificarCondicoesClimaticas();
            System.out.println("O clima mudou neste turno.");
        }

        personagem.verificarMorte();


        turnoAtual++;
    }

    public int getTurnoAtual() {
        return turnoAtual;
    }
}