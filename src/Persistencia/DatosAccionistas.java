/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Accionista;
import Modelo.Direccion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angie Perez
 */
public class DatosAccionistas {

    private String nombreArchivo = "Datos Accionista.txt";

    public String Guardar(ArrayList<Accionista> lista) {
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.exists()) {
                archivo.delete();
            }
            FileWriter fichero = new FileWriter(this.nombreArchivo);
            PrintWriter pw = new PrintWriter(fichero);
            for (Accionista p : lista) {
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
                linea += p.getInversion();
                pw.println(linea);
            }
            
            pw.close();
            return "OK";
        } catch (IOException e) {
            return "Ocurrio un error al guardar en el archivo, porfavor cierre el arfchivo si esta abierto";
        }
    }

    public ArrayList<Accionista> Cargar() {
        File f = new File(this.nombreArchivo);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            ArrayList<Accionista> listaAccionista = new ArrayList<>();
            while (linea != null) {
                Accionista p = new Accionista();
                String datosLinea[] = linea.split(";");
                p.setId(datosLinea[0]);
                p.setNombre(datosLinea[1]);

                Direccion direccion = new Direccion();
                direccion.setPais(datosLinea[2]);
                direccion.setCiudad(datosLinea[3]);
                direccion.setNomenclatura(datosLinea[4]);
                p.setDireccion(direccion);

                String textoInversion = datosLinea[5];
                double inversion = Double.parseDouble(textoInversion);
                p.setInversion(inversion);
                listaAccionista.add(p);

                linea = br.readLine();
            }

            br.close();
            return listaAccionista;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

}
