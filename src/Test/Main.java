package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Modelo.Ordenamiento.Externo.MezclaEquilibradaMultiple;
import Modelo.*;
import Controlador.*;
import Modelo.Ordenamiento.Externo.*;
import Modelo.Ordenamiento.Interno.*;
import Vista.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erofa
 */
public class Main {
    
    public static void main(String[] args) {
        Long fechaActual = System.currentTimeMillis();        
        List<RegistroEmpleados> nominas = new ArrayList<RegistroEmpleados>();
        
        nominas.add(new RegistroEmpleados("Ivan Aguilar", 350, "1029338192", fechaActual, "3121838192", 350*0.16));
        nominas.add(new RegistroEmpleados("Andres Cardenas", 100, "5432342342", fechaActual, "2345123566", 150*0.16));
        nominas.add(new RegistroEmpleados("Edwin Fajardo", 150, "3241355456", fechaActual, "7645345236", 200*0.16));
        nominas.add(new RegistroEmpleados("Hector Burgos", 300, "1321232131", fechaActual, "4345623456", 300*0.16));
        nominas.add(new RegistroEmpleados("Daniel Alvarez", 270, "8554323446", fechaActual, "6534572346", 270*0.16));
        nominas.add(new RegistroEmpleados("Kirbey Garcia", 201, "7281934721", fechaActual, "2349182930", 201*0.16));
        
        MainView vMain = new MainView();
        VRegistroEmpleados vRegistro = new VRegistroEmpleados();
//        RegistroEmpleados regEmpleados = new RegistroEmpleados("Default", 200, "12001082", 2321, "13001082",12.00);
//
//        
        List<RegistroEmpleados> nomina = null;
       
        Controlador ctrl = new Controlador(vMain, nominas, vRegistro);
        ctrl.iniciar();
        vMain.setVisible(true);
        vRegistro.setVisible(false);
        
        
    }
    
}
