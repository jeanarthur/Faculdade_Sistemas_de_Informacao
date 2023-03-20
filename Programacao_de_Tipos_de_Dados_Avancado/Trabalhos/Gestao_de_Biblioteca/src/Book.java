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
}
