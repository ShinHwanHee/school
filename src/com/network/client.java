package com.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class client {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("문자를 입력하세요 :");
        char ch = sc.nextLine().charAt(0);
        int num = (int)ch;

        System.out.println(num);
    }

    public void SocketClient(String[] args){
        SocketClientSample sample=new SocketClientSample();
        sample.sendSocketSample();
    }

    public void sendSocketSample(){
        for (int loop=0; loop<3; loop++) {
            sendSocketData("I liked java at "+new Date());
        }
        sendSocketData("EXIT");
    }

    public void sendSocketData(String data) {
        Socket socket=null;
        try{
            System.out.println("Client:Connecting");
            socket=new Socket("127.0.0.1",9999);
            System.out.println("Client:Connect status="+socket.isConnected());
            Thread.sleep(1000);
            OutputStream stream=socket.getOutputStream();
            BufferedOutputStream out=
                    new BufferedOutputStream(stream);
            byte[] bytes=data.getBytes();
            out.write(bytes);
            System.out.println("Client:sent data");
            out.close();
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

    public void SocketServer(String[] args) {
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
                System.out.println("Server:Accepted.");
                InputStream stream=client.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                String data=null;
                StringBuilder receivedData=new StringBuilder();
                while ((data=in.readLine())!=null) {
                    receivedData.append(data);
                }
                System.out.println("Received data:" + receivedData);
                in.close();
                stream.close();
                client.close();
                if((data=in.readLine())!=null) {
                    receivedData.append(data);
                }
                System.out.println("Received data:"+receivedData);
                in.close();
                stream.close();
                client.close();
                if (receivedData!=null && "EXIT".equals(receivedData.toString())) {
                    System.out.println("Stop SocketServer");
                    break;
                }
                System.out.println("-----------");

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
