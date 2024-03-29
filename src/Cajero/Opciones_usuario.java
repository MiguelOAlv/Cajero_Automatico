/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Cajero;

import Conexion_bd.Conexion;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public class Opciones_usuario extends javax.swing.JFrame {

    /**
     * Creates new form Opciones_admin
     */

    public Opciones_usuario (Sesion sesion_usuario) {
        initComponents();
        this.Nombre = sesion_usuario.getNombre();
        this.idioma = sesion_usuario.getIdioma();
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
        initCombo();
        initJLabel();
    }
   public void cargarIdioma(Idioma idioma){
        Properties propiedades = new Idioma(idioma.getNombre());
        this.setTitle(propiedades.getProperty("Usuario"));
        lblSesion.setText(propiedades.getProperty("lblSesion"));
        lblFecha.setText(propiedades.getProperty("lblFecha"));
        lblHora1.setText(propiedades.getProperty("lblHora"));
        lblCuenta.setText(propiedades.getProperty("lblCuenta"));
        btnDesconectar.setText(propiedades.getProperty("btnDesconectar"));
        btnRetirar.setText(propiedades.getProperty("btnRetirar"));
        btnDepositar.setText(propiedades.getProperty("btnDepositar"));
        btnTransferencia.setText(propiedades.getProperty("btnTransferencia"));
        btnFactura.setText(propiedades.getProperty("btnFactura"));
        btnPIN.setText(propiedades.getProperty("btnPIN"));
        btnMovimientos.setText(propiedades.getProperty("btnMovimientos"));
        lblInfoCajero.setText(propiedades.getProperty("lblInfoCajero"));
        lblID.setText(propiedades.getProperty("lblID"));
        lblUbicacion.setText(propiedades.getProperty("lblUbicacion"));
        lblInfoCuenta.setText(propiedades.getProperty("lblInfoCuenta"));
        lblNumeroCuenta.setText(propiedades.getProperty("lblNumeroCuenta"));
        lblSaldoCuenta.setText(propiedades.getProperty("lblSaldoCuenta"));
        lblTipoCuenta.setText(propiedades.getProperty("lblTipoCuenta"));
    }
    private void initCombo(){
        try {
                Connection conexionCombo = Conexion.mySQL("proyecto_final", "root", "");
                Statement sentenciaCombo = conexionCombo.createStatement();
                String sqlCombo = "SELECT ID_Cuenta FROM cuentas WHERE ID_Cliente = '"+this.Sesion.getID_Cliente()+"'";
                ResultSet resultado = sentenciaCombo.executeQuery(sqlCombo);
                while(resultado.next()){
                    cmbCuentas.addItem(resultado.getString("ID_Cuenta"));
                }
                 } catch (SQLException ex) {
            Logger.getLogger(Opciones_usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initJLabel(){
        String nombre_sesion = this.Nombre;
        lblSesion.setText(lblSesion.getText()+nombre_sesion);
        LocalDate hoy = LocalDate.now();
        lblFecha.setText(lblFecha.getText()+hoy);
        Timer timer = new Timer(1000,new ActionListener(){
            public void actionPerformed(ActionEvent e){
                LocalTime hora = LocalTime.now();
                DateTimeFormatter formatoHora=DateTimeFormatter.ofPattern("HH:mm:ss");
                lblHora.setText(formatoHora.format(hora));
            }
        });
        timer.start();
        lblHora.setText(Sesion.getTimer()+"");
        try{
            Connection conexion = Conexion.mySQL("proyecto_final", "root", "");
            Statement sentencia_label = conexion.createStatement();
            String sql = "SELECT * FROM cajeros_automaticos WHERE ID_Cajero = 1";
            ResultSet resultado = sentencia_label.executeQuery(sql);
            int contador=0;
                if(resultado.next()){
                    contador = resultado.getInt(1);
                            }
                    if(contador>0){
                        int id = resultado.getInt("ID_Cajero");
                        String ubicacion = resultado.getString("Ubicacion");
                               lblID.setText(lblID.getText()+" "+String.valueOf(id));
                               lblUbicacion.setText(lblUbicacion.getText()+" "+ubicacion);
                            }else{
                                JOptionPane.showMessageDialog(this, "Error, no se encuentran cajeros en la base de datos","Error", JOptionPane.ERROR_MESSAGE);
                            }
                    }catch(SQLException ex) {
                        System.out.println(ex.getMessage());
                        JOptionPane.showMessageDialog(this, "Error en la consulta","Error", JOptionPane.ERROR_MESSAGE);
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

        btnDesconectar = new javax.swing.JButton();
        lblSesion = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblInfoCuenta = new javax.swing.JLabel();
        lblNumeroCuenta = new javax.swing.JLabel();
        lblSaldoCuenta = new javax.swing.JLabel();
        lblTipoCuenta = new javax.swing.JLabel();
        lblCuenta = new javax.swing.JLabel();
        cmbCuentas = new javax.swing.JComboBox<>();
        btnRetirar = new javax.swing.JButton();
        btnDepositar = new javax.swing.JButton();
        btnFactura = new javax.swing.JButton();
        btnPIN = new javax.swing.JButton();
        btnMovimientos = new javax.swing.JButton();
        btnTransferencia = new javax.swing.JButton();
        lblHora = new javax.swing.JLabel();
        lblHora1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblInfoCajero = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblUbicacion = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuario");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDesconectar.setBackground(new java.awt.Color(51, 51, 255));
        btnDesconectar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDesconectar.setForeground(new java.awt.Color(255, 255, 255));
        btnDesconectar.setText("Desconectar");
        btnDesconectar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDesconectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 140, 40));

        lblSesion.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblSesion.setForeground(new java.awt.Color(0, 0, 0));
        lblSesion.setText("Sesión:");
        getContentPane().add(lblSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 160, 30));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        lblInfoCuenta.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblInfoCuenta.setForeground(new java.awt.Color(0, 0, 0));
        lblInfoCuenta.setText("INFORMACIÓN DE LA CUENTA");
        jPanel2.add(lblInfoCuenta);

        lblNumeroCuenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNumeroCuenta.setForeground(new java.awt.Color(0, 0, 0));
        lblNumeroCuenta.setText("Numero de cuenta:");
        jPanel2.add(lblNumeroCuenta);

        lblSaldoCuenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSaldoCuenta.setForeground(new java.awt.Color(0, 0, 0));
        lblSaldoCuenta.setText("Saldo actual:");
        jPanel2.add(lblSaldoCuenta);

        lblTipoCuenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTipoCuenta.setForeground(new java.awt.Color(0, 0, 0));
        lblTipoCuenta.setText("Tipo de cuenta:");
        jPanel2.add(lblTipoCuenta);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 260, 80));

        lblCuenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCuenta.setForeground(new java.awt.Color(0, 0, 0));
        lblCuenta.setText("Selecciona la cuenta:");
        getContentPane().add(lblCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 180, 17));

        cmbCuentas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCuentasItemStateChanged(evt);
            }
        });
        cmbCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCuentasActionPerformed(evt);
            }
        });
        getContentPane().add(cmbCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 160, 20));

        btnRetirar.setBackground(new java.awt.Color(0, 204, 204));
        btnRetirar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRetirar.setForeground(new java.awt.Color(0, 0, 0));
        btnRetirar.setText("Retirar efectivo");
        btnRetirar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 190, -1));

        btnDepositar.setBackground(new java.awt.Color(0, 204, 204));
        btnDepositar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDepositar.setForeground(new java.awt.Color(0, 0, 0));
        btnDepositar.setText("Depositar dinero");
        btnDepositar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDepositar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 190, -1));

        btnFactura.setBackground(new java.awt.Color(0, 204, 204));
        btnFactura.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFactura.setForeground(new java.awt.Color(0, 0, 0));
        btnFactura.setText("Pagar factura");
        btnFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });
        getContentPane().add(btnFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 190, -1));

        btnPIN.setBackground(new java.awt.Color(0, 204, 204));
        btnPIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPIN.setForeground(new java.awt.Color(0, 0, 0));
        btnPIN.setText("Cambiar PIN tarjeta");
        btnPIN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPINActionPerformed(evt);
            }
        });
        getContentPane().add(btnPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 190, -1));

        btnMovimientos.setBackground(new java.awt.Color(0, 204, 204));
        btnMovimientos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMovimientos.setForeground(new java.awt.Color(0, 0, 0));
        btnMovimientos.setText("Consultar movimientos");
        btnMovimientos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });
        getContentPane().add(btnMovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 190, -1));

        btnTransferencia.setBackground(new java.awt.Color(0, 204, 204));
        btnTransferencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTransferencia.setForeground(new java.awt.Color(0, 0, 0));
        btnTransferencia.setText("Realizar transferencia");
        btnTransferencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciaActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 190, -1));

        lblHora.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 70, 30));

        lblHora1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblHora1.setForeground(new java.awt.Color(0, 0, 0));
        lblHora1.setText("Hora:");
        getContentPane().add(lblHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 60, 30));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(3, 1, 0, 5));

        lblInfoCajero.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblInfoCajero.setForeground(new java.awt.Color(0, 0, 0));
        lblInfoCajero.setText("INFORMACIÓN DEL CAJERO");
        jPanel1.add(lblInfoCajero);

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(0, 0, 0));
        lblID.setText("ID Cajero:");
        jPanel1.add(lblID);

        lblUbicacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUbicacion.setForeground(new java.awt.Color(0, 0, 0));
        lblUbicacion.setText("Ubicación:");
        jPanel1.add(lblUbicacion);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 260, 70));

        lblFecha.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 0));
        lblFecha.setText("Fecha:");
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo_admin.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        Inicio Inicio = new Inicio();
        Inicio.setVisible(true);
        this.Sesion.getTimer().stop();
        this.dispose();
    }//GEN-LAST:event_btnDesconectarActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        RetirarEfectivo RetirarEfectivo = new RetirarEfectivo(this.Sesion,cuenta);
        RetirarEfectivo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRetirarActionPerformed

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
        DepositarEfectivo DepositarEfectivo = new DepositarEfectivo(this.Sesion,cuenta);
        DepositarEfectivo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDepositarActionPerformed

    private void btnPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPINActionPerformed
         CambiarPIN CambiarPIN = new CambiarPIN(this.Sesion);
         CambiarPIN.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnPINActionPerformed

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
         ConsultarMovimientos ConsultarMovimientos = new ConsultarMovimientos(this.Sesion);
         ConsultarMovimientos.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnMovimientosActionPerformed

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
         PagarFactura PagarFactura = new PagarFactura(this.Sesion,cuenta);
         PagarFactura.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnFacturaActionPerformed

    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        if(cmbCuentas.getSelectedItem()==null){
             JOptionPane.showMessageDialog(this, "Error, debe seleccionar una cuenta para poder continuar","Error", JOptionPane.ERROR_MESSAGE);
        }else{
        RealizarTransferencia RealizarTransferencia = new RealizarTransferencia(this.Sesion, cuenta);
        RealizarTransferencia.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_btnTransferenciaActionPerformed

    private void cmbCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCuentasActionPerformed
            //SELECCIONAR UN ITEM DEL COMBOBOX Y PASARLO A NUMERO ENTERO
            String sCuentaSeleccionada = (String) cmbCuentas.getSelectedItem();
            int CuentaSeleccionada = Integer.parseInt(sCuentaSeleccionada);
            this.cuenta= CuentaSeleccionada;
    }//GEN-LAST:event_cmbCuentasActionPerformed

    private void cmbCuentasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCuentasItemStateChanged
            //LIMPIAR LOS VALORES EN LOS LABEL
            lblNumeroCuenta.setText("Número de cuenta:");
            lblSaldoCuenta.setText("Saldo de la cuenta:");
            lblTipoCuenta.setText("Tipo de cuenta:");
            //SELECCIONAR UN ITEM DEL COMBOBOX Y PASARLO A NUMERO ENTERO
            String sCuentaSeleccionada = (String) cmbCuentas.getSelectedItem();
            int CuentaSeleccionada = Integer.parseInt(sCuentaSeleccionada);
            this.cuenta= CuentaSeleccionada;
            //CARGAR LABELS DE INFORMACIÓN DE CUENTA
            try {
            Connection conexion = Conexion.mySQL("proyecto_final", "root", "");
            Statement sentencia_label = conexion.createStatement();
            String sql = "SELECT ID_Cuenta, Saldo, Tipo_cuenta FROM cuentas WHERE ID_Cuenta = '"+CuentaSeleccionada+"'";
            ResultSet resultado = sentencia_label.executeQuery(sql);
            if(resultado.next()){
                lblNumeroCuenta.setText(lblNumeroCuenta.getText()+" "+resultado.getString("ID_Cuenta"));
                lblSaldoCuenta.setText(lblSaldoCuenta.getText()+" "+resultado.getString("Saldo"));
                lblTipoCuenta.setText(lblTipoCuenta.getText()+" "+resultado.getString("Tipo_cuenta"));
            }else{
                JOptionPane.showMessageDialog(this, "Error, debe seleccionar una cuenta para poder continuar","Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones_usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbCuentasItemStateChanged

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
            java.util.logging.Logger.getLogger(Opciones_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Opciones_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Opciones_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Opciones_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnPIN;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JComboBox<String> cmbCuentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblHora1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblInfoCajero;
    private javax.swing.JLabel lblInfoCuenta;
    private javax.swing.JLabel lblNumeroCuenta;
    private javax.swing.JLabel lblSaldoCuenta;
    private javax.swing.JLabel lblSesion;
    private javax.swing.JLabel lblTipoCuenta;
    private javax.swing.JLabel lblUbicacion;
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
