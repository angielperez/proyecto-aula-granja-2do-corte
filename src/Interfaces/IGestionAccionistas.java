/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Modelo.Accionista;

/**
 *
 * @author Angie Perez
 */
public interface IGestionAccionistas {
    String guardar(Accionista nuevo);
    String actualizar(String id, Accionista nuevo);
    String eliminar(String id);
    Accionista buscar(String id);
}
