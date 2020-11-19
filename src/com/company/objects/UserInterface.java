package com.company.objects;

import com.company.BookTypeEnum;
import com.sun.security.auth.module.JndiLoginModule;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInterface extends JFrame {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    static Scanner userInput = new Scanner(System.in);
    Library myLibrary = new Library();
    ArrayList<Book> bookList = myLibrary.getBookListArray();
    // to delete
    String[] petString = {"", "Bird", "Cat", "Dog", "Rabbit", "Pig"};

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public UserInterface() throws HeadlessException {
        // création de la fenêtre principale
        super("Bibliot-APP");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1080, 760);

        // création du container qui va contenir tous les éléments
        JPanel container = (JPanel) this.getContentPane();
        container.setLayout(new FlowLayout());

        // container du formulaire
        JPanel formContainer = (JPanel) this.getContentPane();
        formContainer.setLayout(new FlowLayout());
        formContainer.setVisible(true);

        // Boutons Radio
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton livreRadio = new JRadioButton("Livre");
        livreRadio.setVisible(false);
        JRadioButton magazineRadio = new JRadioButton("MAgazine");
        magazineRadio.setVisible(false);
        JRadioButton mangaRadio = new JRadioButton("Manga");
        mangaRadio.setVisible(false);
        buttonGroup.add(livreRadio);
        buttonGroup.add(magazineRadio);
        buttonGroup.add(mangaRadio);

        // container du texte
        JPanel textContainer = (JPanel) this.getContentPane();
        textContainer.setLayout(new FlowLayout());
        textContainer.setVisible(true);

        // initialisation de la barre de menu horizontale TOP
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);

        // création des libellés des menus
        JButton addBook = new JButton();
        addBook.setText("Ajouter Livre");
        JButton allBooks = new JButton();
        allBooks.setText("Tous les livres");
        JButton oddBooks = new JButton();
        oddBooks.setText("...index impaires");
        JButton getStatistic = new JButton();
        getStatistic.setText("Statistiques");
        JButton deleteBook = new JButton();
        deleteBook.setText("Supp. Livre");
        JButton quitApp = new JButton();
        quitApp.setText("QUITTER");
        JLabel label = new JLabel();
        label.setText("filtre");
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(60, 25));

        // to delete
        JComboBox petList = new JComboBox(petString);
        petList.setSelectedIndex(4);
        petList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(petList.getSelectedItem());
            }
        });
        // to delete
        // petList.addActionListener();

        // implémentation du menu Horizontale TOP
        menu.add(addBook);
        menu.add(allBooks);
        menu.add(oddBooks);
        menu.add(getStatistic);
        menu.add(label);
        menu.add(textField);
        menu.add(petList);
        menu.add(deleteBook);
        menu.add(quitApp);

        // label du formulaire
        JLabel titleLabel = new JLabel();
        titleLabel.setVisible(false);
        titleLabel.setText("Titre");
        JLabel authorLabel = new JLabel();
        authorLabel.setVisible(false);
        authorLabel.setText("Author");
        JLabel indexLabel = new JLabel();
        indexLabel.setVisible(false);
        indexLabel.setText("Index");
        JLabel yearLabel = new JLabel();
        yearLabel.setVisible(false);
        yearLabel.setText("Année");
        JLabel editionLabel = new JLabel();
        editionLabel.setVisible(false);
        editionLabel.setText("Edition");
        JLabel languageLabel = new JLabel();
        languageLabel.setVisible(false);
        languageLabel.setText("Langue");

        // TextField du formulaire
        JTextField titleTextField = new JTextField();
        titleTextField.setVisible(false);
        titleTextField.setPreferredSize(new Dimension(60, 25));
        JTextField authorTextField = new JTextField();
        authorTextField.setVisible(false);
        authorTextField.setPreferredSize(new Dimension(60, 25));
        JTextField indexTextField = new JTextField();
        indexTextField.setVisible(false);
        indexTextField.setPreferredSize(new Dimension(60, 25));
        JTextField yearTextField = new JTextField();
        yearTextField.setVisible(false);
        yearTextField.setPreferredSize(new Dimension(60, 25));
        JTextField editionTextField = new JTextField();
        editionTextField.setVisible(false);
        editionTextField.setPreferredSize(new Dimension(60, 25));
        JTextField languageTextField = new JTextField();
        languageTextField.setVisible(false);
        languageTextField.setPreferredSize(new Dimension(60, 25));

        JButton submit = new JButton();
        submit.setVisible(false);
        submit.setText("Valider");

        // affichage de tous les livres
        JTextPane textPane = new JTextPane();
        textPane.setText("Tous les livres\n\n" + askAllBooks());

        // implémentation du formulaire d'ajout
        formContainer.add(titleLabel);
        formContainer.add(titleTextField);
        formContainer.add(authorLabel);
        formContainer.add(authorTextField);
        formContainer.add(indexLabel);
        formContainer.add(indexTextField);
        formContainer.add(yearLabel);
        formContainer.add(yearTextField);
        formContainer.add(editionLabel);
        formContainer.add(editionTextField);
        formContainer.add(languageLabel);
        formContainer.add(languageTextField);
        formContainer.add(livreRadio);
        formContainer.add(magazineRadio);
        formContainer.add(mangaRadio);
        formContainer.add(submit);

        // implémentation du container texte
        textContainer.add(textPane);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookTitle = titleTextField.getText();
                String bookAuthor = authorTextField.getText();
                String bookIndex = indexTextField.getText();
                String bookYear = yearTextField.getText();
                String bookEdition = editionTextField.getText();
                String bookLanguage = languageTextField.getText();

                for (Book book:bookList){
                    System.out.println(book.getBookTitle());
                }

            }
        });

        // toggle du menu ajouter un livre
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleAddBook(titleLabel, titleTextField, authorLabel, authorTextField, indexLabel, indexTextField, yearLabel, yearTextField, editionLabel, editionTextField, languageLabel, languageTextField, livreRadio, magazineRadio, mangaRadio, submit);

            }
        });

        // voir tous les livres
        allBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAddBook(titleLabel, titleTextField, authorLabel,
                        authorTextField, indexLabel, indexTextField, yearLabel,
                        yearTextField, editionLabel, editionTextField,
                        languageLabel, languageTextField, livreRadio,
                        magazineRadio, mangaRadio, submit);
                textPane.setText("Tous les livres\n\n" + askAllBooks());
            }
        });

        // voir les livres index impairs

        oddBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAddBook(titleLabel, titleTextField, authorLabel,
                        authorTextField, indexLabel, indexTextField, yearLabel,
                        yearTextField, editionLabel, editionTextField,
                        languageLabel, languageTextField, livreRadio,
                        magazineRadio, mangaRadio, submit);
                textPane.setText("Tous les livres avec un index impaire\n\n" + askOddIndexedBook());
            }
        });

        getStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAddBook(titleLabel, titleTextField, authorLabel,
                        authorTextField, indexLabel, indexTextField, yearLabel,
                        yearTextField, editionLabel, editionTextField,
                        languageLabel, languageTextField, livreRadio,
                        magazineRadio, mangaRadio, submit);
                textPane.setText("Statistiques selon le type\n\n" + getStatistic());
            }
        });

        quitApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    private void toggleAddBook(JLabel titleLabel, JTextField titleTextField, JLabel authorLabel, JTextField authorTextField, JLabel indexLabel, JTextField indexTextField, JLabel yearLabel, JTextField yearTextField, JLabel editionLabel, JTextField editionTextField, JLabel languageLabel, JTextField languageTextField, JRadioButton livreRadio, JRadioButton magazineRadio, JRadioButton mangaRadio, JButton submit) {
        titleLabel.setVisible(!titleLabel.isVisible());
        titleTextField.setVisible(!titleTextField.isVisible());
        authorLabel.setVisible(!authorLabel.isVisible());
        authorTextField.setVisible(!authorTextField.isVisible());
        indexLabel.setVisible(!indexLabel.isVisible());
        indexTextField.setVisible(!indexTextField.isVisible());
        yearLabel.setVisible(!yearLabel.isVisible());
        yearTextField.setVisible(!yearTextField.isVisible());
        editionLabel.setVisible(!editionLabel.isVisible());
        editionTextField.setVisible(!editionTextField.isVisible());
        languageLabel.setVisible(!languageLabel.isVisible());
        languageTextField.setVisible(!languageTextField.isVisible());
        livreRadio.setVisible(!livreRadio.isVisible());
        magazineRadio.setVisible(!magazineRadio.isVisible());
        mangaRadio.setVisible(!mangaRadio.isVisible());
        submit.setVisible(!submit.isVisible());
    }

    private void hideAddBook(JLabel titleLabel, JTextField titleTextField,
                             JLabel authorLabel, JTextField authorTextField, JLabel indexLabel, JTextField indexTextField, JLabel yearLabel, JTextField yearTextField, JLabel editionLabel, JTextField editionTextField, JLabel languageLabel, JTextField languageTextField, JRadioButton livreRadio, JRadioButton magazineRadio, JRadioButton mangaRadio, JButton submit) {
        titleLabel.setVisible(false);
        titleTextField.setVisible(false);
        authorLabel.setVisible(false);
        authorTextField.setVisible(false);
        indexLabel.setVisible(false);
        indexTextField.setVisible(false);
        yearLabel.setVisible(false);
        yearTextField.setVisible(false);
        editionLabel.setVisible(false);
        editionTextField.setVisible(false);
        languageLabel.setVisible(false);
        languageTextField.setVisible(false);
        livreRadio.setVisible(false);
        magazineRadio.setVisible(false);
        mangaRadio.setVisible(false);
        submit.setVisible(false);
    }



/*    public void addSomeBook(String bookTitle,String bookAuthor,String bookType) {

        myLibrary.addBook(bookTitle, bookAuthor, bookType);

    }*/

    public String askOddIndexedBook() {
        return myLibrary.getAllOddIndexedBook();
    }

    public void askTitleStartWithLetterA() {
        System.out.println(myLibrary.getBookStartWith());
    }

    public String askAllBooks() {
        return myLibrary.getAllBooks();

    }

    public String getStatistic() {
        String result = "";
        for (BookTypeEnum type : BookTypeEnum.values()) {
            result += type + ": " + rateOccurence(type.toString()) + " %\n";
        }
        return result;
    }

    private float rateOccurence(String query) {
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
