package com.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

public class SocketServerSample {

    public static void main(String[] args) {
        SocketServerSample sample=new SocketServerSample();
        sample.startServer();
    }

    public void startServer(){
        ServerSocket server=null;
        Socket client=null;
        try {
            server=new ServerSocket(9999);
            while (true){
                System.out.println("Server:Waiting for request.");
                client=server.accept();
                System.out.println("-------::: Accrpt :::--------");
                System.out.println("Server:Accepted.");
                InputStream stream=client.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                String data= in.readLine();

                System.out.println("Received data: + data");

                OutputStream outStream = client.getOutputStream();
                BufferedWriter out = new BufferedWriter( new OutputStreamWriter( outStream ));
                byte[] bytes = data.getBytes(StandardCharsets.US_ASCII);
                StringBuffer sb =new StringBuffer();
                for ( byte b : bytes) {
                    sb.append(String.format("%s ", b ));
                }
                out.write(sb.toString());
                out.newLine();
                out.flush();
                System.out.println("Return : "+sb.toString());
                System.out.println("--------::: End :::----------");
                }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (server!=null){
                try{
                    server.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
