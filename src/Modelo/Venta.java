package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Angie Perez
 */
public class Venta extends Ingreso {
    
    private int huevosVendidos;
    
    public Venta() {
    }

    public Venta(int huevosVendidos) {
        this.huevosVendidos = huevosVendidos;
    }

    /**
     * @return the huevosVendidos
     */
    public int getHuevosVendidos() {
        return huevosVendidos;
    }

    /**
     * @param huevosVendidos the huevosVendidos to set
     */
    public void setHuevosVendidos(int huevosVendidos) {
        this.huevosVendidos = huevosVendidos;
    }
}