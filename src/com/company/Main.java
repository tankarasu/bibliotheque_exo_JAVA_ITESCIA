package com.company;

import com.company.objects.UserInterface;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserInterface myApp = new UserInterface();
                    myApp.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("L'application à détecter une erreur " +
                            "de type " + e.getMessage());
                }
            }
        });
    }
}
