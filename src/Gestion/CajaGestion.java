/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.datosEgresos;
import static Gestion.VariablesGlobales.datosIngresos;
import static Gestion.VariablesGlobales.datosVentas;
import Modelo.Alimentacion;
import Modelo.Egreso;
import Modelo.Gallina;
import Modelo.Ingreso;
import Modelo.Produccion;
import Modelo.Venta;
import Persistencia.DatosEgresos;
import Persistencia.DatosIngresos;
import Persistencia.DatosVentas;
import java.util.ArrayList;

/**
 *
 * @author  Angie Perez

 */
public class CajaGestion {
    DatosIngresos datosIngreso = new DatosIngresos();
    DatosEgresos datosEgreso = new DatosEgresos();
    DatosVentas datosVenta= new DatosVentas();
    
    public int totalIngresos(){
        ArrayList<Ingreso> ingresos = datosIngresos.Cargar();
        int sum = 0;
        for (Ingreso ingreso : ingresos) {
            sum += ingreso.getValor();
        }
        return sum;
    }
    
    public int totalEgresos(){
        ArrayList<Egreso> egresos = datosEgresos.Cargar();
        int sum = 0;
        for (Egreso egreso : egresos) {
                sum += egreso.getValor();
            }
        return sum;
    }
    
    
    public int totalVentas(){
        ArrayList<Venta> ventas = datosVentas.Cargar();
        int sum = 0;
        for (Venta venta :ventas) {
                sum += venta.getValor();
            }
        return sum;
    }
}
