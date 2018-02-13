/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author ivana
 */
public class ArchivoTxt {
    
    public final String SALTO = System.lineSeparator();
    
    public void escribirTxt(String archivo, ArrayList<RegistroEmpleados> nomina){
        
        FileWriter fichero1 = null;
        PrintWriter pw = null;
        
        try{
            fichero1 = new FileWriter(archivo); 
            pw = new PrintWriter(fichero1);
            for(RegistroEmpleados nom : nomina){
                String Temp2 = nom.getImpuesto().toString();
                pw.println(Temp2);
            }
            fichero1.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }
    
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
    
    public Double[] guardarTxtEnArreglo(String datosTxt, List<RegistroEmpleados> nomina){
        
        Double[] arreglo = new Double[nomina.size()];
        
        StringTokenizer tokens = new StringTokenizer(datosTxt, SALTO);
        
        for(int i = 0; i < nomina.size(); i++){
            
            String str = tokens.nextToken(); 
            arreglo[i] = Double.valueOf(str);

        }
        
        return arreglo;
    }
    
    public Double[] guardarTxtEnArregloEM(String datosTxt, List<RegistroEmpleados> nomina){
        
        Double[] arreglo = new Double[nomina.size()];
        
        StringTokenizer tokens = new StringTokenizer(datosTxt, SALTO);
        
        for(int i = nomina.size() - 1; i >= 0; i--){
            
            String str = tokens.nextToken(); 
            arreglo[i] = Double.valueOf(str);

        }
        
        return arreglo;
    }
    
}
