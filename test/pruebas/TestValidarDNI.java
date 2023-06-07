package pruebas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import Cajero.Metodos;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestValidarDNI {
    @Test
    public void testDNICorrecto() {
        assertTrue(Metodos.validarDNI("12345678Z"));
    }

    @Test
    public void testDNIIncorrectoPorLongitud() {
        assertFalse(Metodos.validarDNI("12345678"));
    }

    @Test
    public void testDNIIncorrectoPorCaracteres() {
        assertFalse(Metodos.validarDNI("1234567XZ"));
    }

    @Test
    public void testDNIIncorrectoPorLetraControl() {
        assertFalse(Metodos.validarDNI("12345678A"));
    }
}
