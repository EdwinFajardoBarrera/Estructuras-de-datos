/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author erofa
 */
public class RegistroEmpleados {
    
    private String nombre;
    private int monto;
    private String cuentaDestino;
    private long fechaTransferencia;
    private String cuentaOrigen;
    //private BigDecimal impuesto = new BigDecimal(0);
    private double impuesto;
    public ArrayList<RegistroEmpleados> listaEmpleados = new ArrayList<RegistroEmpleados>();

    public RegistroEmpleados(String nombre, int monto, String cuentaDestino, long fechaTransferencia, String cuentaOrigen, double impuesto) {
        this.nombre = nombre;
        this.monto = monto;
        this.cuentaDestino = cuentaDestino;
        this.fechaTransferencia = fechaTransferencia;
        this.cuentaOrigen = cuentaOrigen;
        this.impuesto = impuesto;
    }    

    //Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public long getFechaTransferencia() {
        return fechaTransferencia;
    }

    public void setFechaTransferencia(long fechaTransferencia) {
        this.fechaTransferencia = fechaTransferencia;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    
}
