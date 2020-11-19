package com.company.objects;

import com.company.BookTypeEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInterface extends JFrame {
    // -------------------------------------------------
    // variables membres
    // -------------------------------------------------
    static Scanner userInput = new Scanner(System.in);
    Library myLibrary = new Library();
    ArrayList<Book> bookList = myLibrary.getBookListArray();
    String bookType = "Roman";

    // -------------------------------------------------
    //constructor
    // -------------------------------------------------

    public UserInterface() throws HeadlessException {
        // création de la fenêtre principale
        super("Bibliot-APP");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1080, 460);

        // création du container qui va contenir tous les éléments
        JPanel container = (JPanel) this.getContentPane();
        container.setLayout(new FlowLayout());

        // container du formulaire
        JPanel formContainer = (JPanel) this.getContentPane();
        formContainer.setLayout(new FlowLayout());
        formContainer.setVisible(true);

        // Boutons Radio
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton romanRadio = new JRadioButton("Roman");
        romanRadio.setSelected(true);
        romanRadio.setVisible(false);
        JRadioButton thrillerRadio = new JRadioButton("Thriller");
        thrillerRadio.setVisible(false);
        JRadioButton cartoonRadio = new JRadioButton("Cartoon");
        cartoonRadio.setVisible(false);
        buttonGroup.add(romanRadio);
        buttonGroup.add(thrillerRadio);
        buttonGroup.add(cartoonRadio);

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
        label.setText("id à supprime");
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(60, 25));

        // implémentation du menu Horizontale TOP
        menu.add(addBook);
        menu.add(allBooks);
        menu.add(oddBooks);
        menu.add(getStatistic);
        menu.add(label);
        menu.add(textField);
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
        formContainer.add(romanRadio);
        formContainer.add(thrillerRadio);
        formContainer.add(cartoonRadio);
        formContainer.add(submit);

        // implémentation du container texte
        textContainer.add(textPane);

        // gestion du delete de livre
        deleteBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookList.removeIf(book -> (book.getBookIndex().equalsIgnoreCase(textField.getText())));
                textPane.setText("Tous les livres\n\n" + askAllBooks());
            }
        });

        // évènement lors du Submit
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookTitle = titleTextField.getText();
                String bookAuthor = authorTextField.getText();
                String bookIndex = indexTextField.getText();
                String bookYear = yearTextField.getText();
                String bookEdition = editionTextField.getText();
                String bookLanguage = languageTextField.getText();

                // validation du formulaire
                String formValidationLog = "";

                // validation de l'année
                if (!isYearValid(yearTextField)) {
                    formValidationLog += "Typed Year is not Valid\n";
                }
                //validation de l'édition
                if (!isEditionValid(editionTextField)) {
                    formValidationLog += "Typed edition is not Valid\n";
                }
                // language Validation
                if (!isLanguageValid(languageTextField)) {
                    formValidationLog += "Typed Language is not Valid\n";
                }
                // validation de l'index
                if (!isIndexValid(indexTextField)) {
                    formValidationLog += "Typed Index is not Valid\n";
                }
                // validation globale du formulaire
                if ((!titleTextField.getText().trim().equalsIgnoreCase("")) && (!authorTextField.getText().trim().equalsIgnoreCase("")) && isYearValid(yearTextField) && isEditionValid(editionTextField) && isLanguageValid(languageTextField) && isIndexValid(indexTextField)) {
                    addSomeBook(bookTitle, bookAuthor, bookType, bookIndex,
                            bookYear, bookEdition, bookLanguage);
                    textPane.setText("Tous les livres\n\n" + askAllBooks());

                    // on réinitialise les champs une fois le livre ajouté
                    // on pourrait extraire la méthode et l'étendre à la
                    // fonction où l'utilisateur s'est trompé
                    titleTextField.setText("");
                    authorTextField.setText("");
                    indexTextField.setText("");
                    yearTextField.setText("");
                    editionTextField.setText("");
                    languageTextField.setText("");

                    // on camoufle le panel d'ajout de livre
                    hideAddBook(titleLabel, titleTextField, authorLabel,
                            authorTextField, indexLabel, indexTextField, yearLabel,
                            yearTextField, editionLabel, editionTextField,
                            languageLabel, languageTextField, romanRadio,
                            thrillerRadio, cartoonRadio, submit);

                    // après tous les tests s'il nous manque le titre ou
                    // l'auteur on prévient l'utilisateur
                } else if ((titleTextField.getText().trim().equalsIgnoreCase(
                        "")) || (authorTextField.getText().trim().equalsIgnoreCase(""))) {
                    formValidationLog += "\nyou also must provide a Title and" +
                            " " +
                            "the Author\n";
                    textPane.setText(formValidationLog);
                }
            }
        });


        // toggle du menu ajouter un livre
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleAddBook(titleLabel, titleTextField, authorLabel, authorTextField, indexLabel, indexTextField, yearLabel, yearTextField, editionLabel, editionTextField, languageLabel, languageTextField, romanRadio, thrillerRadio, cartoonRadio, submit);
                textPane.setText("");
            }
        });

        // voir tous les livres
        allBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAddBook(titleLabel, titleTextField, authorLabel,
                        authorTextField, indexLabel, indexTextField, yearLabel,
                        yearTextField, editionLabel, editionTextField,
                        languageLabel, languageTextField, romanRadio,
                        thrillerRadio, cartoonRadio, submit);
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
                        languageLabel, languageTextField, romanRadio,
                        thrillerRadio, cartoonRadio, submit);
                textPane.setText("Tous les livres avec un index impaire\n\n" + askOddIndexedBook());
            }
        });

        // on récupère les statistiques
        getStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAddBook(titleLabel, titleTextField, authorLabel,
                        authorTextField, indexLabel, indexTextField, yearLabel,
                        yearTextField, editionLabel, editionTextField,
                        languageLabel, languageTextField, romanRadio,
                        thrillerRadio, cartoonRadio, submit);
                textPane.setText("Statistiques selon le type\n\n" + getStatistic());
            }
        });

        // on quitte l'application
        quitApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        // lors de l'activation le type de livre change en Cartoon
        romanRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (romanRadio.isSelected()) {
                    bookType = "Roman";
                }
            }
        });

        // lors de l'activation le type de livre change en Thriller
        thrillerRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (thrillerRadio.isSelected()) {
                    bookType = "Thriller";
                }
            }
        });

        // lors de l'activation le type de livre change en Cartoon
        cartoonRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cartoonRadio.isSelected()) {
                    bookType = "Cartoon";
                }
            }
        });

    }

    /**
     * A method who validate if the index is valid
     *
     * @param indexTextField - the field used to input the value
     * @return a boolean who represent the validation
     */
    private boolean isIndexValid(JTextField indexTextField) {
        String languageRegex = "^[0-9]+[ ]?$";
        for (Book book : bookList) {
            // vérification de la présence de l'index dans la DB
            if (book.getBookIndex().equalsIgnoreCase(indexTextField.getText())) {
                return false;
            }

        }
        boolean isIndexValid = Pattern.matches(languageRegex,
                indexTextField.getText());
        return isIndexValid;
    }

    /**
     * a method who validate if the edition number is valid
     *
     * @param editionTextField- the field used to input the value
     * @return a boolean who represent the validation
     */
    private boolean isEditionValid(JTextField editionTextField) {
        String languageRegex = "^[0-9]{1,2}[ ]?$";

        return Pattern.matches(languageRegex,
                editionTextField.getText());
    }

    /**
     * a method who validate the Year typed by the user
     *
     * @param yearTextField - - the field used to input the value
     * @return a boolean who represent the validation
     */
    private boolean isYearValid(JTextField yearTextField) {
        String languageRegex = "^[0-9]{4}[ ]?$";

        boolean isYearValid = Pattern.matches(languageRegex,
                yearTextField.getText());
        return isYearValid;
    }

    /**
     * a method who validate the language typed by the user
     *
     * @param languageTextField - the field used to input the value
     * @return a boolean who represent the validation
     */
    private boolean isLanguageValid(JTextField languageTextField) {
        String languageRegex = "^[a-zA-Z]{2}[ ]?$";

        boolean isLanguageValid = Pattern.matches(languageRegex,
                languageTextField.getText());
        return isLanguageValid;
    }

    // -------------------------------------------------
    // méthodes
    // -------------------------------------------------

    /**
     * This methods toggling all ADD BOOK input and label etc ... all params
     * are explicit
     *
     * @param titleLabel
     * @param titleTextField
     * @param authorLabel
     * @param authorTextField
     * @param indexLabel
     * @param indexTextField
     * @param yearLabel
     * @param yearTextField
     * @param editionLabel
     * @param editionTextField
     * @param languageLabel
     * @param languageTextField
     * @param livreRadio
     * @param magazineRadio
     * @param mangaRadio
     * @param submit
     */
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

    /**
     * This methods hide all ADD BOOK label input etc ... when needed, all
     * Params explicit
     *
     * @param titleLabel
     * @param titleTextField
     * @param authorLabel
     * @param authorTextField
     * @param indexLabel
     * @param indexTextField
     * @param yearLabel
     * @param yearTextField
     * @param editionLabel
     * @param editionTextField
     * @param languageLabel
     * @param languageTextField
     * @param livreRadio
     * @param magazineRadio
     * @param mangaRadio
     * @param submit
     */
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

    /**
     * This method querying DB for adding a new book
     *
     * @param bookTitle    -explicit
     * @param bookAuthor   -explicit
     * @param bookType     -explicit
     * @param bookIndex    -explicit
     * @param bookYear     -explicit
     * @param bookEdition  -explicit
     * @param bookLanguage -explicit
     */
    public void addSomeBook(String bookTitle, String bookAuthor,
                            String bookType, String bookIndex,
                            String bookYear, String bookEdition,
                            String bookLanguage) {
        myLibrary.addBook(bookTitle, bookAuthor, bookType, bookIndex, bookYear
                , bookEdition, bookLanguage);
    }

    /**
     * Querying all odd indexed books of the db
     *
     * @return - a String containing all odd indexed books
     */
    public String askOddIndexedBook() {
        return myLibrary.getAllOddIndexedBook();
    }

    /**
     * Querying all books of the DB
     *
     * @return - a string with All books
     */
    public String askAllBooks() {
        return myLibrary.getAllBooks();

    }

    /**
     * Gets all the statistic and return it
     *
     * @return - a String with all statistics
     */
    public String getStatistic() {
        String result = "";
        for (BookTypeEnum type : BookTypeEnum.values()) {
            result += type + ": " + rateOccurence(type.toString()) + " %\n";
        }
        return result;
    }

    /**
     * This methods calculate the % rate of each type of Book
     *
     * @param query - the requested type
     * @return the % of books on requested type
     */
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
