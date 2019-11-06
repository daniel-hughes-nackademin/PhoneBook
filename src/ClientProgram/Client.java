package ClientProgram;

import ServerProgram.DAO_BuddyBase;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class Client {

    Client() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        String hostName = "172.20.201.176";
        int portNr = 22222;

        try(
                Socket addressSocket = new Socket(hostName, portNr);

                PrintWriter out = new PrintWriter(addressSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(addressSocket.getInputStream()));
        ) {
            String fromServer;
            String fromUser;
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            while ((fromServer = in.readLine()) != null){
                String[] buddyInfo = fromServer.split(",");
                for (String line:buddyInfo) {
                    System.out.println(line);
                }
                    fromUser = stdIn.readLine();
                if (fromUser != null){
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e){
            System.err.println("Unknown host: " + hostName);
            System.exit(1);
        } catch (IOException e){
            System.err.println("Could not get I/O for " + hostName);
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        new Client();


    }
}
