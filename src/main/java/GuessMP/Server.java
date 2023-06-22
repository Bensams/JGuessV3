package GuessMP;

import java.io.*;
import java.net.*;
import java.util.Random;

/**
 *
 * @author BPs
 */
public class Server  {
    
    int port;
    protected final int maxAttempts = 5;
    protected final int maxNum = 100;
    protected int numToGuess = randomNumber(1, maxNum);
//    modify only here for the timer
    protected final int mins = 5;
    protected long minsToGuess = mins * 60;
    
    public int randomNumber(int min, int max){
        Random ran = new Random();
        return ran.nextInt(max - min + 1) + 1;
    }
    
    private boolean Guessed = false;
    String uName; // Store the user who guessed the number
    public boolean isGuessed() { // check if someone's already guess the number
        return Guessed;
    }
    public boolean setGuessed() { // if someone guessed the number
        return Guessed = true;
    }
    public void setWhoGuessedIt(String uName) { // set the username who guessed the correct number 
     this.uName = uName;   
    }
    public String getWhoGuessedIt() { // get the username who get the correct number and tell other that this user already guessed the number
     return uName;
    }

    public Server(int port) throws Exception {
        this.port = port;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server Started. Waiting for clients...");
            
            while (true) {                
                Socket clientSocket = serverSocket.accept();
                System.out.println("New Client connected: " + clientSocket.getInetAddress());
                
//                Thread clientThread = new Thread(new ClientHandler(clientSocket, this));
//                clientThread.start();
            }
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
//        try {
//            new Server();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
