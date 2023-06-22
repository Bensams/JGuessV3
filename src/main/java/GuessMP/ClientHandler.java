package GuessMP;

import java.net.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author BPs
 */
public class ClientHandler implements Runnable {
    private Server mainServer;
    private Socket clientSocket;
    private int numToGuess;
    private int maxNum;
    private int maxAttempts;
    
    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
//        this.mainServer = server;
//        this.numToGuess = server.numToGuess;
//        this.maxAttempts = server.maxAttempts;
//        this.minsToEnd = server.minsToGuess;
//        this.maxNum = server.maxNum;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            
            String uName; // Store the name of the user
            
            out.println("Welcome to Guess the Number game!");
            out.println("Enter your username: ");
            uName = in.readLine();
            System.out.println(uName);
            out.println("You have " + maxAttempts + " attempts to guess a number between 1 and "+ maxNum +".");
//            out.println("The game will last " + server.mins + " minutes.");
            out.println("Guess: ");
//          reveal number
            System.out.println("reveal: " + numToGuess);
            long startTime = System.currentTimeMillis();
//            long endTime = startTime + (minsToEnd * 1000);

            String guess;
            int attempts = maxAttempts;
            
            int playerGuess;
//          System.currentTimeMillis() < endTime && 
            while (!(attempts == 0) ) {
                guess = in.readLine();
                playerGuess = Integer.parseInt(guess); 
                
                if (playerGuess == numToGuess && !mainServer.isGuessed()) {
                    mainServer.setGuessed();
                    mainServer.setWhoGuessedIt(uName);
                    out.println("Correct guess! Game over.");
                    clientSocket.close();
                    System.out.println("Client has disconneted.");
                } else if (playerGuess == numToGuess && mainServer.isGuessed()) {
                    out.println("Correct guess! But user " + mainServer.getWhoGuessedIt() + ", already gussed the number.");
                    clientSocket.close();
                    System.out.println("Client has disconneted.");
                } else if (mainServer.isGuessed()) {
                    out.println("User " + mainServer.getWhoGuessedIt() + ", already gussed the number.");
                    clientSocket.close();
                    System.out.println("Client has disconneted.");
                } else if (playerGuess < numToGuess) {
                    --attempts;
                    if (!(attempts == 0)) 
                        out.println("Try a higher number. Attempts left: " + (attempts) + ": ");
                } else {
                    --attempts;
                    if (!(attempts == 0)) 
                        out.println("Try a lower number. Attempts left: " + (attempts) + ": ");
                }
                
            } 
            if (attempts == 0) {
                out.println("Game over. You couldn't guess the number. The number was: " + numToGuess);
                clientSocket.close();
                System.out.println("Client has disconneted.");
            } else {
                clientSocket.close();
                System.out.println("Client has disconneted.");
            } 
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
