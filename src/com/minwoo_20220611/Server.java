package com.minwoo_20220611;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Server sample = new Server();
        sample.SocketServerSample();
    }

    public void SocketServerSample() {
        ServerSocket server = null;
        Socket client = null;

        String dataSave = "";

        try {
            server = new ServerSocket(9999);
            while (true) {
                System.out.println("Server:Waiting for request.");
                client = server.accept();   // 접근
                System.out.println("-------------::: Accept :::-----------");
                System.out.println("Server:Accepted.");
                InputStream stream = client.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                String data = in.readLine();

                System.out.println("Received data:" + data);


                OutputStream outStream = client.getOutputStream();
//                BufferedWriter out = new BufferedWriter( new OutputStreamWriter( outStream ) );

                if ("COMPLETE".equals(data)) {

                    File file = new File("d:\\MinwooTest.txt");

                    // 파일 있으면 지우고 새로 만들기
                    if(file.isFile()) {
                        file.delete();
                    }

                    // 파일 쓰기
                    FileWriter fw = new FileWriter(file);
                    PrintWriter writer = new PrintWriter(fw);

                    writer.print(dataSave);

                    writer.close();

                    FileOutputStream fos = new FileOutputStream(file);


//                    out.write("COMPLETE");
//                    out.newLine();
//                    out.flush();

                } else {

                    dataSave = dataSave + "\n" +data;

                    System.out.println("Save : "+ data);

//                    out.write("Save");
//                    out.newLine();
//                    out.flush();
                }

//                out.close();
                in.close();
                stream.close();
                client.close();
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
