/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Mockup.Ventanas;

import Gestion.AccionistaGestion;
import Gestion.VariablesGlobales;
import Modelo.Accionista;
import Modelo.Caja;
import Modelo.Direccion;
import Modelo.Dueño;
import Modelo.Granja;
import Modelo.Inventario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class VistaGestionAccionista extends javax.swing.JFrame {

    /**
     * Creates new form RDueño
     */
    public String escenario = "REGISTRAR";
    public boolean volverIngreso = false;

    private AccionistaGestion gestion = new AccionistaGestion();

    public VistaGestionAccionista(String escenario) {
        this.escenario = escenario;
        initComponents();
        ValidarEscenario();
    }

    public void ValidarEscenario() {
        if (this.escenario != "REGISTRAR") {
            this.txtIdentificacion.setEnabled(true);
            this.txtNombre.setEnabled(false);
            this.txtPais.setEnabled(false);
            this.txtCiudad.setEnabled(false);
            this.txtNomenclatura.setEnabled(false);
            this.txtInversion.setEnabled(false);
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
        String id = this.txtIdentificacion.getText();
        if (id.isBlank()) {
            JOptionPane.showMessageDialog(null, "El campo identificación es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Accionista accionista = gestion.buscar(id);
            if (accionista != null) {
                this.txtNombre.setText(accionista.getNombre());
                this.txtIdentificacion.setText(accionista.getId());
                this.txtPais.setText(accionista.getDireccion().getPais());
                this.txtCiudad.setText(accionista.getDireccion().getCiudad());
                this.txtNomenclatura.setText(accionista.getDireccion().getNomenclatura());
                this.txtInversion.setText(String.valueOf(accionista.getInversion()));

                if (this.escenario.equals("EDITAR")) {

                    this.txtIdentificacion.setEnabled(false);
                    this.txtNombre.setEnabled(true);
                    this.txtPais.setEnabled(true);
                    this.txtCiudad.setEnabled(true);
                    this.txtNomenclatura.setEnabled(true);
                    this.txtInversion.setEnabled(true);
                    this.btnRegistrar.setEnabled(true);
                }

                if (this.escenario.equals("ELIMINAR")) {
                    this.btnRegistrar.setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El accionista no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void Guardar() {
        try {
            String nombre = this.txtNombre.getText();
            String id = this.txtIdentificacion.getText();
            String pais = this.txtPais.getText();
            String ciudad = this.txtCiudad.getText();
            String nomenclatura = this.txtNomenclatura.getText();
            String inversion = this.txtInversion.getText();
            if (nombre.isBlank()) {
                JOptionPane.showMessageDialog(null, "El campo nombre es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (id.isBlank()) {
                JOptionPane.showMessageDialog(null, "El identificacion pais es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (pais.isBlank()) {
                JOptionPane.showMessageDialog(null, "El campo pais es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (ciudad.isBlank()) {
                JOptionPane.showMessageDialog(null, "El campo ciudad es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (nomenclatura.isBlank()) {
                JOptionPane.showMessageDialog(null, "El campo nomenclatura es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (inversion.isBlank()) {
                JOptionPane.showMessageDialog(null, "El campo inversion es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                double totalInversion = 0;
                try {
                    totalInversion = Double.parseDouble(inversion);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "El campo inversion no es un numero valido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Accionista accionista = new Accionista();
                accionista.setNombre(nombre);
                accionista.setId(id);

                Direccion direccion = new Direccion();
                direccion.setPais(pais);
                direccion.setCiudad(ciudad);
                direccion.setNomenclatura(nomenclatura);
                accionista.setDireccion(direccion);
                accionista.setInversion(totalInversion);
                String respuestaGuardado = "";
                if (this.escenario == "REGISTRAR") {
                    respuestaGuardado = gestion.guardar(accionista);
                }

                if (this.escenario == "EDITAR") {
                    respuestaGuardado = gestion.actualizar(id, accionista);
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
        String id = this.txtIdentificacion.getText();
        if (id.isBlank()) {
            JOptionPane.showMessageDialog(null, "El identificacion pais es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String respuesta = gestion.eliminar(id);
            JOptionPane.showMessageDialog(null, respuesta, "Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void Volver() {
        VistaMenuAccionistas vista = new VistaMenuAccionistas();
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

        txtNombre = new javax.swing.JTextField();
        txtIdentificacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tituloGranja = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNomenclatura = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtInversion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 170, -1));

        txtIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificacionActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Identificacion:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        jLabel3.setText("Información del accionista");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        tituloGranja.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tituloGranja.setText("GRANJA SAN MARTIN");
        getContentPane().add(tituloGranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrar.setText("Guardar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 130, 30));

        Volver.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 130, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ciudad:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        txtNomenclatura.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNomenclatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomenclaturaActionPerformed(evt);
            }
        });
        getContentPane().add(txtNomenclatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 170, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Direccion:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Pais:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        txtCiudad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadActionPerformed(evt);
            }
        });
        getContentPane().add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 170, 20));

        txtPais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaisActionPerformed(evt);
            }
        });
        getContentPane().add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 170, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Inversion:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, -1));

        txtInversion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtInversion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInversionActionPerformed(evt);
            }
        });
        getContentPane().add(txtInversion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 170, 20));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/Imagenes/Persona2.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificacionActionPerformed
    }//GEN-LAST:event_txtIdentificacionActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (this.escenario.equals("ELIMINAR")) {
            Eliminar();
        } else {
            Guardar();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        Volver();
    }//GEN-LAST:event_VolverActionPerformed

    private void txtNomenclaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomenclaturaActionPerformed
        this.txtNomenclatura.getText();
    }//GEN-LAST:event_txtNomenclaturaActionPerformed

    private void txtCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadActionPerformed

    private void txtPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaisActionPerformed

    private void txtInversionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInversionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInversionActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Volver;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel tituloGranja;
    private javax.swing.JTextField txtCiudad;
    public static javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtInversion;
    public static javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNomenclatura;
    private javax.swing.JTextField txtPais;
    // End of variables declaration//GEN-END:variables
}
