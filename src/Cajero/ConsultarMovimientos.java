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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Miguel
 */
public class ConsultarMovimientos extends javax.swing.JFrame {

    /**
     * Creates new form Opciones_admin
     */

    public ConsultarMovimientos (Sesion sesion_usuario) {
        initComponents();
        this.Sesion = sesion_usuario;
        this.idioma= sesion_usuario.getIdioma();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sesion_usuario.mantenerSesion();
            }
        });
        cargarIdioma(this.idioma);
        sesion_usuario.setFrameActual(this);
        jPanel2.setBackground(new Color(0, 0, 0, 0));
    }
        public void cargarIdioma(Idioma idioma){
            Properties propiedades = new Idioma(idioma.getNombre());
            this.setTitle(propiedades.getProperty("Consultar Movimientos"));
            btnRetroceder.setText(propiedades.getProperty("btnRetroceder"));
            btnVerRegistros.setText(propiedades.getProperty("btnVerRegistros"));
            lblInicio.setText(propiedades.getProperty("lblInicio"));
            lblFin.setText(propiedades.getProperty("lblFin"));
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblInicio = new javax.swing.JLabel();
        jdcInicio = new com.toedter.calendar.JDateChooser();
        jdcFin = new com.toedter.calendar.JDateChooser();
        lblFin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRetroceder = new javax.swing.JButton();
        btnVerRegistros = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cambiar PIN");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Tarjeta", "Fecha", "Hora", "Tipo", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(1).setPreferredWidth(85);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 360, 230));

        lblInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(0, 0, 0));
        lblInicio.setText("Fecha Inicio:");
        getContentPane().add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 150, -1));
        getContentPane().add(jdcInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 150, 30));
        getContentPane().add(jdcFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 150, 30));

        lblFin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFin.setForeground(new java.awt.Color(0, 0, 0));
        lblFin.setText("Fecha Fin:");
        getContentPane().add(lblFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 150, -1));

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

        btnVerRegistros.setBackground(new java.awt.Color(51, 255, 204));
        btnVerRegistros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerRegistros.setForeground(new java.awt.Color(0, 0, 0));
        btnVerRegistros.setText("Ver Registros");
        btnVerRegistros.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVerRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerRegistrosActionPerformed(evt);
            }
        });
        jPanel2.add(btnVerRegistros);

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

    private void btnVerRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerRegistrosActionPerformed
            if(jdcInicio.getDate()==null || jdcFin.getDate()==null){
                JOptionPane.showMessageDialog(this, "El rango de fechas no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                Date fechaInicio = jdcInicio.getDate();
                Date fechaFin = jdcFin.getDate();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                String sFechaInicio = formatoFecha.format(fechaInicio);
                String sFechaFin = formatoFecha.format(fechaFin);
        try {
            TableColumnModel modeloColumna = table.getColumnModel();
            modeloColumna.getColumn(1).setPreferredWidth(100);
            Connection conexionHistorial = Conexion.mySQL("proyecto_final", "root", "");
            Statement sentenciaHistorial= conexionHistorial.createStatement();
            String sqlHistorial = "SELECT ID_Tarjeta, Fecha, Hora, Tipo_movimiento, Monto FROM movimientos WHERE Fecha BETWEEN '"+sFechaInicio+"' AND '"+sFechaFin+"' AND ID_Tarjeta='"+this.Sesion.getTarjetaCredito()+"'";
            ResultSet resultadoHistorial = sentenciaHistorial.executeQuery(sqlHistorial);
            DefaultTableModel modeloTabla = (DefaultTableModel) table.getModel();
            modeloTabla.setRowCount(0);
            Object[] filas = new String[5];
            while(resultadoHistorial.next()) {
                    filas[0] = resultadoHistorial.getString("ID_Tarjeta");
                    filas[1] = resultadoHistorial.getString("Fecha");
                    filas[2] = resultadoHistorial.getString("Hora");
                    filas[3] = resultadoHistorial.getString("Tipo_movimiento");
                    filas[4] = resultadoHistorial.getString("Monto");
                    modeloTabla.addRow(filas);
                }         
            } catch (SQLException ex) {
                Logger.getLogger(HistorialCajero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnVerRegistrosActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                //new Opciones_usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JButton btnVerRegistros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFin;
    private com.toedter.calendar.JDateChooser jdcInicio;
    private javax.swing.JLabel lblFin;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
    private javax.swing.table.DefaultTableModel modeloTabla;
    private Sesion Sesion;
    private Idioma idioma;
}
