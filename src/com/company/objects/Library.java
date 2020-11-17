package com.company.objects;

import com.company.objects.type.Cartoon;
import com.company.objects.type.Roman;
import com.company.objects.type.Thriller;

import java.util.ArrayList;

public class Library {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    private final ArrayList<Book> m_aBookListArray = new ArrayList();

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Library() {
        // simulation d'une BDD
        m_aBookListArray.add(new Roman("Les Misérables", "Victor Hugo", "1"));
        m_aBookListArray.add(new Roman("Crimes pour l'exemple", "Nora " +
                "Roberts", "2"));
        m_aBookListArray.add(new Roman("Ghost Story", "Peter Straub", "3"));
        m_aBookListArray.add(new Thriller("Ca", "Stephen King", "4"));
        m_aBookListArray.add(new Thriller("1984", "George Orwell", "5"));
        m_aBookListArray.add(new Cartoon("Mickey Mouse", "Disney", "6"));
        m_aBookListArray.add(new Cartoon("Lucky Luke", "Uderzo & Gosciny", "7"));
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------
    public String getAllBooks() {

        StringBuilder result = new StringBuilder();
        for (Book book : m_aBookListArray) {
            result.append(book.getBookTitle()).append("\n");
        }
        return result.toString();
    }

    public void addBook(String title, String author, String bookType) {
        String index = String.valueOf(getBookListArray().size() + 1);
        Book newBook = new Book("", "", "");
        bookType = bookType.toUpperCase();
        switch (bookType) {
            case "THRILLER":
                newBook = new Thriller(title, author, index);
                break;
            case "ROMAN":
                newBook = new Roman(title, author, index);
                break;
            case "CARTOON":
                newBook = new Cartoon(title, author, index);
                break;
        }
        addBookListArray(newBook);
    }

    public String getBookStartWith() {
        StringBuilder result = new StringBuilder();
        for (Book book : m_aBookListArray) {
            String bookTitle = book.getBookTitle();
            if (bookTitle.substring(0, 1).equalsIgnoreCase("L")) {
                result.append(book.getBookTitle()).append("\n");
            }
        }
        return result.toString();
    }

    public String getAllOddIndexedBook() {
        StringBuilder result = new StringBuilder();
        for (Book book : m_aBookListArray) {
            if ((Integer.parseInt(book.getBookIndex()) % 2) == 1) {
                result.append(book.getBookTitle()).append("\n");
            }
        }

        return result.toString();
    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public ArrayList<Book> getBookListArray() {
        return m_aBookListArray;
    }

    // -------------------------------------------------
    // setters
    // -------------------------------------------------

    public void addBookListArray(Book p_NewBook) {
        m_aBookListArray.add(p_NewBook);
    }
}
