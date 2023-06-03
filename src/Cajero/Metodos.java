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
   
       //Se introduce en un array los billetes a contar de distintos tipos.
       public static int[] reparto(int cantidadTotal){
            //Crear array de tiposbilletes y billetes
            int[] tiposBillete = new int[]{50,20,10,5};
            int[] billetes = new int[4];
            for (int i = 0; i < 4; i++) {
                billetes[i] = cantidadTotal / tiposBillete[i];//En cada iteracion de billetes, agrega la cantidad de billetes de cada tipo que viene de la cantidadTotal entre el tipo de billete.
                cantidadTotal = cantidadTotal % tiposBillete[i];//Calcula el resto, pasadas las 4 iteraciones, el resto debe de ser 0
            }
            return billetes;
    }
       //Si la cantidad es mayor a 50, se llama al metodo reparto para que devuelva un array de billetes y se le suman los billetes correspondientes a los ultimos 50
       public static int[] entregarDinero(int cantidadTotal){
           int[] billetes = new int[4];
           if(cantidadTotal >=50){
               cantidadTotal = cantidadTotal-50;
               billetes = reparto(cantidadTotal);
               //Sumar los billetes necesarios para hacer los ultimos 50 de la cantidad
               billetes[1] = billetes[1]+1;//Equivale a los billetes de 20
               billetes[2] = billetes[2]+2;//Equivale a los billetes de 10
               billetes[3] = billetes[3]+2;//Equivale a los billetes de 5
           }else{
               billetes = reparto(cantidadTotal);
           }
            return billetes;
       }
}