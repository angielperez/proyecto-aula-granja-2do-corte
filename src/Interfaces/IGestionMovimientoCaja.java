/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author Angie Perez
 */
public interface IGestionMovimientoCaja {
    String guardar(String tipoMov);
    String anular(String tipoMov);
    void imprimir(String tipoMov);
}
