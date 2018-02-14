//Clase que implementa metodos para el ordenamiendo por "Quicksort"
package Modelo.Ordenamiento.Interno;

import Modelo.RegistroEmpleados;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Ivan Aguilar
 */
public class Quicksort {
    
    /**
     * @param A
     * @param izq
     * @param der 
     */
    public void realizarQuicksort(int[] A, int izq, int der){
        
        int pivote=A[izq]; 
        int i=izq; 
        int j=der;
        int aux;
 
        while(i<j) {     
            
            while(A[i]<=pivote && i<j) i++; 
            
                while(A[j]>pivote) j--;  
              
                    if (i<j) {                                          
                        aux= A[i];                  
                        A[i]=A[j];
                         A[j]=aux;
                    }
                    
        }
        
        A[izq]=A[j];
        A[j]=pivote;
        
        if(izq<j-1){
            
            realizarQuicksort(A,izq,j-1); 
        }
        
        if(j+1 <der){
            
            realizarQuicksort(A,j+1,der); 

        }
        
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
          
        Quicksort quicksort = new Quicksort();
        quicksort.realizarQuicksort(arreglo, 0, arreglo.length - 1);
        
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
