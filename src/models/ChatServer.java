package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer implements Runnable {
            // attribut(s)
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Thread t3;
    private Thread t4;
            // methode(s)
    // constructeur(s)
    public ChatServer(Socket socket) {
        this.socket = socket;
    }
    // accesseur(s)
    
    // mutateur(s)
    
    // autre(s)

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream() ) );
            out = new PrintWriter( this.socket.getOutputStream() );
            t3 = new Thread(new TextSentListenerThread(out) );
            t4 = new Thread(new TextReceivedListenerThread(in) );
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
