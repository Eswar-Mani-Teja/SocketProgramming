import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {

        try {
            // Connect to server
            System.out.println("Client Started");
            Socket socket = new Socket("localhost", 9800);

            // Get input from user
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter message: ");
            String message = userInput.readLine();

            // Send the message to the server
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println(message);
            System.out.println("Sent the message: " + message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
