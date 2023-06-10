/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Mockup.Ventanas.VistaLogin;
import Modelo.Granja;
import Persistencia.DatosAccionistas;
import Persistencia.DatosAlimentaciones;
import Persistencia.DatosDueño;
import Persistencia.DatosEgresos;
import Persistencia.DatosGallinas;
import Persistencia.DatosGranja;
import Persistencia.DatosIngresos;
import Persistencia.DatosProducciones;
import Persistencia.DatosVentas;
import java.util.Scanner;

/**
 *
 * @author Angie Perez
 */
public class VariablesGlobales {
    public static Granja granja;
    public static VistaLogin vistaPrincipal  = new VistaLogin(); 
    public static DatosGranja datosGranja = new DatosGranja();
    public static DatosGallinas datosGallinas = new DatosGallinas();
    public static DatosDueño datosDueño = new DatosDueño();
    public static DatosAccionistas datosAccionistas = new DatosAccionistas();
    public static DatosProducciones datosProducciones = new DatosProducciones();
    public static DatosAlimentaciones datosAlimentaciones = new DatosAlimentaciones();
    public static DatosVentas datosVentas = new DatosVentas();
    public static DatosIngresos datosIngresos = new DatosIngresos();
    public static DatosEgresos datosEgresos = new DatosEgresos();
}
