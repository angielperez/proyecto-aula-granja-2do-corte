/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Modelo.Egreso;





/**
 *
 * @author Angie Perez
 */
public interface IGestionEgreso {
    String guardar(Egreso nuevo);
    String actualizar(String codigo, Egreso nuevo);
    String eliminar(String codigo);
    Egreso buscar(String codigo);
}
