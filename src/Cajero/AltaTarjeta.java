/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Cajero;
import static Cajero.Metodos.validarDNI;
import Conexion_bd.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class AltaTarjeta extends javax.swing.JFrame {

    /**
     * Creates new form Introducir_Tarjeta
     */
    public AltaTarjeta(Sesion sesion_admin){
        this.sesion= sesion_admin;
        initComponents();
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        jPanel2.setBackground(new Color(0, 0, 0, 0));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnRetroceder = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txfDNI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txfPIN = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txfLimite = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alta Tarjeta");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 250, 0));

        btnRetroceder.setBackground(new java.awt.Color(255, 255, 255));
        btnRetroceder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRetroceder.setForeground(new java.awt.Color(0, 0, 0));
        btnRetroceder.setText("Retroceder");
        btnRetroceder.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        jPanel2.add(btnRetroceder);

        btnConfirmar.setBackground(new java.awt.Color(51, 255, 51));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(0, 0, 0));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel2.add(btnConfirmar);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 550, 40));

        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 10, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("DNI:");
        jPanel1.add(jLabel2);
        jPanel1.add(txfDNI);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("PIN:");
        jPanel1.add(jLabel4);
        jPanel1.add(txfPIN);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Limite de credito diario:");
        jPanel1.add(jLabel5);
        jPanel1.add(txfLimite);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 550, 240));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo_admin.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(610, 350));
        jLabel1.setMinimumSize(new java.awt.Dimension(610, 350));
        jLabel1.setPreferredSize(new java.awt.Dimension(610, 350));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        Opciones_admin Opciones_admin = new Opciones_admin(this.sesion);
        Opciones_admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if(txfDNI.getText().equals("") || txfPIN.getText().equals("") || txfLimite.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos para poder realizar el alta", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
        String dni = txfDNI.getText();
        String pin = txfPIN.getText();
        String limite = txfLimite.getText();
        String ID_Cliente="0";
        LocalDate hoy = LocalDate.now();
        //Se coge la fecha actual y se le suman 5 años para calcular la fecha de vencimiento
        LocalDate cincoAños = hoy.plusYears(5);
        
        //Contrastar DNI introducido con clientes en la base de datos con ese DNI
        try {
        Connection conexionDNI = Conexion.mySQL("proyecto_final", "root", "");
        Statement sentenciaDNI= conexionDNI.createStatement();   
        String sqlDNI = "SELECT ID_Cliente FROM clientes WHERE DNI = '"+dni+"'";
        ResultSet resultadoDNI = sentenciaDNI.executeQuery(sqlDNI);
            if(resultadoDNI.next()){
                ID_Cliente = resultadoDNI.getString("ID_Cliente");
            }else{
                JOptionPane.showMessageDialog(this, "El campo dni no se corresponde con ningun cliente", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            } catch (SQLException ex) {
                Logger.getLogger(AltaTarjeta.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!limite.matches("[0-9]+")){
                JOptionPane.showMessageDialog(this, "El campo limite solo puede contener datos numericos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                try{
                    int numeroTarjeta= Metodos.generarAleatorio();//Generar numero aleatorio para la tarjeta
                    Connection conexionTarjeta = Conexion.mySQL("proyecto_final", "root", "");
                    Statement sentenciaTarjeta;
                    sentenciaTarjeta = conexionTarjeta.createStatement();
                    String sqlTarjeta = "INSERT INTO tarjetas_de_credito(ID_Tarjeta,ID_Cliente, PIN, Limite_de_credito, Fecha_vencimiento)VALUES("+numeroTarjeta+","+ID_Cliente+", '"+pin+"', '"+limite+"','"+cincoAños+"');";
                    int resultadoTarjeta = sentenciaTarjeta.executeUpdate(sqlTarjeta);
                    if(resultadoTarjeta>0){
                        JOptionPane.showMessageDialog(this, "La tarjeta se ha dado de alta correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        txfDNI.setText("");
                        txfPIN.setText("");
                        txfLimite.setText("");
                    }else{
                        JOptionPane.showMessageDialog(this, "Error al realizar la inserción", "Error", JOptionPane.ERROR_MESSAGE);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(AltaTarjeta.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed
    
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
            java.util.logging.Logger.getLogger(AltaTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AltaCliente2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txfDNI;
    private javax.swing.JTextField txfLimite;
    private javax.swing.JTextField txfPIN;
    // End of variables declaration//GEN-END:variables
    private Sesion sesion;
}
