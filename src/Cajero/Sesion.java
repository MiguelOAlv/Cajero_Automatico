/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cajero;

import java.time.LocalDate;

/**
 *
 * @author Miguel
 */
public class Sesion {
    private int ID_Administrador;
    private String ID_Cliente;
    private String Nombre;
    private String Contrasena;
    private String TarjetaCredito;
    private int pin;
    private LocalDate fecha;
    
    // Constructor
    public Sesion(int ID_Administrador, String Nombre, String Contrasena) {
        this.ID_Administrador = ID_Administrador;
        this.Nombre = Nombre;
        this.Contrasena = Contrasena;
        this.fecha = LocalDate.now();
    }
    
    public Sesion(String ID_Cliente, String Nombre, String TarjetaCredito, int pin) {
        this.ID_Cliente = ID_Cliente;
        this.Nombre = Nombre;
        this.TarjetaCredito = TarjetaCredito;
        this.pin = pin;
        this.fecha = LocalDate.now();
    }

    public int getID_Administrador() {
        return ID_Administrador;
    }

    public void setID_Administrador(int ID_Administrador) {
        this.ID_Administrador = ID_Administrador;
    }

    public String getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(String ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContraseña() {
        return Contrasena;
    }

    public void setContraseña(String Contraseña) {
        this.Contrasena = Contraseña;
    }

    public String getTarjetaCredito() {
        return TarjetaCredito;
    }

    public void setTarjetaCredito(String TarjetaCredito) {
        this.TarjetaCredito = TarjetaCredito;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Sesion{" + "ID_Administrador=" + ID_Administrador + ", ID_Cliente=" + ID_Cliente + ", Nombre=" + Nombre + ", Contrasena=" + Contrasena + ", TarjetaCredito=" + TarjetaCredito + ", pin=" + pin + ", fecha=" + fecha + '}';
    }
    
    
}
