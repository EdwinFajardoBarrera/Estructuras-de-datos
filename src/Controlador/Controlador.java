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
        
        this.vMain = vMain;
        this.vRegistro = vRegistro;
        this.regEmpleados = regEmpleados;
        this.tbModEmpleados = tbModEmpleados;
        
        this.vMain.JBSalir.addActionListener(this);
        this.vMain.JBEmpleadoNuevo.addActionListener(this);
        
    }
    
    public void iniciar(){
        vMain.setTitle("Control de empleados");
        vMain.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(vMain.getJBSalir() == e.getSource()){     //Pregunta si el boton "Salir" se presionó        
        vMain.dispose();        
        }
        
    }
}