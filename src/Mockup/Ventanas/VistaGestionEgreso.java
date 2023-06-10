/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Mockup.Ventanas;

import Gestion.EgresoGestion;
import Gestion.GallinaGestion;
import Gestion.VariablesGlobales;
import Modelo.Egreso;
import Modelo.Gallina;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class VistaGestionEgreso extends javax.swing.JFrame {

    /**
     * Creates new form RDueño
     */
    public String escenario = "REGISTRAR";

    private EgresoGestion gestion = new EgresoGestion();

    public VistaGestionEgreso(String escenario) {
        this.escenario = escenario;
        initComponents();
        ValidarEscenario();
    }

    public void ValidarEscenario() {
        if (this.escenario != "REGISTRAR") {
            this.txtCodigo.setEnabled(true);

            this.btnBuscar.setVisible(true);
            this.btnRegistrar.setEnabled(false);

        } else {
            this.btnBuscar.setVisible(false);
        }

        if (this.escenario.equals("EDITAR")) {
            btnRegistrar.setText("Actualizar");
        }

        if (this.escenario.equals("ELIMINAR")) {
            btnRegistrar.setText("Eliminar");
        }
    }

    public void Buscar() {
        String codigo = this.txtCodigo.getText();
        if (codigo.isBlank()) {
            JOptionPane.showMessageDialog(null, "El campo de codigo es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Egreso egreso = gestion.buscar(codigo);
            if (egreso != null) {
                String valor = String.valueOf(egreso.getValor());
                this.txtValorEgreso.setText(valor);
                this.txtDescripcion.setText(egreso.getDescripcion());
                this.txtCodigo.setText(egreso.getCodigo());

                this.labelFecha.setVisible(true);
                this.labelFecha.setText("Fecha: " + egreso.getFecha().toString());

                if (this.escenario.equals("EDITAR")) {

                    this.txtCodigo.setEnabled(false);
                    this.btnRegistrar.setEnabled(true);
                }

                if (this.escenario.equals("ELIMINAR")) {
                    this.btnRegistrar.setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El Egreso no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void Guardar() {
        try {
            String valor = this.txtValorEgreso.getText();

            String descripcion = this.txtDescripcion.getText();
            String codigo = this.txtCodigo.getText();

            if (valor.isBlank()) {
                JOptionPane.showMessageDialog(null, "El valor del Egreso es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (descripcion.isBlank()) {
                JOptionPane.showMessageDialog(null, "La descripcion es obligatoria", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (codigo.isBlank()) {
                JOptionPane.showMessageDialog(null, "El codigo es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                Egreso egreso = new Egreso();
                if (this.escenario.equals("EDITAR")) {
                    Egreso egresoConDatosAntiguos = gestion.buscar(codigo);
                    egreso.setFecha(egresoConDatosAntiguos.getFecha());
                }
                double valordouble = Double.parseDouble(valor);
                egreso.setValor(valordouble);

                egreso.setDescripcion(descripcion);
                egreso.setCodigo(codigo);
                if (this.escenario.equals("REGISTRAR")) {
                    egreso.setFecha(LocalDate.now());
                }

                String respuestaGuardado = "";
                if (this.escenario == "REGISTRAR") {
                    respuestaGuardado = gestion.guardar(egreso);
                }

                if (this.escenario == "EDITAR") {
                    respuestaGuardado = gestion.actualizar(codigo, egreso);
                }

                if (respuestaGuardado.equals("OK")) {
                    JOptionPane.showMessageDialog(null, "Guardado exitosamente", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, respuestaGuardado, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            //ACA PASO UN ERROR EN CONVERSIONES O CUALQUIER OTRA COSA
            JOptionPane.showMessageDialog(null, "Ocurrio un error al validar la información, porfavor verifique los datos", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void Eliminar() {
        String codigo = this.txtCodigo.getText();
        if (codigo.isBlank()) {
            JOptionPane.showMessageDialog(null, "El codigo es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String respuesta = gestion.eliminar(codigo);
            JOptionPane.showMessageDialog(null, respuesta, "Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void Volver() {
        VistaMenuEgreso vista = new VistaMenuEgreso();
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
        txtValorEgreso = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
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
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        jLabel3.setText("Información del Egreso");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        tituloGranja.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tituloGranja.setText("GESTION EGRESO");
        getContentPane().add(tituloGranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrar.setText("Guardar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 130, 30));

        btnVolver.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 130, 30));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Valor del Egreso:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        txtValorEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorEgresoActionPerformed(evt);
            }
        });
        getContentPane().add(txtValorEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 170, -1));

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 170, 40));

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
        if (this.escenario.equals("ELIMINAR")) {
            Eliminar();
        } else {
            Guardar();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Volver();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtValorEgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorEgresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorEgresoActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel tituloGranja;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtDescripcion;
    public static javax.swing.JTextField txtValorEgreso;
    // End of variables declaration//GEN-END:variables
}
