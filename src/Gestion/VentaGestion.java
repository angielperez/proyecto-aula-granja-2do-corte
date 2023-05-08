/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestion;
import Modelo.Venta;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class VentaGestion implements IGestion{

    @Override
    public String guardar() {
        Scanner teclado = new Scanner(System.in);
        Venta venta = new Venta();
        System.out.println("Huevos vendidos:");
        venta.setHuevosVendidos(teclado.nextInt());
        System.out.println("Valor del huevo:");
        venta.setValor(teclado.nextDouble());
        venta.setFecha(LocalDate.now());
        int cantidadHuevosActuales = granja.getInventario().getTotalHuevos();
        granja.getInventario().setTotalHuevos(cantidadHuevosActuales-venta.getHuevosVendidos());
        double valorActualCaja = granja.getCaja().getTotalCaja();
        double valorNuevo = venta.getValor()*venta.getHuevosVendidos();
        granja.getCaja().setTotalCaja(valorActualCaja+valorNuevo);
        granja.getCaja().getIngresos().add(venta);
        return "Venta registrada exitosamente";
    }

    @Override
    public String actualizar() {
        return "Opcion no disponible";
    }

    @Override
    public void imprimir() {
        System.out.println("Opcion en proceso de desarrollo");
    }
    
}
