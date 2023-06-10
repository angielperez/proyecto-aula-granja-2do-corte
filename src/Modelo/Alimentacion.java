/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Angie Perez
 */
public class Alimentacion {
    private double cantidadAlimiento;
    private LocalDate fecha;

    public Alimentacion() {
    }

    public Alimentacion(double cantidadAlimiento, LocalDate fecha) {
        this.cantidadAlimiento = cantidadAlimiento;
        this.fecha = fecha;
    }

    public double getCantidadAlimiento() {
        return cantidadAlimiento;
    }

    public void setCantidadAlimiento(double cantidadAlimiento) {
        this.cantidadAlimiento = cantidadAlimiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}
