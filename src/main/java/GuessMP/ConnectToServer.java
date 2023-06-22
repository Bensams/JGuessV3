/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package GuessMP;

import static GuessMP.CreateServer.MAX_PORT_NUMBER;
import static GuessMP.CreateServer.MIN_PORT_NUMBER;
import com.sun.glass.ui.Cursor;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author BPs
 */
public class ConnectToServer extends javax.swing.JFrame {

    /** Creates new form ConnectToServer */
    public ConnectToServer() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_IpAddress = new javax.swing.JTextField();
        tf_Port = new javax.swing.JTextField();
        lbl_IpAddress = new javax.swing.JLabel();
        lbl_Port = new javax.swing.JLabel();
        btn_Join = new javax.swing.JButton();
        lbl_Title = new javax.swing.JLabel();
        lbl_Status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Connect or Join a Room");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lbl_IpAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_IpAddress.setText("IP ADDRESS:");

        lbl_Port.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_Port.setText("PORT:");

        btn_Join.setText("JOIN");
        btn_Join.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Join.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_JoinActionPerformed(evt);
            }
        });

        lbl_Title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_Title.setText("Join a Room");

        lbl_Status.setText("<status>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addComponent(btn_Join)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_IpAddress)
                            .addComponent(lbl_Port))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Title)
                            .addComponent(tf_Port, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_IpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_Status)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Title)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_IpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_IpAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Port))
                .addGap(36, 36, 36)
                .addComponent(btn_Join)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(lbl_Status))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    String address;
    int port;
    public void setAddress(String address) {
       this.address = address;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getAddress() {
       return address;
    }
    public int getPort() {
        return port;
    }

    public static boolean available(int port) {
    if (port < MIN_PORT_NUMBER || port > MAX_PORT_NUMBER) {
        throw new IllegalArgumentException("Invalid start port: " + port);
    }
    ServerSocket ss = null;
    try {
        ss = new ServerSocket(port);
        ss.setReuseAddress(true);
        return true;
    } catch (IOException e) {
    } finally {
        if (ss != null) {
            try {
                ss.close();
            } catch (IOException e) {
                /* should not be thrown */
            }
        }
     }
    return false;
    }
    
    private void btn_JoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_JoinActionPerformed
        
        String address = tf_IpAddress.getText();
        int port = Integer.parseInt(tf_Port.getText());
        if (port < MIN_PORT_NUMBER || port > MAX_PORT_NUMBER) {
            lbl_Status.setVisible(true);
            lbl_Status.setText("Invalid start port: " + port);
            throw new IllegalArgumentException("Invalid start port: " + port);
        }
        setAddress(address);
        setPort(port);
        if (!available(port)) {
            this.dispose();
            String uName = JOptionPane.showInputDialog("Enter your username");
            try {
                new Room(uName, port).setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            lbl_Status.setVisible(true);
            lbl_Status.setText("Connection Failed!!!");
        }
        
    }//GEN-LAST:event_btn_JoinActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        lbl_Status.setVisible(false);
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(ConnectToServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectToServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectToServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectToServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectToServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Join;
    private javax.swing.JLabel lbl_IpAddress;
    private javax.swing.JLabel lbl_Port;
    private javax.swing.JLabel lbl_Status;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JTextField tf_IpAddress;
    private javax.swing.JTextField tf_Port;
    // End of variables declaration//GEN-END:variables

}
