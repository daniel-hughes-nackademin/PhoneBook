package ServerProgram;

import Resources.Buddy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    DAO_BuddyBase buddyBase = new DAO_BuddyBase();

    Server(){
        int portNr = 22222;

        try(
                ServerSocket serverSocket = new ServerSocket(portNr);
                Socket clientSocket = serverSocket.accept();

                ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
        ) {
            Object inputLine;
            Buddy outputBuddy;

            while((inputLine = ois.readObject()) != null){
                outputBuddy = buddyBase.getBuddy((String)inputLine);
                oos.writeObject(outputBuddy);
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Server();

    }
}
