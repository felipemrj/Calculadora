> :information_source: For the English version, see [DOCUMENTATION.md](DOCUMENTATION.md).

## **Etapa 1: Estruturação Inicial**

- **Definir as funcionalidades do programa:**

Antes de iniciar o desenvolvimento da calculadora em si, dediquei um tempo para visualizar como gostaria que ela ficasse ao final do projeto.
Dessa forma, posso construir o projeto com mais facilidade, já conhecendo as funcionalidades desde o início.
Decidi que os principais recursos seriam: limpar, limpar entrada, apagar, operações aritméticas básicas e suporte a números decimais.
Mesmo sendo elementos simples, o objetivo principal deste projeto é praticar programação orientada a objetos, e não a complexidade do algoritmo.
Para ajudar na visualização, desenhei um protótipo simples:

![Protótipo](images/calculatorPrototype.PNG)

- **Definir a estrutura básica do projeto:**

Visando um projeto bem organizado e que facilite implementação das funcionalidades e expansão, decidi dividir as classes em dois principais pacotes: main e operations.

**main:** Esse pacote contém a classe principal do programa, que centraliza o controle da aplicação, bem como a classe responsável por lidar com a entrada e saída do usuário.

**operations:** Esse pacote é dedicado às classes relacionadas às operações matemáticas, incluindo a superclasse e suas subclasses específicas para cada operação.
Além de proporcionar melhor visibilidade e organização das classes, essa estrutura facilita a aplicação dos conceitos de herança e polimorfismo no futuro.


## **Etapa 2: Projeto e Implementação das Classes**

- **Definir as classes principais:**

No pacote main, a classe Calculator ficará responsável pela lógica da aplicação, e UserInterface irá gerenciar a entrada e saída do usuário.
No pacote operations, criei Operator para servir como superclasse e as subclasses para cada operação matemática.

```
src/
  ├── main/
  │    ├── Calculator.java
  │    └── UserInterface.java        
  └── operations/
       ├── Operator.java
       ├── Addition.java
       ├── Subtraction.java
       ├── Multiplication.java
       ├── Division.java
       └── Percentage.java
```

- **Aplicar encapsulamento:**

Todos os atributos das classes são privados, garantindo que só possam ser acessados externamente através de métodos públicos (getters). Isso previne que outras partes do código alterem valores diretamente, protegendo a integridade dos dados.
Além disso, as subclasses de Operator trabalham apenas com os operandos recebidos via construtor.

## Etapa 3: Herança, Polimorfismo e Abstração

- **Criar a hierarquia de operações:**

Todas as operações aritméticas herdam da classe abstrata `Operator`, que encapsula a lógica compartilhada e serve como interface comum para todas as operações.

- **Aplicar herança, polimorfismo e abstração:**

  - **Herança:** Todas as classes de operações aritméticas (`Addition`, `Subtraction`, etc.) estendem a superclasse `Operator`, reutilizando sua lógica e garantindo uma interface consistente.
  - **Polimorfismo:** Usando o tipo `Operator` para os objetos de operação, a calculadora pode tratar cada operação da mesma forma. Isso torna o código escalável, fácil de manter e flexível para futuras expansões.
  - **Abstração:** A superclasse `Operator` define o método abstrato `calculate()`, e cada subclasse fornece sua implementação específica, garantindo um contrato para todas as operações.

---

## Etapa 4: Implementação e Testes (Iterativo)

- **Implementar funcionalidades e testar cada uma:**

Nenhuma nova funcionalidade foi adicionada nesta etapa, mas o código foi polido para maior clareza e consistência. As mensagens para o usuário foram melhoradas para guiá-lo a inserir dados válidos; os cálculos agora rodam em loop para facilitar o uso e o teste. Nomes de variáveis e a estrutura do código foram aprimorados para melhor legibilidade, e os resultados agora são formatados antes de serem exibidos.

- **Tratar erros e exceções:**

A calculadora passou a validar toda entrada do usuário para garantir que apenas dados válidos sejam aceitos (usando entrada como string e parse para double). Exceções como `NumberFormatException` e `ArithmeticException` são tratadas adequadamente. Testes manuais foram realizados, cobrindo cenários como operações básicas, entrada inválida, divisão por zero e cálculos contínuos.

## Etapa 5: Interface Gráfica (UI)

- **Implementar a interface gráfica:**

A interface de linha de comando foi substituída por uma interface gráfica usando Java Swing. Agora, a calculadora abre em uma janela, com todos os botões e o display organizados em um GridBagLayout. O display é um JTextField de somente leitura que mostra as entradas e o resultado, e cada botão é um JButton conectado às classes de operações por meio de action listeners. Agora o projeto conta com uma GUI funcional e muito mais amigável para o usuário.

## Etapa 6: Refatoração e Melhorias

Nessa etapa, revisei e refatorei o código buscando maior clareza, manutibilidade e escalabilidade. Introduzi métodos auxiliares na GUI para eliminar repetição na criação e configuração dos botões, além de melhorar a nomeação de variáveis em todo o código. A lógica de cada operação aritmética foi separada em sua própria classe, reforçando a estrutura orientada a objetos e facilitando futuras modificações. O tratamento de exceções também foi aprimorado, proporcionando melhor retorno ao usuário, especialmente em operações inválidas como divisão por zero.

## Etapa 7: Documentação Final e Reflexão

Este projeto é uma aplicação Java Swing criada para praticar os princípios da programação orientada a objetos. Durante o desenvolvimento, foquei em separar a interface do usuário da lógica de cálculo, que reside no pacote operations. Cada operação é implementada como uma subclasse da classe abstrata Operator, tornando a calculadora mais fácil de manter e expandir.

Refletindo sobre este projeto, aprendi a importância de projetar códigos modulares e legíveis. Manter a lógica separada da interface facilitou o trabalho e evidenciou os benefícios da POO. Utilizar o Swing para o layout foi desafiador no início, mas consegui alcançar a experiência de usuário que havia imaginado.

No geral, construir esta calculadora foi uma experiência valiosa, reforçando boas práticas de design, refatoração, documentação e controle de versão. No futuro, gostaria de adicionar recursos como suporte ao teclado, funções de memória e um painel de histórico para tornar a aplicação ainda mais completa.