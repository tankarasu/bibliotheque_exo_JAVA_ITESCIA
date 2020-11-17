package com.company.objects;

public class Book {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    private String m_sTitle;
    private String m_sAuthor;
    private String m_sIndex;
    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Book(String title, String author, String Index) {
        m_sIndex = Index; // todo pass generateIndex return Value
        m_sAuthor = author;
        m_sTitle = title;
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

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


    public void setBookIndex(String p_Index) {
        m_sIndex = p_Index;
    }

    public void setBookAuthor(String p_sAuthor) {
        m_sAuthor = p_sAuthor;
    }

}
