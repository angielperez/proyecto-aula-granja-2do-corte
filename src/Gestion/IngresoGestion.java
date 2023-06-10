/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestionIngreso;
import Modelo.Ingreso;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Angie Perez
 */
public class IngresoGestion implements IGestionIngreso{
ArrayList<Ingreso> lista = VariablesGlobales.datosIngresos.Cargar();
   
    @Override
    public String guardar(Ingreso nuevo) {
        Ingreso busqueda = buscar(nuevo.getCodigo());
        if(busqueda != null){
            return "El codigo ya existe";
        }
        lista.add(nuevo);
        return VariablesGlobales.datosIngresos.Guardar(lista);
    }
    
    @Override
    public String actualizar(String codigo, Ingreso nuevo) {
        int posicionBusqueda = buscarObtenerPosicion(codigo);
        if(posicionBusqueda == -1){
            return "EL Ingreso no existe";
        }else{            
            lista.set(posicionBusqueda, nuevo);
            return VariablesGlobales.datosIngresos.Guardar(lista);
        }
    }
    @Override
    public String eliminar(String codigo){
        int pos = buscarObtenerPosicion(codigo);
        if(pos == -1){
            return "El Ingreso no existe";
        }else{
            lista.remove(pos);
            String respuesta = VariablesGlobales.datosIngresos.Guardar(lista);
            if(respuesta.equals("OK")){
                return "Eliminado exitosamente";
            }
            return respuesta;
        }
    }
    @Override
    public Ingreso buscar(String codigo){
        for (int i = 0; i < lista.size(); i++) {
            Ingreso ingreso = lista.get(i);
            if(ingreso.getCodigo().equals(codigo)){
                return ingreso;
            }
        }
        return null;
    }
    
    public int buscarObtenerPosicion(String codigo){
        for (int i = 0; i < lista.size(); i++) {
            Ingreso ingreso = lista.get(i);
            if(ingreso.getCodigo().equals(codigo)){
                return i;
            }
        }
        return -1;
    }
}
    

