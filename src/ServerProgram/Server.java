package ServerProgram;

import java.io.*;
import java.net.Socket;

public class Server implements Runnable{

    private Socket clientSocket;
    Thread thread;

    Server(Socket clientSocket) {
        try {
            this.clientSocket = clientSocket;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        try(
                ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
        ) {
            Protocol protocol = new Protocol();

            oos.writeObject(protocol.getObject(null));
            String inputLine;

            while((inputLine = (String)ois.readObject()) != null){
                oos.writeObject(protocol.getObject(inputLine));
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
