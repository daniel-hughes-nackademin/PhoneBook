package ClientProgram;

import Resources.Buddy;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    Client() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        String hostName = "172.20.201.176";
        int portNr = 22222;

        try(
                Socket addressSocket = new Socket(localHost, portNr);
                ObjectOutputStream oos = new ObjectOutputStream(addressSocket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(addressSocket.getInputStream());
        ) {


            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            boolean running = true;

            while (running){
                System.out.println("Which Buddy do you need information about?");

                String fromUser = stdIn.readLine();

                if(fromUser != null){
                    oos.writeObject(fromUser);
                }

                Buddy buddy = (Buddy) ois.readObject();
                if(buddy == null){
                    System.out.println("The Buddy is not found in the system!");
                }
                else{
                    System.out.println(buddy.getName() + " is born on the date " + buddy.getDateOfBirth() +
                            ", has the phone number " + buddy.getPhoneNr() + " and the email address " + buddy.getEmail());
                }
            }
        } catch (UnknownHostException e){
            System.err.println("Unknown host: " + hostName);
            System.exit(1);
        } catch (IOException e){
            System.err.println("Could not get I/O for " + hostName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        new Client();


    }
}
