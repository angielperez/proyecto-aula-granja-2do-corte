/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestionGallina;
import Modelo.Gallina;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Angie Perez
 */
public class GallinaGestion implements IGestionGallina{
    ArrayList<Gallina> lista = VariablesGlobales.datosGallinas.Cargar();
   
    @Override
    public String guardar(Gallina nuevo) {
        Gallina busqueda = buscar(nuevo.getCodigo());
        if(busqueda != null){
            return "El codigo ya existe";
        }
        lista.add(nuevo);
        return VariablesGlobales.datosGallinas.Guardar(lista);
    }
    
    @Override
    public String actualizar(String codigo, Gallina nuevo) {
        int posicionBusqueda = buscarObtenerPosicion(codigo);
        if(posicionBusqueda == -1){
            return "La Gallina no existe";
        }else{            
            lista.set(posicionBusqueda, nuevo);
            return VariablesGlobales.datosGallinas.Guardar(lista);
        }
    }
    @Override
    public String eliminar(String codigo){
        int pos = buscarObtenerPosicion(codigo);
        if(pos == -1){
            return "La Gallina no existe";
        }else{
            lista.remove(pos);
            String respuesta = VariablesGlobales.datosGallinas.Guardar(lista);
            if(respuesta.equals("OK")){
                return "Eliminada exitosamente";
            }
            return respuesta;
        }
    }
    @Override
    public Gallina buscar(String codigo){
        for (int i = 0; i < lista.size(); i++) {
            Gallina gallina = lista.get(i);
            if(gallina.getCodigo().equals(codigo)){
                return gallina;
            }
        }
        return null;
    }
    
    public int buscarObtenerPosicion(String codigo){
        for (int i = 0; i < lista.size(); i++) {
            Gallina gallina = lista.get(i);
            if(gallina.getCodigo().equals(codigo)){
                return i;
            }
        }
        return -1;
    }
}