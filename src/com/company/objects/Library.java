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
        m_aBookListArray.add(new Roman("Les Misérables", "Victor Hugo",
                "Roman", "1", "1888", "23", "fr"));
        m_aBookListArray.add(new Roman("Crimes pour l'exemple", "Nora " +
                "Roberts", "Roman", "2", "2002", "1", "uk"));
        m_aBookListArray.add(new Roman("Ghost Story", "Peter Straub", "Roman"
                , "3", "1990", "1", "us"));
        m_aBookListArray.add(new Thriller("Ca", "Stephen King", "Thriller",
                "4", "1993", "2", "us"));
        m_aBookListArray.add(new Thriller("1984", "George Orwell", "Thriller"
                , "5", "1980", "1", "uk"));
        m_aBookListArray.add(new Cartoon("Mickey Mouse", "Disney", "Cartoon",
                "6", "1934", "34", "us"));
        m_aBookListArray.add(new Cartoon("Lucky Luke", "Uderzo & Gosciny",
                "Cartoon", "7", "1965", "56", "be"));
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    /**
     * This method is called to make a request on Virtual DB
     *
     * @return the methods return a string that contains all the Books
     */
    public String getAllBooks() {

        StringBuilder result = new StringBuilder();
        for (Book book : m_aBookListArray) {
            result.append(book.getBookIndex()).append("|").append(book.getType());
            result.append("|");
            result.append(book.getBookTitle()).append("\n");
        }
        return result.toString();
    }

    /**
     * This Methods add a book on the virtual DB
     * @param bookTitle - explicit
     * @param bookAuthor - explicit
     * @param bookType - Roman Thriller or Cartoon
     * @param bookIndex - The Unique Index typed by the User
     * @param bookYear - The year book was written first
     * @param bookEdition - The number of edition, i.e 1,2 ...
     * @param bookLanguage - The lanquage or the translation of the current Book
     */
    public void addBook(String bookTitle, String bookAuthor, String bookType,
                        String bookIndex, String bookYear, String bookEdition,
                        String bookLanguage) {
        Book newBook = new Book("", "", "", "", "", "", "");
        bookType = bookType.toUpperCase();
        switch (bookType) {
            case "THRILLER":
                newBook = new Thriller(bookTitle, bookAuthor, bookType,
                        bookIndex, bookYear, bookEdition, bookLanguage);
                break;
            case "ROMAN":
                newBook = new Roman(bookTitle, bookAuthor, bookType, bookIndex,
                        bookYear, bookEdition, bookLanguage);
                break;
            case "CARTOON":
                newBook = new Cartoon(bookTitle, bookAuthor, bookType, bookIndex
                        , bookYear, bookEdition, bookLanguage);
                break;
        }
        addBookListArray(newBook);
    }

    @SuppressWarnings("unused")
    /*
      This method is now unused but we can easily implement it later if needed
      it return a string listing all books starting with a specific letter.
     */
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

    /**
     * This methode is used to return the list of all odd indexed books
     * @return - explicit
     */
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
