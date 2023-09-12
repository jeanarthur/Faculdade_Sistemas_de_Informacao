# Atividade: Princípio de Encapsulamento e Lei de Demeter em Java

## Contexto
Imagine que você está trabalhando como desenvolvedor em uma empresa que está desenvolvendo um sistema de gerenciamento de biblioteca. O sistema deve permitir que os usuários cadastrem livros, autores e bibliotecas, bem como verifiquem a disponibilidade de livros em bibliotecas específicas.

## Tarefa
Sua tarefa é criar uma classe `Biblioteca` que siga os princípios de encapsulamento e respeite a Lei de Demeter. Você também deve criar um programa de exemplo que use a classe `Biblioteca` para demonstrar seu funcionamento.

## Requisitos

1. Crie uma classe `Livro` com os seguintes atributos privados:
   - `titulo` (String)
   - `autor` (String)
   - `disponivel` (boolean)

2. Crie uma classe `Autor` com os seguintes atributos privados:
   - `nome` (String)

3. Crie uma classe `Biblioteca` com os seguintes atributos privados:
   - `nome` (String)
   - `livros` (uma lista de objetos `Livro`)
   - `autores` (uma lista de objetos `Autor`)

4. A classe `Biblioteca` deve ter um construtor que recebe o nome da biblioteca e inicializa as listas de livros e autores como vazias.

5. A classe `Biblioteca` deve ter um método público chamado `adicionarLivro` que aceita um objeto `Livro` como parâmetro e adiciona o livro à lista de livros da biblioteca.

6. A classe `Biblioteca` deve ter um método público chamado `adicionarAutor` que aceita um objeto `Autor` como parâmetro e adiciona o autor à lista de autores da biblioteca.

7. A classe `Biblioteca` deve ter um método público chamado `verificarDisponibilidade` que aceita o título de um livro como parâmetro e retorna true se o livro estiver disponível na biblioteca, ou false caso contrário.

## Desenvolvimento do Programa de Exemplo

Crie um programa de exemplo em Java que demonstre o uso da classe `Biblioteca` e suas funcionalidades. O programa deve:

1. Criar uma instância de `Biblioteca`.
2. Criar alguns objetos `Livro` e `Autor`.
3. Adicionar os livros e autores à biblioteca.
4. Verificar a disponibilidade de alguns livros na biblioteca.
5. Exibir os resultados no console.

## Critérios de Avaliação

Você será avaliado com base nos seguintes critérios:

- Implementação correta e completa das classes `Livro`, `Autor` e `Biblioteca` com encapsulamento adequado.
- Implementação dos métodos `adicionarLivro`, `adicionarAutor` e `verificarDisponibilidade` na classe `Biblioteca`.
- Funcionamento correto do programa de exemplo, que demonstra o uso da classe `Biblioteca`.
- Respeito aos princípios de encapsulamento e Lei de Demeter, evitando acesso direto a atributos privados de outras classes.
- Qualidade do código, incluindo boas práticas de nomenclatura e formatação.
