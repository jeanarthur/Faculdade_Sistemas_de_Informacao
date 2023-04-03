import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Library {
    private static final String DATABASE_PATH = "Programacao_de_Tipos_de_Dados_Avancado/Trabalhos/Gestao_de_Biblioteca/src/database.csv";
    private static final String REPORT_PATH= "Programacao_de_Tipos_de_Dados_Avancado/Trabalhos/Gestao_de_Biblioteca/reports/";
    static String[] books;
    static String searchedBy = "";

    public static void main(String[] args) {
        boolean isRunning = true;
        try {
            String[] database = Csv.getContent(DATABASE_PATH);
            books = new String[database.length - 1];
            for(int i = 0; i < database.length - 1; i++) {
                books[i] = database[i+1];
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar a base de dados! Erro: " + e.getMessage());
        }

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
                    case 2 -> remove(searchBooks());
                    case 3 -> search();
                    case 4 -> generateReport(searchBooks());
                    case 5 -> isRunning = false;
                    default -> System.out.println("\u001B[31mOpção inválida!\u001B[0m");
                }
            } catch (NumberFormatException ex) {
                System.out.println("\u001B[31mOpção informada precisa ser um número!\u001B[0m");
            } catch (Exception ex){
                System.out.println("\u001B[31mErro inesperado!\u001B[0m\nErro: " + ex.getMessage());
            }
        } while(isRunning);
    }

    private static void generateReport(String[] books) {
        if (books.length != 0){
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
            String filename = String.format("booksReportBy%s_%s.csv", searchedBy, date.format(dateFormatter));

            try {
                Csv.addRow(REPORT_PATH + filename, "nome_do_livro,numero_de_paginas,nome_do_autor,area_de_interesse");
            } catch (IOException e) {
                System.out.println("Erro ao adicionar linha no relatório! Erro: " + e.getMessage());
            }
            for (String book : books){
                try {
                    Csv.addRow(REPORT_PATH + filename, book);
                } catch (IOException e) {
                    System.out.println("Erro ao adicionar linha no relatório! Erro: " + e.getMessage());
                }
            }

            System.out.printf("\u001B[32mRelatório gerado com sucesso!\u001B[0m\nCaminho do arquivo: %s\n", REPORT_PATH + filename);
        }
    }

    public static void search(){
        if (books.length == 0){ System.out.println("Nenhum livro registrado no sistema!"); }
        else {
            String[] foundBooks = searchBooks();
            while (true){
                if (foundBooks.length == 0){ break; }
                String[] booksList = listBooks(foundBooks);
                String[] options = new String[booksList.length + 3];
                int i = 0;
                for (String book : booksList){ options[i++] = book; }
                options[i++] = ("Gerar Relatório da busca");
                options[i++] = ("Remover um dos livros");
                options[i] = ("Voltar");
                printMenu("Livros", options);
                String option = getInput("Digite uma opção: ");

                try {
                    int optionValue = Integer.parseInt(option);
                    if (optionValue == foundBooks.length + 1) { generateReport(foundBooks); }
                    else if (optionValue == foundBooks.length + 2) { foundBooks = remove(foundBooks); }
                    else if (optionValue == foundBooks.length + 3) { break; }
                    else if (optionValue < 1 || optionValue > foundBooks.length) { System.out.println("\u001B[31mOpção inválida!\u001B[0m"); }
                } catch (NumberFormatException ex) {
                    System.out.println("\u001B[31mOpção informada precisa ser um número!\u001B[0m");
                } catch (Exception ex){
                    System.out.println("\u001B[31mErro inesperado!\u001B[0m\nErro: " + ex.getMessage());
                }

            }
        }
    }

    private static void addBook() {
        System.out.println("Preencha os campos ");
        String name = getInput("Título: ");
        String author = getInput("Autor: ");
        String area = getInput("Área de interesse: ");
        try {
            int pages = Integer.parseInt(getInput("Quantidade de páginas: "));
            String bookRecord = String.format("%s,%d,%s,%s", name, pages, author, area);
            books = Csv.addRow(DATABASE_PATH, bookRecord);
            System.out.printf("\u001B[32mLivro: %s adicionado com sucesso!\u001B[0m\n", name);
        } catch (Exception ex) { System.out.println("\u001B[31mErro ao cadastrar informações!\u001B[0m"); }
    }

    private static String[] remove(String[] bookList) {
        if (bookList.length == 0){ return new String[0]; }
        String[] newBookList = new String[bookList.length - 1];
        if (bookList.length == 1){
            try {
                Csv.removeRow(DATABASE_PATH, bookList[0]);
            } catch (IOException e) {
                System.out.println("Erro ao remover da base de dados! Erro: " + e.getMessage());
            }
            System.out.printf("\u001B[32mLivro %s removido com sucesso!\u001B[0m\n", bookList[0].split(",")[0]);
            return new String[0];
        } else {
            boolean isSelecting = true;
            do{
                String[] booksList = listBooks(bookList);
                String[] options = new String[bookList.length + 1];
                int i = 0;
                for (String book : booksList){ options[i++] = book; }
                options[i] = "Cancelar";
                printMenu("Remover livro nº: ", options);
                String option = getInput("Digite uma opção: ");

                try {
                    int optionValue = Integer.parseInt(option);
                    if (optionValue == bookList.length + 1) { break; }
                    if (optionValue < 1 || optionValue > bookList.length) { System.out.println("\u001B[31mOpção inválida!\u001B[0m"); }
                    String selectedBook = bookList[optionValue-1];
                    Csv.removeRow(DATABASE_PATH, selectedBook);
                    i = 0;
                    for (String book : bookList){
                        if (!book.equals(selectedBook)){ newBookList[i++] = book; }
                    }
                    System.out.printf("\u001B[32mLivro %s removido com sucesso!\u001B[0m\n", selectedBook.split(",")[0]);
                } catch (NumberFormatException ex) {
                    System.out.println("\u001B[31mOpção informada não é um número!\u001B[0m");
                    continue;
                } catch (Exception ex){
                    System.out.println("\u001B[31mErro inesperado!\u001B[0m\nErro: " + ex.getMessage());
                    continue;
                }
                isSelecting = false;
            } while (isSelecting);
        }
        books = newBookList;
        return newBookList;
    }

    public static String[] listBooks(String[] books){
        if (books.length == 0){ System.out.println("Nenhum livro encontrado!"); }
        else {
            String[] rows = new String[books.length];
            int i = 0;
            for(String book : books){
                String[] columns = book.split(",");
                rows[i++] = (String.format("""
                                Nome: %s
                                Autor: %s
                                Área de interesse: %s
                                Número de páginas: %d
                                \s
                                """,
                        columns[0], columns[2], columns[3], Integer.parseInt(columns[1])));
            }
            return rows;
        }
        return new String[0];
    }

    private static String[] searchByArea() {
        String area = getInput("Digite a area de interesse: ");
        searchedBy = "Area_" + area;

        int founded = 0;
        for (String book : books){
            String bookArea = book.split(",")[3];
            if (bookArea.equalsIgnoreCase(area)) { founded++; }
        }

        String[] foundedBooks = new String[founded];
        int i = 0;
        for (String book : books){
            String bookArea = book.split(",")[3];
            if (bookArea.equalsIgnoreCase(area)) { foundedBooks[i++] = book; }
        }

        if (foundedBooks.length == 0){ System.out.printf("Nenhum livro registrado na área de interesse %s!%n", area); }
        return foundedBooks;
    }

    private static String[] searchByAuthor() {
        String author = getInput("Digite o nome do autor: ");
        searchedBy = "Author_" + author;

        int founded = 0;
        for (String book : books){
            String bookAuthor = book.split(",")[2];
            if (bookAuthor.equalsIgnoreCase(author)) { founded++; }
        }

        String[] foundedBooks = new String[founded];
        int i = 0;
        for (String book : books){
            String bookAuthor = book.split(",")[2];
            if (bookAuthor.equalsIgnoreCase(author)) { foundedBooks[i++] = book; }
        }

        if (foundedBooks.length == 0){ System.out.printf("Nenhum livro registrado do autor %s!%n", author); }
        return foundedBooks;
    }

    private static String[] searchByName() {
        String name = getInput("Digite o título: ");
        searchedBy = "Name_" + name;

        int founded = 0;
        for (String book : books){
            String bookName = book.split(",")[0];
            if (bookName.equalsIgnoreCase(name)) { founded++; }
        }

        String[] foundedBooks = new String[founded];
        int i = 0;
        for (String book : books){
            String bookName = book.split(",")[0];
            if (bookName.equalsIgnoreCase(name)) { foundedBooks[i++] = book; }
        }

        if (foundedBooks.length == 0){ System.out.printf("Nenhum livro registrado com o título %s!%n", name); }
        return foundedBooks;
    }

    private static String[] searchBooks() {
        if (books.length == 0) {
            System.out.println("Nenhum livro registrado no sistema!");
            return new String[0];
        }
        boolean isSearching = true;
        String[] foundBooks = new String[0];
        do{
            String[] menuOptions = {
                    "Nome",
                    "Autor",
                    "Área de Interesse",
                    "Todos",
                    "Cancelar"
            };
            printMenu("Pesquisar por: ", menuOptions);
            String option = getInput("Digite uma opção: ");

            try {
                switch (Integer.parseInt(option)){
                    case 1 -> { foundBooks = searchByName(); isSearching = false; }
                    case 2 -> { foundBooks = searchByAuthor(); isSearching = false; }
                    case 3 -> { foundBooks = searchByArea(); isSearching = false; }
                    case 4 -> { foundBooks = books; searchedBy = "All"; isSearching = false; }
                    case 5 -> isSearching = false;
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
                    if (row.isBlank()) { continue; }
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
