package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Angie Perez
 */
public class Granja {
    
    private String nombre;
    private Dueño dueño;
    private ArrayList <Accionista> accionistas = new ArrayList();
    private Direccion direccion;
    private Caja caja;
    private Inventario inventario;
    private ArrayList <Gallina> gallinas = new ArrayList();

    public Granja() {

    }

    public Granja(String nombre, Dueño dueño, Direccion direccion, Caja caja, Inventario inventario) {
        this.nombre = nombre;
        this.dueño = dueño;
        this.direccion = direccion;
        this.caja = caja;
        this.inventario = inventario;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * @return the dueño
     */
    public Dueño getDueño() {
        return dueño;
    }

    /**
     * @param dueño the dueño to set
     */
    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    /**
     * @return the accionistas
     */
    public ArrayList <Accionista> getAccionistas() {
        return accionistas;
    }

    /**
     * @param accionistas the accionistas to set
     */
    public void setAccionistas(ArrayList <Accionista> accionistas) {
        this.accionistas = accionistas;
    }

    /**
     * @return the direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the caja
     */
    public Caja getCaja() {
        return caja;
    }

    /**
     * @param caja the caja to set
     */
    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    /**
     * @return the inventario
     */
    public Inventario getInventario() {
        return inventario;
    }

    /**
     * @param inventario the inventario to set
     */
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    /**
     * @return the gallinas
     */
    public ArrayList <Gallina> getGallinas() {
        return gallinas;
    }

    /**
     * @param gallinas the gallinas to set
     */
    public void setGallinas(ArrayList <Gallina> gallinas) {
        this.gallinas = gallinas;
    }
}