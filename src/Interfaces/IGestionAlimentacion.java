/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Modelo.Alimentacion;
import java.util.ArrayList;


/**
 *
 * @author Angie Perez
 */
public interface IGestionAlimentacion {
    String guardar(Alimentacion nuevo, String codigoGallina);
    ArrayList<Alimentacion> buscar(String codigoGallina);
}
