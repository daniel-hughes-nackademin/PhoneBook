package ServerProgram;

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

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {


            String inputLine;
            String outputLine;
            String serverMessage = "Which buddy do you need information about?";

            out.println(serverMessage);
            while((inputLine = in.readLine()) != null){
                outputLine = buddyBase.getBuddyInfo(inputLine);
                out.println(outputLine + "," + serverMessage);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Server();

    }
}
