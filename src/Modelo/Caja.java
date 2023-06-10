package Modelo;

import Interfaces.IReportes;
import java.util.ArrayList;

/**
 *
 * @author Angie Perez
 */
public class Caja implements IReportes{

    private double totalIngresos;
    private double totalEgresos;
    private double totalCaja;
    private ArrayList<Gasto> gastos = new ArrayList();
    private ArrayList<Ingreso> ingresos = new ArrayList();
    private ArrayList<Venta> ventas = new ArrayList();
    
    public Caja() {
    }   

    public Caja(double totalIngresos, double totalEgresos, double totalCaja) {
        this.totalIngresos = totalIngresos;
        this.totalEgresos = totalEgresos;
        this.totalCaja = totalCaja;
        this.ingresos = new ArrayList();
        this.gastos = new ArrayList();
        this.ventas= new ArrayList();
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    public double getTotalEgresos() {
        return totalEgresos;
    }

    public double getTotalCaja() {
        return totalCaja;
    }

    public ArrayList<Gasto> getGastos() {
        return gastos;
    }

    public ArrayList<Ingreso> getIngresos() {
        return ingresos;
    }
    
    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setTotalIngresos(double totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public void setTotalEgresos(double totalEgresos) {
        this.totalEgresos = totalEgresos;
    }

    public void setTotalCaja(double totalCaja) {
        this.totalCaja = totalCaja;
    }

    public void setGastos(ArrayList<Gasto> gastos) {
        this.gastos = gastos;
    }

    public void setIngresos(ArrayList<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }    

     public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }  
     
    @Override
    public void mostrarReportes() {
        System.out.println("---------------------------------------------");
        System.out.println("Cantidad de ingresos: "+ this.ingresos.size());
        System.out.println("Cantidad de gastos: "+ this.gastos.size());
        System.out.println("Total ingresos: "+ this.totalIngresos);
        System.out.println("Total gastos: "+ this.totalEgresos);
        System.out.println("Total caja: "+ this.totalCaja);
        System.out.println("---------------------------------------------");
    }
}