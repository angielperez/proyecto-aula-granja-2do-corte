/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Modelo.Venta;



/**
 *
 * @author Angie Perez
 */
public interface IGestionVenta {
    String guardar(Venta nuevo);
    String actualizar(String codigo, Venta nuevo);
    String eliminar(String codigo);
    Venta buscar(String codigo);
}
