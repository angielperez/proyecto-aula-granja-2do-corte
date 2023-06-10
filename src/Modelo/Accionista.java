package Modelo;

/**
 *
 * @author Angie Perez
 */
public class Accionista extends Persona {
    
    private double inversion;

    public Accionista() {
    }

    public Accionista(double inversion) {
        this.inversion = inversion;
    }

    /**
     * @return the inversion
     */
    public double getInversion() {
        return inversion;
    }

    /**
     * @param inversion the inversion to set
     */
    public void setInversion(double inversion) {
        this.inversion = inversion;
    }

    @Override
    public void mostrarInformacion(){
        mostrarInformacionBase();
        System.out.println("Inversion: " + this.getInversion());
    }
    
}