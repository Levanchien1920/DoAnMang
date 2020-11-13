/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iamChien.iter
 */
public class RunServer {

    private String dataStringFromClient;
    private boolean isStarted;
    private ServerSocket server;
    List<Client> clientList = new ArrayList<Client>();

    public RunServer() {
        //super();
    }

    public void startServer() {
        try {
            server = new ServerSocket(2810);
            isStarted = true;
            System.out.println("Server Started!");
            while (isStarted) {
                Client st = new Client(server.accept());
                new Thread(st).start();
                clientList.add(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Client implements Runnable {

        private Socket s;
        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isAcceptStarted = false;

        public Client(Socket s) {
            this.s = s;
        }

        public void send(String str) {
            try {
                dos.writeUTF(str);
            } catch (IOException e) {
            }
        }

        @Override
        public synchronized void run() {
            try {
                System.out.println("Connect successfu!");
                isAcceptStarted = true;
                dis = new DataInputStream(s.getInputStream());
                dos = new DataOutputStream(s.getOutputStream());

                while (isAcceptStarted) {
                    dataStringFromClient = dis.readUTF();
                    System.out.println(dataStringFromClient);
                    for (int index = 0; index < clientList.size(); index++) {
                        Client tempClient = clientList.get(index);
                        tempClient.send(dataStringFromClient);
                    }
                }

            } catch (Exception e) {
                clientList.remove(this);
            } finally {
                try {
                    if (s != null) {
                        s.close();
                    }
                    if (dis != null) {
                        dis.close();
                    }
                    if (dos != null) {
                        dos.close();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new RunServer().startServer();
    }
}
