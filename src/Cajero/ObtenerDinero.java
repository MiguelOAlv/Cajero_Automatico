/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Cajero;

import static Cajero.Metodos.entregarDinero;
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
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;


/**
 *
 * @author Miguel
 */
public class ObtenerDinero extends javax.swing.JFrame {

    /**
     * Creates new form Opciones_admin
     */

    public ObtenerDinero (Sesion sesion_usuario, int cantidad) {
        initComponents();
        this.cantidad=cantidad;
        initBilletes();
        this.Nombre = sesion_usuario.getNombre();
        this.pin = sesion_usuario.getPin();
        this.cuenta = cuenta;
        this.idioma=sesion_usuario.getIdioma();
        cargarIdioma(this.idioma);
        this.Sesion = sesion_usuario;
        this.Sesion.iniciarSesion();
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                sesion_usuario.mantenerSesion();
            }
        });
        this.fecha = LocalDate.now();
        sesion_usuario.setFrameActual(this);
    }
   public void cargarIdioma(Idioma idioma){
        Properties propiedades = new Idioma(idioma.getNombre());
        this.setTitle(propiedades.getProperty("ObtenerDinero"));
        btnRetroceder.setText(propiedades.getProperty("btnRetroceder"));
    }
    public void initBilletes(){
        int contador=0;
        int[]tiposBilletes= new int[]{50,20,10,5};
        int[]billetesDevueltos =entregarDinero(cantidad);
        for (int i = 0; i < billetesDevueltos.length; i++) {
            int tipoBillete = tiposBilletes[i];
            int cantidad = billetesDevueltos[i];
            for (int j = 0; j < cantidad; j++) {
                contador++;
                switch(tipoBillete){
                    case 50:
                            System.out.println(cantidad +" "+ Arrays.toString(billetesDevueltos));
                            JButton boton50 = new javax.swing.JButton();
                            boton50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/billete50.jpg"))); // NOI18N
                            boton50.setBackground(new java.awt.Color(0, 0, 0));
                            boton50.setForeground(new java.awt.Color(255, 255, 255));
                            boton50.setContentAreaFilled(false);
                            boton50.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                boton50.setVisible(false);
                                }
                            });
                            getContentPane().add(boton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 70, 90));
                            jPanel1.setBackground(new Color(0, 0, 0, 0));
                            jPanel1.add(boton50);
                        break;
                    case 20:
                            System.out.println(cantidad +" "+ Arrays.toString(billetesDevueltos));
                            JButton boton20 = new javax.swing.JButton();
                            boton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/billete20.jpg"))); // NOI18N
                            boton20.setBackground(new java.awt.Color(0, 0, 0));
                            boton20.setForeground(new java.awt.Color(255, 255, 255));
                            boton20.setContentAreaFilled(false);
                            boton20.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                boton20.setVisible(false);
                                }
                            });
                            getContentPane().add(boton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 70, 90));
                            jPanel1.setBackground(new Color(0, 0, 0, 0));
                            jPanel1.add(boton20);
                        break;
                    case 10:
                            System.out.println(cantidad +" "+ Arrays.toString(billetesDevueltos));
                            JButton boton10 = new javax.swing.JButton();
                            boton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/billete10.jpg"))); // NOI18N
                            boton10.setBackground(new java.awt.Color(0, 0, 0));
                            boton10.setForeground(new java.awt.Color(255, 255, 255));
                            boton10.setContentAreaFilled(false);
                            boton10.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                boton10.setVisible(false);
                                }
                            });
                            getContentPane().add(boton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 70, 90));
                            jPanel1.setBackground(new Color(0, 0, 0, 0));
                            jPanel1.add(boton10);
                        break;
                    case 5:
                            System.out.println(cantidad +" "+ Arrays.toString(billetesDevueltos));
                            JButton boton5 = new javax.swing.JButton();
                            boton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/billete5.jpg"))); // NOI18N
                            boton5.setBackground(new java.awt.Color(0, 0, 0));
                            boton5.setForeground(new java.awt.Color(255, 255, 255));
                            boton5.setContentAreaFilled(false);
                            boton5.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                boton5.setVisible(false);
                                }
                            });
                            getContentPane().add(boton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 70, 90));
                            jPanel1.setBackground(new Color(0, 0, 0, 0));
                            jPanel1.add(boton5);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Error en la retirada de billetes", "Error",JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
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

        lblIntroduce = new javax.swing.JLabel();
        btnRetroceder = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recoger Billetes");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIntroduce.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblIntroduce.setForeground(new java.awt.Color(0, 255, 255));
        lblIntroduce.setText("Recoja sus billetes");
        getContentPane().add(lblIntroduce, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 170, 30));

        btnRetroceder.setBackground(new java.awt.Color(0, 0, 0));
        btnRetroceder.setForeground(new java.awt.Color(255, 255, 255));
        btnRetroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha.png"))); // NOI18N
        btnRetroceder.setContentAreaFilled(false);
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        getContentPane().add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 60, 40));

        jPanel1.setLayout(new java.awt.GridLayout(1, 50));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 80, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo_cajero.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        Opciones_usuario Opciones_usuario = new Opciones_usuario(this.Sesion);
        Opciones_usuario.setVisible(true);
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
            java.util.logging.Logger.getLogger(ObtenerDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ObtenerDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ObtenerDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ObtenerDinero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblIntroduce;
    // End of variables declaration//GEN-END:variables
    private String ID_Cliente;
    private String Nombre;
    private String TarjetaCredito;
    private int pin;
    private LocalDate fecha;
    private Sesion Sesion;
    private Idioma idioma;
    private int cuenta;
    private int cantidad;
}
