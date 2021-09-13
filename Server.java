package com.company;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

public class Server {
    static Connection connection;
    public static void main(String[]args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/it?useUnicode=true&serverTimezone=UTC","root", "");

            ServerSocket server=new ServerSocket(2030);
            while (true){
                Socket socket= server.accept();
                System.out.println("Connected");
                ServerThread st=new ServerThread(socket,connection);
                Thread thread=new Thread(st);
                thread.start();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
