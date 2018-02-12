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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwin Roman Fajardo Barrera
 */
public class Controlador implements ActionListener{
    
    private MainView vMain;
    private VRegistroEmpleados vRegistro;
    private RegistroEmpleados regEmpleados;
    
    
    public Controlador (MainView vMain, VRegistroEmpleados vRegistro, RegistroEmpleados regEmpleados){
        ItemListener s = null;
        
        this.vMain = vMain;
        this.vRegistro = vRegistro;
        this.regEmpleados = regEmpleados;
        
        //Botones, solo se agrega el listener para saber si se presiona  o no
        this.vMain.JBSalir.addActionListener(this);
        this.vMain.JBGenerarRep.addActionListener(this);
        this.vMain.JBEmpleadoNuevo.addActionListener(this);
        
        this.vRegistro.JBSalir.addActionListener(this);
        this.vRegistro.JBGuardar.addActionListener(this);
        
        //Combo box, se necesita validar cual tipo de ordenamiento esta está seleccionado
        this.vMain.JCBMOrdenamiento.addItemListener(s);
        
        inicializaTabla(vMain.JTEmpleados);
        
    }
    
    public void iniciar(){
        vMain.setTitle("Control de empleados");
        vRegistro.setTitle("Registro empleados");
        vMain.setLocationRelativeTo(null);
        vRegistro.setLocationRelativeTo(null);
    }
    
    public void inicializaTabla(JTable tabla){
        Vector<String> titulos = new Vector<String>();
        Vector<Vector<Object>> datos = new Vector<Vector<Object>>();
        
        titulos.add("Nombre");
        titulos.add("Monto");
        titulos.add("Cuenta");
        
        for(int i=0; i < regEmpleados.listaEmpleados.size(); i++){
            Vector<Object> row = new Vector<Object>();
            
            row.add(regEmpleados.listaEmpleados.get(i).getNombre());
            row.add(regEmpleados.listaEmpleados.get(i).getMonto());
            row.add(regEmpleados.listaEmpleados.get(i).getCuentaDestino());
            
            datos.add(row);       
            
        }
        
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);
        
        tabla.setModel(modelo);                 
        
    }
    
    public void actionPerformed(ActionEvent e){
        String s = (String) vMain.JCBMOrdenamiento.getSelectedItem();
        String tipoOrdenamiento = null;
        
        //Botones para la vista "MainView"
        if(vMain.getJBSalir() == e.getSource()){     //Valida si el boton "Salir" se presiona        
            vMain.dispose();        
        }
        
        if(vMain.getJBEmpleadoNuevo() == e.getSource()){ //Valida si el boton "+ Empleado nuevo" se presiona
            vMain.setVisible(false);
            RegistroEmpleados regEmpleados = new RegistroEmpleados();            
            vRegistro.setVisible(true);
        }
        
        if(vMain.getJBGenerarRep() == e.getSource()){ //Valida si el boton "Generar reporte" se presiona
            System.out.println("Presionaste generar reporte ");
            
             switch(s){
            
            case "Insercion":
                System.out.println("Insercion");
                tipoOrdenamiento = "Interno";
                break;
                
            case "Burbuja":
                System.out.println("Burbuja");
                tipoOrdenamiento = "Interno";
                break;
                
            case "Mergesort":
                System.out.println("Mergesort");
                tipoOrdenamiento = "Interno";
                break;
                
            case "Quicksort":
                System.out.println("Quicksort");
                tipoOrdenamiento = "Interno";
                break;
                
            case "Shellsort":
                System.out.println("Shellsort");
                tipoOrdenamiento = "Interno";
                break;
                
            case "Mezcla directa":
                System.out.println("Mezcla directa");
                tipoOrdenamiento = "Externo";
                break;
                
            case "Mezcla equilibrada multiple":
                System.out.println("Mezcla equilibrada multiple");
                tipoOrdenamiento = "Externo";
                break;                
            
        }
            
        }
        
        //Botones para la vista "VRegistroEmpleados"
        if(vRegistro.getJBGuardar() == e.getSource()){ //Valida si boton "Guardar" se presiona
            
            
            String nombre = vRegistro.JTFNombre.getText();
            int monto = Integer.parseInt(vRegistro.JTFMonto.getText());
            String cuentaD = vRegistro.JTFCuentaD.getText();
            long fechaTrans = System.currentTimeMillis();
            String cuentaOrigen = "12001082";
            
            regEmpleados.setNombre(nombre);
            regEmpleados.setMonto(monto);
            regEmpleados.setCuentaDestino(cuentaD);
            regEmpleados.setFechaTransferencia(fechaTrans);
            regEmpleados.setCuentaOrigen("12001082");
            regEmpleados.setImpuesto(BigDecimal.ZERO);
            
            regEmpleados.listaEmpleados.add(regEmpleados);
            
            inicializaTabla(vMain.JTEmpleados);
            
            
        }
        
        if(vRegistro.getJBSalir() == e.getSource()){ //Valia si el boton "Salir" se presiona
            vRegistro.dispose();
            vMain.setVisible(true);
        }
        
    }
    
}