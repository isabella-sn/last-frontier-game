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

        // Mantém recuperação leve de energia (descanso leve, por exemplo)
        personagem.recuperarEnergia(2);

        // Evento aleatório do ambiente
        gerenciador.executarEventoDoAmbiente(personagem);

        // Mudança climática aleatória
        if (Math.random() < 0.3) {
            gerenciador.modificarCondicoesClimaticas();
            System.out.println("O clima mudou neste turno.");
        }

        turnoAtual++;
    }

    public int getTurnoAtual() {
        return turnoAtual;
    }
}
