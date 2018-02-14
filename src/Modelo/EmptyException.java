//Excepcion que ayuda a que el usuario no deje campos vacíos
package Modelo;
/**
 * @author Edwin Fajardo
 */

public class EmptyException extends Exception {
    /**
     * @param message 
     */
    public EmptyException(String message) {
        super(message);
    }
}