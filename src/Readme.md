# 🌲 Jogo de Sobrevivência - POO com Java

Este é um jogo de sobrevivência baseado em texto desenvolvido como projeto para a disciplina de **Programação Orientada a Objetos (POO)**. O jogo utiliza conceitos fundamentais como **herança**, **polimorfismo**, **encapsulamento**, **composição**, **tratamento de exceções**, **menus com Scanner**, além de **eventos dinâmicos** e um **sistema de ambientes e inventário**.

---

## 🎮 Objetivo do Jogo

O jogador escolhe entre três personagens com habilidades únicas e deve explorar ambientes variados (como Floresta, Caverna, Montanha, Lago e Ruínas), coletar recursos, sobreviver a eventos e gerenciar seu inventário.

---

## 📁 Estrutura do Projeto

Jogo Sobrevivencia LPOO/
│
├── .idea/                         
├── out/                           
├── src/                            
│   ├── ambiente/
│   │   ├── ambientes/
│   │   │   ├── Ambiente.java
│   │   │   ├── Caverna.java
│   │   │   ├── Floresta.java
│   │   │   ├── GerenciadorDeAmbientes.java
│   │   │   ├── LagoERio.java
│   │   │   ├── Montanha.java
│   │   │   ├── Ruinas.java
│   │   │   └── Amientes.java      
│   │
│   ├── criatura/
│   │   └── criaturas/
│   │       ├── Cobra.java
│   │       ├── Crocodilo.java
│   │       ├── Leao.java
│   │       ├── Lebre.java
│   │       └── Criaturas.java
│
│   ├── evento/
│   │   └── eventos/
│   │       ├── EventosClimaticos.java
│   │       ├── EventosDeCriaturas.java
│   │       ├── EventosDeDescoberta.java
│   │       └── EventosDeDoencasEFerimentos.java
│   │   └── Eventos.java
│
│   ├── item/
│   │   └── itens/
│   │       ├── Agua.java
│   │       ├── Alimentos.java
│   │       ├── Armas.java
│   │       ├── Ferramentas.java
│   │       ├── Inventario.java
│   │       ├── Item.java
│   │       ├── Materiais.java
│   │       └── Remedios.java
│   │   └── Itens.java
│
│   ├── personagem/
│   │   └── personagens/
│   │       ├── Medico.java
│   │       ├── Personagem.java
│   │       ├── Rastreador.java
│   │       └── SobreviventeNato.java
│   │   └── Personagens.java
│
│   ├── Main.java                   
│   └── Readme.md                 
│
├── .gitignore
├── Jogo Sobrevivencia LPOO.iml

```

---

## 👨‍💻 Funcionalidades Implementadas

- ✅ Sistema de seleção de personagem  
- ✅ Inventário com limite de peso e uso de itens  
- ✅ Ambientes únicos com clima, eventos e recursos  
- ✅ Exploração de ambiente com eventos aleatórios  
- ✅ Sistema de movimentação entre ambientes  
- ✅ Exibição de status e habilidades especiais dos personagens  

---

## 🧪 Como Executar

1. Clone o projeto ou baixe os arquivos.
2. Abra o projeto no **Visual Studio Code** ou **IntelliJ IDEA**.
3. Compile e execute a classe `Main.java`.
4. Jogue pelo terminal, utilizando o menu interativo para navegar entre ações.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Programação Orientada a Objetos (POO)
- Scanner (entrada de dados)
- Estruturas de controle e listas (`ArrayList`)

---

## ✍️ Autor

Isabella — Projeto para a disciplina de Programação Orientada a Objetos (POO)

---

## 📌 Licença

Este projeto é apenas para fins educacionais.

