package com.company.objects;

import com.company.objects.type.Cartoon;
import com.company.objects.type.Roman;
import com.company.objects.type.Thriller;

import java.util.ArrayList;

public class Library {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    private ArrayList<Book> m_aBookListArray = new ArrayList();

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

        String result = "";
        for (Book book : m_aBookListArray) {
            result += book.getBookTitle() + "\n";
        }
        return result;
    }

    public void addBook(String title, String author, String bookType) {
        String index = String.valueOf(getBookListArray().size() + 1);
        Book newBook = new Book("", "", "");
        switch (bookType) {
            case "Thriller":
                newBook = new Thriller(title, author, index);
                break;
            case "Roman":
                newBook = new Roman(title, author, index);
                break;
            case "Cartoon":
                newBook = new Cartoon(title, author, index);
                break;
        }
        addBookListArray(newBook);
    }

    public String getBookStartWith() {
        String result = "";
        for (Book book : m_aBookListArray) {
            String bookTitle = book.getBookTitle();
            if (bookTitle.substring(0, 1).equalsIgnoreCase("A")) {
                result += book.getBookTitle() + "\n";
            }
        }
        return result;
    }

    public String getAllOddIndexedBook() {
        String result = "";
        for (Book book : m_aBookListArray) {
            if ((Integer.parseInt(book.getBookIndex()) % 2) == 1) {
                result += book.getBookTitle() + "\n";
            }
        }

        return result;
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
