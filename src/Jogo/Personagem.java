import java.util.List;

        public class Personagem {
            private String nome;
            private int vida;
            private int fome;
            private int sede;
            private int energia;
            private int sanidade;
            private List<String> inventario;
            private String localizacao;
            private String Classe;
            private String habilidadeEspecial;

            public Personagem(String nome, String Classe) {
                this.nome = nome;
                this.Classe = Classe;
                this.vida = 100;
                this.fome = 100;
                this.sede = 100;
                this.energia = 100;
                this.sanidade = 100;
                this.inventario = new java.util.ArrayList<>();
                this.localizacao = "Ponto Inicial";
                this.habilidadeEspecial = definirHabilidadeEspecial(Classe);

            }
            private String definirHabilidadeEspecial(String classe){
                return switch (classe.toLowerCase()){
                    case "rastreador" -> "Encontra comida e água com mais facilidade";
                    case "mecanico" -> "Conserta ferramentas e cria novas armas";
                    case "medico" -> "Pode tratar ferimentos sem necessidade de itens raros";
                    case "sobrevivente nato" -> "Menos impacto por fome e sede";
                    default -> "Nenhuma habilidade especial";

                };
            }
            public void consumirRecursos() {
                this.fome -= 10;
                this.sede -= 15;
                this.energia -= 5;
                if(fome <= 20 || sede <=20){
                    this.vida -= 5;
                    }
                if (energia <= 0){
                    this.sanidade -= 10;
                }
            }
            public void descansar() {
                this.energia = 100;
                this.sanidade += 10;
            }
            public void adiccionarItemAoInventario(String item){
                this.inventario.add(item);
            }
            public void moverPara(String novaLocalizacao){
                this.localizacao = novaLocalizacao;
            }
            public String getStatus(){
                return String.format("Nome: %s \nClasse: %s\nVida: %d\nFome: %d\nSede: %d\nEnergia: %d\nSanidade: %d\nLocalização: %s\nHabilidade Especial: %s\nInvnetário: %s",
                     nome, Classe, vida, fome, sede, energia, sanidade, localizacao, habilidadeEspecial, inventario);
            }
        }