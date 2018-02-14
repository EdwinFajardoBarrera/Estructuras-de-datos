//Clase que implementa metodos para el ordenamiendo por "Insercion"
package Modelo.Ordenamiento.Interno;

import Modelo.RegistroEmpleados;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Ivan Aguilar
 */
public class Insercion {
    
    /**
     * @param entrada
     * @return int[]
     */
    public int[] realizarInsercion(int[] entrada){
        int temporal;
        for (int i = 1; i < entrada.length; i++) { //i = 1 para que pueda realizar la comparacion con el numero anterior
            
            int j = i;

            while(j > 0 && comparar(entrada[j], entrada[j-1])){
                temporal = entrada[j];
                entrada[j] = entrada[j-1];
                entrada[j-1] = temporal;
                j--;
            } 
            
            
        }
        
        return entrada;
    }
    
    public boolean comparar(int valor1, int valor2){
        return valor1 <= valor2;
    }
    
    /**
     * @param nomina
     * @return List<RegistroEmpleados>
     */
    public List<RegistroEmpleados> ordenarEmpleados(List<RegistroEmpleados> nomina){
        List<RegistroEmpleados> nominaArreglada = new ArrayList<RegistroEmpleados>();
        
        int[] arreglo = new int[nomina.size()];
        int i = 0;
        
        for(RegistroEmpleados nom : nomina){ 
                
            arreglo[i] = nom.getMonto();
            
            i++;
            
        }
          
        Insercion insercion = new Insercion();
        insercion.realizarInsercion(arreglo);
        
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

