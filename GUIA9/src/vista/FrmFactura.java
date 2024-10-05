/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.ArregloFactura;
import modelo.Factura;

/**
 *
 * @author LAB
 */
public class FrmFactura extends javax.swing.JFrame {

    //Definir un ArrayList para guardar las facturas
    ArregloFactura facturas = new ArregloFactura();

    //Variable para la numeración de las facturas
    int numFactura = 0;
    // Definir el modelo asociado al table
    DefaultTableModel modFacturas;

    //Definir una variable de control para saber a que botón le han dado click 
    boolean agregar = false;

    public FrmFactura() {
        initComponents();
        //CENTRAR formulario 
        this.setLocationRelativeTo(null);

        //llamar al método configurar tabla
        configurarTabla();
        asignarFecha();
        habilitarTextfield(false);
        
        //Asociar el modelo al table
        modFacturas = (DefaultTableModel) tblFactura.getModel();
    }

    //Método para configurar el control Jtable
    void configurarTabla() {
        //Crear objeto de tipo "TableColumn"
        TableColumn columna;

        //Definir el ancho de cada columna
        columna = tblFactura.getColumnModel().getColumn(0);
        columna.setPreferredWidth(30);
        columna = tblFactura.getColumnModel().getColumn(1);
        columna.setPreferredWidth(50);
        columna = tblFactura.getColumnModel().getColumn(2);
        columna.setPreferredWidth(150);
        columna = tblFactura.getColumnModel().getColumn(3);
        columna.setPreferredWidth(70);

        //indicar los encabezados 
        tblFactura.getTableHeader().setReorderingAllowed(false);
        tblFactura.getTableHeader().setResizingAllowed(false);

        //centrar el texto 
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblFactura.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);
    }

    //Definir un método para bloquear y desbloquear los textfields
    void habilitarTextfield(boolean opcion) {
        txtnumFactura.setEditable(opcion);
        txtfActual.setEditable(opcion);
        txtmontoPagar.setEditable(opcion);
        txtnombreVendedor.setEditable(opcion);
    }

    //Método para limpiar los textfields
    void limpiarCajas() {
        txtnumFactura.setText("");
        txtfActual.setText("");
        txtmontoPagar.setText("");
        txtnombreVendedor.setText("");
    }

    //Método para limpiar la tabla ó Jtable
    void limpiarTabla() {
        //verificar si esta vacio 
        int count = tblFactura.getModel().getRowCount();

        if (count > 0) {
            for (int i = 0; i <= facturas.obtenerTamaño(); i++) {
                tblFactura.setValueAt("", i, 0);
                tblFactura.setValueAt("", i, 1);
                tblFactura.setValueAt("", i, 2);
                tblFactura.setValueAt("", i, 3);
            }
        }
    }

    //Método para llenar la tabla ó mostrar datos en el Jtable
    void mostrar() {
        //verificar si la acción es "agregar"
        if (agregar) {
            //agragar fila vacia a la tabla
            modFacturas.addRow(new Object[]{0, "", 0, ""});
        }

        //Verificar si el ArrayList no esta vacio
        if (facturas.obtenerTamaño() > 0) {
            for (int i = 0; i < facturas.obtenerTamaño(); i++) {
                Factura fact = facturas.obtener(i);

                //enviar los datos al Jtable
                tblFactura.setValueAt(fact.getnFactura(), i, 0);
                tblFactura.setValueAt(fact.getFecha(), i, 1);
                tblFactura.setValueAt(fact.getMonto(), i, 2);
                tblFactura.setValueAt(fact.getVendedor(), i, 3);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay Facturas registradas", "Confimación", JOptionPane.INFORMATION_MESSAGE);
            limpiarTabla();
        }
    }
    
    //Método para capturar lo que digite el usuario
    public int obtenernumeroFactura(){
        return Integer.parseInt(txtnumFactura.getText());
    }
    
    public String obtenerFecha(){
        return txtfActual.getText();
    }
    public double obtenerMonto(){
        return Double.parseDouble(txtmontoPagar.getText());
    }
    public String obtenerNombreVendedor(){
        return txtnombreVendedor.getText();
    }
    
    //Método para generar número de factura
    public int generarNumFactura(){
        numFactura++;
        return numFactura;
    }
    
    //Método para mmostrar la fecha en el control correspondiente
    
    void asignarFecha(){
        //Definir un objeto de tipo "Date"
        Date fecha = new Date();
        //Definiar un objeto para formatear la fecha "DateFormat"
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");        
        //Asignar al Jtextfield la fecha del sistema
        txtfActual.setText(formatoFecha.format(fecha));        
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtnumFactura = new javax.swing.JTextField();
        txtfActual = new javax.swing.JTextField();
        txtnumFactura2 = new javax.swing.JTextField();
        txtmontoPagar = new javax.swing.JTextField();
        txtnombreVendedor = new javax.swing.JTextField();
        jOperaciones = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnguardarModif = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("REGISTRO DE VENTAS - FACTURACIÓN");

        txtnumFactura.setBorder(javax.swing.BorderFactory.createTitledBorder("Número Factura"));
        txtnumFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumFacturaActionPerformed(evt);
            }
        });

        txtfActual.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Actual"));
        txtfActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfActualActionPerformed(evt);
            }
        });

        txtnumFactura2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número Factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 102, 102))); // NOI18N
        txtnumFactura2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumFactura2ActionPerformed(evt);
            }
        });

        txtmontoPagar.setBorder(javax.swing.BorderFactory.createTitledBorder("Mónto a pagar"));
        txtmontoPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmontoPagarActionPerformed(evt);
            }
        });

        txtnombreVendedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre del vendedor"));
        txtnombreVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreVendedorActionPerformed(evt);
            }
        });

        jOperaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones de Mantenimiento"));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-botones-playstation-64.png"))); // NOI18N
        btnRegistrar.setToolTipText("Registrar");
        btnRegistrar.setBorder(null);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setEnabled(false);

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consultar.png"))); // NOI18N
        btnConsultar.setToolTipText("Consultar");
        btnConsultar.setEnabled(false);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setEnabled(false);

        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/listar.png"))); // NOI18N
        btnListar.setToolTipText("Listar");
        btnListar.setEnabled(false);

        btnguardarModif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarModif.png"))); // NOI18N
        btnguardarModif.setToolTipText("Guardar Modificación");
        btnguardarModif.setEnabled(false);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.setEnabled(false);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exit.png"))); // NOI18N
        btnSalir.setToolTipText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jOperacionesLayout = new javax.swing.GroupLayout(jOperaciones);
        jOperaciones.setLayout(jOperacionesLayout);
        jOperacionesLayout.setHorizontalGroup(
            jOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jOperacionesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardarModif, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jOperacionesLayout.setVerticalGroup(
            jOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jOperacionesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardarModif, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Factura", "Fecha venta", "Vendedor", "Monto"
            }
        ));
        jScrollPane1.setViewportView(tblFactura);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtnumFactura2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOperaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtnombreVendedor)
                                .addGap(18, 18, 18)
                                .addComponent(txtmontoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(249, 249, 249)
                                        .addComponent(jLabel1))
                                    .addComponent(txtnumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addComponent(txtfActual, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfActual, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtnumFactura2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmontoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumFacturaActionPerformed

    private void txtfActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfActualActionPerformed

    private void txtnumFactura2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumFactura2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumFactura2ActionPerformed

    private void txtmontoPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmontoPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmontoPagarActionPerformed

    private void txtnombreVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreVendedorActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Crear una variable de control  para que no se cierre de un solo el programa
        int respuesta = JOptionPane.showOptionDialog(this, "¿Estás seguro/a que desea salir?", "Mantenimiento de Facturas", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        //Verificar si el usuario da click en el boton "yes"
        if (respuesta == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
           txtnumFactura.setText("" + generarNumFactura());           
           asignarFecha();           
           txtnombreVendedor.requestFocus();
           habilitarTextfield(true);
           txtmontoPagar.setEditable(true);
           txtnombreVendedor.setEditable(true);
           txtmontoPagar.setText("");
           txtnombreVendedor.setText("");
           agregar = true;
           
           btnConsultar.setVisible(false);
           btnGuardar.setVisible(true);           
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnguardarModif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jOperaciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFactura;
    private javax.swing.JTextField txtfActual;
    private javax.swing.JTextField txtmontoPagar;
    private javax.swing.JTextField txtnombreVendedor;
    private javax.swing.JTextField txtnumFactura;
    private javax.swing.JTextField txtnumFactura2;
    // End of variables declaration//GEN-END:variables
}
