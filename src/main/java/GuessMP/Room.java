/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GuessMP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author BPs
 */
public class Room extends javax.swing.JFrame {

    /**
     * Creates new form Room
     */
    public Room(String uName, int port) throws Exception {
        this.uName = uName;
        this.port = port;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            lbl_Status.setText("Server Started. Waiting for clients...");
            
            while (true) {                
                Socket clientSocket = serverSocket.accept();
                System.out.println("New Client connected: " + clientSocket.getInetAddress());
                
                Thread clientThread;
                clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
        e.printStackTrace();
        }
        initComponents();
    }
    String uName;
    int port;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Room = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panel_Player = new javax.swing.JPanel();
        lbl_player1 = new javax.swing.JLabel();
        lbl_player2 = new javax.swing.JLabel();
        lbl_player3 = new javax.swing.JLabel();
        lbl_player4 = new javax.swing.JLabel();
        lbl_Status = new javax.swing.JLabel();
        lbl_playerStat1 = new javax.swing.JLabel();
        lbl_playerStat2 = new javax.swing.JLabel();
        lbl_playerStat3 = new javax.swing.JLabel();
        lbl_playerStat4 = new javax.swing.JLabel();
        panel_GameConfigure = new javax.swing.JPanel();
        btn_Start = new javax.swing.JButton();
        lbl_max = new javax.swing.JLabel();
        tf_Max = new javax.swing.JTextField();
        lbl_max1 = new javax.swing.JLabel();
        lbl_Attempt = new javax.swing.JLabel();
        spin_Attempt = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Room.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_Room.setText("Your Room");
        getContentPane().add(lbl_Room, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 6, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 416, -1));

        lbl_player1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_player1.setText("<Player1>");

        lbl_player2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_player2.setText("<Player2>");

        lbl_player3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_player3.setText("<Player3>");

        lbl_player4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_player4.setText("<Player4>");

        lbl_Status.setText("<status>");

        lbl_playerStat1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_playerStat1.setText("<Player Status>");

        lbl_playerStat2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_playerStat2.setText("<Player Status>");

        lbl_playerStat3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_playerStat3.setText("<Player Status>");

        lbl_playerStat4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_playerStat4.setText("<Player Status>");

        javax.swing.GroupLayout panel_PlayerLayout = new javax.swing.GroupLayout(panel_Player);
        panel_Player.setLayout(panel_PlayerLayout);
        panel_PlayerLayout.setHorizontalGroup(
            panel_PlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_PlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_PlayerLayout.createSequentialGroup()
                        .addComponent(lbl_player1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_playerStat1))
                    .addGroup(panel_PlayerLayout.createSequentialGroup()
                        .addComponent(lbl_player2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_playerStat2))
                    .addGroup(panel_PlayerLayout.createSequentialGroup()
                        .addComponent(lbl_player3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_playerStat3))
                    .addGroup(panel_PlayerLayout.createSequentialGroup()
                        .addComponent(lbl_player4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_playerStat4))
                    .addComponent(lbl_Status))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panel_PlayerLayout.setVerticalGroup(
            panel_PlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PlayerLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_PlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_player1)
                    .addComponent(lbl_playerStat1))
                .addGap(18, 18, 18)
                .addGroup(panel_PlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_player2)
                    .addComponent(lbl_playerStat2))
                .addGap(18, 18, 18)
                .addGroup(panel_PlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_player3)
                    .addComponent(lbl_playerStat3))
                .addGap(18, 18, 18)
                .addGroup(panel_PlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_player4)
                    .addComponent(lbl_playerStat4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Status)
                .addContainerGap())
        );

        getContentPane().add(panel_Player, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, -1, 238));

        btn_Start.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Start.setText("Start");

        lbl_max.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_max.setText("1 to:");
        lbl_max.setToolTipText("");

        tf_Max.setText("100");

        lbl_max1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbl_max1.setText("(Limit number to guess)");
        lbl_max1.setToolTipText("");

        lbl_Attempt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_Attempt.setText("Attempt:");
        lbl_Attempt.setToolTipText("");

        spin_Attempt.setValue(5);

        javax.swing.GroupLayout panel_GameConfigureLayout = new javax.swing.GroupLayout(panel_GameConfigure);
        panel_GameConfigure.setLayout(panel_GameConfigureLayout);
        panel_GameConfigureLayout.setHorizontalGroup(
            panel_GameConfigureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_GameConfigureLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_GameConfigureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_GameConfigureLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lbl_max1))
                    .addGroup(panel_GameConfigureLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lbl_max))
                    .addGroup(panel_GameConfigureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tf_Max, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_GameConfigureLayout.createSequentialGroup()
                            .addComponent(lbl_Attempt)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel_GameConfigureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_Start)
                                .addComponent(spin_Attempt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(19, 19, 19))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panel_GameConfigureLayout.setVerticalGroup(
            panel_GameConfigureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_GameConfigureLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbl_max1)
                .addGap(0, 0, 0)
                .addGroup(panel_GameConfigureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_max)
                    .addComponent(tf_Max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panel_GameConfigureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Attempt)
                    .addComponent(spin_Attempt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(btn_Start)
                .addGap(44, 44, 44))
        );

        getContentPane().add(panel_GameConfigure, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 56, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        lbl_Status.setVisible(false);
        lbl_player1.setVisible(false);
        lbl_playerStat1.setVisible(false);
        lbl_player2.setVisible(false);
        lbl_playerStat2.setVisible(false);
        lbl_player3.setVisible(false);
        lbl_playerStat3.setVisible(false);
        lbl_player4.setVisible(false);
        lbl_playerStat4.setVisible(false);
        if (uName != null) {
            lbl_player1.setVisible(true);
            lbl_playerStat1.setVisible(true);
            lbl_player1.setText(uName);
            lbl_playerStat1.setText("host");
            lbl_Status.setVisible(true);
            lbl_Status.setText("You created a room.");
        }
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Start;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_Attempt;
    private javax.swing.JLabel lbl_Room;
    private javax.swing.JLabel lbl_Status;
    private javax.swing.JLabel lbl_max;
    private javax.swing.JLabel lbl_max1;
    private javax.swing.JLabel lbl_player1;
    private javax.swing.JLabel lbl_player2;
    private javax.swing.JLabel lbl_player3;
    private javax.swing.JLabel lbl_player4;
    private javax.swing.JLabel lbl_playerStat1;
    private javax.swing.JLabel lbl_playerStat2;
    private javax.swing.JLabel lbl_playerStat3;
    private javax.swing.JLabel lbl_playerStat4;
    private javax.swing.JPanel panel_GameConfigure;
    private javax.swing.JPanel panel_Player;
    private javax.swing.JSpinner spin_Attempt;
    private javax.swing.JTextField tf_Max;
    // End of variables declaration//GEN-END:variables
}
