package ServerProgram;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHandler {

    public ServerHandler() {
        int portNr = 22222;
        try {
            ServerSocket serverSocket = new ServerSocket(portNr);

            boolean running = true;

            while (running) {
                final Socket socketToClient = serverSocket.accept();
                new Server(socketToClient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new ServerHandler();
    }
}
