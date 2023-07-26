import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) {
        final int serverPort = 5000;

        try {
            // Create a datagram socket at the server side
            DatagramSocket serverSocket = new DatagramSocket(serverPort);
            System.out.println("Server started. Waiting for messages...");

            while (true) {
                // Create a buffer to store incoming data
                byte[] receiveData = new byte[1024];

                // Create a datagram packet to receive data from the client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Receive the packet from the client
                serverSocket.receive(receivePacket);

                // Convert the data to a string
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Display the message received from the client
                System.out.println("Client: " + message);

                // Send an acknowledgment back to the client (optional)
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String ackMessage = "Message received!";
                byte[] sendData = ackMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


client.java


  import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) {
        final int serverPort = 5000;

        try {
            // Create a datagram socket at the client side
            DatagramSocket clientSocket = new DatagramSocket();

            // Get the IP address of the server (localhost in this case)
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Start reading messages from the user
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                // Read a message from the user
                System.out.print("You: ");
                String message = reader.readLine();

                // Convert the message to bytes
                byte[] sendData = message.getBytes();

                // Create a datagram packet to send data to the server
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

                // Send the packet to the server
                clientSocket.send(sendPacket);

                // Create a buffer to store incoming acknowledgment (optional)
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Wait for an acknowledgment from the server (optional)
                clientSocket.receive(receivePacket);
                String ackMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server: " + ackMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
