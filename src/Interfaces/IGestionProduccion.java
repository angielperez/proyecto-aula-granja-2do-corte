/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Modelo.Produccion;
import java.util.ArrayList;


/**
 *
 * @author Angie Perez
 */
public interface IGestionProduccion {
    String guardar(Produccion nuevo, String codigoGallina);
    ArrayList<Produccion> buscar(String codigoGallina);
}
