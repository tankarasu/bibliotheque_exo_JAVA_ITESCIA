package com.company.objects.type;

import com.company.objects.Book;

public class Thriller extends Book {
    // Constructor
    public Thriller(String title, String author, String index) {
        super(title, author, index);
        setBookTitle(title);
        setBookAuthor(author);
        setBookIndex(index);
        setBookType("Thriller");
    }

}
