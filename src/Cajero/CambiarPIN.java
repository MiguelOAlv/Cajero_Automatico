/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Cajero;

import Conexion_bd.Conexion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Miguel
 */
public class CambiarPIN extends javax.swing.JFrame {

    /**
     * Creates new form Opciones_admin
     */

    public CambiarPIN (Sesion sesion_usuario) {
        initComponents();
        this.Sesion = sesion_usuario;
        this.Nombre = sesion_usuario.getNombre();
        this.idioma=sesion_usuario.getIdioma();
        this.Sesion.iniciarSesion();
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                sesion_usuario.mantenerSesion();
            }
        });
        cargarIdioma(this.idioma);
        this.fecha = LocalDate.now();
        sesion_usuario.setFrameActual(this);
        jPanel2.setBackground(new Color(0, 0, 0, 0));
        initJLabel();
    }
        public void cargarIdioma(Idioma idioma){
            Properties propiedades = new Idioma(idioma.getNombre());
            this.setTitle(propiedades.getProperty("Cambiar PIN"));
            lblLimite.setText(propiedades.getProperty("lblLimite"));
            lblNuevo.setText(propiedades.getProperty("lblNuevo"));
            lblConfirmar.setText(propiedades.getProperty("lblConfirmar"));
            lblActual.setText(propiedades.getProperty("lblActual"));
            btnRetroceder.setText(propiedades.getProperty("btnRetroceder"));
            btnCambiar.setText(propiedades.getProperty("btnCambiar"));
            btnActualizar.setText(propiedades.getProperty("btnActualizar"));
            lblCliente.setText(propiedades.getProperty("lblCliente"));
            lblInfoTarjeta.setText(propiedades.getProperty("lblInfoTarjeta"));
            lblLimiteCredito.setText(propiedades.getProperty("lblLimiteCredito"));
            lblVencimiento.setText(propiedades.getProperty("lblVencimiento"));
    }
    private void initJLabel(){
        try {
            Connection conexion_info = Conexion.mySQL("proyecto_final", "root", "");
            Statement sentencia_info = conexion_info.createStatement();
            String sql_info = "select c.nombre, tdc.Limite_de_credito,tdc.Fecha_vencimiento from clientes c join tarjetas_de_credito tdc on c.ID_Cliente = tdc.ID_Cliente where ID_Tarjeta = "+this.Sesion.getTarjetaCredito()+";";
            ResultSet resultado_info = sentencia_info.executeQuery(sql_info);
            if(resultado_info.next()){
                String nombre = resultado_info.getString("nombre");
                lblCliente.setText(lblCliente.getText()+nombre);
                int limite = resultado_info.getInt("Limite_de_credito");
                lblLimiteCredito.setText(lblLimiteCredito.getText()+limite);
                String fechaVencimiento = resultado_info.getString("Fecha_vencimiento");
                lblVencimiento.setText(lblVencimiento.getText()+fechaVencimiento);
            }else{
                JOptionPane.showMessageDialog(this, "Error al realizar la consulta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AltaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLimite = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblInfoTarjeta = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblLimiteCredito = new javax.swing.JLabel();
        lblVencimiento = new javax.swing.JLabel();
        txfActual = new javax.swing.JPasswordField();
        txfNuevo = new javax.swing.JPasswordField();
        txfConfirmar = new javax.swing.JPasswordField();
        btnActualizar = new javax.swing.JButton();
        txfLimite = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnRetroceder = new javax.swing.JButton();
        btnCambiar = new javax.swing.JButton();
        lblActual = new javax.swing.JLabel();
        lblNuevo = new javax.swing.JLabel();
        lblConfirmar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cambiar PIN");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLimite.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLimite.setForeground(new java.awt.Color(0, 0, 0));
        lblLimite.setText("Establecer limite diario:");
        getContentPane().add(lblLimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 220, 30));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(4, 1, 5, 2));

        lblInfoTarjeta.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblInfoTarjeta.setForeground(new java.awt.Color(0, 0, 0));
        lblInfoTarjeta.setText("INFORMACION DE LA TARJETA");
        jPanel1.add(lblInfoTarjeta);

        lblCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(0, 0, 0));
        lblCliente.setText("Cliente:");
        jPanel1.add(lblCliente);

        lblLimiteCredito.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLimiteCredito.setForeground(new java.awt.Color(0, 0, 0));
        lblLimiteCredito.setText("Limite de credito:");
        jPanel1.add(lblLimiteCredito);

        lblVencimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVencimiento.setForeground(new java.awt.Color(0, 0, 0));
        lblVencimiento.setText("Fecha de vencimiento:");
        jPanel1.add(lblVencimiento);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 250, 130));
        getContentPane().add(txfActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 110, 30));
        getContentPane().add(txfNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 110, 30));
        getContentPane().add(txfConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 110, 30));

        btnActualizar.setBackground(new java.awt.Color(0, 204, 204));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 150, 30));

        txfLimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfLimiteActionPerformed(evt);
            }
        });
        getContentPane().add(txfLimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 130, 30));

        jPanel2.setLayout(new java.awt.GridLayout(1, 2, 250, 0));

        btnRetroceder.setBackground(new java.awt.Color(255, 255, 255));
        btnRetroceder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRetroceder.setForeground(new java.awt.Color(0, 0, 0));
        btnRetroceder.setText("Retroceder");
        btnRetroceder.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        jPanel2.add(btnRetroceder);

        btnCambiar.setBackground(new java.awt.Color(51, 255, 204));
        btnCambiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCambiar.setForeground(new java.awt.Color(0, 0, 0));
        btnCambiar.setText("Cambiar PIN");
        btnCambiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCambiar);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 530, 40));

        lblActual.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblActual.setForeground(new java.awt.Color(0, 0, 0));
        lblActual.setText("PIN actual:");
        getContentPane().add(lblActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 140, 30));

        lblNuevo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNuevo.setForeground(new java.awt.Color(0, 0, 0));
        lblNuevo.setText("Nuevo PIN:");
        getContentPane().add(lblNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 140, 30));

        lblConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblConfirmar.setForeground(new java.awt.Color(0, 0, 0));
        lblConfirmar.setText("Confirmar PIN:");
        getContentPane().add(lblConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo_admin.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        Opciones_usuario Opciones_usuario = new Opciones_usuario(this.Sesion);
        Opciones_usuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        //Obtener el array de txfActual y pasarlo a string
        char[] pinActual=txfActual.getPassword();
        String sPinActual= new String(pinActual);
        if(sPinActual.isEmpty() || sPinActual.trim().equals(this.Sesion.getPin())){
            JOptionPane.showMessageDialog(this, "El campo PIN actual no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            //Obtener el array de txfNuevo y pasarlo a string
            char[] pinNuevo=txfNuevo.getPassword();
            String sPinNuevo= new String(pinNuevo);
            //Obtener el array de txfConfirmar y pasarlo a string
            char[] pinConfirmar=txfConfirmar.getPassword();
            String sPinConfirmar= new String(pinConfirmar);
            try {
             if (sPinNuevo.equals(sPinConfirmar)) {
                Connection conexionCambiarPIN = Conexion.mySQL("proyecto_final", "root", "");
                Statement sentenciaCambiarPIN = conexionCambiarPIN.createStatement();
                String sqlCambiarPIN = "UPDATE tarjetas_de_credito SET PIN = '"+sPinConfirmar+"' WHERE ID_Tarjeta = '"+this.Sesion.getTarjetaCredito()+"';";
                int resultadoLimite = sentenciaCambiarPIN.executeUpdate(sqlCambiarPIN);
                if(resultadoLimite>0){
                    JOptionPane.showMessageDialog(this, "Se ha actualizado correctamente el PIN", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "El PIN no se ha actualizado", "Error", JOptionPane.ERROR_MESSAGE);
                }
             }else{
                 JOptionPane.showMessageDialog(this, "El campo confirmar PIN no coincide con nuevo PIN", "Error", JOptionPane.ERROR_MESSAGE);
             }
                 } catch (SQLException ex) {
                     Logger.getLogger(CambiarPIN.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }//GEN-LAST:event_btnCambiarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(!txfLimite.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(this, "No has establecido un limite valido", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                Connection conexionLimite = Conexion.mySQL("proyecto_final", "root", "");
                Statement sentenciaLimite= conexionLimite.createStatement();
                String sqlLimite = "UPDATE tarjetas_de_credito SET Limite_de_credito = '"+txfLimite.getText()+"' WHERE ID_Tarjeta = '"+this.Sesion.getTarjetaCredito()+"';";
                int resultadoLimite = sentenciaLimite.executeUpdate(sqlLimite);
                if(resultadoLimite>0){
                    JOptionPane.showMessageDialog(this, "Se ha actualizado correctamente el limite diario", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "No se ha actualizado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CambiarPIN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txfLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfLimiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfLimiteActionPerformed

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
            java.util.logging.Logger.getLogger(CambiarPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambiarPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambiarPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambiarPIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Opciones_usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblActual;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblInfoTarjeta;
    private javax.swing.JLabel lblLimite;
    private javax.swing.JLabel lblLimiteCredito;
    private javax.swing.JLabel lblNuevo;
    private javax.swing.JLabel lblVencimiento;
    private javax.swing.JPasswordField txfActual;
    private javax.swing.JPasswordField txfConfirmar;
    private javax.swing.JTextField txfLimite;
    private javax.swing.JPasswordField txfNuevo;
    // End of variables declaration//GEN-END:variables
    private String ID_Cliente;
    private String Nombre;
    private String TarjetaCredito;
    private int pin;
    private LocalDate fecha;
    private Sesion Sesion;
    private Idioma idioma;
}
