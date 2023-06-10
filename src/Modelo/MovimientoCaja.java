/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Interfaces.IReportes;
import java.time.LocalDate;

/**
 *
 * @author Angie Perez
 */
public class MovimientoCaja implements IReportes {
    private String codigo;
    private double valor;
    private String descripcion;
    private LocalDate fecha;
   

    public MovimientoCaja() {
    }

    public MovimientoCaja(double valor, String descripcion, LocalDate fecha) {
        this.valor = valor;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
        /**
     * @return the fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    @Override
    public void mostrarReportes() {
        System.out.println("---------------------------------------------");
        System.out.println("Codigo: "+ this.codigo);
        System.out.println("Descripcion: "+ this.descripcion);
        System.out.println("Valor: "+ this.valor);
        System.out.println("Fecha: "+ this.fecha.toString());
        System.out.println("---------------------------------------------");
    }
    
    
}
