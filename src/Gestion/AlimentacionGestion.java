/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestion;
import Modelo.Alimentacion;
import Modelo.Gallina;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class AlimentacionGestion implements IGestion{

    @Override
    public String guardar() {
        Scanner teclado = new Scanner(System.in);
        String cod;
        System.out.println("Digite el código de la gallina: ");
        cod = teclado.nextLine();
        for (int i = 0; i < granja.getGallinas().size(); i++){
            Gallina gallina = granja.getGallinas().get(i);
            if (cod.equals(gallina.getCodigo())){
                System.out.println("Digite la cantidad de alimento suministrado(gr): ");
                Alimentacion alimentacion = new Alimentacion ();
                alimentacion.setCantidadAlimiento(teclado.nextDouble());
                alimentacion.setFecha(LocalDate.now());
                gallina.getAlimentaciones().add(alimentacion);
                granja.getInventario().setTotalAlimentacionSuministrada(granja.getInventario().getTotalAlimentacionSuministrada()+alimentacion.getCantidadAlimiento());
                System.out.println("Alimentacion registrada exitosamente");
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
            System.out.println("------------------------------------------------"); 
            System.out.println("Gallina #"+ gallina.getCodigo());
            for (int j = 0; j < gallina.getAlimentaciones().size(); j++) {
                Alimentacion alimentacion = gallina.getAlimentaciones().get(j);
                System.out.println("Cantidad de alimento:" + alimentacion.getCantidadAlimiento());
                System.out.println("Fecha de alimentacion:" + alimentacion.getFecha());
                System.out.println("------------------------------------------------"); 
            }
        }
    }
}
