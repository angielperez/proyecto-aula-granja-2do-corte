package Mockup;

import Gestion.AccionistaGestion;
import Gestion.AlimentacionGestion;
import Gestion.DueñoGestion;
import Gestion.GallinaGestion;
import Gestion.GranjaGestion;

import Gestion.ProduccionGestion;
import Gestion.ReporteGestion;
import Gestion.VariablesGlobales;
import static Gestion.VariablesGlobales.datosGranja;
import static Gestion.VariablesGlobales.granja;
import static Gestion.VariablesGlobales.vistaPrincipal;
import Gestion.VentaGestion;
import Mockup.Ventanas.VistaLogin;
import Persistencia.DatosGranja;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Principal {
    
    public static void main(String[] args) {
        //menuCreacionInicial();
        VariablesGlobales.granja = datosGranja.Cargar();
        VariablesGlobales.vistaPrincipal.setVisible(true);
    }
    
    /*public static void menuCreacionInicial(){
        
        int opcion;
        boolean creacionInicialRealizada = false;
        do{
            Scanner teclado = new Scanner(System.in);
            if(granja != null && granja.getDueño() != null){
                creacionInicialRealizada = true;
            }
            System.out.println("***** Menu de creacion inicial ****");
            System.out.println("**** 1. Gestionar Granja ****");
            System.out.println("**** 2. Gestionar Usuarios ****");
            System.out.println("**** 3. Salir ****");
            System.out.print("**** Presione la opcion que desee: ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    menuGestionGranja();
                    break;
                case 2:
                    menuGestionUsuarios();
                    break;
                case 3:
                    
                    break;
                
            }
        } while ((opcion>0) && (opcion<3) && creacionInicialRealizada == false);
        
        if(creacionInicialRealizada == true){
            validarInicioSesion();
        }
    }
    
    public static void menuGestionGranja(){
        
        int opcion;
        GranjaGestion gestion = new GranjaGestion();
        do{
            Scanner teclado = new Scanner(System.in);
            System.out.println("***** Menu Granja ****");
            System.out.println("**** 1. Registrar ****");
            System.out.println("**** 2. Actualizar ****");
            System.out.println("**** 3. Imprimir ****");
            System.out.println("**** 4. Salir ****");
            System.out.print("**** Presione la opcion que desee: ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    String respuesta1 = gestion.guardar();
                    System.out.println(respuesta1);
                    break;
                case 2:
                    String respuesta2 = gestion.actualizar();
                    System.out.println(respuesta2);
                    break;
                case 3:
                    gestion.imprimir();
                    break;
                
            }
        } while ((opcion>0) && (opcion<3));
    }
    
    public static void menuGestionUsuarios(){
        int opcion;
        DueñoGestion gestionDueño = new DueñoGestion();
        AccionistaGestion gestionAccionista = new AccionistaGestion();
        do{
            Scanner teclado = new Scanner(System.in);
            System.out.println("***** Menu Usuarios ****");
            System.out.println("**** 1. Registrar Dueño ****");
            System.out.println("**** 2. Registrar Accionista ****");
            System.out.println("**** 3. Actualizar Dueño ****");
            System.out.println("**** 4. Actualizar Accionista ****");
            System.out.println("**** 5. Imprimir Dueño ****");
            System.out.println("**** 6. Imprimir Accionistas ****");
            System.out.println("**** 7. Salir ****");
            System.out.print("**** Presione la opcion que desee: ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    System.out.println(gestionDueño.guardar());
                    teclado.next();
                    break;
                case 2:
                    System.out.println(gestionAccionista.guardar());
                    teclado.next();
                    break;
                case 3:
                    System.out.println(gestionDueño.actualizar());
                    teclado.next();
                    break;
                case 4:
                    System.out.println(gestionAccionista.actualizar());
                    teclado.next();
                    break;
                case 5:
                    gestionDueño.imprimir();
                    teclado.next();
                    break;
                case 6:
                    gestionAccionista.imprimir();
                    teclado.next();
                    break;
                case 7:
                    break;
                
            }
        } while ((opcion>0) && (opcion<7));
    }
    
    public static void validarInicioSesion(){
        char continuar = 'S';
        while (continuar == 'S'){
            Scanner teclado = new Scanner(System.in);
            System.out.print("Digite su usuario: ");
            String usuario = teclado.nextLine();
            System.out.print("Digite su contraseña: ");
            String contraseña = teclado.nextLine();
            if (granja.getDueño().getCuenta().getUsuario().equals(usuario) && granja.getDueño().getCuenta().getContraseña().equals(contraseña)){
                continuar = 'N';
                menuPrincipal();
            }
            else {
                System.out.println("Credenciales inválidas.");
                System.out.println("¿Desea intentarlo nuevamente (S/N)?");
                char opt = teclado.next().charAt(0);
                continuar = Character.toUpperCase(opt);
            }
        }
    }
    
    public static void menuPrincipal(){    
        int opcion;
        do{
            Scanner teclado = new Scanner(System.in);
            System.out.println("***** Menu de Opciones ****");
            System.out.println("**** 1. Gestionar Granja ****");
            System.out.println("**** 2. Gestionar Usuarios ****");
            System.out.println("**** 3. Gestionar Gallinas ****");
            System.out.println("**** 4. Gestionar Ingresos ****");
            System.out.println("**** 5. Gestionar Gastos ****");
            System.out.println("**** 6. Gestionar Produccion por gallina ****");
            System.out.println("**** 7. Gestionar Alimentacion por gallina ****");
            System.out.println("**** 8. Gestionar Ventas ****");
            System.out.println("**** 9. Reportes ****");
            System.out.println("**** 10. Salir ****");
            System.out.print("**** Presione la opcion que desee: ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    menuGestionGranja();
                    break;
                case 2:
                    menuGestionUsuarios();
                    break;
                case 3:
                    menuGestionGallinas();
                    break;
                case 4:
                    menuGestionMovimientoCaja("INGRESO");
                    break;
                case 5:
                    menuGestionMovimientoCaja("GASTO");
                    break;
                case 6:
                    menuProduccion();
                    break;
                case 7:
                    menuAlimentacion();
                    break;
                case 8:
                    menuVentas();
                    break;
                case 9:
                    menuReportes();
                    break;
                case 10:
                    break;
            }
        } while ((opcion>0) && (opcion<9));
    }

    public static void menuGestionGallinas(){
        int opcion;
        GallinaGestion gestion = new GallinaGestion();
        do{
            Scanner teclado = new Scanner(System.in);
            System.out.println("***** Menu Gallinas ****");
            System.out.println("**** 1. Registrar ****");
            System.out.println("**** 2. Actualizar ****");
            System.out.println("**** 3. Consultar ****");
            System.out.println("**** 4. Imprimir ****");
            System.out.println("**** 5. Salir ****");
            System.out.print("**** Presione la opcion que desee: ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    System.out.println(gestion.guardar());
                    teclado.next();
                    break;
                case 2:
                    System.out.println(gestion.actualizar());
                    teclado.next();
                    break;
                case 3:
                    gestion.consultar();
                    teclado.next();
                    break;
                case 4:
                    gestion.imprimir();
                    teclado.next();
                    break;
                case 5:
                    break;
                
            }
        } while ((opcion>0) && (opcion<5));
    }
    
    public static void menuGestionMovimientoCaja(String tipoMov){
        int opcion;
        MovimientoCajaGestion gestion = new MovimientoCajaGestion();
        do{
            Scanner teclado = new Scanner(System.in);
            System.out.println("***** Menu "+tipoMov+" ****");
            System.out.println("**** 1. Registrar ****");
            System.out.println("**** 2. Anular ****");
            System.out.println("**** 3. Imprimir ****");
            System.out.println("**** 4. Salir ****");
            System.out.print("**** Presione la opcion que desee: ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    System.out.println(gestion.guardar(tipoMov));
                    teclado.next();
                    break;
                case 2:
                    System.out.println(gestion.anular(tipoMov));
                    teclado.next();
                    break;
                case 3:
                    gestion.imprimir(tipoMov);
                    teclado.next();
                    break;
                case 4:
                    break;
                
            }
        } while ((opcion>0) && (opcion<4));
    }
    
    public static void menuProduccion(){
        
        int opcion;
        ProduccionGestion gestion = new ProduccionGestion();
        do{
            Scanner teclado = new Scanner(System.in);
            System.out.println("***** Menu Produccion ****");
            System.out.println("**** 1. Registrar ****");
            System.out.println("**** 2. Imprimir ****");
            System.out.println("**** 3. Salir ****");
            System.out.print("**** Presione la opcion que desee: ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    System.out.println(gestion.guardar());
                    teclado.next();
                    break;
                case 2:
                    gestion.imprimir();
                    teclado.next();
                    break;
                case 3:
                    break;
                
            }
        } while ((opcion>0) && (opcion<3));
    }
    
    public static void menuVentas(){
        int opcion;
        VentaGestion gestion = new VentaGestion();
        do{
            Scanner teclado = new Scanner(System.in);
            System.out.println("***** Menu Venta ****");
            System.out.println("**** 1. Registrar ****");
            System.out.println("**** 2. Salir ****");
            System.out.print("**** Presione la opcion que desee: ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    System.out.println(gestion.guardar());
                    teclado.next();
                    break;
                case 2:
                    break;
                
            }
        } while ((opcion>0) && (opcion<2));
    }
    
    public static void menuReportes(){
        int opcion;
        ReporteGestion gestion = new ReporteGestion();
        do{
            Scanner teclado = new Scanner(System.in);
            System.out.println("***** Menu Reportes ****");
            System.out.println("**** 1. Reporte de inventario ****");
            System.out.println("**** 2. Reporte de caja ****");
            System.out.println("**** 3. Salir ****");
            System.out.print("**** Presione la opcion que desee: ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    gestion.reporteInventario();
                    teclado.next();
                    break;
                case 2:
                    gestion.reporteCaja();
                    teclado.next();
                    break;
                case 3:
                    break;
            }
        } while ((opcion>0) && (opcion<3));
    }

    private static void menuAlimentacion() {
        int opcion;
        AlimentacionGestion gestion = new AlimentacionGestion();
        do{
            Scanner teclado = new Scanner(System.in);
            System.out.println("***** Menu Alimentacion ****");
            System.out.println("**** 1. Registrar ****");
            System.out.println("**** 2. Imprimir ****");
            System.out.println("**** 3. Salir ****");
            System.out.print("**** Presione la opcion que desee: ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    System.out.println(gestion.guardar());
                    teclado.next();
                    break;
                case 2:
                    gestion.imprimir();
                    teclado.next();
                    break;
                case 3:
                    break;
                
            }
        } while ((opcion>0) && (opcion<3));
    }*/
}