package server;

import server.dao.CheckLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Process;
import model.User;
import model.UserSocket;
import server.dao.CheckLogout;
import server.dao.GetUser;

public class StartServer extends javax.swing.JFrame {

    ServerSocket serverSocket = null;
    int port;
    public static List<UserSocket> listUserSocket = new ArrayList<UserSocket>();

    public StartServer() {
        initComponents();
    }
    
    public static void loadUser(){
        List<User> listUser = GetUser.getAll();
        for(User user: listUser){
            UserSocket userSocket = new UserSocket(null, user);
            listUserSocket.add(userSocket);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPort = new javax.swing.JTextField();
        btnStartServer = new javax.swing.JButton();
        btnStopServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtPort.setText("1111");

        btnStartServer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStartServer.setForeground(new java.awt.Color(0, 51, 255));
        btnStartServer.setText("Start Server");
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        btnStopServer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStopServer.setForeground(new java.awt.Color(0, 51, 255));
        btnStopServer.setText("Stop Server");
        btnStopServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStartServer)
                        .addGap(18, 18, 18)
                        .addComponent(btnStopServer))
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStopServer)
                    .addComponent(btnStartServer))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServerActionPerformed
        btnStartServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String port = txtPort.getText();
                try {
                    serverSocket = new ServerSocket(Integer.parseInt(port));
                    StartServer.loadUser();
                    for(UserSocket u : StartServer.listUserSocket){
                        System.out.println(u.getUser().getId());
                    }
                    System.out.println("Server is started");
                    while (true) {
                        Socket socket = serverSocket.accept();
                        //new thread
                        ServerControl control = new ServerControl(socket);
                        control.start();
                        ServerChat chat = new ServerChat(socket);
                        chat.start();
                        System.out.println(socket);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }//GEN-LAST:event_btnStartServerActionPerformed

    private void btnStopServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopServerActionPerformed

    }//GEN-LAST:event_btnStopServerActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStartServer;
    private javax.swing.JButton btnStopServer;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables
}

class ServerChat extends Thread {

    private Socket socket;

    public ServerChat(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Start chat");
        //nhan tin nhan
        //kiem tra doi tuong nhan, gui cho nguoi nhan neu User on
        //luu tin nhan vao database

    }

}

class ServerControl extends Thread {

    private Socket socket;

    public ServerControl(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Start control");
        try {
            while (true) {
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                Process p = (Process) objectInputStream.readObject();
                if (p.getControl().equals("login")) {
                    //xu ly login
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    if (CheckLogin.checkLogin(p.getUser().getUsername(), p.getUser().getPassword())) {
                        //kiem tra login thanh cong
                        //them user vao listUserSocket

                        //chuyen trang thai thanh on cho user
                       
                        User user = GetUser.getUserByUsername(p.getUser().getUsername());
                        List<User> listUser = GetUser.getAll(p.getUser().getUsername());
                        System.out.println("start server:"+listUser.get(1).getFullname());
                        System.out.println("fullname serrver:" + user.getFullname());
                        p.setUser(user);
                        p.setListUsers(listUser);
                        p.setReply(true);
                        StartServer.listUserSocket.add(new UserSocket(socket, p.getUser()));
                        System.out.println(socket.getPort() + ":" + "Login Success");

                    } else {
                        p.setReply(false);
                        System.out.println(socket.getPort() + ":" + "Login Failure");
                    }
                    objectOutputStream.writeObject(p);
                }
                if (p.getControl().equals("register")) {
//register 
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    if (server.dao.CheckRegister.checkRegister(p.getUser().getUsername(), p.getUser().getPassword(), p.getUser().getFullname(), p.getUser().getDescription())) {
                        p.setReply(true);
                        StartServer.listUserSocket.add(new UserSocket(socket, p.getUser()));
                        System.out.println("Register successfully");

                    } else {
                        p.setReply(false);
                        System.out.println("Register failed");
                    }
                    objectOutputStream.writeObject(p);
                }
                if (p.getControl().equals("setting")) {
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    if (CheckLogin.checkLogin(p.getUser().getUsername(), p.getUser().getPassword())) {
                        p.setReply(true);
                        StartServer.listUserSocket.add(new UserSocket(socket, p.getUser()));
                        System.out.println("Setting complete");

                    } else {
                        p.setReply(false);
                        System.out.println("Cannot setting");
                    }
                    objectOutputStream.writeObject(p);

                }
                if (p.getControl().equals("logout")) {
                    System.out.println("logout");
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//                    CheckLogout.checkLogout(p.getUser().getUsername()) == 1
                    if (true) {
                        p.setReply(true);
                        System.out.println("Logged out");

                    } else {
                        p.setReply(false);
                        System.out.println("Cannot logout");
                    }
                    objectOutputStream.writeObject(p);
                    //for() gui 
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
