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
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public class ArqueoCajero extends javax.swing.JFrame {

    /**
     * Creates new form Introducir_Tarjeta
     */
    public ArqueoCajero(Sesion sesion_admin){
        this.sesion= sesion_admin;
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        lblCajero = new javax.swing.JLabel();
        lblDeposito = new javax.swing.JLabel();
        lblRetirada = new javax.swing.JLabel();
        lblEfectivo = new javax.swing.JLabel();
        lblLimite = new javax.swing.JLabel();
        jdcInicio = new com.toedter.calendar.JDateChooser();
        jdcFin = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        txfLimite = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnRetroceder = new javax.swing.JButton();
        btnArqueo = new javax.swing.JButton();
        btnCuadre = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arqueo Cajero");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        lblCajero.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblCajero.setForeground(new java.awt.Color(0, 0, 0));
        lblCajero.setText("INFORMACIÓN DEL CAJERO");
        jPanel1.add(lblCajero);

        lblDeposito.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDeposito.setForeground(new java.awt.Color(0, 0, 0));
        lblDeposito.setText("Deposito:");
        jPanel1.add(lblDeposito);

        lblRetirada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRetirada.setForeground(new java.awt.Color(0, 0, 0));
        lblRetirada.setText("Retirada:");
        jPanel1.add(lblRetirada);

        lblEfectivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEfectivo.setForeground(new java.awt.Color(0, 0, 0));
        lblEfectivo.setText("Cantidad de efectivo total:");
        jPanel1.add(lblEfectivo);

        lblLimite.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLimite.setForeground(new java.awt.Color(0, 0, 0));
        lblLimite.setText("Limite diario:");
        jPanel1.add(lblLimite);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 530, 140));

        jdcInicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcInicioPropertyChange(evt);
            }
        });
        getContentPane().add(jdcInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 150, 30));
        getContentPane().add(jdcFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 150, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Fecha Fin:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 150, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha Inicio:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 150, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Establecer limite diario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 210, -1));

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
        getContentPane().add(txfLimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 130, 30));

        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 55, 0));

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

        btnArqueo.setBackground(new java.awt.Color(0, 153, 153));
        btnArqueo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnArqueo.setForeground(new java.awt.Color(0, 0, 0));
        btnArqueo.setText("Realizar Arqueo");
        btnArqueo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnArqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArqueoActionPerformed(evt);
            }
        });
        jPanel2.add(btnArqueo);

        btnCuadre.setBackground(new java.awt.Color(51, 255, 204));
        btnCuadre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCuadre.setForeground(new java.awt.Color(0, 0, 0));
        btnCuadre.setText("Cuadre Caja");
        btnCuadre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCuadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuadreActionPerformed(evt);
            }
        });
        jPanel2.add(btnCuadre);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 530, 40));

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

    private void btnArqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArqueoActionPerformed
        if(jdcInicio.getDate()==null && jdcFin.getDate()==null){
            JOptionPane.showMessageDialog(this,"No has seleccionado un intervalo de fechas", "Error",JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                Date fechaInicio = jdcInicio.getDate();
                Date fechaFin = jdcFin.getDate();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                String sFechaInicio = formatoFecha.format(fechaInicio);
                String sFechaFin = formatoFecha.format(fechaFin);
                Date dhoy = new Date();
                //COMPROBAR QUE LA FECHA NO SEA ANTERIOR A LA FECHA INICIO O POSTERIOR A LA FECHA ACTUAL
                if(fechaFin.before(fechaInicio) || fechaFin.after(dhoy)){
                   JOptionPane.showMessageDialog(this, "La fecha fin es anterior a la fecha inicio o posterior a la fecha actual", "Error", JOptionPane.ERROR_MESSAGE);
                   return;
                }
                DateTimeFormatter ldformatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate hoy = LocalDate.now();
                String sHoy = hoy.format(ldformatoFecha);
                LocalTime horaActual = LocalTime.now();
                Time horaSql = Time.valueOf(horaActual);
                
                //CALCULAR LA CANTIDAD DE DEPOSITO QUE HAY SIN CONTAR EL CUADRE DE CAJA HECHO POR EL ADMINISTRADOR (WHERE ID_Tarjeta is not null)
                Connection conexionDeposito = Conexion.mySQL("proyecto_final", "root", "");
                Statement sentenciaDeposito= conexionDeposito.createStatement();
                String sqlDeposito = "SELECT monto FROM transacciones_cajeros WHERE Fecha BETWEEN '"+sFechaInicio+"' AND '"+sFechaFin+"' AND Tipo_transaccion = 'Deposito' AND ID_Tarjeta is not null";
                ResultSet resultadoDeposito = sentenciaDeposito.executeQuery(sqlDeposito); 
                int cantidadDeposito=0;
                int cantidadTotalDeposito=0;
                 while(resultadoDeposito.next()){
                    cantidadDeposito=(resultadoDeposito.getInt("monto"));
                    cantidadTotalDeposito = cantidadTotalDeposito+cantidadDeposito;
                    lblDeposito.setText("Deposito: "+cantidadTotalDeposito);
                }
                 //CALCULAR LA CANTIDAD DE RETIRADA QUE HAY SIN CONTAR EL CUADRE DE CAJA HECHO POR EL ADMINISTRADOR (WHERE ID_Tarjeta is not null)
                Connection conexionRetirada = Conexion.mySQL("proyecto_final", "root", "");
                Statement sentenciaRetirada= conexionRetirada.createStatement();
                String sqlRetirada = "SELECT monto FROM transacciones_cajeros WHERE Fecha BETWEEN '"+sFechaInicio+"' AND '"+sFechaFin+"' AND Tipo_transaccion = 'Retirada' AND ID_Tarjeta is not null";
                ResultSet resultadoRetirada = sentenciaRetirada.executeQuery(sqlRetirada);
                int cantidadRetirada=0;
                int cantidadTotalRetirada=0;
                while(resultadoRetirada.next()){
                    cantidadRetirada=(resultadoRetirada.getInt("monto"));
                    cantidadTotalRetirada = cantidadTotalRetirada+cantidadRetirada;
                    lblRetirada.setText("Retirada: "+cantidadTotalRetirada);
                }
                
                String efectivoTexto = lblEfectivo.getText().trim();
                int cantidadEfectivo=0 ,efpos = efectivoTexto.indexOf(":");
                if (efpos != -1) {
                    try {
                    String sEfectivo = efectivoTexto.substring(efpos + 1).trim();
                    cantidadEfectivo = Integer.parseInt(sEfectivo);
                    } catch (NumberFormatException e) {
                }
                }
                int nuevaCantidad = cantidadEfectivo + cantidadTotalDeposito + cantidadTotalRetirada;
                
                //COMPROBAR QUE NO HAYA UNA DIFERENCIA EN EL ULTIMO ARQUEO
                Connection conexionDiferencia = Conexion.mySQL("proyecto_final", "root", "");
                Statement sentenciaDiferencia= conexionDiferencia.createStatement();
                String sqlDiferencia = "SELECT diferencia FROM arqueos ORDER BY ID_Arqueo DESC LIMIT 1";
                ResultSet resultadoDiferencia = sentenciaDiferencia.executeQuery(sqlDiferencia);
                if(resultadoDiferencia.next()){
                    int diferencia = resultadoDiferencia.getInt("diferencia");
                    if(diferencia>0 || diferencia <0){
                        JOptionPane.showMessageDialog(this, "La diferencia del ultimo arqueo debe de ser 0, cuadre la caja antes de realizar el arqueo", "Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                //INTRODUCIR LOS DATOS DEL ARQUEO EN LA BASE DE DATOS
                Connection conexionArqueo = Conexion.mySQL("proyecto_final", "root", "");
                Statement sentenciaArqueo= conexionArqueo.createStatement();
                String sqlArqueo = "INSERT INTO arqueos (ID_Cajero, ID_Administrador, Fecha_Inicio, Fecha_Fin, Fecha_arqueo_realizado, Hora, total_esperado, total_contado) VALUES(1,"+sesion.getID_Administrador()+",'"+sFechaInicio+"','"+sFechaFin+"','"+sHoy+"','"+horaSql+"','"+nuevaCantidad+"','"+cantidadEfectivo+"');";
                int resultadoArqueo = sentenciaArqueo.executeUpdate(sqlArqueo);
                if(resultadoArqueo>0){
                    JOptionPane.showMessageDialog(this,"Se ha realizado correctamente el arqueo", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "El arqueo no se ha podido realizar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ArqueoCajero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnArqueoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(jdcInicio.getDate()==null || jdcFin.getDate()==null){
        try {
            Connection conexionLimite = Conexion.mySQL("proyecto_final", "root", "");
            Statement sentenciaLimite= conexionLimite.createStatement();
            String sqlLimite = "UPDATE cajeros_automaticos SET limite_diario = '"+txfLimite.getText()+"';";
            int resultadoLimite = sentenciaLimite.executeUpdate(sqlLimite);
            if(resultadoLimite>0){
                JOptionPane.showMessageDialog(this, "Se ha actualizado correctamente el limite diario", "Exito", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "No se ha actualizado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            }
            } catch (SQLException ex) {
            Logger.getLogger(ArqueoCajero.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            try{
            Date fechaInicio = jdcInicio.getDate();
            Date fechaFin = jdcFin.getDate();
            Date hoy = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String sFechaInicio = formatoFecha.format(fechaInicio);
            String sFechaFin = formatoFecha.format(fechaFin);
            //COMPROBAR QUE LA FECHA FIN NO SEA ANTERIOR A LA FECHA INICIO O POSTERIOR A LA FECHA ACTUAL
            if(fechaFin.before(fechaInicio) || fechaFin.after(hoy)){
                   JOptionPane.showMessageDialog(this, "La fecha fin es anterior a la fecha inicio o posterior a la fecha actual", "Error", JOptionPane.ERROR_MESSAGE);
                   return;
            }else{
                lblCajero.setText("INFORMACIÓN DEL CAJERO ENTRE "+sFechaInicio+ " Y "+sFechaFin);
                
                //CONSEGUIR DEPOSITOS ENTRE DOS FECHAS
                Connection conexionDeposito = Conexion.mySQL("proyecto_final", "root", "");
                Statement sentenciaDeposito= conexionDeposito.createStatement();
                String sqlDeposito = "SELECT monto FROM transacciones_cajeros WHERE Fecha BETWEEN '"+sFechaInicio+"' AND '"+sFechaFin+"' AND Tipo_transaccion = 'Deposito' AND ID_Tarjeta is not null";
                ResultSet resultadoDeposito = sentenciaDeposito.executeQuery(sqlDeposito); 
                int cantidadDeposito=0;
                int cantidadTotalDeposito=0;
                while(resultadoDeposito.next()){
                    cantidadDeposito=(resultadoDeposito.getInt("monto"));
                    cantidadTotalDeposito = cantidadTotalDeposito+cantidadDeposito;
                    lblDeposito.setText("Deposito: "+cantidadTotalDeposito);
                }
                    //CONSEGUIR RETIRADAS ENTRE DOS FECHAS
                    Connection conexionRetirada = Conexion.mySQL("proyecto_final", "root", "");
                    Statement sentenciaRetirada= conexionRetirada.createStatement();
                    String sqlRetirada = "SELECT monto FROM transacciones_cajeros WHERE Fecha BETWEEN '"+sFechaInicio+"' AND '"+sFechaFin+"' AND Tipo_transaccion = 'Retirada' AND ID_Tarjeta is not null";
                    ResultSet resultadoRetirada = sentenciaRetirada.executeQuery(sqlRetirada);
                    int cantidadRetirada=0;
                    int cantidadTotalRetirada=0;
                    while(resultadoRetirada.next()){
                    cantidadRetirada=(resultadoRetirada.getInt("monto"));
                    cantidadTotalRetirada = cantidadTotalRetirada+cantidadRetirada;
                    lblRetirada.setText("Retirada: "+cantidadTotalRetirada);
                }
                        //CANTIDAD TOTAL DEL ATM - RETIRADA + DEPOSITO
                        Connection conexionCantidad = Conexion.mySQL("proyecto_final", "root", "");
                        Statement sentenciaCantidad= conexionCantidad.createStatement();
                        String sqlCantidad = "SELECT Cantidad_de_efectivo_actual, limite_diario FROM cajeros_automaticos WHERE ID_Cajero = 1";
                        ResultSet resultadoCantidad = sentenciaCantidad.executeQuery(sqlCantidad);
                        if(resultadoCantidad.next()){
                            lblEfectivo.setText("Cantidad de efectivo total: "+resultadoCantidad.getInt("Cantidad_de_efectivo_actual"));
                            lblLimite.setText("Limite diario: "+resultadoCantidad.getInt("limite_diario")+"");
                        }else{
                            JOptionPane.showMessageDialog(this, "La cantidad es erronea", "Error", JOptionPane.ERROR_MESSAGE);
                            }
         
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ArqueoCajero.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txfLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfLimiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfLimiteActionPerformed

    private void btnCuadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuadreActionPerformed
           CuadreCaja CuadreCaja = new CuadreCaja(this.sesion);
           CuadreCaja.setVisible(true);
           this.dispose();
    }//GEN-LAST:event_btnCuadreActionPerformed

    private void jdcInicioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcInicioPropertyChange
        try {
            //SI HAY UN ARQUEO EN LA BASE DE DATOS, RECOGE LA FECHA FIN Y LA COLOCA EN LA FECHA INICIO
            Connection conexionFecha = Conexion.mySQL("proyecto_final", "root", "");
            Statement sentenciaFecha= conexionFecha.createStatement();
            String sqlFecha = "SELECT Fecha_Fin FROM arqueos ORDER BY ID_Arqueo DESC LIMIT 1";
            ResultSet resultadoFecha = sentenciaFecha.executeQuery(sqlFecha);
            if(resultadoFecha.next()){
                jdcInicio.setDate(resultadoFecha.getDate("Fecha_Fin"));
                jdcInicio.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArqueoCajero.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_jdcInicioPropertyChange
    
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
            java.util.logging.Logger.getLogger(ArqueoCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArqueoCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArqueoCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArqueoCajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnArqueo;
    private javax.swing.JButton btnCuadre;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser jdcFin;
    private com.toedter.calendar.JDateChooser jdcInicio;
    private javax.swing.JLabel lblCajero;
    private javax.swing.JLabel lblDeposito;
    private javax.swing.JLabel lblEfectivo;
    private javax.swing.JLabel lblLimite;
    private javax.swing.JLabel lblRetirada;
    private javax.swing.JTextField txfLimite;
    // End of variables declaration//GEN-END:variables
    private Sesion sesion;
}
