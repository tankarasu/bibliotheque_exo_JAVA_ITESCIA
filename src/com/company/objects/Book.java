package com.company.objects;

public class Book {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    private String m_sTitle;
    private String m_sAuthor;
    private String m_sIndex;
    private String m_sType;
    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public Book(String title, String author, String Index) {
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

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


    public void setTitle(String m_sTitle) {
        this.m_sTitle = m_sTitle;
    }

    public void setBookIndex(String p_Index) {
        m_sIndex = p_Index;
    }

    public void setBookAuthor(String p_sAuthor) {
        m_sAuthor = p_sAuthor;
    }

    public void setType(String m_sType) {
        this.m_sType = m_sType;
    }
}
