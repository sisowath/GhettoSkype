package models;

import java.io.PrintWriter;
import java.util.Scanner;

public class TextSentListenerThread implements Runnable {
            // attribut(s)
    private PrintWriter out;
    private Scanner saisie;
    private String message;
            // methode(s)
    // constructeur(s)
    public TextSentListenerThread(PrintWriter out) {
        this.out = out;
    }
    // accesseur(s)
    
    // mutateur(s)
    
    // autre(s)

    @Override
    public void run() {
        saisie = new Scanner(System.in);
        while(true) {
            System.out.println("Votre message : ");
            message = saisie.nextLine();
            out.println(message);
            out.flush();
        }
    }
    
}
