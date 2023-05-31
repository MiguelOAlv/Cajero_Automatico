/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cajero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

/**
 *
 * @author Miguel
 */
public class Metodos {
    
    //Metodo para verificar la validez de un DNI, se introduce un string como parametro y devuelve false o true.
    public static boolean validarDNI(String dni) {
    if (dni.length() != 9) {
        return false;
    }
    String numeros = dni.substring(0, 8);
    char letraControl = Character.toUpperCase(dni.charAt(8));
    if (!numeros.matches("[0-9]+")) {//Se comparan los numeros obtenidos con el patron 0-9
        return false;
    }
    int numero = Integer.parseInt(numeros);
    char letraCalculada = "TRWAGMYFPDXBNJZSQVHLCKE".charAt(numero % 23);
    return letraControl == letraCalculada;//Si es distinta la letra de control con la calculada devuelve false, si no devuelve true
    }
    
    //Metodo para verificar la validez de un correo, se introduce un string como parametro que ha de contener un "@" y un ".", devuelve true o false si cumple los requisitos.
    public static boolean validarCorreo(String correo){
        int arrobaIndex = correo.indexOf('@');
        int puntoIndex = correo.lastIndexOf('.');
        /*
        Comprueba que el caracter @ está presente y que no es el primero ni el último
        Comprueba que hay al menos un punto después del @
        Comprueba que el punto no es el último caracter
        */
        return arrobaIndex > 0 && puntoIndex > arrobaIndex + 1 && puntoIndex < correo.length() - 1;//Si cumple las 3 condiciones, devuelve true, si no devuelve false.
    }

    public static String formatearFecha(LocalDate fecha){
         DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String sFecha = formato.format(fecha);
         return sFecha;
    }  
}
