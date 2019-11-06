package ClientProgram;

import Resources.Buddy;
import Resources.Intro;
import Resources.Response;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    Client() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        String hostName = "172.20.201.176";
        int portNr = 22222;

        try (
                Socket addressSocket = new Socket(localHost, portNr);
                ObjectOutputStream oos = new ObjectOutputStream(addressSocket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(addressSocket.getInputStream());
        ) {


            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            Object fromServer;

            if ((fromServer = ois.readObject()) instanceof Intro) {
                Intro intro = (Intro) fromServer;
                System.out.println(intro.getMessage());

                boolean running = true;
                while (running) {
                    System.out.println("Which Buddy do you need information about?");

                    String fromUser = stdIn.readLine();

                    if (fromUser != null) {
                        oos.writeObject(fromUser);
                    }

                    if((fromServer = ois.readObject()) instanceof Response){
                        Response response = (Response) fromServer;
                        if(response.isFound()){
                            Buddy buddy = response.getBuddy();
                            System.out.println(buddy.getName() + " is born on the date " + buddy.getDateOfBirth() +
                                    ", has the phone number " + buddy.getPhoneNr() + " and the email address " + buddy.getEmail());
                        }
                        else {
                            System.out.println("The Buddy is not found in the system!");
                        }
                    }
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Could not get I/O for " + hostName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        new Client();


    }
}
