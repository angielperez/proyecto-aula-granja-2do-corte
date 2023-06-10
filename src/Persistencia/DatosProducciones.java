/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Gallina;
import Modelo.Gasto;
import Modelo.Ingreso;
import Modelo.Produccion;
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
public class DatosProducciones {
    private String nombreArchivo = "Datos Producciones Gallinas {CODIGO_GALLINA}.txt";

    public String Guardar(ArrayList<Produccion> lista, String codigoGallina) {
        try {
            String nombre = nombreArchivo.replace("{CODIGO_GALLINA}", codigoGallina);
            File archivo = new File(nombre );
            if (archivo.exists()) {
                archivo.delete();
            }
            FileWriter fichero = new FileWriter(nombre);
            PrintWriter pw = new PrintWriter(fichero);
            for (Produccion p : lista) {
                String linea = "";
                linea += codigoGallina;
                linea += ";";
                linea += p.getCantidadHuevos();
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
    
    public ArrayList<Produccion> Cargar(String codigoGallina) {
        String nombre = nombreArchivo.replace("{CODIGO_GALLINA}", codigoGallina);
        File archivo = new File(nombre );
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            ArrayList<Produccion> listaProduccion = new ArrayList<>();
            while (linea != null) {
                
                String datosLinea[] = linea.split(";");
                String codigoGallinaEnLinea = datosLinea[0];
                if(codigoGallinaEnLinea.equals(codigoGallina)){
                    Produccion p = new Produccion();

                    String textoCantidadHuevos = datosLinea[1];
                    int cantidadHuevos = Integer.parseInt(textoCantidadHuevos);
                    p.setCantidadHuevos(cantidadHuevos);

                    String textoFecha = datosLinea[2];
                    LocalDate fecha = LocalDate.parse(textoFecha);
                    p.setFecha(fecha);
                    listaProduccion.add(p);
                }
                linea = br.readLine();
            }

            br.close();
            return listaProduccion;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
