/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Mockup.Ventanas;

/**
 *
 * @author Lenovo
 */
public class VistaGestionCaja extends javax.swing.JFrame {

    /**
     * Creates new form VistaMenuAccionistas
     */
    public VistaGestionCaja() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtConsultarCaja = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        txtGestionarVenta = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtGestionarIngreso = new javax.swing.JButton();
        txtGestionarEgreso = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtConsultarCaja.setText("Consultar Caja");
        txtConsultarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsultarCajaActionPerformed(evt);
            }
        });
        jPanel1.add(txtConsultarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 250, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("CAJA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 170, -1));

        txtGestionarVenta.setText("Gestionar Venta");
        txtGestionarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGestionarVentaActionPerformed(evt);
            }
        });
        jPanel1.add(txtGestionarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 250, -1));

        jButton5.setText("Registrar");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 250, -1));

        txtGestionarIngreso.setText("Gestionar Ingreso");
        txtGestionarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGestionarIngresoActionPerformed(evt);
            }
        });
        jPanel1.add(txtGestionarIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 250, -1));

        txtGestionarEgreso.setText("Gestionar Egreso");
        txtGestionarEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGestionarEgresoActionPerformed(evt);
            }
        });
        jPanel1.add(txtGestionarEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 250, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/Imagenes/Granja.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGestionarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGestionarVentaActionPerformed
        VistaMenuVenta vista = new VistaMenuVenta();
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtGestionarVentaActionPerformed

    private void txtConsultarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultarCajaActionPerformed
        // TODO add your handling code here:
        VistaReporteCaja vista = new VistaReporteCaja();
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtConsultarCajaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        VistaMenuPrincipal vista = new VistaMenuPrincipal();
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtGestionarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGestionarIngresoActionPerformed
        // TODO add your handling code here:
        
        VistaMenuIngreso vista = new VistaMenuIngreso(); 
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtGestionarIngresoActionPerformed

    private void txtGestionarEgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGestionarEgresoActionPerformed
        // TODO add your handling code here:
        
        VistaMenuEgreso vista = new VistaMenuEgreso(); 
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtGestionarEgresoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton txtConsultarCaja;
    private javax.swing.JButton txtGestionarEgreso;
    private javax.swing.JButton txtGestionarIngreso;
    private javax.swing.JButton txtGestionarVenta;
    // End of variables declaration//GEN-END:variables
}
