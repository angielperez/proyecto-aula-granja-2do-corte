/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Direccion;
import Modelo.Granja;
import Modelo.Inventario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Angie Perez
 */
public class DatosGranja {

    private String nombreArchivo = "Datos Granja.txt";

    public String Guardar(Granja p) {
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.exists()) {
                archivo.delete();
            }
            FileWriter fichero = new FileWriter(this.nombreArchivo);
            PrintWriter pw = new PrintWriter(fichero);
            String linea = "";
            linea += p.getNombre();
            linea += ";";
            linea += p.getDireccion().getPais();
            linea += ";";
            linea += p.getDireccion().getCiudad();
            linea += ";";
            linea += p.getDireccion().getNomenclatura();
            linea += ";";
            linea += p.getInventario().getTotalAlimentacionSuministrada();
            linea += ";";
            linea += p.getInventario().getTotalHuevos();
            pw.println(linea);
            pw.close();
            return "OK";
        } catch (IOException e) {
            return "Ocurrio un error al guardar en el archivo, por favor cierre el archivo si esta abierto";
        }
    }

    public Granja Cargar() {
        try {
            File f = new File(this.nombreArchivo);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            Granja granja = new Granja();
            while (linea != null) {
                String datosLinea[] = linea.split(";");
                granja.setNombre(datosLinea[0]);
                Direccion direccion = new Direccion();
                direccion.setPais(datosLinea[1]);
                direccion.setCiudad(datosLinea[2]);
                direccion.setNomenclatura(datosLinea[3]);
                granja.setDireccion(direccion);

                Inventario inventario = new Inventario();
                String textoTotalAlimentacion = datosLinea[4];
                double totalAlimentacion = Double.parseDouble(textoTotalAlimentacion);
                inventario.setTotalAlimentacionSuministrada(totalAlimentacion);

                String textoTotalHuevos = datosLinea[5];
                int totalHuevos = Integer.parseInt(textoTotalHuevos);
                inventario.setTotalHuevos(totalHuevos);

                granja.setInventario(inventario);
                linea = br.readLine();
            }

            if (granja.getNombre() == null) {
                return null;
            }

            //LE ASIGNAMOS A LA GRANJA TODOS SUS OBJETOS
            DatosDueño datosDueño = new DatosDueño();
            granja.setDueño(datosDueño.Cargar());
            DatosAccionistas datosAccionistas = new DatosAccionistas();
            granja.setAccionistas(datosAccionistas.Cargar());
            DatosCaja datosCaja = new DatosCaja();
            granja.setCaja(datosCaja.Cargar());

            br.close();
            return granja;
        } catch (IOException e) {
            return null;
        }
    }
}
