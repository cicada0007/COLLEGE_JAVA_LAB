import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(12345);

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            
            // Create input and output streams for communication
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read from and write to the client
            String clientMessage = inFromClient.readLine();
            System.out.println("Client: " + clientMessage);
            outToClient.println("Message received!");

            // Close the connections
            inFromClient.close();
            outToClient.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
