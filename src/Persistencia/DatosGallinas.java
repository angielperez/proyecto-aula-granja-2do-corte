/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Alimentacion;
import Modelo.Gallina;
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
public class DatosGallinas {
    private String nombreArchivo = "Datos Gallinas.txt";

    public String Guardar(ArrayList<Gallina> lista) {
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.exists()) {
                archivo.delete();
            }
            FileWriter fichero = new FileWriter(this.nombreArchivo);
            PrintWriter pw = new PrintWriter(fichero);
            for (Gallina p : lista) {
                String linea = "";
                linea += p.getCodigo();
                linea += ";";
                linea += p.getPeso();
                pw.println(linea);
            }
            pw.close();
            return "OK";
        } catch (IOException e) {
            return "Ocurrio un error al guardar en el archivo, porfavor cierre el arfchivo si esta abierto";
        }
    }

    public ArrayList<Gallina> Cargar() {
        File f = new File(this.nombreArchivo);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            ArrayList<Gallina> listaGallinas = new ArrayList<>();
            
            DatosProducciones datosProducciones = new DatosProducciones();
            DatosAlimentaciones datosAlimentaciones = new DatosAlimentaciones();
            while (linea != null) {
                Gallina p = new Gallina();
                String datosLinea[] = linea.split(";");
                p.setCodigo(datosLinea[0]);

                String textoPeso = datosLinea[1];
                double peso = Double.parseDouble(textoPeso);
                p.setPeso(peso);
                
                String codigoGallina = p.getCodigo();
                ArrayList<Produccion> produccionesDeLaGallina = datosProducciones.Cargar(codigoGallina);
                p.setProducciones(produccionesDeLaGallina);
                
                ArrayList<Alimentacion> alimentacionesDeLaGallina = datosAlimentaciones.Cargar(codigoGallina);
                p.setAlimentaciones(alimentacionesDeLaGallina);
                
                listaGallinas.add(p);
                linea = br.readLine();
            }

            br.close();
            return listaGallinas;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

}
