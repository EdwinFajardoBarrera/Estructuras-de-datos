//Clase que implementa metodos para el ordenamiendo por "Shellsort"
package Modelo.Ordenamiento.Interno;

import Modelo.RegistroEmpleados;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Ivan Aguilar
 */
public class Shellsort {
    
    /**
     * @param entrada
     * @return int[]
     */
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
    
    /**
     * 
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
