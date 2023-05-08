/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestion;
import Modelo.Gallina;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class GallinaGestion implements IGestion{

    @Override
    public String guardar() {
        Scanner teclado = new Scanner(System.in);
        Gallina gallina = new Gallina();
        System.out.print("Digite el código de la gallina: ");
        gallina.setCodigo(teclado.nextLine());
        System.out.print("Digite el peso en kg de la gallina: ");
        gallina.setPeso(teclado.nextDouble());
        granja.getGallinas().add(gallina);
        return "Se registro exitosamente.";
    }

    @Override
    public String actualizar() {
        Scanner teclado = new Scanner(System.in);
        String id;
        System.out.println("Por seguridad, digite el codigo");
        id = teclado.nextLine();
        int posicionBusqueda = buscarObtenerPosicion(id);
        if(posicionBusqueda == -1){
            return "La gallina no existe";
        }else{
            Gallina gallina = new Gallina();
            System.out.print("Digite el código de la gallina: ");
            gallina.setCodigo(teclado.nextLine());
            System.out.print("Digite el peso en kg de la gallina: ");
            gallina.setPeso(teclado.nextDouble());
            
            granja.getGallinas().set(posicionBusqueda, gallina);
            return "Se actualizo exitosamente";
        }
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < granja.getGallinas().size(); i++) {
            Gallina gallina = granja.getGallinas().get(i);
            gallina.mostrarReportes();
        }
    }
    
    public static int buscarObtenerPosicion(String cod){
        for (int i = 0; i < granja.getGallinas().size(); i++) {
            Gallina gallina = granja.getGallinas().get(i);
            if(gallina.getCodigo().equals(cod)){
                return i;
            }
        }
        return -1;
    }
    
    public Gallina existeGallina(String codigo){
        for (int i = 0; i < granja.getGallinas().size(); i++) {
            Gallina gallina = granja.getGallinas().get(i);
            if(gallina.getCodigo().equals(codigo)){
                return gallina;
            }
        }
        return null;
    }
    
    public void consultar(){
        Scanner teclado = new Scanner(System.in);        
        System.out.print("Digite el codigo de la gallina: ");
        String codigo = teclado.nextLine();
        Gallina gallina = existeGallina(codigo);
        if(gallina == null){
            System.out.println("La gallina no existe");
        }else{
            gallina.mostrarReportes();
        }
    }
    
}
