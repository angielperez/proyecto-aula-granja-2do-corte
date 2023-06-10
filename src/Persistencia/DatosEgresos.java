/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;


import Modelo.Egreso;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Angie Perez
 */
public class DatosEgresos {

    private String nombreArchivo = "Datos Egresos.txt";

    public String Guardar(ArrayList<Egreso> lista) {
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.exists()) {
                archivo.delete();
            }
            FileWriter fichero = new FileWriter(this.nombreArchivo);
            PrintWriter pw = new PrintWriter(fichero);
            for (Egreso p : lista) {
                String linea = "";
                linea += p.getCodigo();
                linea += ";";
                linea += p.getValor();
                linea += ";";
                linea += p.getDescripcion();
                linea += ";";
                linea += p.getFecha().toString();
             
                pw.println(linea);
            }
            pw.close();
            return "OK";
        } catch (IOException e) {
            return "Ocurrio un error al guardar en el archivo, porfavor cierre el arfchivo si esta abierto";
        }
    }

    public ArrayList<Egreso> Cargar() {
        File f = new File(this.nombreArchivo);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            ArrayList<Egreso> listaEgreso = new ArrayList<>();
            while (linea != null) {
                Egreso p = new Egreso();
                String datosLinea[] = linea.split(";");
                p.setCodigo(datosLinea[0]);

                String textoValor = datosLinea[1];
                double valor = Double.parseDouble(textoValor);
                p.setValor(valor);
                p.setDescripcion(datosLinea[2]);

                String textoFecha = datosLinea[3];
                LocalDate fecha = LocalDate.parse(textoFecha);
                p.setFecha(fecha);
                
                listaEgreso.add(p);
                linea = br.readLine();
            }

            br.close();
            return listaEgreso;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

}
