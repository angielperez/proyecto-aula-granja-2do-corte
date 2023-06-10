/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Modelo.Gallina;

/**
 *
 * @author Angie Perez
 */
public interface IGestionGallina {
    String guardar(Gallina nuevo);
    String actualizar(String codigo, Gallina nuevo);
    String eliminar(String codigo);
    Gallina buscar(String codigo);
}
