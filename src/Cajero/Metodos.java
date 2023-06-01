/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cajero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author Miguel
 */
public class Metodos {
    private static Set<Integer> numerosGenerados = new HashSet<>();
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
    //Metodo para pasar un LocalDate a fecha con formato SQL
    public static String formatearFecha(LocalDate fecha){
         DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String sFecha = formato.format(fecha);
         return sFecha;
    } 
    //Metodo para generar un numero aleatorio de 8 digitos
    public static int generarAleatorio(){
        int min = 10000000;
        int max = 99999999;
        int rango = max - min + 1;
        //Genera un numero aleatorio entre el min y el max
        int numero = (int)(Math.random()*(max - min +1)+min);
        //Si el numero generado se encuentra en el hashset de enteros, vuelve a generar otro numero aleatorio
        while (numerosGenerados.contains(numero)) {
            numero = (int) (Math.random() * rango) + min;
        }
        // Agregar el número generado a la lista de números generados
        numerosGenerados.add(numero);
        return numero;
    }
}
