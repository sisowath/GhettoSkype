package models;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
            // attribut(s)    
    private int portNumber;
    private Socket socket;
    private Thread t1;
            // methode(s)
    // constructeur(s)
    public Client(int portNumber) {
        this.portNumber = portNumber;
        try {
            this.socket = new Socket("localhost", this.portNumber);
        } catch (IOException ex) {
            System.out.println("ERREUR ! Aucun serveur écoute le port " + portNumber);
        }
        t1 = new Thread(new ChatClient(this.socket) );
        t1.start();
    }
    // accesseur(s)
    
    // mutateur(s)
    
    // autre(s)
}
