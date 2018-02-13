/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Ordenamiento.Interno;

import Modelo.RegistroEmpleados;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivana
 */
public class Mergesort {
    
    public void merge(int[] arreglo, int izq, int media, int der){
        
        int n1 = media - izq + 1;
        int n2 = der - media;
        
        int I[] = new int[n1];
        int D[] = new int[n2];
        
        for(int i = 0; i < n1; i++) {
            I[i] = arreglo[izq + i];
        }   
        
        for(int j = 0; j < n2; j++) {
            D[j] = arreglo[media + 1 + j];
        } 
        
        int i = 0;
        int j = 0;
        
        int k = izq;
        
        while(i < n1 && j < n2){
            if (I[i] <= D[j]) {
                arreglo[k] = I[i];
                i++;
            }else{
                arreglo[k] = D[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arreglo[k] = I[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arreglo[k] = D[j];
            j++;
            k++;
        }
        
    }
    
    public void realizarMergesort(int[] arreglo, int izq, int der){
        
        if(izq < der){
            int media = (izq + der) / 2; //al asignar un int en java siempre pone el valor más pequeño

            realizarMergesort(arreglo, izq, media);
            realizarMergesort(arreglo, media + 1, der);

            merge(arreglo, izq, media, der);
        }
        
    }
    
    public List<RegistroEmpleados> ordenarEmpleados(List<RegistroEmpleados> nomina){
        List<RegistroEmpleados> nominaArreglada = new ArrayList<RegistroEmpleados>();
        
        int[] arreglo = new int[nomina.size()];
        int i = 0;
        
        for(RegistroEmpleados nom : nomina){ 
                
            arreglo[i] = nom.getMonto();
            
            i++;
            
        }
          
        Mergesort mergesort = new Mergesort();
        mergesort.realizarMergesort(arreglo, 0, arreglo.length - 1);
        
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
