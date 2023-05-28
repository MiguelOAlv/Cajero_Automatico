package Cajero;

import Conexion_bd.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Miguel
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPin = new javax.swing.JLabel();
        txfPin = new javax.swing.JTextField();
        lblCajero = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ATM");
        setBackground(new java.awt.Color(102, 255, 255));
        setIconImages(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPin.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblPin.setText("INTRODUCE TU PIN SECRETO:");
        getContentPane().add(lblPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 290, 30));

        txfPin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfPin.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        getContentPane().add(txfPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 190, 30));

        lblCajero.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        lblCajero.setText("CAJERO ATM");
        getContentPane().add(lblCajero, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 380, 70));

        btnLogin.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        btnLogin.setText("Acceder");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 130, 30));

        btnRetroceder.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        btnRetroceder.setText("Retroceder");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        getContentPane().add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, 30));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 346));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
    Connection conexion = Conexion.mySQL("proyecto_final", "root", "");
    if (conexion == null) {
    JOptionPane.showMessageDialog(null, "Conexión no establecida");
    }else{
         try {
                String pinIntroducido=txfPin.getText();

                if (pinIntroducido.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Debe introducir un pin", "Error",JOptionPane.ERROR_MESSAGE);
                } else {
                    Statement sentencia = conexion.createStatement();
                    String sql = "SELECT ID_Tarjeta FROM  = '"+pinIntroducido+"'";
                    ResultSet datos = sentencia.executeQuery(sql);
                    if (datos.next()) {
                        JOptionPane.showMessageDialog(null, "Se ha conectado correctamente");
                        // abrir el siguiente JFrame
                    } else {
                        if (intentos == 0) {
                            JOptionPane.showMessageDialog(null, "Tarjeta bloqueada por exceso de intentos. El programa se cerrará.");
                            System.exit(0);
                        }
                        JOptionPane.showMessageDialog(null, "El DNI y/o el PIN son incorrectos. Inténtelo de nuevo.");
                        intentos--;
                        txfPin.setText("");
                    }
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la consulta");
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
            Inicio Inicio = new Inicio();
            Inicio.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnRetrocederActionPerformed
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JLabel lblCajero;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblPin;
    private javax.swing.JTextField txfPin;
    // End of variables declaration//GEN-END:variables
    private int intentos=2;
}
