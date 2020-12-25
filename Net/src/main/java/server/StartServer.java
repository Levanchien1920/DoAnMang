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
import model.Message;
import model.Process;
import model.User;
import model.UserSocket;
import server.dao.CheckLogout;
import server.dao.GetConversation;
import server.dao.GetUser;
import model.Conversation;
import model.ListMessage;
import server.dao.CheckAccountSetting;
import server.dao.GetMessage;

public class StartServer extends javax.swing.JFrame {

    ServerSocket serverSocket = null;
    int port;
    public static List<UserSocket> listUserSocket = new ArrayList<UserSocket>();

    public StartServer() {
        initComponents();
    }

    public static void loadUser() {
        List<User> listUser = GetUser.getAll();
        for (User user : listUser) {
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
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtPort.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Start Server");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnStartServer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStopServer)))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartServer)
                    .addComponent(btnStopServer))
                .addContainerGap(54, Short.MAX_VALUE))
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

                    System.out.println("Server is started");
                    while (true) {
                        Socket socket = serverSocket.accept();
                        ServerControl control = new ServerControl(socket);
                        control.start();
                        System.out.println("Connected:" + socket);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables
}

class ServerControl extends Thread {

    private Socket socket;

    public ServerControl(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
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
                        User user = GetUser.getUserByUsername(p.getUser().getUsername());
                        List<User> listUser = GetUser.getAll(p.getUser().getUsername());
                        p.setUser(user);
                        p.setListUsers(listUser);
                        p.setReply(true);
                        int index = 0;
                        //update usersocket
                        for (UserSocket us : StartServer.listUserSocket) {
                            if (p.getUser().getId() == us.getUser().getId()) {
                                if (us.getSocket() != null) {
                                    p.setReply(false);
                                    break;
                                }
                                StartServer.listUserSocket.set(index, new UserSocket(socket, p.getUser()));
                            }
                            index++;
                        }

                        List<Conversation> listConversations = GetConversation.getAllConversations(p.getUser().getId());
                        List<ListMessage> listMessages = new ArrayList<>();
                        for (Conversation cs : listConversations) {
                            List<Message> mes = GetMessage.getMessageByIdCon(cs.getId_con());
                            listMessages.add(new ListMessage(cs, mes));
                        }
                        p.setListMessages(listMessages);

                        System.out.println("Login Success:" + socket);
                        objectOutputStream.writeObject(p);

                        //cap nhat trang thai cho cac user khac
                        for (UserSocket us : StartServer.listUserSocket) {
                            if (us.getUser().getId() != p.getUser().getId()) {
                                if (us.getSocket() != null) {
                                    List<User> listUserUpdate = GetUser.getAll(us.getUser().getUsername());
                                    OutputStream ooutputStream = us.getSocket().getOutputStream();
                                    ObjectOutputStream oobjectOutputStream = new ObjectOutputStream(ooutputStream);
                                    Process pp = new Process(listUserUpdate, "status");
                                    oobjectOutputStream.writeObject(pp);
                                }
                            }
                            index++;
                        }
                    } else {
                        p.setReply(false);
                        System.out.println("Login Failure" + socket);
                        objectOutputStream.writeObject(p);
                    }

