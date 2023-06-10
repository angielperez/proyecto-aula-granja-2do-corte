/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestionEgreso;
import Modelo.Egreso;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author  Angie Perez
 */
public class EgresoGestion implements IGestionEgreso{
ArrayList<Egreso> lista = VariablesGlobales.datosEgresos.Cargar();
   
    @Override
    public String guardar(Egreso nuevo) {
        Egreso busqueda = buscar(nuevo.getCodigo());
        if(busqueda != null){
            return "El Egreso ya existe";
        }
        lista.add(nuevo);
        return VariablesGlobales.datosEgresos.Guardar(lista);
    }
    
    @Override
    public String actualizar(String codigo, Egreso nuevo) {
        int posicionBusqueda = buscarObtenerPosicion(codigo);
        if(posicionBusqueda == -1){
            return "EL Egreso no existe";
        }else{            
            lista.set(posicionBusqueda, nuevo);
            return VariablesGlobales.datosEgresos.Guardar(lista);
        }
    }
    @Override
    public String eliminar(String codigo){
        int pos = buscarObtenerPosicion(codigo);
        if(pos == -1){
            return "El Egreso no existe";
        }else{
            lista.remove(pos);
            String respuesta = VariablesGlobales.datosEgresos.Guardar(lista);
            if(respuesta.equals("OK")){
                return "Eliminado exitosamente";
            }
            return respuesta;
        }
    }
    @Override
    public Egreso buscar(String codigo){
        for (int i = 0; i < lista.size(); i++) {
            Egreso egreso = lista.get(i);
            if(egreso.getCodigo().equals(codigo)){
                return egreso;
            }
        }
        return null;
    }
    
    public int buscarObtenerPosicion(String codigo){
        for (int i = 0; i < lista.size(); i++) {
            Egreso egreso = lista.get(i);
            if(egreso.getCodigo().equals(codigo)){
                return i;
            }
        }
        return -1;
    }
}
    

