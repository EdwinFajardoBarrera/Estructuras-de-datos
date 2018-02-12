/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ivana
 */
public class ExportarArchivoCSV {
    
    public void generarArchivo(List<RegistroEmpleados> nomina){
        String ruta = "";
        String nombreArchivo = "nomina.csv";
        File archivo = new File(ruta + nombreArchivo);
        
        try {
            
            FileWriter writer = new FileWriter(archivo, false); 
            CsvWriter csvSalida = new CsvWriter(writer, ','); 
            
            csvSalida.write("Nombre");
            csvSalida.write("Monto de transferencia");
            csvSalida.write("Cuenta de destino");
            csvSalida.write("Fecha de transferencia");
            csvSalida.write("Cuenta de origen");
            csvSalida.write("Impuesto");
            csvSalida.endRecord(); 
            
            for(RegistroEmpleados nom : nomina){ 
                
                csvSalida.write(nom.getNombre());
                csvSalida.write(Integer.toString(nom.getMonto()));
                csvSalida.write(nom.getCuentaDestino());
                csvSalida.write(Long.toString(nom.getFechaTransferencia()));
                csvSalida.write(nom.getCuentaOrigen());
                csvSalida.write(nom.getImpuesto().toString());
                csvSalida.endRecord();
                
            }
            
            csvSalida.close();
            
        }catch (IOException e) {
            System.out.println("No existen permisos de I/O");
        }
        
    }
    
}
