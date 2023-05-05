import agent.Phone;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {


        try(ServerSocket server = new ServerSocket(8000)){

            System.out.println("Server get started");

            while (true)
                try(Phone phone = new Phone(server);) {

                    String request = phone.readLine();
                    System.out.println("Request: " + request);
                    // Weather API for temperature
                    // This line is a joke :D
                    String response = "HELLO FROM SERVER!" + request.length();
                    phone.writeLine(response);
                    System.out.println("Response: " + response);
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }

            }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}