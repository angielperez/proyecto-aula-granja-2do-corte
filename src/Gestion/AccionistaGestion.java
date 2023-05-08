/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestion;
import Modelo.Accionista;
import Modelo.Direccion;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class AccionistaGestion implements IGestion{

    @Override
    public String guardar() {
        Scanner teclado = new Scanner(System.in);
        Accionista accionista = new Accionista();
        Direccion direccion = new Direccion();
        System.out.print("Digite la identificacion: "); 
        accionista.setId(teclado.nextLine());
        System.out.print("Digite el nombre: "); 
        accionista.setNombre(teclado.nextLine());
        System.out.print("Digite el pais:");
        direccion.setPais(teclado.nextLine());
        System.out.print("Digite la ciudad:");
        direccion.setCiudad(teclado.nextLine());
        System.out.print("Digite la nomenclatura:");
        direccion.setNomenclatura(teclado.nextLine());

        System.out.print("Digite la inversion:");
        accionista.setInversion(teclado.nextDouble());
        granja.getAccionistas().add(accionista);

        return "Se registro exitosamente";
    }
    

    @Override
    public String actualizar() {
        Scanner teclado = new Scanner(System.in);
        String id;
        System.out.println("Por seguridad, digite la identificacion");
        id = teclado.nextLine();
        int posicionBusqueda = buscarObtenerPosicion(id);
        if(posicionBusqueda == -1){
            return "El accionista no existe";
        }else{
            Accionista accionista = new Accionista();
            Direccion direccion = new Direccion();
            System.out.print("Digite la identificacion: "); 
            accionista.setId(teclado.nextLine());
            System.out.print("Digite el nombre: "); 
            accionista.setNombre(teclado.nextLine());
            System.out.print("Digite el pais:");
            direccion.setPais(teclado.nextLine());
            System.out.print("Digite la ciudad:");
            direccion.setCiudad(teclado.nextLine());
            System.out.print("Digite la nomenclatura:");
            direccion.setNomenclatura(teclado.nextLine());

            System.out.print("Digite la inversion:");
            accionista.setInversion(teclado.nextDouble());
            
            granja.getAccionistas().set(posicionBusqueda, accionista);
            return "Se actualizo exitosamente";
        }
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < granja.getAccionistas().size(); i++) {
            Accionista accionista = granja.getAccionistas().get(i);
            System.out.println("-----------------------------------------------------");
            System.out.println("Identificacion: "+ accionista.getId());
            System.out.println("Nombre: "+ accionista.getNombre());
            System.out.println("Pais: "+ accionista.getDireccion().getPais());
            System.out.println("Ciudad: "+ accionista.getDireccion().getCiudad());
            System.out.println("Nomenclatura: "+ accionista.getDireccion().getNomenclatura());
            System.out.println("Inversion: "+ accionista.getInversion());
            System.out.println("-----------------------------------------------------");
        }
        
    }
    
    public static Accionista buscar(String id){
        for (int i = 0; i < granja.getAccionistas().size(); i++) {
            Accionista accionista = granja.getAccionistas().get(i);
            if(accionista.getId().equals(id)){
                return accionista;
            }
        }
        return null;
    }
    
    public static int buscarObtenerPosicion(String id){
        for (int i = 0; i < granja.getAccionistas().size(); i++) {
            Accionista accionista = granja.getAccionistas().get(i);
            if(accionista.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    
}
