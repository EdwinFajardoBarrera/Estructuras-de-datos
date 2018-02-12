/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Modelo.*;
import Controlador.*;
import Vista.*;
import java.math.BigDecimal;

/**
 *
 * @author erofa
 */
public class Main {
    
    public static void main(String[] args) {
        BigDecimal valor = new BigDecimal(0);
        
        
        MainView vMain = new MainView();
        VRegistroEmpleados vRegistro = new VRegistroEmpleados();
        RegistroEmpleados regEmpleados = new RegistroEmpleados("Default", 200, "12001082", 2321, "13001082",valor);        
        
        Controlador ctrl = new Controlador(vMain, vRegistro, regEmpleados);
        ctrl.iniciar();
        vMain.setVisible(true);
        vRegistro.setVisible(false);
        
        
    }
    
}
