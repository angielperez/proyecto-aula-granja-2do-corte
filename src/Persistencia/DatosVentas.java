/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;


import Modelo.Venta;
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
public class DatosVentas {

    private String nombreArchivo = "Datos Ventas.txt";

    public String Guardar(ArrayList<Venta> lista) {
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.exists()) {
                archivo.delete();
            }
            FileWriter fichero = new FileWriter(this.nombreArchivo);
            PrintWriter pw = new PrintWriter(fichero);
            for (Venta p : lista) {
                String linea = "";
                linea += p.getCodigo();
                linea += ";";
                linea += p.getValor();
                linea += ";";
                linea += p.getDescripcion();
                linea += ";";
                linea += p.getFecha().toString();
                linea += ";";
                linea += p.getHuevosVendidos();
                pw.println(linea);
            }
            pw.close();
            return "OK";
        } catch (IOException e) {
            return "Ocurrio un error al guardar en el archivo, porfavor cierre el arfchivo si esta abierto";
        }
    }

    public ArrayList<Venta> Cargar() {
        File f = new File(this.nombreArchivo);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            ArrayList<Venta> listaVenta = new ArrayList<>();
            while (linea != null) {
                Venta p = new Venta();
                String datosLinea[] = linea.split(";");
                p.setCodigo(datosLinea[0]);
                
               
                String textoValor = datosLinea[1];
                double valor = Double.parseDouble(textoValor);
                p.setValor(valor);
                p.setDescripcion(datosLinea[2]);

                String textoFecha = datosLinea[3];
                LocalDate fecha = LocalDate.parse(textoFecha);
                p.setFecha(fecha);
                
                String textoHuevosVendidos=datosLinea[4];
                int huevosVendidos = Integer.parseInt(textoHuevosVendidos);
                p.setHuevosVendidos(huevosVendidos);
                
              
                listaVenta.add(p);
                linea = br.readLine();
            }

            br.close();
            return listaVenta;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

}
