package Modelo;

import Interfaces.IReportes;

/**
 *
 * @author andre
 */
public class Inventario implements IReportes{
    
    private double totalAlimentacionSuministrada;
    private int totalHuevos;

    public Inventario() {
    }

    public Inventario(int totalHuevos, double totalAlimentacionSuministrada) {
        this.totalHuevos = totalHuevos;
        this.totalAlimentacionSuministrada = totalAlimentacionSuministrada;
    }

    /**
     * @return the totalHuevos
     */
    public int getTotalHuevos() {
        return totalHuevos;
    }

    /**
     * @param totalHuevos the totalHuevos to set
     */
    public void setTotalHuevos(int totalHuevos) {
        this.totalHuevos = totalHuevos;
    }

    public double getTotalAlimentacionSuministrada() {
        return totalAlimentacionSuministrada;
    }

    public void setTotalAlimentacionSuministrada(double totalAlimentacionSuministrada) {
        this.totalAlimentacionSuministrada = totalAlimentacionSuministrada;
    }
    

    @Override
    public void mostrarReportes() {
        System.out.println("-----------------------REPORTE DE INVENTARIO--------------------");
        System.out.println("Cantidad de huevos: "+ this.totalHuevos);
        System.out.println("ALimentacion suministrada(gr): "+ this.totalAlimentacionSuministrada);
    }
}