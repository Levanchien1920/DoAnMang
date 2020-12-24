package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Conversation;
import model.ListMessage;
import model.Message;
import model.User;
import model.UserSocket;
import model.Process;

public class Main extends javax.swing.JFrame {

    User user = null;
    List<User> listUsers = new ArrayList<>();
    private final String header[] = {"Status", "Full name"};
    private DefaultTableModel tblModel;
    List<ListMessage> listMessages;
    int idFriendChat = 0;
    Thread thread;
    ObjectInputStream objectInputStream;

    public Main() {
        this.tblModel = new DefaultTableModel(header, 0);
        initComponents();
    }

    public Main(User user, List<User> list, List<ListMessage> listMessageFromOther) {
        initComponents();
        this.tblModel = new DefaultTableModel(header, 0);
        this.user = user;
        lbFullname.setText(user.getFullname());
        lblDes.setText(user.getDescription());
        lblId.setText(Integer.toString(user.getId()));
        this.listUsers = list;
        loadAllFriend(listUsers);
        this.listMessages = listMessageFromOther;

        this.thread = new Thread("Thread start Login: chat") {
            public void run() {
                try {
                    while (true) {
                        objectInputStream = new ObjectInputStream(ConnectToServer.socket.getInputStream());
                        model.Process reProcess = (model.Process) objectInputStream.readObject();
                        if (reProcess.getControl().equals("chat")) {

                            System.out.println("Message: "+reProcess.getMessage().getBody_msg() + " from: "+ reProcess.getMessage().getId_user_from());
                            int id_user = reProcess.getMessage().getId_user_from();
                            int id_friend = reProcess.getMessage().getId_user_to();
                            boolean check = false;
                            for (ListMessage lm : listMessages) {
                                int idf = lm.getConversation().getId_from();
                                int idt = lm.getConversation().getId_to();
                                if ((id_user == idf && id_friend == idt) || id_user == idt && id_friend == idf) {
                                    lm.getListMessage().add(reProcess.getMessage());
                                } else {
                                    check = true;
                                }
                            }
                            if (check) {
                                int id_con = reProcess.getMessage().getId_con();
                                Conversation con = new Conversation(id_con, id_user, id_friend);
                                List<Message> list = new ArrayList<Message>();
                                list.add(reProcess.getMessage());
                                listMessages.add(new ListMessage(con, list));
                            }
//                            if (id_friend == reProcess.getMessage().getId_user_from()) {
//                                String chatContent = "";
//                                for (ListMessage lm : listMessages) {
//                                    int idf = lm.getConversation().getId_from();
//                                    int idt = lm.getConversation().getId_to();
//                                    if ((id_user == idf && id_friend == idt) || id_user == idt && id_friend == idf) {
//                                        for (Message me : lm.getListMessage()) {
//
//                                            String name = "Me";
//                                            for (User user : listUsers) {
//                                                if (user.getId() == me.getId_user_from()) {
//                                                    name = user.getFullname();
//                                                }
//                                            }
//                                            chatContent += name + " : " + me.getBody_msg() + "\t" + me.getDate_send() + "\n";
//                                        }
//                                        break;
//                                    }
//                                }
//                                taChat.setText("");
//                                taChat.setText(chatContent);
//                            }
                        } else if (reProcess.getControl().equals("status")) {
                            //listUsers = reProcess.getListUsers();
                            System.out.println("test status");
//                            loadAllFriend(listUsers);
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        this.thread.start();
        System.out.println(thread.getName());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taChat = new javax.swing.JTextArea();
        txtSend = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        lblFriend = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ImageIcon icon1 = new ImageIcon("C:\\Users\\caoquangtrong\\OneDrive\\Documents\\NetBeansProjects\\mavenproject1\\src\\main\\java\\angry.png");
        ImageIcon icon2 = new ImageIcon("C://Users//caoquangtrong//OneDrive//Documents//NetBeansProjects//mavenproject1//src//main//java//happy.png");
        ImageIcon icon3 = new ImageIcon("C://Users//caoquangtrong//OneDrive//Documents//NetBeansProjects//mavenproject1//src//main//java//sad.png");

        Object [][] rows = {
            {icon1, icon2, icon3}
        };

        String [] columns = {"ic1", "ic2", "ic3"};
        DefaultTableModel model = new DefaultTableModel(rows, columns){
            public Class <?> getColClass(int column){
                switch (column){
                    case 0: return ImageIcon.class;
                    case 1: return ImageIcon.class;
                    case 2: return ImageIcon.class;
                    default: return Object.class;
                }
            }
        };
        tblFriend = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbFullname = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        btnSetting = new javax.swing.JButton();
        lblDes = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        taChat.setEditable(false);
        taChat.setColumns(20);
        taChat.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        taChat.setRows(5);
        jScrollPane1.setViewportView(taChat);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("Upload file");

        btnSend.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSend.setForeground(new java.awt.Color(51, 0, 255));
        btnSend.setText("SEND");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        lblFriend.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFriend.setForeground(new java.awt.Color(0, 0, 255));
        lblFriend.setText("Chat with friends");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFriend, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSend, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addContainerGap(29, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblFriend, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblFriend.setBounds(0, 0, 672, 672);
        tblFriend.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblFriend.setModel(model);
        tblFriend.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblFriend.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblFriend.setFocusable(false);
        tblFriend.setRequestFocusEnabled(false);
        tblFriend.setRowHeight(30);
        tblFriend.getTableHeader().setReorderingAllowed(false);
        tblFriend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFriendMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblFriend);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 255));
        jLabel2.setText("List friends");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        lbFullname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbFullname.setForeground(new java.awt.Color(0, 51, 204));
        lbFullname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFullname.setText("Le Van Chien");

        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(0, 0, 255));
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnSetting.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSetting.setForeground(new java.awt.Color(0, 0, 255));
        btnSetting.setText("Account Setting");
        btnSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingActionPerformed(evt);
            }
        });

        lblDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDes.setText("Yêu màu hồng ghét sự giả dối");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbFullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblId)
                .addGap(24, 24, 24))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnSetting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDes, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDes, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSetting)
                    .addComponent(btnLogOut))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadAllFriend(List<User> users) {
        Icon active = new ImageIcon("C:\\Users\\caoquangtrong\\OneDrive\\Documents\\NetBeansProjects\\DAM\\Net\\src\\main\\java\\image\\on.png");
        Icon notActive = new ImageIcon("C:\\Users\\caoquangtrong\\OneDrive\\Documents\\NetBeansProjects\\DAM\\Net\\src\\main\\java\\image\\off.png");
        String[] columnNames = {"Status", "Name"};
        int x = users.size();
        Object[][] data = new Object[x][2];

        for (int i = 0; i < users.size(); i++) {
            Icon icon = notActive;
            if (users.get(i).getStatus() == 1) {
                icon = active;
            }
            Object o1 = icon;
            Object o2 = users.get(i).getFullname();
            data[i][0] = o1;
            data[i][1] = o2;
            System.out.println(users.get(i).getFullname() + " :" + users.get(i).getStatus());

        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };

        tblFriend.setModel(model);
        tblFriend.getColumnModel().getColumn(1).setPreferredWidth(400);
        tblFriend.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tblFriend.getTableHeader().setResizingAllowed(false);
    }

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ConnectToServer.outputStream);
            String control = "logout";
            model.Process p = new model.Process(control, this.user);
            objectOutputStream.writeObject(p);
            ConnectToServer.socket.close();
            ConnectToServer connectToServer = new  ConnectToServer();
            connectToServer.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        System.out.println("Closing");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ConnectToServer.outputStream);
            String control = "logout";
            model.Process p = new model.Process(control, user);
            objectOutputStream.writeObject(p);
            ConnectToServer.socket.close();
            ConnectToServer connectToServer = new  ConnectToServer();
            connectToServer.setVisible(true);
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingActionPerformed
        AccountSetting ac = new AccountSetting(this.user);
        ac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ac.setVisible(true);
    }//GEN-LAST:event_btnSettingActionPerformed

    private void tblFriendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFriendMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int column = source.columnAtPoint(evt.getPoint());
        String s = source.getModel().getValueAt(row, column) + "";

        JOptionPane.showMessageDialog(null, listUsers.get(row).getId());
        int id_friend = listUsers.get(row).getId();
        lblFriend.setText(listUsers.get(row).getFullname());
        this.idFriendChat = id_friend;
        int id_user = user.getId();
        String chatContent = "";
        //listMessage
        for (ListMessage lm : listMessages) {
            int idf = lm.getConversation().getId_from();
            int idt = lm.getConversation().getId_to();
            if ((id_user == idf && id_friend == idt) || id_user == idt && id_friend == idf) {
                for (Message me : lm.getListMessage()) {
                    String name = "Me";
                    for (User user : listUsers) {
                        if (user.getId() == me.getId_user_from()) {
                            name = user.getFullname();
                        }
                    }
                    String rowString = name+":"+me.getBody_msg();
                    chatContent += name + " : " + me.getBody_msg() + "\t" + me.getDate_send() + "\n";
                }
                break;
            }
        }
        taChat.setText("");
        taChat.setText(chatContent);
    }//GEN-LAST:event_tblFriendMouseClicked

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        String textSend = txtSend.getText();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        int id_user = user.getId();
        int id_friend = idFriendChat;
        Message newMessage = new Message(textSend, user.getId(), timestamp, idFriendChat);
        
        boolean check = true;
        for (ListMessage lm : listMessages) {
            int idf = lm.getConversation().getId_from();
            int idt = lm.getConversation().getId_to();
            if ((id_user == idf && id_friend == idt) || id_user == idt && id_friend == idf) {
                newMessage.setId_con(lm.getConversation().getId_con());
                lm.getListMessage().add(newMessage);
                check = false;
                break;
            }
        }
        if (check) {
            int id_con = id_user*10+id_friend;
            newMessage.setId_con(id_con);
            Conversation con = new Conversation(id_con, id_user, id_friend);
            List<Message> list = new ArrayList<Message>();
            list.add(newMessage);
            listMessages.add(new ListMessage(con, list));
        }
        JOptionPane.showMessageDialog(null, Integer.toString(newMessage.getId_con()));
        
        String chatContent = "";
        for (ListMessage lm : listMessages) {
            int idf = lm.getConversation().getId_from();
            int idt = lm.getConversation().getId_to();
            if ((id_user == idf && id_friend == idt) || id_user == idt && id_friend == idf) {
                for (Message me : lm.getListMessage()) {
                    String name = "Me";
                    for (User user : listUsers) {
                        if (user.getId() == me.getId_user_from()) {
                            name = user.getFullname();
                        }
                    }
                    chatContent += name + " : " + me.getBody_msg() + "\t" + me.getDate_send() + "\n";
                }
                break;
            }
        }
        taChat.setText("");
        taChat.setText(chatContent);

        System.out.println("Chat to " + idFriendChat + ":" + textSend);

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ConnectToServer.outputStream);
            Process process = new Process("chat", user, newMessage);
            objectOutputStream.writeObject(process);
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSendActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSetting;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbFullname;
    private javax.swing.JLabel lblDes;
    private javax.swing.JLabel lblFriend;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextArea taChat;
    private javax.swing.JTable tblFriend;
    private javax.swing.JTextField txtSend;
    // End of variables declaration//GEN-END:variables
}
