package com.network;


import java.io.*;
import java.sql.SQLOutput;
import java.util.Date;
import java.net.Socket;
import java.util.Scanner;

public class SocketClientSample {
    static Scanner scanner;
    Socket socket = null;
    BufferedReader in = null;
    BufferedWriter out = null;
    OutputStream outputStream = null;
    InputStream inputStream = null;

    public static void main(String[] args){
        SocketClientSample sample=new SocketClientSample();
        try {
            sample.sendSocketSample();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendSocketSample() throws  IOException {
        while(true){
            System.out.println("문자를 입력하세요");
            String request = scanner.nextLine();
            sendSocketData(request);
            if (request.equals("complete")) {
                break;
            }
        }
        inputStream.close();
        outputStream.close();
        out.close();
        in.close();
        socket.close();
    }

    private void sendSocketData(String data) {

        try{
            System.out.println("Client:Connecting");
            socket=new Socket("127.0.0.1",9999);
            Thread.sleep(1000);
            outputStream =socket.getOutputStream();
            out = new BufferedWriter ( new OutputStreamWriter( outputStream));
            out.write(data);
            out.newLine();
            out.flush();
            System.out.println("sent data: " + data);

            inputStream = socket.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String recv = in.readLine();
            System.out.println("recide");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (socket!=null){
                try {
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
