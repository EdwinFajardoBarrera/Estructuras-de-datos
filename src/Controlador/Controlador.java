package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Modelo.Ordenamiento.Externo.MezclaEquilibradaMultiple;
import Modelo.*;
import Modelo.Ordenamiento.Interno.*;
import Modelo.Ordenamiento.Externo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
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
    private RegistroEmpleados regEmpleados;
    private List<RegistroEmpleados> nomina; 
    
        public Controlador(MainView vMain, List<RegistroEmpleados> nomina, VRegistroEmpleados vRegistro){
        this.vMain = vMain;
        this.nomina = nomina;
        this.vRegistro = vRegistro;
        ItemListener s = null;
        
        //Botones, solo se agrega el listener para saber si se presiona  o no
        this.vMain.JBSalir.addActionListener(this);
        this.vMain.JBGenerarRep.addActionListener(this);
        this.vMain.JBEmpleadoNuevo.addActionListener(this);
        
        this.vRegistro.JBSalir.addActionListener(this);
        this.vRegistro.JBGuardar.addActionListener(this);
        
        //Combo box, se necesita validar cual tipo de ordenamiento esta está seleccionado
        this.vMain.JCBMOrdenamiento.addItemListener(s);
        
        configuraTabla(vMain.JTEmpleados);
    }
    
    public void iniciar(){
        vMain.setTitle("Control de empleados");
        vRegistro.setTitle("Registro empleados");
        vMain.setLocationRelativeTo(null);
        vRegistro.setLocationRelativeTo(null);
    }
    
    //Metodo para inicializar y actualizar el contenido de la tabla principal   
        public void configuraTabla(JTable tabla){
        Vector<String> titulos = new Vector<String>();
        Vector<Vector<Object>> datos = new Vector<Vector<Object>>();
        
        titulos.add("Nombre");
        titulos.add("Monto");
        titulos.add("Cuenta");
        
        for (RegistroEmpleados nom : nomina) {
            Vector<Object> row = new Vector<Object>();
            
            row.add(nom.getNombre());
            row.add(nom.getMonto());
            row.add(nom.getCuentaDestino());
            
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
            //vMain.setVisible(false);            
            vRegistro.setVisible(true);
            vRegistro.setLocationRelativeTo(vMain);
        }
        
        if(vMain.getJBGenerarRep() == e.getSource()){ //Valida si el boton "Generar reporte" se presiona
            //System.out.println("Presionó generar reporte ");
            
             switch(s){
            
                //Ordena por insercion
                case "Insercion":
                    
                    long tiempoInicial = System.currentTimeMillis();
                    System.out.println("Insercion");
                    Insercion insercion = new Insercion();

                    ExportarArchivoCSV exportar = new ExportarArchivoCSV();                
                
                    nomina = insercion.ordenarEmpleados(nomina);
                    exportar.generarArchivo(nomina);
                
                    long tiempoFinal = System.currentTimeMillis();                
                    long tiempoTotal = (tiempoFinal - tiempoInicial);

                    vMain.JTFResultados.setText("Tiempo total de generación: " + tiempoTotal / 1000 + " segundos");
                
                break;
                
                //Ordena por burbuja
                case "Burbuja":
                    
                    long tiempoInicial2 = System.currentTimeMillis();
                    System.out.println("Burbuja");
                    Burbuja burbuja = new Burbuja();

                    ExportarArchivoCSV exportar2 = new ExportarArchivoCSV();

                    nomina = burbuja.ordenarEmpleados(nomina);
                    exportar2.generarArchivo(nomina);

                    long tiempoFinal2 = System.currentTimeMillis();                
                    long tiempoTotal2 = tiempoFinal2 - tiempoInicial2;
                    vMain.JTFResultados.setText("Tiempo total de generación: " + tiempoTotal2 / 1000 + " segundos");

                break;
                
                //Ordena por mergesort
                case "Mergesort":
                    
                    System.out.println("Mergesort");
                    long tiempoInicial3 = System.currentTimeMillis();
                    Mergesort mergesort = new Mergesort();

                    ExportarArchivoCSV exportar3 = new ExportarArchivoCSV();

                    nomina = mergesort.ordenarEmpleados(nomina);
                    exportar3.generarArchivo(nomina);

                    long tiempoFinal3 = System.currentTimeMillis();                
                    long tiempoTotal3 = tiempoFinal3 - tiempoInicial3;
                    vMain.JTFResultados.setText("Tiempo total de generación: " + tiempoTotal3 / 1000 + " segundos");

                break;
                
                //Ordena por quicksort
                case "Quicksort":
                    
                    long tiempoInicial4 = System.currentTimeMillis();                   
                    System.out.println("Quicksort");
                    Quicksort quicksort = new Quicksort();

                    ExportarArchivoCSV exportar4 = new ExportarArchivoCSV();

                    nomina = quicksort.ordenarEmpleados(nomina);
                    exportar4.generarArchivo(nomina);

                    long tiempoFinal4 = System.currentTimeMillis();                
                    long tiempoTotal4 = tiempoFinal4 - tiempoInicial4;
                    vMain.JTFResultados.setText("Tiempo total de generación: " + tiempoTotal4 / 1000 + " segundos");
                    
                break;
                
                //Ordena por shellsort
                case "Shellsort":
                    
                    long tiempoInicial5 = System.currentTimeMillis();
                    System.out.println("Shellsort");
                    Shellsort shellsort = new Shellsort();

                    ExportarArchivoCSV exportar5 = new ExportarArchivoCSV();

                    nomina = shellsort.ordenarEmpleados(nomina);
                    exportar5.generarArchivo(nomina);                

                    long tiempoFinal5 = System.currentTimeMillis();                
                    long tiempoTotal5 = tiempoFinal5 - tiempoInicial5;
                    vMain.JTFResultados.setText("Tiempo total de generación: " + tiempoTotal5 / 1000 + " segundos");

                break;
                
                //Ordena por mezcla directa
                case "Mezcla directa":

                    long tiempoInicial6 = System.currentTimeMillis();
                    System.out.println("Mezcla directa");
                    MezclaDirecta mezclaDirecta = new MezclaDirecta();                

                    ExportarArchivoCSV exportar6 = new ExportarArchivoCSV();

                    {
                        try {
                            nomina = mezclaDirecta.ordenarEmpleados(nomina);
                            exportar6.generarArchivo(nomina);
                        } catch (IOException e1) {
                            e1.getMessage();
                        }
                    }             

                    long tiempoFinal6 = System.currentTimeMillis();                
                    long tiempoTotal6 = tiempoFinal6 - tiempoInicial6;
                    vMain.JTFResultados.setText("Tiempo total de generación: " + tiempoTotal6 / 1000 + " segundos");                

                break;
                
                //Ordena por mezcla equilibrada multiple
                case "Mezcla equilibrada multiple":

                    long tiempoInicial7 = System.currentTimeMillis();
                    System.out.println("Mezcla equilibrada multiple");
                    MezclaEquilibradaMultiple mezclaEquilibradaMultiple = new MezclaEquilibradaMultiple();             

                    ExportarArchivoCSV exportar7 = new ExportarArchivoCSV();                            

                    {
                        try {
                            nomina = mezclaEquilibradaMultiple.ordenarEmpleados(nomina);
                                            exportar7.generarArchivo(nomina);
                        } catch (IOException ex) {
                            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }            

                    long tiempoFinal7 = System.currentTimeMillis();                
                    long tiempoTotal7 = tiempoFinal7 - tiempoInicial7;
                    vMain.JTFResultados.setText("Tiempo total de generación: " + tiempoTotal7 / 1000 + " segundos");

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
            
            Double impuesto = monto * .16;
            
            
            RegistroEmpleados reg = new RegistroEmpleados(nombre, monto, cuentaD, fechaTrans, cuentaOrigen, impuesto);
            
            nomina.add(reg);            
            
            configuraTabla(vMain.JTEmpleados);
            
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