package com.minwoo_20220611;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Client sample = new Client();
        sample.sendSocketSample();
    }

    public void sendSocketSample() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String data = scanner.next();
            sendSocketData(data);

            if(data.equals("COMPLETE")) {
                break;
            }

        }

        scanner.close();

    }

    public void sendSocketData(String data) {
        Socket socket = null;
//        String output = null;
        BufferedWriter out = null;
        OutputStream outputStream = null;

        try {
            System.out.println("Client:Connecting");
            socket = new Socket("127.0.0.1", 9999);
            System.out.println("Client:Connect status=" + socket.isConnected());

            outputStream = socket.getOutputStream();
            out = new BufferedWriter( new OutputStreamWriter( outputStream ) );

            out.write(data);
            out.newLine();
            out.flush();

            System.out.println("Client:Sent data");

//            InputStream input = socket.getInputStream();
//            BufferedReader in = new BufferedReader(new InputStreamReader(input));
//
//            String read = in.readLine();
//            System.out.println("Received data:" + data);
//
//            System.out.println(read);
//
//            in.close();
//            input.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
