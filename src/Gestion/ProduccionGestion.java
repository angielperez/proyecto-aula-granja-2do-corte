/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestion;
import Modelo.Gallina;
import Modelo.Produccion;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class ProduccionGestion implements IGestion{

    @Override
    public String guardar() {
        Scanner teclado = new Scanner(System.in);
        String cod;
        System.out.println("Digite el código de la gallina: ");
        cod = teclado.nextLine();
        for (int i = 0; i < granja.getGallinas().size(); i++){
            Gallina gallina = granja.getGallinas().get(i);
            if (cod.equals(gallina.getCodigo())){
                System.out.println("Digite la cantidad de huevos: ");
                Produccion produccion = new Produccion ();
                produccion.setCantidadHuevos(teclado.nextInt());
                produccion.setFecha(LocalDate.now());
                gallina.getProducciones().add(produccion);
                granja.getInventario().setTotalHuevos(granja.getInventario().getTotalHuevos()+produccion.getCantidadHuevos());
                System.out.println("Produccion registrada exitosamente");
            }
        }
        return "La gallina no existe";
    }

    @Override
    public String actualizar() {
        return "Opcion no disponible";
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < granja.getGallinas().size(); i++) {
            Gallina gallina = granja.getGallinas().get(i);
                System.out.println("Gallina #"+ gallina.getCodigo());
                for (int j = 0; j < gallina.getProducciones().size(); j++) {
                    Produccion produccion = gallina.getProducciones().get(j);
                    System.out.println("Cantidad de huevos:" + produccion.getCantidadHuevos());
                    System.out.println("Fecha de produccion:" + produccion.getFecha());
                }
            System.out.println("-------------------------------------");    
        }
    }
    
}
