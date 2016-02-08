package models;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionListenerThread implements Runnable {
            // attribut(s)
    private ServerSocket serverSocket;
    private Socket sockets[];
    private int compteurClients;
    private Thread t2;
            // methode(s)
    // constructeur(s)
    public ConnectionListenerThread(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        this.sockets = new Socket[100];
        compteurClients = 0;
    }
    // accesseur(s)
    
    // mutateur(s)
    
    // autre(s)

    @Override
    public void run() {
        while(true) {
            try {
                this.sockets[compteurClients] = this.serverSocket.accept();
                compteurClients++;
                t2 = new Thread(new ChatServer(this.sockets[compteurClients]) );
                t2.start();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionListenerThread.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
}
