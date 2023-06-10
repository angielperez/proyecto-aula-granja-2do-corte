/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestionProduccion;
import Modelo.Gallina;
import Modelo.Produccion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Angie Perez
 */
public class ProduccionGestion implements IGestionProduccion{

    private GallinaGestion gallinaGestion = new GallinaGestion();
    
    @Override
    public String guardar(Produccion nuevo, String codigoGallina) {
        Gallina gallina = gallinaGestion.buscar(codigoGallina);
        ArrayList<Produccion> producciones = gallina.getProducciones();
        producciones.add(nuevo);
        return VariablesGlobales.datosProducciones.Guardar(producciones, codigoGallina);
    }

    @Override
    public ArrayList<Produccion> buscar(String codigoGallina) {
        return VariablesGlobales.datosProducciones.Cargar(codigoGallina);
    }    
}
