/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestionVenta;
import Modelo.Venta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Angie Perez
 */
public class VentaGestion implements IGestionVenta{
ArrayList<Venta> lista = VariablesGlobales.datosVentas.Cargar();
   
    @Override
    public String guardar(Venta nuevo) {
        Venta busqueda = buscar(nuevo.getCodigo());
        if(busqueda != null){
            return "El codigo ya existe";
        }
        lista.add(nuevo);
        return VariablesGlobales.datosVentas.Guardar(lista);
    }
    
    @Override
    public String actualizar(String codigo, Venta nuevo) {
        int posicionBusqueda = buscarObtenerPosicion(codigo);
        if(posicionBusqueda == -1){
            return "La Venta no existe";
        }else{            
            lista.set(posicionBusqueda, nuevo);
            return VariablesGlobales.datosVentas.Guardar(lista);
        }
    }
    @Override
    public String eliminar(String codigo){
        int pos = buscarObtenerPosicion(codigo);
        if(pos == -1){
            return "La Venta no existe";
        }else{
            lista.remove(pos);
            String respuesta = VariablesGlobales.datosVentas.Guardar(lista);
            if(respuesta.equals("OK")){
                return "Eliminada exitosamente";
            }
            return respuesta;
        }
    }
    @Override
    public Venta buscar(String codigo){
        for (int i = 0; i < lista.size(); i++) {
            Venta venta = lista.get(i);
            if(venta.getCodigo().equals(codigo)){
                return venta;
            }
        }
        return null;
    }
    
    public int buscarObtenerPosicion(String codigo){
        for (int i = 0; i < lista.size(); i++) {
            Venta venta = lista.get(i);
            if(venta.getCodigo().equals(codigo)){
                return i;
            }
        }
        return -1;
    }
}
    

