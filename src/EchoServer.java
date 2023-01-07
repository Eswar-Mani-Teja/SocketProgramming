import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {

        try {
            // Wait for client to connect
            System.out.println("Waiting for clients...");
            ServerSocket serverSocket = new ServerSocket(9800);
            Socket socket = serverSocket.accept(); // Blocking call: waits for the client to connect
            System.out.println("Connection established");

            // Read the data sent by the client
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String messageFromClient = bufferedReader.readLine();
            System.out.print("Received message: " + messageFromClient);

            // Send message to the client
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("Received the message: " + messageFromClient);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
