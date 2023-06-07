/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Cajero;
import Conexion_bd.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class DesbloquearTarjeta extends javax.swing.JFrame {

    /**
     * Creates new form Introducir_Tarjeta
     */
    public DesbloquearTarjeta(Sesion sesion_admin){
        this.sesion= sesion_admin;
        initComponents();
        jPanel2.setBackground(new Color(0, 0, 0, 0));
        jPanel3.setBackground(new Color(0, 0, 0, 0));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfTarjeta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnRetroceder = new javax.swing.JButton();
        btnDesbloquear = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblLimite = new javax.swing.JLabel();
        lblVencimiento = new javax.swing.JLabel();
        lblBloqueado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Desbloquear Tarjeta");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptar.setBackground(new java.awt.Color(255, 255, 255));
        btnAceptar.setForeground(new java.awt.Color(0, 0, 0));
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 100, 30));

        jPanel3.setLayout(new java.awt.GridLayout(1, 2, 15, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Numero de tarjeta:");
        jPanel3.add(jLabel1);
        jPanel3.add(txfTarjeta);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 380, 30));

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

        btnDesbloquear.setBackground(new java.awt.Color(51, 255, 51));
        btnDesbloquear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDesbloquear.setForeground(new java.awt.Color(0, 0, 0));
        btnDesbloquear.setText("Desbloquear");
        btnDesbloquear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDesbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesbloquearActionPerformed(evt);
            }
        });
        jPanel2.add(btnDesbloquear);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 510, 40));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(5, 1, 10, 10));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("INFORMACIÓN DE LA TARJETA");
        jPanel1.add(jLabel3);

        lblCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(0, 0, 0));
        lblCliente.setText("Cliente:");
        jPanel1.add(lblCliente);

        lblLimite.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLimite.setForeground(new java.awt.Color(0, 0, 0));
        lblLimite.setText("Limite de credito:");
        jPanel1.add(lblLimite);

        lblVencimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVencimiento.setForeground(new java.awt.Color(0, 0, 0));
        lblVencimiento.setText("Fecha de vencimiento:");
        jPanel1.add(lblVencimiento);

        lblBloqueado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBloqueado.setForeground(new java.awt.Color(0, 0, 0));
        lblBloqueado.setText("Estado de la tarjeta:");
        jPanel1.add(lblBloqueado);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 510, 150));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo_admin.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            int numeroTarjeta = Integer.parseInt(txfTarjeta.getText());
            Connection conexion_info = Conexion.mySQL("proyecto_final", "root", "");
            Statement sentencia_info = conexion_info.createStatement();
            String sql_info = "SELECT c.nombre, tdc.Limite_de_credito, tdc.Fecha_vencimiento, tdc.Bloqueada FROM clientes c join tarjetas_de_credito tdc ON c.ID_Cliente = tdc.ID_Cliente WHERE ID_Tarjeta = "+numeroTarjeta+";";
            ResultSet resultado_info = sentencia_info.executeQuery(sql_info);
            if(resultado_info.next()){
                String nombre = resultado_info.getString("nombre");
                lblCliente.setText("Cliente: "+nombre);
                Float limite = resultado_info.getFloat("Limite_de_credito");
                lblLimite.setText("Limite de credito: "+limite);
                String fechaVencimiento = resultado_info.getString("Fecha_vencimiento");
                lblVencimiento.setText("Fecha de vencimiento: "+fechaVencimiento);
                int bloqueado = resultado_info.getInt("Bloqueada");
                if(bloqueado==1){
                    lblBloqueado.setText("Estado de la tarjeta: Bloqueada");
                }else{
                    lblBloqueado.setText("Estado de la tarjeta: Operativa");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Error al realizar la consulta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AltaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        Opciones_admin Opciones_admin = new Opciones_admin(this.sesion);
        Opciones_admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void btnDesbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesbloquearActionPerformed
        try {
        int numeroTarjeta = Integer.parseInt(txfTarjeta.getText());
        Connection conexion_desbloquear = Conexion.mySQL("proyecto_final", "root", "");
        Statement sentencia_desbloquear = conexion_desbloquear.createStatement();
        String sql_desbloquear = "UPDATE tarjetas_de_credito SET Bloqueada = 0 WHERE ID_Tarjeta = "+numeroTarjeta+"";
        int resultado_desbloquear = sentencia_desbloquear.executeUpdate(sql_desbloquear);
        if(resultado_desbloquear>0){
                JOptionPane.showMessageDialog(this, "La tarjeta con numero "+numeroTarjeta+" se ha desbloqueado correctamente","Éxito" , JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "El numero introducido no corresponde con ninguno en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DesbloquearTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btnDesbloquearActionPerformed
    
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
            java.util.logging.Logger.getLogger(DesbloquearTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesbloquearTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesbloquearTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesbloquearTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnDesbloquear;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBloqueado;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblLimite;
    private javax.swing.JLabel lblVencimiento;
    private javax.swing.JTextField txfTarjeta;
    // End of variables declaration//GEN-END:variables
    private Sesion sesion;
}
