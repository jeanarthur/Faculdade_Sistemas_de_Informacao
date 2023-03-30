import java.util.ArrayList;
import java.util.List;

public class Book {
    private String name;
    private int pages;
    private String author;
    private String area;

    public Book(String name, int pages, String author, String area){
        this.name = name;
        this.pages = pages;
        this.author = author;
        this.area = area;
    }

    public String getName() { return name; }
    public int getPages() { return pages; }
    public String getAuthor() { return author; }
    public String getArea() { return area; }

    public static List<Book> parseBook(List<String[]> data){
        List<Book> books = new ArrayList<>();
        for (String[] row : data){ books.add(new Book(row[0], Integer.parseInt(row[1]), row[2], row[3])); }
        return books;
    }

    public static List<String[]> toCsvPattern(List<Book> books){
        List<String[]> booksRecords = new ArrayList<>();
        String[] header = {"nome_do_livro","numero_de_paginas","nome_do_autor","area_de_interesse"};
        booksRecords.add(header);

        for (Book book : books){
            String[] record = {book.getName(), String.valueOf(book.getPages()), book.getAuthor(), book.getArea()};
            booksRecords.add(record);
        }

        return booksRecords;
    }

}
