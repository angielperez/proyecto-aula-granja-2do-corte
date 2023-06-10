/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Caja;
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
public class DatosCaja {

    private String nombreArchivo = "Datos Caja.txt";

    public String Guardar(Caja p) {
        try {
            File archivo = new File(nombreArchivo);
            if(archivo.exists()){
                archivo.delete();
            }
            FileWriter fichero = new FileWriter(this.nombreArchivo);
            PrintWriter pw = new PrintWriter(fichero);
            String linea = "";
            linea += p.getTotalIngresos();
            linea += ";";
            linea += p.getTotalEgresos();
            linea += ";";
            linea += p.getTotalCaja();
            pw.println(linea);
            pw.close();
            return "OK";
        } catch (IOException e) {
            return "Ocurrio un error al guardar en el archivo, porfavor cierre el arfchivo si esta abierto";
        }
    }

    public Caja Cargar() {
        try {
            File f = new File(this.nombreArchivo);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            Caja p = new Caja();
            while (linea != null) {
                String datosLinea[] = linea.split(";");

                String textoIngresos = datosLinea[0];
                double ingresos = Double.parseDouble(textoIngresos);
                p.setTotalIngresos(ingresos);

                String textoEgresos = datosLinea[1];
                double egresos = Double.parseDouble(textoEgresos);
                p.setTotalEgresos(egresos);

                String textoTotalCaja = datosLinea[2];
                double totalCaja = Double.parseDouble(textoTotalCaja);
                p.setTotalCaja(totalCaja);

                linea = br.readLine();
            }

            //LE ASIGNAMOS A LA GRANJA TODOS SUS OBJETOS
            DatosGastos datosGasto = new DatosGastos();
            p.setGastos(datosGasto.Cargar());

            DatosIngresos datosIngresos = new DatosIngresos();
            p.setIngresos(datosIngresos.Cargar());
            
            DatosVentas datosVentas= new DatosVentas(); 
            p.setVentas(datosVentas.Cargar());

            br.close();
            return p;
        } catch (IOException e) {
            return null;
        }
    }
}
