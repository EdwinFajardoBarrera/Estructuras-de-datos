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
        
        RegistroEmpleados regEmpleados = new RegistroEmpleados();
        MainView mView = new MainView();
        
        Controlador ctrl = new Controlador(mView, regEmpleados);
        ctrl.iniciar();
        mView.setVisible(true);
        
        
    }
    
}
