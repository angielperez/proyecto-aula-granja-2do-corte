/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Mockup.Ventanas;


import Gestion.GallinaGestion;
import Gestion.VariablesGlobales;
import Gestion.VentaGestion;
import Modelo.Gallina;
import Modelo.Venta;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class VistaGestionVenta extends javax.swing.JFrame {

    /**
     * Creates new form RDueño
     */
    public String escenario = "REGISTRAR";
   
    
    private VentaGestion gestion = new VentaGestion();
    
    public VistaGestionVenta(String escenario) {
        this.escenario = escenario;
        initComponents();
        ValidarEscenario();
    }
    
    
    
    public void ValidarEscenario(){
        if(this.escenario != "REGISTRAR"){
            this.txtCodigo.setEnabled(true);
            this.btnBuscar.setVisible(true);
            this.btnRegistrar.setEnabled(false);
            
        }else{
            this.labelFecha.setVisible(false);
            this.btnBuscar.setVisible(false);
        }
        
        if(this.escenario.equals("EDITAR")){
            btnRegistrar.setText("Actualizar");
        }
        
        if(this.escenario.equals("ELIMINAR")){
            btnRegistrar.setText("Eliminar");
        }
    }
    
    public void Buscar(){
        String codigo = this.txtCodigo.getText();
        if(codigo.isBlank()){
            JOptionPane.showMessageDialog(null, "El campo de codigo es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            Venta venta = gestion.buscar(codigo);
            if(venta != null){
                String valor=String.valueOf(venta.getValor());
                this.txtValorVenta.setText(valor);
                this.txtDescripcion.setText(venta.getDescripcion());
                this.txtCodigo.setText(venta.getCodigo());
                
                String huevosVendidos = String.valueOf(venta.getHuevosVendidos());
                this.txtHuevosVendidos.setText(huevosVendidos);
                this.labelFecha.setVisible(true);
                this.labelFecha.setText("Fecha: " + venta.getFecha().toString());
             
                if(this.escenario.equals("EDITAR")){
                   
                    this.txtCodigo.setEnabled(false);
                    this.btnRegistrar.setEnabled(true);
                }
                
                if(this.escenario.equals("ELIMINAR")){
                     this.btnRegistrar.setEnabled(true);
                }
            }else{
                JOptionPane.showMessageDialog(null, "La Venta no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void Guardar(){
        try {
            String valor = this.txtValorVenta.getText();
            String huevosVendidos= this.txtHuevosVendidos.getText();

            String descripcion= this.txtDescripcion.getText();
            String codigo = this.txtCodigo.getText();

            if(valor.isBlank()){
                JOptionPane.showMessageDialog(null, "El valor de la venta es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            }else if (huevosVendidos.isBlank()){
                JOptionPane.showMessageDialog(null, "La cantidad de huevos es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            }else if (descripcion.isBlank()){
                JOptionPane.showMessageDialog(null, "La descripcion es obligatoria", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(codigo.isBlank()){
                JOptionPane.showMessageDialog(null, "El codigo es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            }else{

                Venta venta = new Venta();
                if(this.escenario.equals("EDITAR")){
                    Venta ventaConDatosAtiguos = gestion.buscar(codigo);
                    venta.setFecha(ventaConDatosAtiguos.getFecha());
                }
                double valordouble = Double.parseDouble(valor); 
                venta.setValor(valordouble);

                int huevosVendidosint =Integer.parseInt(huevosVendidos);
                venta.setHuevosVendidos(huevosVendidosint);
                venta.setDescripcion(descripcion);
                venta.setCodigo(codigo);
                if(this.escenario.equals("REGISTRAR")){
                    venta.setFecha(LocalDate.now());
                }

                String respuestaGuardado= "";
                if(this.escenario == "REGISTRAR"){
                    respuestaGuardado = gestion.guardar(venta);
                }

                if(this.escenario == "EDITAR"){
                    respuestaGuardado = gestion.actualizar(codigo, venta);
                }

                if(respuestaGuardado.equals("OK")){
                    JOptionPane.showMessageDialog(null, "Guardado exitosamente", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, respuestaGuardado, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            //ACA PASO UN ERROR EN CONVERSIONES O CUALQUIER OTRA COSA
            JOptionPane.showMessageDialog(null, "Ocurrio un error al validar la información, porfavor verifique los datos", "Error", JOptionPane.ERROR_MESSAGE);

        }
        
    }
    
    public void Eliminar(){
        String codigo = this.txtCodigo.getText();
        if(codigo.isBlank()){
            JOptionPane.showMessageDialog(null, "El codigo es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            String respuesta = gestion.eliminar(codigo);
            JOptionPane.showMessageDialog(null, respuesta, "Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void Volver(){
        VistaMenuVenta vista = new VistaMenuVenta();
        vista.setVisible(true);
        this.dispose();     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tituloGranja = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtValorVenta = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtHuevosVendidos = new javax.swing.JTextField();
        labelFecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Codigo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Descripcion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, -1));

        jLabel3.setText("Información de la Venta");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        tituloGranja.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tituloGranja.setText("GESTION VENTA ");
        getContentPane().add(tituloGranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrar.setText("Guardar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 130, 30));

        btnVolver.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 130, 30));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Valor de la Venta:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        txtValorVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorVentaActionPerformed(evt);
            }
        });
        getContentPane().add(txtValorVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 170, -1));

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 170, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Huevos Vendidos:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        txtHuevosVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHuevosVendidosActionPerformed(evt);
            }
        });
        getContentPane().add(txtHuevosVendidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 170, -1));

        labelFecha.setText("Fecha:");
        getContentPane().add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/Imagenes/Persona2.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(this.escenario.equals("ELIMINAR")){
           Eliminar();
        }else{
            Guardar();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Volver();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtValorVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorVentaActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtHuevosVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHuevosVendidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHuevosVendidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel tituloGranja;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtDescripcion;
    public static javax.swing.JTextField txtHuevosVendidos;
    public static javax.swing.JTextField txtValorVenta;
    // End of variables declaration//GEN-END:variables
}
