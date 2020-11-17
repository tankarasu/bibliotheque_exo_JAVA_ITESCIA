package com.company.objects;

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

    public void addBook(String title, String author) {
        String index = String.valueOf(getBookListArray().size() + 1);
        Book newBook = new Book(title, author, index);
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
