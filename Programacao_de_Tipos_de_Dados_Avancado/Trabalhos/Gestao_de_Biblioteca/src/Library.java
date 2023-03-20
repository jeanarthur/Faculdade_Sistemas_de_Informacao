import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        boolean isRunning = true;

        do{
            String[] menuOptions = {
                    "Adicionar Livro",
                    "Remover Livro",
                    "Buscar Livro(s)",
                    "Gerar Relatório",
                    "Sair"
            };
            printMenu("Biblioteca", menuOptions);
            String option = getInput("Digite uma opção: ");

            try {
                switch (Integer.parseInt(option)){
                    case 1 -> addBook();
                    case 2 -> removeBook();
                    case 3 -> printMenu("Livros", listBooks(searchBooks()).toArray(new String[0]));
                    case 4 -> generateReport();
                    case 5 -> isRunning = false;
                    default -> throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("\u001B[31mOpção inválida!\u001B[0m");
            }
        } while(isRunning);
    }

    private static void generateReport() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        List<String[]> booksRecords = new ArrayList<>();
        String[] header = {"nome_do_livro","numero_de_paginas","nome_do_autor","area_de_interesse"};
        booksRecords.add(header);

        for (Book book : books){
            String[] record = {book.getName(), String.valueOf(book.getPages()), book.getAuthor(), book.getArea()};
            booksRecords.add(record);
        }

        String filename = "booksReport_" + date.format(dateFormatter);
        Csv.write(booksRecords, filename);
        System.out.printf("\u001B[32mRelatório: %s gerado com sucesso!\u001B[0m\n", filename);
    }

    private static void addBook() {
        System.out.println("Preencha os campos: ");
        String name = getInput("Título: ");
        String author = getInput("Autor: ");
        String area = getInput("Área de interesse: ");
        int pages = Integer.parseInt(getInput("Quantidade de páginas: "));
        books.add(new Book(name, pages, author, area));
        System.out.printf("\u001B[32mLivro: %s adicionado com sucesso!\u001B[0m\n", name);
    }

    private static void removeBook() {
        List<Book> foundBooks = searchBooks();
        if (foundBooks.size() == 1){
            books.remove(foundBooks.get(0));
        } else {
            boolean isSelecting = true;
            do{
                List<String> booksList = listBooks(foundBooks);
                booksList.add("Cancelar");
                printMenu("Remover livro nº: ", booksList.toArray(new String[0]));
                String option = getInput("Digite uma opção: ");

                try {
                    int optionValue = Integer.parseInt(option);
                    if (optionValue == foundBooks.size() + 1) { break; }
                    if (optionValue < 1 || optionValue > foundBooks.size()) { throw new Exception(); }
                    Book selectedBook = foundBooks.get(optionValue-1);
                    books.remove(selectedBook);
                    System.out.printf("\u001B[32mLivro %s removido com sucesso!\u001B[0m\n", selectedBook.getName());
                } catch (Exception ex) {
                    System.out.println("\u001B[31mOpção inválida!\u001B[0m");
                    continue;
                }
                isSelecting = false;
            } while (isSelecting);
        }
    }

    public static List<String> listBooks(List<Book> books){
        if (books.size() == 0){ System.out.println("Nenhum livro encontrado!"); }
        else {
            List<String> rows = new ArrayList<>();
            for(Book book : books){
                rows.add(String.format("""
                                Nome: %s
                                Autor: %s
                                Área de interesse: %s
                                Número de páginas: %d
                                
                                """,
                        book.getName(), book.getAuthor(), book.getArea(), book.getPages()));
            }
            return rows;
        }
        return new ArrayList<>();
    }

    private static List<Book> searchByArea() {
        String area = getInput("Digite a area de interesse: ");
        return books.stream().filter(book -> book.getArea().equals(area)).toList();
    }

    private static List<Book> searchByAuthor() {
        String author = getInput("Digite o nome do autor: ");
        return books.stream().filter(book -> book.getAuthor().equals(author)).toList();
    }

    private static List<Book> searchByName() {
        String name = getInput("Digite o nome: ");
        return books.stream().filter(book -> book.getName().equals(name)).toList();
    }

    private static List<Book> searchBooks() {
        boolean isSearching = true;
        List<Book> foundBooks = new ArrayList<>();
        do{
            String[] menuOptions = {
                    "Nome",
                    "Autor",
                    "Área de Interesse",
                    "Cancelar"
            };
            printMenu("Pesquisar por: ", menuOptions);
            String option = getInput("Digite uma opção: ");

            try {
                switch (Integer.parseInt(option)){
                    case 1 -> { foundBooks = searchByName(); isSearching = false; }
                    case 2 -> { foundBooks = searchByAuthor(); isSearching = false; }
                    case 3 -> { foundBooks = searchByArea(); isSearching = false; }
                    case 4 -> isSearching = false;
                    default -> throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("\u001B[31mOpção inválida!\u001B[0m");
            }
        } while (isSearching);
        return foundBooks;
    }

    private static String getInput(String consoleMessage){
        Scanner scanner = new Scanner(System.in);
        System.out.print(consoleMessage);
        return scanner.nextLine();
    }

    private static void printMenu(String title, String[] options){
        int largerLength = title.length();

        for (int i = 0; i < options.length; i++){
            if (options[i].contains("\n")){
                String[] rows = options[i].split("\n");
                int j = 0;
                for(String row : rows){
                    String formattedRow;
                    if (j++ == 0) { formattedRow = String.format("%d. %s", i+1, row); }
                    else { formattedRow = String.format("%s  %s", " ".repeat(String.valueOf(i+1).length()), row); }
                    options[i] = options[i].replaceFirst(row, formattedRow);
                    if (formattedRow.length() > largerLength) { largerLength = formattedRow.length(); }
                }
            } else {
                options[i] = String.format("%d. %s", i+1, options[i]);
                if (options[i].length() > largerLength) { largerLength = options[i].length(); }
            }

        }

        String format = "| %-" + largerLength + "s |\n";
        String separator = String.format("+%s+\n", "=".repeat(largerLength + 2));

        System.out.print(separator);
        System.out.printf(format, title);
        System.out.print(separator);
        for(String option : options){
            if (option.contains("\n")){
                String[] rows = option.split("\n");
                for(String row : rows){ System.out.printf(format, row); }
            } else {
                System.out.printf(format, option);
            }
        }
        System.out.print(separator);
    }

}
