<h1 align = "center">
  BTI/UFRN 2023.2 - Linguagem de Programação II: Projeto Final
</h1>

<p align ="center">
<a href= "#sobre-este-projeto">👨🏻‍💻 Sobre este projeto</a> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
<a href="#diagrama">📐 Diagrama de Classes</a> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
<a href="#instalar">📋 Instruções de compilação</a> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
<a href="#executar">📝 Como executar</a> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
<a href="#testes">🧪 Como realizar os testes</a>
</p>

**Alunos:** João Marcelo de Souza (Mat.: 20220030819) | José Manoel Freitas da Silva (Mat.: 20220039467)
***

<h2 id = "sobre-este-projeto">👨🏻‍💻 Sobre este projeto</h2>

Este repositório contém o projeto final desenvolvido pelos alunos [José Manoel Freitas da Silva](https://github.com/JosManoel) e [João Marcelo de Souza](https://github.com/MarceloJoao), na matéria de **Linguagem de Programação II** do Bacharelado em Tecnologia da Informação, ofertado pelo IMD/UFRN.

O propósito deste projeto é reimplementar um sistema de gerenciamento para uma empresa, incluindo módulos para gerenciamento de funcionários, finanças e negócios, que foi originalmente desenvolvido na matéria de  **Linguagem de Programação I**, também ofertada no Bacharelado em Tecnologia da Informação, ofertado pelo IMD/UFRN. O intuito dessa atividade é colocar em prática o conteúdo aprendido de modo a refatorar um projeto já existente, comparando as diferenças entre as versões.

* [Video de apresentação](https://drive.google.com/file/d/1qaJQtL7ul5kqAFu6_qujAwxVy_trlmTx/view?usp=sharing)

***

<h2 id="diagrama">📐 Diagrama de Classes</h2>
<img src="image/diagram.png">

***

<h2 id="instalar">📋 Instruções de compilação</h2>

Para compilar o projeto é utilizado o seguinte comando:

```bash
./gradlew build && mv build/libs/*.jar ./projeto-final-lp2.jar
```

Ao final da compilação será gerado um arquivo .jar na raiz do diretório com o titulo de **_projeto-final-lp2_**.

Caso ocorra algum erro de permissão, em um ambiente linux, execute o seguinte comando:

```bash
chmod +x ./gradlew
```
***

<h2 id="executar">📝 Como executar</h2>
Após compilar o projeto, você pode executar o programa usando o seguinte comando:

```bash
java -jar projeto-final-lp2.jar
```

***

<h2 id=“testes”>🧪 Como realizar os testes</h2>

Caso seja necessário verificar os testes implementados, utilize:

```bash
./gradlew test
```

<div align = "center">

👋 Feito por [MarceloJoao](https://github.com/MarceloJoao) e [JosManoel](https://github.com/JosManoel) com ☕ , 🎧 e 💻.

</div> 
