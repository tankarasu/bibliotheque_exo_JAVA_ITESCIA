package com.company.objects.type;

import com.company.objects.Book;

public class Cartoon extends Book {

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Cartoon(String bookTitle, String bookAuthor, String bookType, String bookIndex, String bookYear, String bookEdition, String bookLanguage) {
        super(bookTitle, bookAuthor, bookType, bookIndex, bookYear, bookEdition, bookLanguage);
    }

    // objet prêt à être spécialiser
}
