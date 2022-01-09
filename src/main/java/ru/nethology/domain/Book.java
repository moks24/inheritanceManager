package ru.nethology.domain;

public class Book extends Product{
    private String author;

    public Book(){super();}

    public Book(int id, int name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
