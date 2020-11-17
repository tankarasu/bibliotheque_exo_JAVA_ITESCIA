package com.company.objects.type;

import com.company.objects.Book;

public class Cartoon extends Book {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------


    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Cartoon(String title, String author, String index) {
        super(title, author, index);
        setTitle(title);
        setBookAuthor(author);
        setBookIndex(index);
        setType("Cartoon");
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
