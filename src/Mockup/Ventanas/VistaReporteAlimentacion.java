/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Mockup.Ventanas;



import Gestion.AlimentacionGestion;
import Gestion.GallinaGestion;
import Gestion.ProduccionGestion;
import Gestion.VariablesGlobales;
import Modelo.Alimentacion;
import Modelo.Gallina;
import Modelo.Produccion;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author angie
 */
public class VistaReporteAlimentacion extends javax.swing.JFrame {   
    
    private AlimentacionGestion gestion = new AlimentacionGestion();
    private GallinaGestion gestionGallina = new GallinaGestion();
    
    public VistaReporteAlimentacion() {
        initComponents();
    }
    
    
    public void Buscar(){
        String codigo = this.txtCodigo.getText();
        if(codigo.isBlank()){
            JOptionPane.showMessageDialog(null, "El campo de codigo es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            Gallina gallina = gestionGallina.buscar(codigo);
            if(gallina != null){
                DefaultTableModel modelo =  (DefaultTableModel) tabla.getModel();
                
                //BORRAMOS LOS DATOS Q TENIA ANTES
                int a =modelo.getRowCount()-1;  //Índices van de 0 a n-1
                for(int i=a;i>=0;i--){ 
                    modelo.removeRow(i);
                }
                
                //AGREGAMOS A LA TABLA LA LISTA DE PRODUCCIONES
                for (Alimentacion alimentacion : gallina.getAlimentaciones()) {
                    modelo.addRow(new Object[] {alimentacion.getFecha().toString(), alimentacion.getCantidadAlimiento()});
                }
                tabla.setModel(modelo);
            }else{
                JOptionPane.showMessageDialog(null, "La Gallina no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
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
        tituloGranja = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 150, -1));

        tituloGranja.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tituloGranja.setText("Alimentacion");
        getContentPane().add(tituloGranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        Volver.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 130, 30));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Codigo Gallina:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Cantidad de Alimento"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 460, 220));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mockup/Imagenes/Huevos2.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, -1, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        VistaMenuPrincipal vista = new VistaMenuPrincipal();
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Volver;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel tituloGranja;
    public static javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
