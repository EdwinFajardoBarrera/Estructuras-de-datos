//Clase principal para la ejecucion del programa
package Test;

import Modelo.*;
import Controlador.*;
import Vista.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Edwin Fajardo
 */
public class Main {
    /**
     * @param args 
     */
    public static void main(String[] args) {
        
        Long fechaActual = System.currentTimeMillis();        
        List<RegistroEmpleados> nominas = new ArrayList<RegistroEmpleados>();
        
        //Datos de entrada default
        nominas.add(new RegistroEmpleados("Ivan Aguilar", 350, "1029338192", fechaActual, "3121838192", 350*0.16));
        nominas.add(new RegistroEmpleados("Andres Cardenas", 100, "5432342342", fechaActual, "2345123566", 150*0.16));
        nominas.add(new RegistroEmpleados("Edwin Fajardo", 150, "3241355456", fechaActual, "7645345236", 200*0.16));
        nominas.add(new RegistroEmpleados("Hector Burgos", 300, "1321232131", fechaActual, "4345623456", 300*0.16));
        nominas.add(new RegistroEmpleados("Daniel Alvarez", 270, "8554323446", fechaActual, "6534572346", 270*0.16));
        nominas.add(new RegistroEmpleados("Kirbey Garcia", 201, "7281934721", fechaActual, "2349182930", 201*0.16));
        
        MainView vMain = new MainView();
        VRegistroEmpleados vRegistro = new VRegistroEmpleados();
        List<RegistroEmpleados> nomina = null;
       
        Controlador ctrl = new Controlador(vMain, nominas, vRegistro);
        ctrl.iniciar();
        vMain.setVisible(true);
        vRegistro.setVisible(false);        
        
    }
    
}
