package com.company.objects.type;

import com.company.objects.Book;

public class Roman extends Book {

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Roman(String title, String author, String index) {
        super(title, author,index );
        setBookTitle(title);
        setBookAuthor(author);
        setBookIndex(index);
        setBookType("Roman");
    }

}
