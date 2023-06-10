package Modelo;

import Interfaces.IReportes;
import java.util.ArrayList;

/**
 *
 * @author Angie Perez
 */
public class Gallina implements IReportes{
    
    private String codigo;
    private double peso;
    private ArrayList <Produccion> producciones= new ArrayList();
    private ArrayList <Alimentacion> alimentaciones= new ArrayList();

    public Gallina() {
        
    }

    public Gallina(String codigo, double peso) {
        this.codigo = codigo;
        this.peso = peso;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the producciones
     */
    public ArrayList <Produccion> getProducciones() {
        return producciones;
    }

    /**
     * @param producciones the producciones to set
     */
    public void setProducciones(ArrayList <Produccion> producciones) {
        this.producciones = producciones;
    }

    public ArrayList<Alimentacion> getAlimentaciones() {
        return alimentaciones;
    }

    public void setAlimentaciones(ArrayList<Alimentacion> alimentaciones) {
        this.alimentaciones = alimentaciones;
    }
    
    

    @Override
    public void mostrarReportes() {
        int maximo = 0;
        int minimo = 999999999;
        for (Produccion produccion : producciones) {
            if(produccion.getCantidadHuevos() > maximo){
                maximo = produccion.getCantidadHuevos();
            }
            
            if(produccion.getCantidadHuevos() < minimo){
                minimo = produccion.getCantidadHuevos();
            }
        }
        if(minimo == 999999999){
            minimo = 0;
        }
        System.out.println("Peso:" + this.peso);
        System.out.println("Cantidad alimentacion consumida:" + this.alimentaciones.size());
        System.out.println("Cantidad producciones:" + this.producciones.size());
        System.out.println("Mayor produccion:" + maximo);
        System.out.println("Menor produccion:" + minimo);
    }
}