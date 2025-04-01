package personagem;

import personagem.personagens.*;

public class Main {
    public static void main(String[] args) {
        Medico medico = new Medico("Doutor Vida");
        Rastreador rastreador = new Rastreador("Olhos de Águia");
        SobreviventeNato sobrevivente = new SobreviventeNato("Lobo Solitário");

        System.out.println("\n-- Teste dos Personagens --");

        medico.exibirStatus();
        medico.habilidadeEspecial();

        System.out.println();

        rastreador.exibirStatus();
        rastreador.habilidadeEspecial();

        System.out.println();

        sobrevivente.exibirStatus();
        sobrevivente.habilidadeEspecial();
    }
}
