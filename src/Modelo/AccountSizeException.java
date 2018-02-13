//Excepción para que el usuario únicamente ingrese cuentas de dimension 10
package Modelo;
/**
 * @author Edwin Fajardo
 */
public class AccountSizeException extends Exception{
    
    public AccountSizeException(String message) {
        super(message);
    }
    
}
