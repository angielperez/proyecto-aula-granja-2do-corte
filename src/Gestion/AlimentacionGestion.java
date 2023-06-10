/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;

import Interfaces.IGestionAlimentacion;
import Modelo.Alimentacion;
import Modelo.Gallina;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Angie Perez
 */
public class AlimentacionGestion implements IGestionAlimentacion{
private GallinaGestion gallinaGestion = new GallinaGestion();
    
    @Override
    public String guardar(Alimentacion nuevo, String codigoGallina) {
        Gallina gallina = gallinaGestion.buscar(codigoGallina);
        ArrayList<Alimentacion> alimentaciones = gallina.getAlimentaciones();
        alimentaciones.add(nuevo);
        return VariablesGlobales.datosAlimentaciones.Guardar(alimentaciones, codigoGallina);
    }

    @Override
    public ArrayList<Alimentacion> buscar(String codigoGallina) {
        return VariablesGlobales.datosAlimentaciones.Cargar(codigoGallina);
    }    
}


   