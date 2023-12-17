package ru.fsv67;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_book")
    private String nameBook;
    @Column(name = "author")
    private String author;

    public Book(int id, String nameBook, String author) {
        this.id = id;
        this.nameBook = nameBook;
        this.author = author;
    }

    public Book(String nameBook, String author) {
        this.nameBook = nameBook;
        this.author = author;
    }

    public Book() {
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameBook='" + nameBook + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
