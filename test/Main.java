/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Test.*;
import Modelo.Ordenamiento.Externo.MezclaEquilibradaMultiple;
import Modelo.*;
import Controlador.*;
import Modelo.Ordenamiento.Externo.*;
import Modelo.Ordenamiento.Interno.*;
import Vista.*;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author erofa
 */
public class Main {
    
    public static void main(String[] args) {
        //BigDecimal bigdecimal = new BigDecimal(12);
        
        MainView vMain = new MainView();
        VRegistroEmpleados vRegistro = new VRegistroEmpleados();
        RegistroEmpleados regEmpleados = new RegistroEmpleados("Default", 200, "12001082", 2321, "13001082",12.00);
        Burbuja burbuja = new Burbuja();
        Insercion insercion = new Insercion();
        Mergesort mergesort = new Mergesort();
        Quicksort quicksort = new Quicksort();
        Shellsort shellsort = new Shellsort();
        MezclaDirecta mezclaDirecta = new MezclaDirecta();
        MezclaEquilibradaMultiple mezclaEquilibradaMultiple = new MezclaEquilibradaMultiple();
        List<RegistroEmpleados> nomina = null;
        
        Controlador ctrl = new Controlador(vMain, vRegistro, regEmpleados, burbuja, insercion, mergesort, quicksort, shellsort, mezclaDirecta, mezclaEquilibradaMultiple, nomina);
        ctrl.iniciar();
        vMain.setVisible(true);
        vRegistro.setVisible(false);
        
        
    }
    
}