                    System.out.println("State UserSocket:");
                    for (UserSocket us : StartServer.listUserSocket) {
                        System.out.println("\t" + us.toString());
                    }

                }
                if (p.getControl().equals("register")) {

                    if (server.dao.CheckRegister.checkRegister(p.getUser().getUsername(), p.getUser().getPassword(), p.getUser().getFullname(), p.getUser().getDescription())) {
                        p.setReply(true);
                        User user = GetUser.getUserByUsername(p.getUser().getUsername());
                        StartServer.listUserSocket.add(new UserSocket(null, user));
                        System.out.println("Register successfully");

                        for (UserSocket us : StartServer.listUserSocket) {
                            if (us.getUser().getId() != p.getUser().getId()) {
                                if (us.getSocket() != null) {
                                    List<User> listUserUpdate = GetUser.getAll(us.getUser().getUsername());
                                    OutputStream outputStreamm = us.getSocket().getOutputStream();
                                    ObjectOutputStream objectOutputStreamm = new ObjectOutputStream(outputStreamm);
                                    Process pp = new Process(listUserUpdate, "status");
                                    objectOutputStreamm.writeObject(pp);
                                }
                            }
                        }

                    } else {
                        p.setReply(false);
                        System.out.println("Register failed");
                    }
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    objectOutputStream.writeObject(p);
                }
                if (p.getControl().equals("setting")) {

                    if (CheckAccountSetting.checkAccountSetting(p.getUser().getId(), p.getUser().getUsername(),
                            p.getUser().getFullname(), p.getUser().getDescription())) {
                        p.setReply(true);

                        for (UserSocket us : StartServer.listUserSocket) {
                            if (us.getUser().getId() == p.getUser().getId()) {
                                us.setUser(p.getUser());
                            }
                        }

                        for (UserSocket us : StartServer.listUserSocket) {
                            if (us.getUser().getId() != p.getUser().getId()) {
                                if (us.getSocket() != null) {
                                    List<User> listUserUpdate = GetUser.getAll(us.getUser().getUsername());
                                    OutputStream outputStreamm = us.getSocket().getOutputStream();
                                    ObjectOutputStream objectOutputStreamm = new ObjectOutputStream(outputStreamm);
                                    Process pp = new Process(listUserUpdate, "status");
                                    objectOutputStreamm.writeObject(pp);
                                }
                            }
                        }

                        if (CheckLogout.checkLogout(p.getUser().getUsername()) == 1) {
                            System.out.println("Logout Success:" + socket);
                            int index = 0;
                            for (UserSocket us : StartServer.listUserSocket) {
                                User tempUser = us.getUser();
                                if (p.getUser().getId() == us.getUser().getId()) {
                                    StartServer.listUserSocket.set(index, new UserSocket(null, tempUser));
                                }
                                index++;
                            }
                            System.out.println("State UserSocket:");
                            for (UserSocket us : StartServer.listUserSocket) {
                                System.out.println("\t" + us.toString());
                            }

                            for (UserSocket us : StartServer.listUserSocket) {
                                if (us.getUser().getId() != p.getUser().getId()) {
                                    if (us.getSocket() != null) {
                                        List<User> listUserUpdate = GetUser.getAll(us.getUser().getUsername());
                                        OutputStream outputStream = us.getSocket().getOutputStream();
                                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                                        Process pp = new Process(listUserUpdate, "status");
                                        objectOutputStream.writeObject(pp);
                                    }
                                }
                                index++;
                            }
                        }

                        System.out.println("Setting complete");
                    } else {
                        p.setReply(false);
                        System.out.println("Cannot setting");
                    }
                }
                if (p.getControl().equals("logout")) {
                    if (CheckLogout.checkLogout(p.getUser().getUsername()) == 1) {
                        System.out.println("Logout Success:" + socket);
                        int index = 0;
                        for (UserSocket us : StartServer.listUserSocket) {
                            User tempUser = us.getUser();
                            if (p.getUser().getId() == us.getUser().getId()) {
                                StartServer.listUserSocket.set(index, new UserSocket(null, tempUser));
                            }
                            index++;
                        }
                        System.out.println("State UserSocket:");
                        for (UserSocket us : StartServer.listUserSocket) {
                            System.out.println("\t" + us.toString());
                        }

                        for (UserSocket us : StartServer.listUserSocket) {
                            if (us.getUser().getId() != p.getUser().getId()) {
                                if (us.getSocket() != null) {
                                    List<User> listUserUpdate = GetUser.getAll(us.getUser().getUsername());
                                    OutputStream outputStream = us.getSocket().getOutputStream();
                                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                                    Process pp = new Process(listUserUpdate, "status");
                                    objectOutputStream.writeObject(pp);
                                }
                            }
                            index++;
                        }
                    }
                }
                if (p.getControl().equals("chat")) {
                    int id_from = p.getMessage().getId_user_from();
                    int id_to = p.getMessage().getId_user_to();
                    String sms = p.getMessage().getBody_msg();

                    if (GetConversation.checkIsConversationExist(p.getMessage()) == 1) {
                        System.out.println("Message: " + p.getMessage().getBody_msg() + " from: " + p.getMessage().getId_user_from() + " to: " + p.getMessage().getId_user_to());
                        int index = 0;
                        for (UserSocket us : StartServer.listUserSocket) {
                            if (id_to == us.getUser().getId()) {
                                if (us.getSocket() != null) {
                                    OutputStream outputStream = us.getSocket().getOutputStream();
                                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                                    Process pp = new Process("chat", p.getUser(), p.getMessage());
                                    objectOutputStream.writeObject(pp);
                                    System.out.println("Da phan hoi");
                                }
                            }
                            index++;
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Disconnected to client");
        } catch (ClassNotFoundException ex) {
            System.out.println("Disconnected to client");
        }

    }
}
