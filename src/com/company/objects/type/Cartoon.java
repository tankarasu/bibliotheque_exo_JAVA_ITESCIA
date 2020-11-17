package com.company.objects.type;

import com.company.objects.Book;

public class Cartoon extends Book {

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Cartoon(String title, String author, String index) {
        super(title, author, index);
        setBookTitle(title);
        setBookAuthor(author);
        setBookIndex(index);
        setBookType("Cartoon");
    }

}
