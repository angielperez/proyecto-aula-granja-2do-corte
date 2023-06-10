/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Modelo.Ingreso;





/**
 *
 * @author Angie Perez
 */
public interface IGestionIngreso {
    String guardar(Ingreso nuevo);
    String actualizar(String codigo, Ingreso nuevo);
    String eliminar(String codigo);
    Ingreso buscar(String codigo);
}
