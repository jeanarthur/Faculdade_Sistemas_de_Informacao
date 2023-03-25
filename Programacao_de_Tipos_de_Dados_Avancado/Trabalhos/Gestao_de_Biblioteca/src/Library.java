import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    static List<Book> books = new ArrayList<>();
    private static final String DATABASE_PATH = "Programacao_de_Tipos_de_Dados_Avancado/Trabalhos/Gestao_de_Biblioteca/src/database.csv";
    private static final String REPORT_PATH= "Programacao_de_Tipos_de_Dados_Avancado/Trabalhos/Gestao_de_Biblioteca/reports/";
    static String searchedBy = "";

    public static void main(String[] args) {
        boolean isRunning = true;
        books = Book.parseBook(Csv.read(DATABASE_PATH));

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
                    default -> throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("\u001B[31mOpção inválida!\u001B[0m");
            }
        } while(isRunning);
    }

    private static void generateReport(List<Book> books) {
        if (books.size() != 0){
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
            List<String[]> booksRecords = new ArrayList<>();
            String[] header = {"nome_do_livro","numero_de_paginas","nome_do_autor","area_de_interesse"};
            booksRecords.add(header);

            for (Book book : books){
                String[] record = {book.getName(), String.valueOf(book.getPages()), book.getAuthor(), book.getArea()};
                booksRecords.add(record);
            }

            String filename = String.format("booksReportBy%s_%s.csv", searchedBy, date.format(dateFormatter));
            Csv.write(booksRecords, REPORT_PATH + filename);
            System.out.printf("\u001B[32mRelatório gerado com sucesso!\u001B[0m\nCaminho do arquivo: %s\n", REPORT_PATH + filename);
        }
    }

    public static void search(){
        if (books.size() == 0){ System.out.println("Nenhum livro registrado no sistema!"); }
        else {
            List<Book> foundBooks = searchBooks();
            while (true){
                if (foundBooks.size() == 0){ break; }
                List<String> booksList = listBooks(foundBooks);
                booksList.add("Gerar Relatório da busca");
                booksList.add("Remover um dos livros");
                booksList.add("Voltar");
                printMenu("Livros", booksList.toArray(new String[0]));
                String option = getInput("Digite uma opção: ");

                try {
                    int optionValue = Integer.parseInt(option);
                    if (optionValue == foundBooks.size() + 1) { generateReport(foundBooks); }
                    else if (optionValue == foundBooks.size() + 2) { foundBooks = remove(foundBooks); }
                    else if (optionValue == foundBooks.size() + 3) { break; }
                    else if (optionValue < 1 || optionValue > foundBooks.size()) { throw new Exception(); }
                } catch (Exception ex) { System.out.println("\u001B[31mOpção inválida!\u001B[0m"); System.out.println(ex.getMessage()); }

            }
        }
    }

    private static void addBook() {
        System.out.println("Preencha os campos: ");
        String name = getInput("Título: ");
        String author = getInput("Autor: ");
        String area = getInput("Área de interesse: ");
        try {
            int pages = Integer.parseInt(getInput("Quantidade de páginas: "));
            books.add(new Book(name, pages, author, area));
            updateDatabase();
            System.out.printf("\u001B[32mLivro: %s adicionado com sucesso!\u001B[0m\n", name);
        } catch (Exception ex) { System.out.println("\u001B[31mErro ao cadastrar informações!\u001B[0m"); }
    }

    private static List<Book> remove(List<Book> bookList) {
        if (bookList.size() == 0){ return new ArrayList<>(); }
        if (bookList.size() == 1){
            Book book = bookList.get(0);
            books.remove(book);
            System.out.printf("\u001B[32mLivro %s removido com sucesso!\u001B[0m\n", book.getName());
            return new ArrayList<>();
        } else {
            boolean isSelecting = true;
            do{
                List<String> booksList = listBooks(bookList);
                booksList.add("Cancelar");
                printMenu("Remover livro nº: ", booksList.toArray(new String[0]));
                String option = getInput("Digite uma opção: ");

                try {
                    int optionValue = Integer.parseInt(option);
                    if (optionValue == bookList.size() + 1) { break; }
                    if (optionValue < 1 || optionValue > bookList.size()) { throw new Exception(); }
                    Book selectedBook = bookList.get(optionValue-1);
                    books.remove(selectedBook);
                    bookList.remove(selectedBook);
                    System.out.printf("\u001B[32mLivro %s removido com sucesso!\u001B[0m\n", selectedBook.getName());
                } catch (Exception ex) {
                    System.out.println("\u001B[31mOpção inválida!\u001B[0m");
                    System.out.println(ex.getMessage());
                    continue;
                }
                isSelecting = false;
            } while (isSelecting);
        }
        updateDatabase();
        return bookList;
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
                                \s
                                """,
                        book.getName(), book.getAuthor(), book.getArea(), book.getPages()));
            }
            return rows;
        }
        return new ArrayList<>();
    }

    private static List<Book> searchByArea() {
        String area = getInput("Digite a area de interesse: ");
        searchedBy = "Area_" + area;
        List<Book> bookList = books.stream().filter(book -> book.getArea().equalsIgnoreCase(area)).toList();
        if (bookList.size() == 0){ System.out.printf("Nenhum livro registrado com o área de interesse %s!%n", area); }
        return bookList;
    }

    private static List<Book> searchByAuthor() {
        String author = getInput("Digite o nome do autor: ");
        searchedBy = "Author_" + author;
        List<Book> bookList = books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).toList();
        if (bookList.size() == 0){ System.out.printf("Nenhum livro do autor %s registrado!%n", author); }
        return bookList;
    }

    private static List<Book> searchByName() {
        String name = getInput("Digite o título: ");
        searchedBy = "Name_" + name;
        List<Book> bookList = books.stream().filter(book -> book.getName().equalsIgnoreCase(name)).toList();
        if (bookList.size() == 0){ System.out.printf("Nenhum livro registrado com o título %s!%n", name); }
        return bookList;
    }

    private static List<Book> searchBooks() {
        if (books.size() == 0) {
            System.out.println("Nenhum livro registrado no sistema!");
            return new ArrayList<>();
        }
        boolean isSearching = true;
        List<Book> foundBooks = new ArrayList<>();
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

    public static void updateDatabase(){
        List<String[]> booksRecords = new ArrayList<>();
        String[] header = {"nome_do_livro","numero_de_paginas","nome_do_autor","area_de_interesse"};
        booksRecords.add(header);

        for (Book book : books){
            String[] record = {book.getName(), String.valueOf(book.getPages()), book.getAuthor(), book.getArea()};
            booksRecords.add(record);
        }

        Csv.write(booksRecords, DATABASE_PATH);
    }

}
