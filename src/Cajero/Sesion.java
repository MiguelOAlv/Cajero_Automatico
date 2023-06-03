/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cajero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Miguel
 */
public class Sesion {
    private int ID_Administrador;
    private String ID_Cliente;
    private String Nombre;
    private String Contrasena;
    private String ID_Tarjeta;
    private int pin;
    private LocalDate fecha;
    private Timer timer;
    private JFrame frameActual;
    private Idioma idioma;

    
    
    // Constructor administrador
    public Sesion(int ID_Administrador, String Nombre, String Contrasena) {
        this.ID_Administrador = ID_Administrador;
        this.Nombre = Nombre;
        this.Contrasena = Contrasena;
        this.fecha = LocalDate.now();
        this.timer=null;
    }
    // Constructor cliente
    public Sesion(String ID_Cliente, String Nombre, String ID_Tarjeta, int pin, JFrame frameActual, Idioma idioma) {
        this.ID_Cliente = ID_Cliente;
        this.Nombre = Nombre;
        this.ID_Tarjeta = ID_Tarjeta;
        this.pin = pin;
        this.fecha = LocalDate.now();
        this.idioma = idioma;
        this.timer = new Timer(60000, new ActionListener(){//Lanzar disparador si pasan 60 segundos de inactividad
            public void actionPerformed(ActionEvent e){
                cerrarSesion();
            }
        });
        this.timer.setRepeats(false);//Colocar el timer para que al dispararse no se repita automaticamente
        this.frameActual = frameActual;
    }
    
    public int getPin() {
        return pin;
    }

    public Idioma getIdioma() {
        return idioma;
    }
    //INICIAR TEMPORIZADOR
    public void iniciarSesion(){
        this.timer.start();
    }
    //RENOVAR EL TEMPORIZADOR
    public void mantenerSesion(){
        this.timer.restart();
    }
    //CERRAR SESION Y CREAR FRAME DE INICIO
    private void cerrarSesion(){
        Inicio Inicio = new Inicio();
        Inicio.setVisible(true);
        this.frameActual.dispose();
        JOptionPane.showMessageDialog(null, "La sesión se ha cerrado por inactividad", "Desconexion", JOptionPane.INFORMATION_MESSAGE);
        timer.stop();
    }
    //METODO PARA SABER EL FRAME ACTUAL Y AL CERRAR SESION CERRAR LA VENTANA ACTUAL
    public void setFrameActual(JFrame nuevoFrame) {
    this.frameActual = nuevoFrame;
    }
    
    public Timer getTimer() {
        return timer;
    }
    
    public int getID_Administrador() {
        return ID_Administrador;
    }

    public String getID_Cliente() {
        return ID_Cliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getTarjetaCredito() {
        return ID_Tarjeta;
    }

    public void setTarjetaCredito(String ID_Tarjeta) {
        this.ID_Tarjeta = ID_Tarjeta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Sesion{" + "ID_Administrador=" + ID_Administrador + ", ID_Cliente=" + ID_Cliente + ", Nombre=" + Nombre + ", Contrasena=" + Contrasena + ", TarjetaCredito=" + ID_Tarjeta + ", pin=" + pin + ", fecha=" + fecha + '}';
    }
    
    
}
