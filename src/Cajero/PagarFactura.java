/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Cajero;

import static Cajero.Metodos.formatearFecha;
import Conexion_bd.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class PagarFactura extends javax.swing.JFrame {

    /**
     * Creates new form Opciones_admin
     */

    public PagarFactura (Sesion sesion_usuario,int cuenta) {
        initComponents();
        this.Nombre = sesion_usuario.getNombre();
        this.pin = sesion_usuario.getPin();
        this.cuenta = cuenta;
        this.ID_Cliente=sesion_usuario.getID_Cliente();
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
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        jPanel2.setBackground(new Color(0, 0, 0, 0));
    }
   public void cargarIdioma(Idioma idioma){
        Properties propiedades = new Idioma(idioma.getNombre());
        this.setTitle(propiedades.getProperty("RealizarTransferencia"));
        btnFactura.setText(propiedades.getProperty("btnFactura"));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txfImporte = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txfConcepto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnRetroceder = new javax.swing.JButton();
        btnFactura = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuario");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("IMPORTE:");
        jPanel1.add(jLabel2);
        jPanel1.add(txfImporte);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CONCEPTO:");
        jPanel1.add(jLabel4);
        jPanel1.add(txfConcepto);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 550, 130));

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

        btnFactura.setBackground(new java.awt.Color(51, 255, 51));
        btnFactura.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFactura.setForeground(new java.awt.Color(0, 0, 0));
        btnFactura.setText("Realizar Operación");
        btnFactura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });
        jPanel2.add(btnFactura);

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

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
        
            if(txfImporte.getText().equals("") || txfConcepto.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Debe rellenar el campo IMPORTE y CONCEPTO para poder realizar la operacion", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                if(!txfImporte.getText().matches("[0-9]+")){
                    JOptionPane.showMessageDialog(this, "El campo IMPORTE solo puede contener digitos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
                }else{
                try{
            float importe = Float.parseFloat(txfImporte.getText());
            //Generar datos ficticios para rellenar campos de recibo
            //Generar numero aleatorio de 4 digitos y agregarle un 47(Valladolid)
            int numeroAleatorio = (int)(Math.random()*9000)+1000;
            String numEmisora = "47"+numeroAleatorio;
            //Generar numero aleatorio de 7 digitos
            int numeroAleatorio2 = (int)(Math.random()*9000000)+1000000;
            String numRecibo =numeroAleatorio2+"";
            LocalDate hoy = LocalDate.now();
            String sFecha =formatearFecha(hoy);
            String dni="",nombre="",apellido="",telefono="",direccion="";
            try {
            Connection conexionFactura = Conexion.mySQL("proyecto_final", "root", "");
            Statement sentenciaFactura=conexionFactura.createStatement();
            String sqlFactura = "SELECT DNI, Nombre, Apellido, Telefono, Direccion FROM clientes JOIN cuentas ON clientes.ID_Cliente = cuentas.ID_Cliente WHERE clientes.ID_Cliente = '"+this.ID_Cliente+"' AND cuentas.ID_Cuenta = '"+this.cuenta+"'";
            ResultSet resultadoFactura = sentenciaFactura.executeQuery(sqlFactura);
            if(resultadoFactura.next()){
                  dni = resultadoFactura.getString("DNI");
                  nombre = resultadoFactura.getString("Nombre");
                  apellido = resultadoFactura.getString("Apellido");
                  telefono = resultadoFactura.getString("Telefono");
                  direccion = resultadoFactura.getString("Direccion");
            }else{
                JOptionPane.showMessageDialog(this, "No se ha podido realizar el tramite", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int contadorRecibo=0;//Agregar contador para que cada pdf vaya por separado
            Document documento = new Document(PageSize.A4.rotate());
            PdfWriter writer = PdfWriter.getInstance(documento, new java.io.FileOutputStream("recibo"+contadorRecibo+".pdf"));
            documento.open();
            //Agregar imagen
            Image imagen = Image.getInstance("./src/img/valladolid.jpg");
            imagen.scaleToFit(100, 100);
            imagen.setAlignment(Element.ALIGN_LEFT);
            documento.add(imagen);
            //Agregar parrafos
            Font grande = new Font(FontFactory.getFont("arial",18));
            grande.setColor(BaseColor.DARK_GRAY);
            Paragraph parrafoFecha = new Paragraph(sFecha, grande);
            parrafoFecha.setAlignment(Element.ALIGN_RIGHT);
            documento.add(parrafoFecha);
            Paragraph parrafo1=new Paragraph("RECIBO FACTURA", grande);
            parrafo1.setAlignment(Element.ALIGN_CENTER);
            documento.add(parrafo1);
            Paragraph espacio = new Paragraph("\n");
            documento.add(espacio);
            Font pequeño = new Font(FontFactory.getFont("arial",8));
            //Agregar tabla
            PdfPTable table = new PdfPTable(5);
            //Asignar el ancho relativo a cada columna
            float[] columnWidths = {1f,1f,2f,2f,1f};
            table.setWidths(columnWidths);
             

            PdfPCell celda11= new PdfPCell(new Phrase("Num. Emisora"));
            celda11.setBorder(0);
            PdfPCell celda12= new PdfPCell(new Phrase("Num. Recibo"));
            PdfPCell celda13= new PdfPCell(new Phrase("NIF/CIF/TITULAR"));
            PdfPCell celda14= new PdfPCell(new Phrase("Nombre y apellido"));
            PdfPCell celda15= new PdfPCell(new Phrase("Importe"));
            PdfPCell celda21= new PdfPCell(new Phrase(numEmisora));
            PdfPCell celda22= new PdfPCell(new Phrase(numRecibo));
            PdfPCell celda23= new PdfPCell(new Phrase(dni));
            PdfPCell celda24= new PdfPCell(new Phrase(nombre+" "+apellido));
            PdfPCell celda25= new PdfPCell(new Phrase(importe));
            PdfPCell celda31= new PdfPCell(new Phrase("Concepto"));
            PdfPCell celda33= new PdfPCell(new Phrase(""));
            PdfPCell celda32= new PdfPCell(new Phrase(txfConcepto.getText()));
            PdfPCell celda34= new PdfPCell(new Phrase(""));
            PdfPCell celda35= new PdfPCell(new Phrase(""));
            table.addCell(celda11);
            table.addCell(celda12);
            table.addCell(celda13);
            table.addCell(celda14);
            table.addCell(celda15);
            table.addCell(celda21);
            table.addCell(celda22);
            table.addCell(celda23);
            table.addCell(celda24);
            table.addCell(celda25);
            table.addCell(celda31);
            table.addCell(celda32);
            table.addCell(celda33);
            table.addCell(celda34);
            table.addCell(celda35);
            
            //Añadir la tabla al documento
            documento.add(table);
            //Abrir el fichero en el explorador por defecto
            File file = new File("recibo"+contadorRecibo+".pdf");
            Desktop.getDesktop().open(file);
            documento.close();
                    } catch (SQLException ex) {
                      Logger.getLogger(PagarFactura.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }catch(FileNotFoundException ex){
                    Logger.getLogger(PagarFactura.class.getName()).log(Level.SEVERE, null, ex);
                    }catch(DocumentException ex){
                    Logger.getLogger(PagarFactura.class.getName()).log(Level.SEVERE,null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(PagarFactura.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }
    }//GEN-LAST:event_btnFacturaActionPerformed

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
            java.util.logging.Logger.getLogger(PagarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txfConcepto;
    private javax.swing.JTextField txfImporte;
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