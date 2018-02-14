//Excepcion que evita que el usuario ingrese motontos de transferencia menores a 10
package Modelo;
/**
 * @author Edwin Fajardo
 */
public class LessThanTenException extends Exception {
    /**
     * @param message 
     */
    public LessThanTenException(String message) {
        super(message);
    }
}
