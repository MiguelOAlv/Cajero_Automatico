/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Cajero;

import static Cajero.Metodos.formatearFecha;
import Conexion_bd.Conexion;
import java.awt.Color;
import java.awt.Toolkit;
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


/**
 *
 * @author Miguel
 */
public class DepositarEfectivo extends javax.swing.JFrame {

    /**
     * Creates new form Opciones_admin
     */

    public DepositarEfectivo (Sesion sesion_usuario,int cuenta) {
        initComponents();
        this.Nombre = sesion_usuario.getNombre();
        this.pin = sesion_usuario.getPin();
        this.ID_Cliente=sesion_usuario.getID_Cliente();
        this.cuenta = cuenta;
        this.idioma=sesion_usuario.getIdioma();
        cargarIdioma(this.idioma);
        this.Sesion = sesion_usuario;
        this.Sesion.iniciarSesion();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sesion_usuario.mantenerSesion();
            }
        });
        this.fecha = LocalDate.now();
        sesion_usuario.setFrameActual(this);
        jPanel2.setBackground(new Color(0, 0, 0, 0));
    }
   public void cargarIdioma(Idioma idioma){
        Properties propiedades = new Idioma(idioma.getNombre());
        this.setTitle(propiedades.getProperty("DepositarDinero"));
        btnDepositar.setText(propiedades.getProperty("btnDepositar"));
        btnRetroceder.setText(propiedades.getProperty("btnRetroceder"));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSeleccion2 = new javax.swing.JLabel();
        txfCantidad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnRetroceder = new javax.swing.JButton();
        btnDepositar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuario");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSeleccion2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSeleccion2.setForeground(new java.awt.Color(0, 0, 0));
        lblSeleccion2.setText("Seleccione la cantidad que desea depositar:");
        getContentPane().add(lblSeleccion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 440, 30));
        getContentPane().add(txfCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 240, 40));

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

        btnDepositar.setBackground(new java.awt.Color(51, 255, 51));
        btnDepositar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDepositar.setForeground(new java.awt.Color(0, 0, 0));
        btnDepositar.setText("Depositar");
        btnDepositar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });
        jPanel2.add(btnDepositar);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 540, 40));

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

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
        if(txfCantidad.getText().equals("") || Integer.parseInt(txfCantidad.getText())%5!=0 ){
            JOptionPane.showMessageDialog(this, "Debe introducir una cantidad multiplo de 5 para poder depositar", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
            int deposito = Integer.parseInt(txfCantidad.getText());    
            
            Connection conexionDeposito = Conexion.mySQL("proyecto_final", "root", "");
            Statement sentenciaDeposito = conexionDeposito.createStatement();
            String sqlDeposito = "UPDATE cuentas SET Saldo = Saldo + "+deposito+" WHERE ID_Cliente = "+this.ID_Cliente+" AND ID_Cuenta="+this.cuenta+";";
            int resultadoDeposito = sentenciaDeposito.executeUpdate(sqlDeposito);
            if(resultadoDeposito>0){
                    JOptionPane.showMessageDialog(this, "El deposito se ha realizado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }else{
                 JOptionPane.showMessageDialog(this, "No se ha podido realizar el deposito, consulte con la sucursal", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RetirarEfectivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDepositarActionPerformed

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
            java.util.logging.Logger.getLogger(DepositarEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepositarEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepositarEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepositarEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblSeleccion2;
    private javax.swing.JTextField txfCantidad;
    // End of variables declaration//GEN-END:variables
    private String ID_Cliente;
    private String Nombre;
    private String TarjetaCredito;
    private int pin;
    private LocalDate fecha;
    private Sesion Sesion;
    private Idioma idioma;
    private int cuenta;
}
