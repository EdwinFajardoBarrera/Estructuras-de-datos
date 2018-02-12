/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Modelo.Ordenamiento.Interno.*;
import Modelo.Ordenamiento.Externo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwin Roman Fajardo Barrera
 */
public final class Controlador implements ActionListener{
    
    private final MainView vMain;
    private final VRegistroEmpleados vRegistro;
    private final RegistroEmpleados regEmpleados;
    private Burbuja burbuja;
    private Insercion insercion;
    private Mergesort mergesort;
    private Quicksort quicksort;
    private Shellsort shellsort;
    private MezclaDirecta mezclaDirecta;
    private MezclaEquilibradaMultiple mezclaEquilibradaMultiple;
    
    
    public Controlador (MainView vMain, VRegistroEmpleados vRegistro, 
            RegistroEmpleados regEmpleados, Burbuja burbuja, Insercion insercion, Mergesort mergesort, Quicksort quicksort, Shellsort shellsort, MezclaDirecta mezclaDirecta, MezclaEquilibradaMultiple mezclaEquilibradaMultiple){
        ItemListener s = null;
        
        this.vMain = vMain;
        this.vRegistro = vRegistro;
        this.regEmpleados = regEmpleados;
        this.burbuja = burbuja;
        this.insercion = insercion;
        this.mergesort = mergesort;
        this.quicksort = quicksort;
        this.shellsort = shellsort;
        this.mezclaDirecta = mezclaDirecta;
        this.mezclaEquilibradaMultiple = mezclaEquilibradaMultiple;
        
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
    
    @Override
    public void actionPerformed(ActionEvent e){
        String s = (String) vMain.JCBMOrdenamiento.getSelectedItem();
        
        //Botones para la vista "MainView"
        if(vMain.getJBSalir() == e.getSource()){     //Valida si el boton "Salir" se presiona        
            vMain.dispose();        
        }
        
        if(vMain.getJBEmpleadoNuevo() == e.getSource()){ //Valida si el boton "+ Empleado nuevo" se presiona
            vMain.setVisible(false);            
            vRegistro.setVisible(true);
        }
        
        if(vMain.getJBGenerarRep() == e.getSource()){ //Valida si el boton "Generar reporte" se presiona
            System.out.println("Presionaste generar reporte ");
            ExportarArchivoCSV exportar = new ExportarArchivoCSV();
            
             switch(s){
            
            case "Insercion":
                System.out.println("Insercion");
                insercion.ordenarEmpleados(regEmpleados.listaEmpleados);
                exportar.generarArchivo(regEmpleados.listaEmpleados);                
                break;
                
            case "Burbuja":
                System.out.println("Burbuja");
                burbuja.ordenarEmpleados(regEmpleados.listaEmpleados);
                exportar.generarArchivo(regEmpleados.listaEmpleados);
                break;
                
            case "Mergesort":
                System.out.println("Mergesort");
                mergesort.ordenarEmpleados(regEmpleados.listaEmpleados);
                exportar.generarArchivo(regEmpleados.listaEmpleados);
                break;
                
            case "Quicksort":
                System.out.println("Quicksort");
                quicksort.ordenarEmpleados(regEmpleados.listaEmpleados);
                exportar.generarArchivo(regEmpleados.listaEmpleados);
                break;
                
            case "Shellsort":
                System.out.println("Shellsort");
                shellsort.ordenarEmpleados(regEmpleados.listaEmpleados);
                exportar.generarArchivo(regEmpleados.listaEmpleados);
                break;
                
            case "Mezcla directa":
                System.out.println("Mezcla directa");
            {
                try {
                    mezclaDirecta.ordenarEmpleados(regEmpleados.listaEmpleados);
                    exportar.generarArchivo(regEmpleados.listaEmpleados);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
                
            case "Mezcla equilibrada multiple":
                System.out.println("Mezcla equilibrada multiple");
                break;                
            
        }
            
        }
        
        //Botones para la vista "VRegistroEmpleados"
        if(vRegistro.getJBGuardar() == e.getSource()){ //Valida si boton "Guardar" se presiona
            
            try{
            
            String nombre = vRegistro.JTFNombre.getText();            
            if(nombre.isEmpty() || nombre.length() > 50){
                throw new EmptyException("");
            }
            
            int monto = Integer.parseInt(vRegistro.JTFMonto.getText());
            if(monto < 10){
                throw new LessThanTenException("");
            }
            
            String cuentaD = vRegistro.JTFCuentaD.getText();            
            if(cuentaD.length() != 10){
                throw new AccountSizeException("");
            }            
            
            long fechaTrans = System.currentTimeMillis();
            
            String cuentaOrigen = "1200108200";
            if(cuentaOrigen.length() != 10){
                throw new AccountSizeException("");
            }
            
            BigDecimal impuesto = new BigDecimal(monto * .16);
            impuesto.setScale(2, RoundingMode.UP);
            
            
            RegistroEmpleados reg = new RegistroEmpleados(nombre, monto, cuentaD, fechaTrans, cuentaOrigen, impuesto);
            
            regEmpleados.listaEmpleados.add(reg);            
            
            inicializaTabla(vMain.JTEmpleados);
            
            JOptionPane.showMessageDialog(null,"Guardado satisfactoriamente");
            
            }
            
            catch(InputMismatchException e1){
                JOptionPane.showMessageDialog(null, "Escribio caracteres no validos");
            }            
            catch(NumberFormatException e2){
                JOptionPane.showMessageDialog(null, e2.getMessage());                
            }             
            catch (EmptyException e3) {
                JOptionPane.showMessageDialog(null,"No puede tener campos vacíos o el tamaño se excedio");                
            } 
            catch (LessThanTenException e4) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un monto mayor a $10");
            }
            catch (AccountSizeException e5) {
                JOptionPane.showMessageDialog(null, "La cuenta debe constar de 10 digitos");
            }
            
        }
        
        if(vRegistro.getJBSalir() == e.getSource()){ //Valia si el boton "Salir" se presiona
            vRegistro.dispose();
            vMain.setVisible(true);
        }
        
    }
    
}