package GuessMP;

import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author BPs
 */
public class ClientSide extends ConnectToServer {
//    private String host = getAddress();
//    private int port = getPort();
    
    public ClientSide(String host, int port) throws IOException {
        try (Socket socket = new Socket(host, port);
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner sc = new Scanner(System.in)) {
             
            System.out.println("Successfully connect to the server. Start Guessing will be start");
            
            String response;
//          2 Message Received
            response = input.readLine();
            System.out.println(response);
            response = input.readLine();
            System.out.print(response);
//          Send a username
            output.println(sc.nextLine());
//          1 Message Received
            response = input.readLine();
            System.out.println(response);
            
            while (!response.startsWith("Correct guess!") || !response.startsWith("Game Over.")) {                
                response = input.readLine();
                System.out.print(response);

                if (!response.startsWith("Correct guess!")) {
                    String guess = sc.nextLine();
                        while (guess.equals("")){
                        System.out.print("Input guess: ");
                        guess = sc.nextLine();    
                    } 
                    

                        output.println(guess);
                } else if (response.startsWith("User")) {
                    socket.close();
                    break;
                } else {
                    socket.close();
                    System.out.println("");
                    break;
                }
 
            } 
            
            if (response.startsWith("Game Over.")) {
                System.out.println(response);
                socket.close();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException {
//        try {
//          new ClientSide();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
