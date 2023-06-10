/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestion;
import Modelo.Cuenta;
import Modelo.Direccion;
import Modelo.Dueño;
import java.util.Scanner;

/**
 *
 * @author  Angie Perez

 */
public class DueñoGestion implements IGestion{

    @Override
    public String guardar() {
        Scanner teclado = new Scanner(System.in);
        if(granja.getDueño() == null){
            Dueño dueño = new Dueño();
            Direccion direccion = new Direccion();
            Cuenta cuenta = new Cuenta();
            System.out.print("Digite la identificacion: "); 
            dueño.setId(teclado.nextLine());
            System.out.print("Digite el nombre: "); 
            dueño.setNombre(teclado.nextLine());
            System.out.print("Digite el pais:");
            direccion.setPais(teclado.nextLine());
            System.out.print("Digite la ciudad:");
            direccion.setCiudad(teclado.nextLine());
            System.out.print("Digite la nomenclatura:");
            direccion.setNomenclatura(teclado.nextLine());
            
            System.out.print("Digite el usuario:");
            cuenta.setUsuario(teclado.nextLine());
            System.out.print("Digite la contraseña:");
            cuenta.setContraseña(teclado.nextLine());
            
            dueño.setDireccion(direccion);
            dueño.setCuenta(cuenta);
            
            granja.setDueño(dueño);

            return "Se registro exitosamente";
        }else{
            return "La granja ya tiene un dueño registrado";
        }
    }

    @Override
    public String actualizar() {
        Scanner teclado = new Scanner(System.in);
        String id;
        System.out.println("Por seguridad, digite la identificacion");
        id = teclado.nextLine();
        if(granja.getDueño() == null){
            return "La granja no tiene un dueño registrado";
        }else if(id.equals(granja.getDueño().getId()) == false){
            return "La identificacion no coincide con la del dueño de la granja";
        }else{
            Dueño dueño = new Dueño();
            Direccion direccion = new Direccion();
            Cuenta cuenta = new Cuenta();
            System.out.print("Digite la identificacion: "); 
            dueño.setId(teclado.nextLine());
            System.out.print("Digite el nombre: "); 
            dueño.setNombre(teclado.nextLine());
            System.out.print("Digite el pais:");
            direccion.setPais(teclado.nextLine());
            System.out.print("Digite la ciudad:");
            direccion.setCiudad(teclado.nextLine());
            System.out.print("Digite la nomenclatura:");
            direccion.setNomenclatura(teclado.nextLine());
            
            System.out.print("Digite el usuario:");
            cuenta.setUsuario(teclado.nextLine());
            System.out.print("Digite la contraseña:");
            cuenta.setContraseña(teclado.nextLine());
            
            dueño.setDireccion(direccion);
            dueño.setCuenta(cuenta);
            
            granja.setDueño(dueño);
            return "Se actualizo exitosamente";
        }
    }

    @Override
    public void imprimir() {
        
        System.out.println("-----------------------------------------------------");
        System.out.println("Identificacion: "+ granja.getDueño().getId());
        System.out.println("Nombre: "+ granja.getDueño().getNombre());
        System.out.println("Pais: "+ granja.getDueño().getDireccion().getPais());
        System.out.println("Ciudad: "+ granja.getDueño().getDireccion().getCiudad());
        System.out.println("Nomenclatura: "+ granja.getDueño().getDireccion().getNomenclatura());
        System.out.println("Usuario: "+ granja.getDueño().getCuenta().getContraseña());
        System.out.println("-----------------------------------------------------");
    }
    
}
