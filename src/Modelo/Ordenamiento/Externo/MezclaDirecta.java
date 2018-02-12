/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Ordenamiento.Externo;

import Modelo.ArchivoTxt;
import Modelo.RegistroEmpleados;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ivana
 */
public class MezclaDirecta {

    public final String SALTO = System.lineSeparator();

    public void realizarMezclaDirecta(String F, String F1, String F2) throws IOException {
        int n = tamanoArchivo(F);
        int particion = 1;

        while (particion < n) {
            particionar(F, F1, F2, particion);
            fusionar(F, F1, F2, particion);
            particion = particion * 2;
        }

    }

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

    public void fusionar(String F, String F1, String F2, int part) throws FileNotFoundException, IOException {

        int r1 = 0, r2 = 0, k = 0, l = 0;
        boolean b1 = false, b2 = false;

        File original = new File(F);
        File archivo1 = new File(F1);
        File archivo2 = new File(F2);

        FileReader reader1 = new FileReader(archivo1);
        FileReader reader2 = new FileReader(archivo2);

        Scanner scanner1 = new Scanner(reader1);
        Scanner scanner2 = new Scanner(reader2);

        FileWriter writer = new FileWriter(original);

        if (scanner1.hasNextInt()) {
            r1 = scanner1.nextInt();
            b1 = true;
        }

        if (scanner2.hasNextInt()) {
            r2 = scanner2.nextInt();
            b2 = true;
        }

        while ((scanner1.hasNextInt() || b1) && (scanner2.hasNextInt() || b2)) {

            k = 0;
            l = 0;

            while (k < part && b1 && l < part && b2) {
                if (r1 >= r2) { //mayor a menor
                    writer.write(r1 + SALTO);
                    k++;
                    b1 = false;
                    if (scanner1.hasNextInt()) {
                        r1 = scanner1.nextInt();
                        b1 = true;
                    }
                } else {
                    writer.write(r2 + SALTO);
                    l++;
                    b2 = false;
                    if (scanner2.hasNextInt()) {
                        r2 = scanner2.nextInt();
                        b2 = true;
                    }
                }
            }

            while (k < part && b1) {
                writer.write(r1 + SALTO);
                b1 = false;
                k++;
                if (scanner1.hasNextInt()) {
                    r1 = scanner1.nextInt();
                    b1 = true;
                }
            }

            while (l < part && b2) {
                writer.write(r2 + SALTO);
                b2 = false;
                l++;
                if (scanner2.hasNextInt()) {
                    r2 = scanner2.nextInt();
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

        while (scanner1.hasNextInt()) {
            writer.write(scanner1.nextInt() + SALTO);
        }

        while (scanner2.hasNextInt()) {
            writer.write(scanner2.nextInt() + SALTO);
        }

        scanner1.close();
        scanner2.close();
        writer.close();

    }

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

    public List<RegistroEmpleados> ordenarEmpleados(ArrayList<RegistroEmpleados> nomina) throws IOException{
        ArchivoTxt archivo = new ArchivoTxt();
        
        List<RegistroEmpleados> nominaArreglada = new ArrayList<RegistroEmpleados>();
        
        int[] arreglo = new int[nomina.size()];
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

                if(arreglo[i] == nom.getMonto()){
                    nominaArreglada.add(nom);
                }
                
            }
            
        }
        
        return nominaArreglada;
        
    }

}
