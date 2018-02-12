/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Ordenamiento.Interno;

import Modelo.RegistroEmpleados;
import java.util.ArrayList;

/**
 *
 * @author ivana
 */
public class Shellsort {
    
    public int[] realizarSherllsort(int[] entrada){
        int n = entrada.length;
        int salto = (int) Math.floor(n/2);
        
        int temp;
        while(salto > 0){
            
            for (int i = salto; i < n; i++) {
                
                int j = i;
                temp = entrada[i];
                while(j >= salto && entrada[j - salto] > temp){
                    entrada[j] = entrada[j - salto];
                    j = j - salto;
                }
                
                entrada[j] = temp;
            }
           
            salto = (int) Math.floor(salto/2);
            
        }
        
        return entrada;
    }
    
    public ArrayList<RegistroEmpleados> ordenarEmpleados(ArrayList<RegistroEmpleados> nomina){
        ArrayList<RegistroEmpleados> nominaArreglada = new ArrayList<RegistroEmpleados>();
        
        int[] arreglo = new int[nomina.size()];
        int i = 0;
        
        for(RegistroEmpleados nom : nomina){ 
                
            arreglo[i] = nom.getMonto();
            
            i++;
            
        }
          
        Shellsort shellsort = new Shellsort();
        shellsort.realizarSherllsort(arreglo);
        
        for (i = 0; i < arreglo.length; i++) {
        
            for(RegistroEmpleados nom : nomina){ 

                if(arreglo[i] == nom.getMonto()){  
                    nominaArreglada.add(nom);        
                }
                
            }
            
        }
        
        return nominaArreglada;
    }
   
}
