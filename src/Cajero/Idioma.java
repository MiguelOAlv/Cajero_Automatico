/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cajero;
import java.io.IOException;
import java.util.Properties;
 
public class Idioma extends Properties{
 
    private static final long serialVersionUID = 1L;
    private String nombre;
    
    public Idioma(String nombre){
 
        if(nombre.equals("Espanol")){
                    this.nombre="Espanol";
                    getProperties("espanol.properties");
        }
        else if (nombre.equals("Ingles")){
                    this.nombre="Ingles";
                    getProperties("ingles.properties");
        }
        else if (nombre.equals("Frances")){
                    this.nombre="Frances";
                    getProperties("frances.properties");
        }
        else {
            this.nombre="Espanol";
            getProperties("Espanol");
        }
    }

    public String getNombre() {
        return nombre;
    }
 
    private void getProperties(String idioma) {
        try {
            this.load( getClass().getResourceAsStream(idioma) );
        } catch (IOException ex) {
 
        }
   }
}