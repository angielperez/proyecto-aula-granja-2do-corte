package Modelo;

/**
 *
 * @author Angie Perez
 */
public class Direccion {
    
    private String pais;
    private String ciudad;
    private String nomenclatura;

    public Direccion() {
    }

    public Direccion(String pais, String ciudad, String nomenclatura) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.nomenclatura = nomenclatura;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the numero
     */
    public String getNomenclatura() {
        return nomenclatura;
    }

    /**
     * @param numero the numero to set
     */
    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    @Override
    public String toString() {
        return "Direccion{" + "pais=" + pais + ", ciudad=" + ciudad + ", numero=" + nomenclatura + '}';
    }
}