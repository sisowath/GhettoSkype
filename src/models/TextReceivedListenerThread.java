package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextReceivedListenerThread implements Runnable {
            // attribut(s)
    private BufferedReader in;
    private String message;
            // methode(s)
    // constructeur(s)
    public TextReceivedListenerThread(BufferedReader in) {
        this.in = in;
    }
    // accesseur(s)
    public String getMessage() {
        return this.message;
    }
    // mutateur(s)
    
    // autre(s)

    @Override
    public void run() {
        while(true) {
            try {            
                message = in.readLine();
            } catch (IOException ex) {
                Logger.getLogger(TextReceivedListenerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
