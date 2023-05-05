import agent.Phone;

import java.io.*;

public class Client {
    public static void main(String[] args) {

        try (Phone phone = new Phone("127.0.0.1", 8000);) {
            //Connected to server

            //City for temperature request;
            String request = "Warsaw";
            //sending request to server
            phone.writeLine(request);

            String response = phone.readLine();
            System.out.println(response);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
