//Esta clase implementa métodos para el manejo de archivos TXT
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Ivan Aguilar
 */
public class ArchivoTxt {
    
    public final String SALTO = System.lineSeparator();
    
    /**
     * @param archivo
     * @param nomina 
     */
    public void escribirTxt(String archivo, List<RegistroEmpleados> nomina){
        
        FileWriter fichero1 = null;
        PrintWriter pw = null;
        
        try{
            fichero1 = new FileWriter(archivo); 
            pw = new PrintWriter(fichero1);
            for(RegistroEmpleados nom : nomina){
                String Temp2 = Double.toString(nom.getImpuesto());
                pw.println(Temp2);
            }
            fichero1.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }
    /**
     * @param direccion
     * @return String
     */
    public String leerTxt (String direccion){   
        
        String texto = "";

            try{

                BufferedReader bf = new BufferedReader(new FileReader (direccion));    
                String temp = ""; 
                String bfRead;

                while( (bfRead = bf.readLine()) != null ){   
                    temp = temp + bfRead + SALTO;                    
                }

                texto = temp;         

            }catch(Exception e){
            
            }

            return texto;

    }
    
    /**
     * @param datosTxt
     * @param nomina
     * @return Double[]
     */
    public Double[] guardarTxtEnArreglo(String datosTxt, List<RegistroEmpleados> nomina){
        
        Double[] arreglo = new Double[nomina.size()];
        
        StringTokenizer tokens = new StringTokenizer(datosTxt, SALTO);
        
        for(int i = 0; i < nomina.size(); i++){
            
            String str = tokens.nextToken(); 
            arreglo[i] = Double.valueOf(str);

        }
        
        return arreglo;
        
    }
    
    /**
     * @param datosTxt
     * @param nomina
     * @return Double
     */
    public Double[] guardarTxtEnArregloEM(String datosTxt, List<RegistroEmpleados> nomina){
        
        Double[] arreglo = new Double[nomina.size()];
        
        StringTokenizer tokens = new StringTokenizer(datosTxt, SALTO);
        
        for(int i = nomina.size() - 1; i >= 0; i--){
            
            if(tokens.hasMoreTokens()){
                String str = tokens.nextToken(); 
                arreglo[i] = Double.valueOf(str);
            }
        }
        
        return arreglo;
    }
    
}
