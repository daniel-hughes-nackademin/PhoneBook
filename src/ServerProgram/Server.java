package ServerProgram;

import Resources.Buddy;
import Resources.Intro;
import Resources.Response;

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

            oos.writeObject(new Intro());

            while((inputLine = ois.readObject()) != null){
                Buddy buddy = buddyBase.getBuddy((String)inputLine);
                Response outputResponse;
                if(buddy == null){
                    outputResponse = new Response(buddy, false);
                }
                else {
                    outputResponse = new Response(buddy, true);
                }
                oos.writeObject(outputResponse);
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Server();

    }
}
