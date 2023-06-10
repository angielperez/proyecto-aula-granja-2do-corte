/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestion;
import Interfaces.IGestionAccionistas;
import Modelo.Accionista;
import Modelo.Direccion;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Angie Perez
 */
public class AccionistaGestion implements IGestionAccionistas{

    ArrayList<Accionista> lista = VariablesGlobales.datosAccionistas.Cargar();
    
    @Override
    public String guardar(Accionista nuevo) {
        Accionista busqueda = buscar(nuevo.getId());
        if(busqueda != null){
            return "La Identificacion ya existe";
        }
        
        
        lista.add(nuevo);
        return VariablesGlobales.datosAccionistas.Guardar(lista);
    }
    
    @Override
    public String actualizar(String id, Accionista nuevo) {
        int posicionBusqueda = buscarObtenerPosicion(id);
        if(posicionBusqueda == -1){
            return "El accionista no existe";
        }else{            
            lista.set(posicionBusqueda, nuevo);
            return VariablesGlobales.datosAccionistas.Guardar(lista);
        }
    }
    @Override
    public String eliminar(String id){
        int pos = buscarObtenerPosicion(id);
        if(pos == -1){
            return "El accionista no existe";
        }else{
            lista.remove(pos);
            String respuesta = VariablesGlobales.datosAccionistas.Guardar(lista);
            if(respuesta.equals("OK")){
                return "Eliminado exitosamente";
            }
            return respuesta;
        }
    }
    @Override
    public Accionista buscar(String id){
        for (int i = 0; i < lista.size(); i++) {
            Accionista accionista = lista.get(i);
            if(accionista.getId().equals(id)){
                return accionista;
            }
        }
        return null;
    }
    
    public int buscarObtenerPosicion(String id){
        for (int i = 0; i < lista.size(); i++) {
            Accionista accionista = lista.get(i);
            if(accionista.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    
}
