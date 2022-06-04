package com.minwoo_20220604;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class SocketClientSample {

    public static void main(String[] args) {
        SocketClientSample sample = new SocketClientSample();
        sample.sendSocketSample();
    }

    public void sendSocketSample() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String data = scanner.next();
            String resurt = sendSocketData(data);

            if(resurt.equals("bye!")) {
                break;
            }

        }

        scanner.close();

    }

    public String sendSocketData(String data) {
        Socket socket = null;
        String output = null;
        try {
            System.out.println("Client:Connecting");
            socket = new Socket("127.0.0.1", 9999);
            System.out.println("Client:Connect status=" + socket.isConnected());

            OutputStream stream = socket.getOutputStream();
            BufferedOutputStream out = new BufferedOutputStream(stream);
            byte[] bytes = data.getBytes();
            out.write(bytes);
            System.out.println("Client:Sent data");

            InputStream input = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));

            //String a = in.readLine();
//
//
//            StringBuffer receivedData = new StringBuffer();
//            while ((data = in.readLine()) != null) {
//                receivedData.append(data);
//            }

            System.out.println(input);

            output = input.toString();

            in.close();
//            input.close();
//            out.close();
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
        return output;
    }
}
