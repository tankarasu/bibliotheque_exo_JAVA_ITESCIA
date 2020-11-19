package com.company.objects;

public class Book {

    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------

    private final String m_sTitle;
    private final String m_sIndex;
    private final String m_sType;

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    @SuppressWarnings("unused")
    public Book(String bookTitle, String bookAuthor, String bookType,
                String bookIndex, String bookYear, String bookEdition,
                String bookLanguage) {
        m_sTitle = bookTitle;
        m_sIndex = bookIndex;
        m_sType = bookType;

    }

    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    public String getBookIndex() {
        return m_sIndex;
    }

    public String getBookTitle() {
        return m_sTitle;
    }

    public String getType() {
        return m_sType;
    }

}
