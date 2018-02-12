/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Modelo.*;
import Controlador.*;
import Vista.*;

/**
 *
 * @author erofa
 */
public class Main {
    
    public static void main(String[] args) {
        
        
        MainView vMain = new MainView();
        VRegistroEmpleados vRegistro = new VRegistroEmpleados();
        RegistroEmpleados regEmpleados = new RegistroEmpleados();
        TBModeloEmpleados modEmpleados = new TBModeloEmpleados();
        
        
        Controlador ctrl = new Controlador(vMain, vRegistro, regEmpleados, modEmpleados);
        ctrl.iniciar();
        vMain.setVisible(true);
        vRegistro.setVisible(false);
        
        
    }
    
}
