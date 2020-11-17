package com.company.objects;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInterface {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    static Scanner userInput = new Scanner(System.in);
    Library myLibrary = new Library();
    ArrayList<Book> bookList = myLibrary.getBookListArray();
    String[] typeList = {"ROMAN", "THRILLER", "CARTOON"};

    // ------------------------------------------------- 
    // méthodes
    // -------------------------------------------------
    public void launchApplication() {
        System.out.println("Welcome on this Library application");
        System.out.println("-----------------------------------");
        chooseOption();
    }

    public void chooseOption() {
        String choosenOption;
        String regex = "^[ ]?[123456]?[ ]?$";
        Pattern pattern = Pattern.compile(regex);

        boolean result = false;
        do {
            System.out.println("Make a choice : ");
            System.out.println("1-Add one or some books");
            System.out.println("2-Ask for odd indexed books list");
            System.out.println("3-Ask for books starting with specific " +
                    "letters");
            System.out.println("4-Ask for all available books");
            System.out.println("5-Quit the application");
            System.out.println("6-Statistiques");
            choosenOption = userInput.nextLine();
            Matcher matcher = pattern.matcher(choosenOption);
            result = matcher.matches();
        } while (!result);

        switch (choosenOption) {
            case "1":
                addSomeBook();
                break;
            case "2":
                askOddIndexedBook();
                break;
            case "3":
                askTitleStartWithLetterA();
                break;
            case "4":
                askAllBooks();
                break;
            case "5":
                System.out.println("See you soon");
                break;
            case "6":
                getStatistic();
                break;
        }
    }

    public void addSomeBook() {
        String bookType = "";
        do {
            System.out.println("What's the type of " +
                    "Book?\n-Thriller\n-Cartoon\n-Roman");
            bookType = userInput.nextLine();

        } while (!bookType.equalsIgnoreCase("Thriller") & !bookType.equalsIgnoreCase("Roman") & !bookType.equalsIgnoreCase("Cartoon"));

        System.out.println("What's the title?");
        String bookTitle = userInput.nextLine();
        System.out.println("Who's the Author?");
        String bookAuthor = userInput.nextLine();


        myLibrary.addBook(bookTitle, bookAuthor, bookType);
        System.out.println(" type q for quit or anything else to add a new " +
                "one");
        String choice = userInput.nextLine();

        if ("q".equals(choice)) {
            System.out.println("A bientôt");
            chooseOption();
        } else {
            addSomeBook();
        }
    }

    public void askOddIndexedBook() {
        System.out.println(myLibrary.getAllOddIndexedBook());
        chooseOption();
    }

    public void askTitleStartWithLetterA() {
        System.out.println(myLibrary.getBookStartWith());
        chooseOption();
    }

    public void askAllBooks() {
        System.out.println(myLibrary.getAllBooks());
        chooseOption();
    }

    public void getStatistic() {
        System.out.println("Statistic according to th type of book present in" +
                " the Library");
        for (String type : typeList) {
            System.out.println(type+": "+rateOccurency(type)+" %");
        }
        System.out.println(); // espacement
        chooseOption();
    }

    public float rateOccurency(String query) {
        int frequency = 0;
        for (Book book : bookList) {
            if (book.getType().equalsIgnoreCase(query)) {
                frequency++;
            }
        }
        float result = (float) frequency / bookList.size() * 100;
        result = (float) Math.ceil(result * 100);
        return result / 100;
    }
    // -------------------------------------------------
    // getters
    // -------------------------------------------------

    // -------------------------------------------------
    // setters
    // -------------------------------------------------


}
