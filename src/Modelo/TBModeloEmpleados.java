/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author erofa
 */
public class TBModeloEmpleados {
    
    public void inicializaTabla(JTable tabla){
        Vector<String> titulos = new Vector<String>();
        Vector<Vector<Object>> datos = new Vector<Vector<Object>>();
        
        titulos.add("Nombre");
        titulos.add("Monto");
        titulos.add("Cuenta");
        
        //for(int i=0; i<GeneraNomina.listaEmpleados.size(); i++){
            Vector<Object> row = new Vector<Object>();
            
            //row.add(GeneraNomina.listaEmpleados.get(i).getNombre());
            //row.add(GeneraNomina.listaEmpleados.get(i).getApellidoP());
            //row.add(GeneraNomina.listaEmpleados.get(i).getSeguroSocial());
            
                       
            //row.add( ((EmpleadoAsalariado)  GeneraNomina.listaEmpleados.get(i)).getSalarioSemanal());
            
            datos.add(row);       
            
        //}
        
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);
        
        tabla.setModel(modelo);                 
        
    }
    
}
