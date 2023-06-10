/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Cuenta;
import Modelo.Direccion;
import Modelo.Dueño;
import Modelo.Granja;
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
public class DatosDueño {

    private String nombreArchivo = "Datos Dueño.txt";

    public String Guardar(Dueño p) {
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.exists()) {
                archivo.delete();
            }
            FileWriter fichero = new FileWriter(this.nombreArchivo);
            PrintWriter pw = new PrintWriter(fichero);
            String linea = "";
            linea += p.getId();
            linea += ";";
            linea += p.getNombre();
            linea += ";";
            linea += p.getDireccion().getPais();
            linea += ";";
            linea += p.getDireccion().getCiudad();
            linea += ";";
            linea += p.getDireccion().getNomenclatura();
            linea += ";";
            linea += p.getCuenta().getUsuario();
            linea += ";";
            linea += p.getCuenta().getContraseña();
            pw.println(linea);
            pw.close();
            return "OK";
        } catch (IOException e) {
            return "Ocurrio un error al guardar en el archivo, porfavor cierre el arfchivo si esta abierto";
        }
    }

    public Dueño Cargar() {
        File f = new File(this.nombreArchivo);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            Dueño p = new Dueño();
            while (linea != null) {
                String datosLinea[] = linea.split(";");
                p.setId(datosLinea[0]);
                p.setNombre(datosLinea[1]);

                Direccion direccion = new Direccion();
                direccion.setPais(datosLinea[2]);
                direccion.setCiudad(datosLinea[3]);
                direccion.setNomenclatura(datosLinea[4]);

                p.setDireccion(direccion);

                Cuenta cuenta = new Cuenta();
                cuenta.setUsuario(datosLinea[5]);
                cuenta.setContraseña(datosLinea[6]);
                p.setCuenta(cuenta);

                linea = br.readLine();
            }
            if (p.getId() == null) {
                return null;
            }
            br.close();
            return p;
        } catch (IOException e) {
            return null;
        }
    }
}
