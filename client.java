import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Create a client socket and connect to the server
            Socket clientSocket = new Socket("localhost", 12345);
            
            // Create input and output streams for communication
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Send a message to the server
            outToServer.println("Hello, server!");

            // Read the server's response
            String serverResponse = inFromServer.readLine();
            System.out.println("Server: " + serverResponse);

            // Close the connections
            inFromServer.close();
            outToServer.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
