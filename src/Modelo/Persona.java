/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Angie Perez
 */
public abstract class Persona {
    private String nombre;
    private String id;
    private Direccion direccion = new Direccion();

    public Persona() {
    }

    public Persona(String nombre, String id, Direccion direccion) {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public void mostrarInformacionBase(){
        System.out.println("Id: " + this.getId());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Pais: " + this.getDireccion().getPais());
        System.out.println("Ciudad: " + this.getDireccion().getCiudad());
        System.out.println("Nomenclatura: " + this.getDireccion().getNomenclatura());
    }
    
    public abstract void mostrarInformacion();
}
