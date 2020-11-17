package com.company.objects.type;

import com.company.objects.Book;

public class Thriller extends Book {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Thriller(String title, String author, String index) {
        super(title, author, index);
        setTitle(title);
        setBookAuthor(author);
        setBookIndex(index);
        setType("Thriller");
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
