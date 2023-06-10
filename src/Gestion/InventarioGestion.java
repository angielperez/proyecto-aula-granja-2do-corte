/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Modelo.Alimentacion;
import Modelo.Gallina;
import Modelo.Produccion;
import Persistencia.DatosGallinas;
import java.util.ArrayList;

/**
 *
 * @author Angie Perez
 */
public class InventarioGestion {
    DatosGallinas datosGallinas = new DatosGallinas();
    public int totalHuevos(){
        ArrayList<Gallina> gallinas = datosGallinas.Cargar();
        int sum = 0;
        for (Gallina gallina : gallinas) {
            for (Produccion produccion : gallina.getProducciones()) {
                sum += produccion.getCantidadHuevos();
            }
        }
        return sum;
    }
    
    public int totalAlimentaciones(){
        ArrayList<Gallina> gallinas = datosGallinas.Cargar();
        int sum = 0;
        for (Gallina gallina : gallinas) {
            for (Alimentacion alimentacion : gallina.getAlimentaciones()) {
                sum += alimentacion.getCantidadAlimiento();
            }
        }
        return sum;
    }
}
