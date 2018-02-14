//Esta clase implementa metodos para exportar un ArrayList a un archivo csv
package Modelo;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 * @author Ivan Aguilar
 */
public class ExportarArchivoCSV {
    /**
     * @param nomina 
     */
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
                csvSalida.write(Double.toString(nom.getImpuesto()));
                csvSalida.endRecord();
                
            }
            
            csvSalida.close();
            
        }catch (IOException e) {
            System.out.println("No existen permisos de I/O");
        }
        
    }
    
}
