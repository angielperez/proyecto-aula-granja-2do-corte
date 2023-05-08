/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import static Gestion.VariablesGlobales.granja;
import Interfaces.IGestionMovimientoCaja;
import Modelo.Gasto;
import Modelo.Ingreso;
import Modelo.MovimientoCaja;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class MovimientoCajaGestion implements IGestionMovimientoCaja{

    @Override
    public String guardar(String tipoMov) {
        Scanner teclado = new Scanner(System.in);
        MovimientoCaja mov = new MovimientoCaja();
        System.out.print("Digite el código: ");
        mov.setCodigo(teclado.nextLine());
        System.out.print("Digite la descripcion: ");
        mov.setDescripcion(teclado.nextLine());
        System.out.print("Digite el valor: ");
        mov.setValor(teclado.nextDouble());
        System.out.print("Digite el dia : ");
        int dia = teclado.nextInt();
        System.out.print("Digite el mes : ");
        int mes = teclado.nextInt();
        System.out.print("Digite el año : ");
        int año = teclado.nextInt();
        LocalDate fecha = LocalDate.of(año, mes, dia);
        mov.setFecha(fecha);
        mov.setEstado("ACTIVO");
        
        if(tipoMov.equals("INGRESO")){
            granja.getCaja().getIngresos().add((Ingreso) mov);
        }else{
            granja.getCaja().getGastos().add((Gasto) mov);
        }
        return "Se registro exitosamente.";
    }

    @Override
    public String anular(String tipoMov) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite el codigo del movimiento: ");
        String cod = teclado.nextLine();
        int posicionBusqueda = buscarObtenerPosicion(cod, tipoMov);
        if(posicionBusqueda == -1){
            return "El movimiento de caja no existe";
        }else{
            if(tipoMov.equals("INGRESO")){
                granja.getCaja().getIngresos().get(posicionBusqueda).setEstado("ANULADO");
            }else{
                granja.getCaja().getGastos().get(posicionBusqueda).setEstado("ANULADO");
            }
            return "Se anulo exitosamente";
        }
    }

    @Override
    public void imprimir(String tipoMov) {
        System.out.println("------------------INGRESOS------------------");
        for (int i = 0; i < granja.getCaja().getIngresos().size(); i++) {
            Ingreso ingreso = granja.getCaja().getIngresos().get(i);
            ingreso.mostrarReportes();
        }
        
        System.out.println("------------------GASTOS------------------");
        for (int i = 0; i < granja.getCaja().getGastos().size(); i++) {
            Gasto gasto = granja.getCaja().getGastos().get(i);
            gasto.mostrarReportes();
        }
    }
    
    public int buscarObtenerPosicion(String cod, String tipoMov){
        if(tipoMov.equals("INGRESO")){
            for (int i = 0; i < granja.getCaja().getIngresos().size(); i++) {
                Ingreso ingreso = granja.getCaja().getIngresos().get(i);
                if(ingreso.getCodigo().equals(cod)){
                    return i;
                }
            }
        }else{
            for (int i = 0; i < granja.getCaja().getGastos().size(); i++) {
                Gasto gasto = granja.getCaja().getGastos().get(i);
                if(gasto.getCodigo().equals(cod)){
                    return i;
                }
            }
        }
        return -1;
    }

   

    
}
