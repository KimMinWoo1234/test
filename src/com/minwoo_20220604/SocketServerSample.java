package com.minwoo_20220604;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerSample {

    public static void main(String[] args) {
        SocketServerSample sample = new SocketServerSample();
        sample.startServer();
    }

    public void startServer() {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(9999);
            while (true) {
                System.out.println("Server:Waiting for request.");
                client = server.accept();
                System.out.println("Server:Accepted.");
                InputStream stream = client.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                String data = null;
                StringBuffer receivedData = new StringBuffer();
                while ((data = in.readLine()) != null) {
                    receivedData.append(data);
                }
                System.out.println("Received data:" + receivedData);

                OutputStream outStream = client.getOutputStream();
                BufferedOutputStream out = new BufferedOutputStream(outStream);

                if ("exit".equals(receivedData.toString())) {

                    out.write("bye!".getBytes());

                } else {

                    byte[] bytes = receivedData.toString().getBytes("US-ASCII");

                    out.write(bytes);

                    System.out.println(bytes.toString());

                }

                out.write("Hello!".getBytes());

                out.close();
                in.close();
                stream.close();
                client.close();
                System.out.println("----------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
