/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 *
 * @author Edwin Roman Fajardo Barrera
 */
public class Controlador implements ActionListener{
    
    private MainView vMain;
    private VRegistroEmpleados vRegistro;
    private RegistroEmpleados regEmpleados;
    private TBModeloEmpleados tbModEmpleados;
    
    
    public Controlador (MainView vMain, RegistroEmpleados regEmpleados){
        ItemListener s = null;
        
        this.vMain = vMain;
        this.vRegistro = vRegistro;
        this.regEmpleados = regEmpleados;
        this.tbModEmpleados = tbModEmpleados;
        
        //Botones
        this.vMain.JBSalir.addActionListener(this);
        this.vMain.JBGenerarRep.addActionListener(this);
        this.vMain.JBEmpleadoNuevo.addActionListener(this);
        //Combo box, se necesita validar cual tipo de ordenamiento esta está seleccionado
        this.vMain.JCBMOrdenamiento.addItemListener(s);
        
    }
    
    public void iniciar(){
        vMain.setTitle("Control de empleados");
        vMain.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        String s = (String) vMain.JCBMOrdenamiento.getSelectedItem();
        
        switch(s){
            
            case "Insercion":
                System.out.println("Insercion");
                break;
                
            case "Burbuja":
                System.out.println("Burbuja");
                break;
                
            case "Mergesort":
                System.out.println("Mergesort");
                break;
                
            case "Quicksort":
                System.out.println("Quicksort");
                break;
                
            case "Shellsort":
                System.out.println("Shellsort");
                break;
                
            case "Mezcla directa":
                System.out.println("Mezcla directa");
                break;
                
            case "Mezcla equilibrada multiple":
                System.out.println("Mezcla equilibrada multiple");
                break;                
            
        }
        
        
        if(vMain.getJBSalir() == e.getSource()){     //Valida si el boton "Salir" se presionó        
        vMain.dispose();        
        }
        
        if(vMain.getJBEmpleadoNuevo() == e.getSource()){ //Valida si el boton "+ Empleado nuevo" se presionó
            System.out.println("Presionaste +Nuevo empleado");
        }
        
        if(vMain.getJBGenerarRep() == e.getSource()){ //valida si el boton "Generar reporte se presiono"
            System.out.println("Presionaste generar reporte ");
        }
        
        
    }
    
}