/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestion;
import Modelo.Caja;
import Modelo.Direccion;
import Modelo.Granja;
import Persistencia.DatosGranja;
import java.util.Scanner;

/**
 *
 * @author Angie Perez
 */
public class GranjaGestion implements IGestion{
    
    DatosGranja datosGranja = new DatosGranja();
    
    @Override
    public String guardar() {
        Scanner teclado = new Scanner(System.in);
        if(granja != null){
            return "Ya existe una granja registrada";
        }
        granja = new Granja();
        Direccion direccion = new Direccion();
        System.out.print("Digite el nombre: "); 
        granja.setNombre(teclado.nextLine());
        System.out.print("Digite el pais:");
        direccion.setPais(teclado.nextLine());
        System.out.print("Digite la ciudad:");
        direccion.setCiudad(teclado.nextLine());
        System.out.print("Digite la nomenclatura:");
        direccion.setNomenclatura(teclado.nextLine());
        granja.setDireccion(direccion);
        granja.setCaja(new Caja(0, 0, 0));
        
        return "Se registro exitosamente";
    }

    @Override
    public String actualizar() {
        Scanner teclado = new Scanner(System.in);
        Direccion direccion = new Direccion();
        System.out.print("Digite el nombre: "); 
        granja.setNombre(teclado.nextLine());
        System.out.print("Digite el pais:");
        direccion.setPais(teclado.nextLine());
        System.out.print("Digite la ciudad:");
        direccion.setCiudad(teclado.nextLine());
        System.out.print("Digite la nomenclatura:");
        direccion.setNomenclatura(teclado.nextLine());
        granja.setDireccion(direccion);
        return "Se actualizo exitosamente";
    }

    @Override
    public void imprimir() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Nombre: "+ granja.getNombre());
        System.out.println("Pais: "+ granja.getDireccion().getPais());
        System.out.println("Ciudad: "+ granja.getDireccion().getCiudad());
        System.out.println("Nomenclatura: "+ granja.getDireccion().getNomenclatura());
        System.out.println("-----------------------------------------------------");
    }
    
}
