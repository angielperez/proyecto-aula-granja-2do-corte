/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;

/**
 *
 * @author Angie Perez
 */
public class ReporteGestion {
    public void reporteCaja(){
        granja.getCaja().mostrarReportes();
    }
    
    public void reporteInventario(){
        granja.getInventario().mostrarReportes();
    }
}
