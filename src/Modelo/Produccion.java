package Modelo;

import Interfaces.IReportes;
import java.time.LocalDate;

/**
 *
 * @author Angie Perez
 */
public class Produccion{
    
    private int cantidadHuevos;
    private LocalDate fecha;

    public Produccion() {
    }

    public Produccion(int cantidadHuevos, LocalDate fecha) {
        this.cantidadHuevos = cantidadHuevos;
        this.fecha = fecha;
    }

    /**
     * @return the cantidadHuevos
     */
    public int getCantidadHuevos() {
        return cantidadHuevos;
    }

    /**
     * @param cantidadHuevos the cantidadHuevos to set
     */
    public void setCantidadHuevos(int cantidadHuevos) {
        this.cantidadHuevos = cantidadHuevos;
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
}