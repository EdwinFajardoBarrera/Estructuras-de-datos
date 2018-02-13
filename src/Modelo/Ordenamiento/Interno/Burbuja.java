//Clase que implementa metodos para el ordenamiendo por "Burbuja"
package Modelo.Ordenamiento.Interno;

import Modelo.RegistroEmpleados;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Ivan Aguilar
 */
public class Burbuja {
    
    public int[] realizarBurbuja(int[] entrada){

        int temp;
        for (int i = 0; i < entrada.length; i++) {
            
            for (int j = 1; j < (entrada.length - i); j++) {
                if(entrada[j - 1] >= entrada[j]){
                    temp = entrada[j - 1];
                    entrada[j - 1] = entrada[j];
                    entrada[j] = temp;
                }

            }
          
        }
        
        return entrada;
    }
    
    public List<RegistroEmpleados> ordenarEmpleados(List<RegistroEmpleados> nomina){
        List<RegistroEmpleados> nominaArreglada = new ArrayList<RegistroEmpleados>();
        
        int[] arreglo = new int[nomina.size()];
        int i = 0;
        
        for(RegistroEmpleados nom : nomina){ 
                
            arreglo[i] = nom.getMonto();
            
            i++;
            
        }
          
        Burbuja burbuja = new Burbuja();
        burbuja.realizarBurbuja(arreglo);
        
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
