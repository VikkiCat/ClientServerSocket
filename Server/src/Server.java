import agent.Phone;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {


        try(ServerSocket server = new ServerSocket(8000)){

            System.out.println("Server get started");

            while (true) {

                Phone phone = new Phone(server);
                new Thread(() -> {
                    String request = phone.readLine();
                    System.out.println("Request: " + request);
                    // Weather API for temperature
                    // This line is a joke :D
                    String response = "HELLO FROM SERVER!" + request.length();
                    //for multithreads
                    //4 seconds for every client
                    try { Thread.sleep(4000);} catch (InterruptedException e) { }
                    phone.writeLine(response);
                    System.out.println("Response: " + response);
                    try {
                        phone.close();
                    } catch (IOException e) { }

                }).start();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}