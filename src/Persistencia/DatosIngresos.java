/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Ingreso;
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
public class DatosIngresos {

    private String nombreArchivo = "Datos Ingresos.txt";

    public String Guardar(ArrayList<Ingreso> lista) {
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.exists()) {
                archivo.delete();
            }
            FileWriter fichero = new FileWriter(this.nombreArchivo);
            PrintWriter pw = new PrintWriter(fichero);
            for (Ingreso p : lista) {
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

    public ArrayList<Ingreso> Cargar() {
        File f = new File(this.nombreArchivo);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            ArrayList<Ingreso> listaIngreso = new ArrayList<>();
            while (linea != null) {
                Ingreso p = new Ingreso();
                String datosLinea[] = linea.split(";");
                p.setCodigo(datosLinea[0]);

                String textoValor = datosLinea[1];
                double valor = Double.parseDouble(textoValor);
                p.setValor(valor);
                p.setDescripcion(datosLinea[2]);

                String textoFecha = datosLinea[3];
                LocalDate fecha = LocalDate.parse(textoFecha);
                p.setFecha(fecha);
                
                listaIngreso.add(p);
                linea = br.readLine();
            }

            br.close();
            return listaIngreso;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

}
