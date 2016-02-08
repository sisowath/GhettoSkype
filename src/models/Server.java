package models;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
            // attribut(s)
    private int portNumber;   
    private String hostAddress;
    private ServerSocket serverSocket;
    private Thread t1;
            // methode(s)
    //constructeur(s)
    public Server(int portNumber) {
        this.portNumber = portNumber;
        try {
            this.hostAddress = InetAddress.getLocalHost().toString();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.serverSocket = new ServerSocket(portNumber);
        } catch (IOException ex) {
            System.out.println("ERREUR ! Le port " + this.serverSocket.getLocalPort() + " est déjà utilisé.");
        }    
        System.out.println( this.getHostAddress() + " écoute sur le port " + this.getPortNumber() );
    }
    // accesseur(s)
    public int getPortNumber() { return portNumber; }
    public String getHostAddress() { return hostAddress; }
    // mutateur(s)
    
    // autre(s)
    public void attendreUneConnexion() {
        t1 = new Thread(new ConnectionListenerThread(serverSocket) );
        t1.start();
    }            
}
