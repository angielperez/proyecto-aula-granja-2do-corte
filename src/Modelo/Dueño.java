package Modelo;

/**
 *
 * @author andre
 */
public class Dueño extends Persona{

    private Cuenta cuenta;
    
    public Dueño() {
    }

    public Dueño(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    @Override
    public void mostrarInformacion(){
        mostrarInformacionBase();
        System.out.println("Usuario: " + this.getCuenta().getUsuario());
    }
}