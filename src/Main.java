package src;

import item.itens.*;
import personagem.personagens.*;



public class Main {
    public static void main(String[] args) {

       //Personagens
        Medico medico = new Medico("Doutor Vida");
        Rastreador rastreador = new Rastreador("Olhos de Águia");
        SobreviventeNato sobrevivente = new SobreviventeNato("Lobo Solitário");


        //Itens dos personagens
        Inventario inventarioMedico = new Inventario(50);
        Inventario inventarioRastreador = new Inventario(60);
        Inventario inventarioSobrevivente = new Inventario(70);

        //Adicionando itens nos inventários
        inventarioMedico.adicionarItem(new Remedios(2, 1.5));
        inventarioMedico.adicionarItem(new Agua());

        inventarioRastreador.adicionarItem(new Alimentos(2, 2.0));
        inventarioRastreador.adicionarItem(new Ferramentas(1, 5.0));

        inventarioSobrevivente.adicionarItem(new Armas(1, 10.0));
        inventarioSobrevivente.adicionarItem(new Materiais(4, 3.0));


        //Status Personagem
        System.out.println("\n-- Teste dos Personagens --");
        medico.exibirStatus();
        medico.habilidadeEspecial();
        inventarioMedico.mostrarInventario();

        System.out.println();

        rastreador.exibirStatus();
        rastreador.habilidadeEspecial();
        inventarioRastreador.mostrarInventario();

        System.out.println();

        sobrevivente.exibirStatus();
        sobrevivente.habilidadeEspecial();
        inventarioSobrevivente.mostrarInventario();


        //Usando e removendo itens de exemplo

        System.out.println("\n-- Usando e Removendo Itens --");
        inventarioMedico.usarItem("Remédios");
        inventarioMedico.removerItem("Água");

        inventarioMedico.mostrarInventario();

    }
}
