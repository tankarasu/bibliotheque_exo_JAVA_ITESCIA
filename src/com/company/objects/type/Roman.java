package com.company.objects.type;

import com.company.objects.Book;

public class Roman extends Book {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Roman(String title, String author, String index) {
        super(title, author,index );
        setTitle(title);
        setBookAuthor(author);
        setBookIndex(index);
        setType("Roman");
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
