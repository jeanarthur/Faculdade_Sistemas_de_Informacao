package com.biblioteca;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("B1");

        Livro livro1 = new Livro("Livro 1", "Autor 1", true);
        Livro livro2 = new Livro("Livro 2", "Autor 1", false);
        Livro livro3 = new Livro("Livro 3", "Autor 2", false);
        Livro livro4 = new Livro("Livro 4", "Autor 1", true);
        Livro livro5 = new Livro("Livro 5", "Autor 3", true);

        Autor autor1 = new Autor("Autor 1");
        Autor autor2 = new Autor("Autor 2");
        Autor autor3 = new Autor("Autor 3");

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);

        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);
        biblioteca.adicionarAutor(autor3);

        System.out.println((biblioteca.verificarDisponibilidade("Livro 1")) ? "Disponível" : "Indisponível");
        System.out.println((biblioteca.verificarDisponibilidade("Livro 2")) ? "Disponível" : "Indisponível");
        System.out.println((biblioteca.verificarDisponibilidade("Livro 3")) ? "Disponível" : "Indisponível");
        System.out.println((biblioteca.verificarDisponibilidade("Livro 4")) ? "Disponível" : "Indisponível");
        System.out.println((biblioteca.verificarDisponibilidade("Livro 5")) ? "Disponível" : "Indisponível");
    }

}
