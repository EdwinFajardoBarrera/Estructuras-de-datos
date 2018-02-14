//Clase que implementa metodos para el ordenamiendo por "Mezcla directa"
package Modelo.Ordenamiento.Externo;

import Modelo.ArchivoTxt;
import Modelo.RegistroEmpleados;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ivan Aguilar
 */
public class MezclaDirecta {
    
    public final String SALTO = System.lineSeparator();
    /**
     * @param F
     * @param F1
     * @param F2
     * @throws IOException 
     */
    public void realizarMezclaDirecta(String F, String F1, String F2) throws IOException {
        int n = tamanoArchivo(F);
        int particion = 1;

        while (particion < n) {
            particionar(F, F1, F2, particion);
            fusionar(F, F1, F2, particion);
            particion = particion * 2;
        }

    }
    
    /**
     * @param F
     * @param F1
     * @param F2
     * @param part
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void particionar(String F, String F1, String F2, int part) throws FileNotFoundException, IOException {

        int k = 0;
        int l = 0;

        File lectura = new File(F);
        File escritura1 = new File(F1);
        File escritura2 = new File(F2);

        FileReader reader = new FileReader(lectura);
        Scanner scanner = new Scanner(reader);

        FileWriter writer1 = new FileWriter(escritura1);
        FileWriter writer2 = new FileWriter(escritura2);

        String linea = "";

        while (scanner.hasNextLine()) {

            k = 0;
            while (k < part) {

                if (scanner.hasNextLine()) {
                    writer1.write(scanner.nextLine() + SALTO);
                }
                k++;
            }

            l = 0;
            while (l < part) {

                if (scanner.hasNextLine()) {
                    writer2.write(scanner.nextLine() + SALTO);
                }
                l++;
            }

        }

        writer1.close();
        writer2.close();
        scanner.close();
    }
    
    /**
     * @param F
     * @param F1
     * @param F2
     * @param part
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void fusionar(String F, String F1, String F2, int part) throws FileNotFoundException, IOException {

        BigDecimal r1 = new BigDecimal(0);
        BigDecimal r2 = new BigDecimal(0);
        int k = 0, l = 0;
        
        boolean b1 = false, b2 = false;

        File original = new File(F);
        File archivo1 = new File(F1);
        File archivo2 = new File(F2);

        FileReader reader1 = new FileReader(archivo1);
        FileReader reader2 = new FileReader(archivo2);

        Scanner scanner1 = new Scanner(reader1);
        Scanner scanner2 = new Scanner(reader2);

        FileWriter writer = new FileWriter(original);

        if (scanner1.hasNextBigDecimal()) {
            r1 = scanner1.nextBigDecimal();
            b1 = true;
        }

        if (scanner2.hasNextBigDecimal()) {
            r2 = scanner2.nextBigDecimal();
            b2 = true;
        }
        
        while ((scanner1.hasNextBigDecimal() || b1) && (scanner2.hasNextBigDecimal() || b2)) {

            k = 0;
            l = 0;

            while (k < part && b1 && l < part && b2) {
                if ((r1.compareTo(r2)) > 0) {
                    r1 = r1.setScale(2, RoundingMode.DOWN);
                    writer.write(r1 + SALTO);
                    k++;
                    b1 = false;
                    if (scanner1.hasNextBigDecimal()) {
                        r1 = scanner1.nextBigDecimal();
                        b1 = true;
                    }
                } else {
                    r2 = r2.setScale(2, RoundingMode.DOWN);
                    writer.write(r2 + SALTO);
                    l++;
                    b2 = false;
                    if (scanner2.hasNextBigDecimal()) {
                        r2 = scanner2.nextBigDecimal();
                        b2 = true;
                    }
                }
            }

            while (k < part && b1) {
                writer.write(r1 + SALTO);
                b1 = false;
                k++;
                if (scanner1.hasNextBigDecimal()) {
                    r1 = scanner1.nextBigDecimal();
                    b1 = true;
                }
            }

            while (l < part && b2) {
                writer.write(r2 + SALTO);
                b2 = false;
                l++;
                if (scanner2.hasNextBigDecimal()) {
                    r2 = scanner2.nextBigDecimal();
                    b2 = true;
                }
            }

        }

        if (b1) {
            writer.write(r1 + SALTO);
        }

        if (b2) {
            writer.write(r2 + SALTO);
        }

        while (scanner1.hasNextBigDecimal()) {
            writer.write(scanner1.nextBigDecimal() + SALTO);
        }

        while (scanner2.hasNextBigDecimal()) {
            writer.write(scanner2.nextBigDecimal() + SALTO);
        }

        scanner1.close();
        scanner2.close();
        writer.close();

    }
    
    /**
     * @param ruta
     * @return int
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public int tamanoArchivo(String ruta) throws FileNotFoundException, IOException {

        int tamano = 0;

        File archivo = new File(ruta);
        FileReader reader = new FileReader(archivo);
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNextLine()) {
            scanner.nextLine();
            tamano++;
        }

        scanner.close();
        return tamano;

    }
    
    /**
     * @param nomina
     * @return List<RegistroEmpleados>
     * @throws IOException 
     */
    public List<RegistroEmpleados> ordenarEmpleados(List<RegistroEmpleados> nomina) throws IOException{        
        ArchivoTxt archivo = new ArchivoTxt();
        
        List<RegistroEmpleados> nominaArreglada = new ArrayList<RegistroEmpleados>();
        
        Double[] arreglo = new Double[nomina.size()];
        int i = 0;
        
        archivo.escribirTxt("F.txt", nomina);
        
        MezclaDirecta md = new MezclaDirecta();

        String F = "F.txt";
        String F1 = "F1.txt";
        String F2 = "F2.txt";
        md.realizarMezclaDirecta(F, F1, F2);
        
        String datosTxt = archivo.leerTxt(F);
        
        arreglo = archivo.guardarTxtEnArreglo(datosTxt, nomina);
        
        for (i = 0; i < arreglo.length; i++) {
        
            for(RegistroEmpleados nom : nomina){ 

                if(arreglo[i] == nom.getImpuesto()){
                    nominaArreglada.add(nom);
                }
                
            }
            
        }
        
   
        
        return nominaArreglada;
        
    }

}
