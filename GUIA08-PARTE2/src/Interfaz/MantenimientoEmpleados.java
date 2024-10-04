/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Clases.ArregloEmpleados;
import Clases.Empleado;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hector
 */
public class MantenimientoEmpleados extends javax.swing.JFrame {

    //Definimos el modelo para asignar el Jtable
    DefaultTableModel modEmpleados;
    //CRear el objeto de la clase ArregloEmpleados
    ArregloEmpleados vectorEmp = new ArregloEmpleados();
    
    //Variable para dar formato a valores con decimales
    DecimalFormat df;
    
    public MantenimientoEmpleados() {
        initComponents();
        
        //Asignacion del formato de decimales para dinero
        df = new DecimalFormat("$##0.00");
        
        //Asociamos al modelo nuestro control Jtable
        modEmpleados = (DefaultTableModel)tblEmpleados.getModel();
        
        /*Cambios en la parte 2 
        Permite mostrar los registros en el archivo 
        con el nombre Empleados.txt
        */
        listar();
    }
    
    
    int obtenerCodigo(){
        return Integer.parseInt(txtCodigo.getText());
    }
    
    String obtenerEmpleado(){
        return txtEmpleado.getText();
    }
    
    double obtenerHoras(){
        return Double.parseDouble(txtHoras.getText());        
    }
    
    double obtenerTarifa(){
        return Double.parseDouble(txtTarifa.getText());
    }
    
    //Metodo que valida el ingreso de los datos del usuario
    String validar(){
        //Validamos que no quede sin datos y sea un valor entero el codigo del empleado
        if (txtCodigo.getText().equals("") || Integer.parseInt(txtCodigo.getText()) < 0) {
            txtCodigo.requestFocus();       //Le asignamos el enfoque 
            return "Codigo del empleado";   // Mensaje a mostrar
        }  //Validamos que no quede sin datos el nombre del empleado
        else if (txtEmpleado.getText().equals("")) {
            txtEmpleado.requestFocus(); // Le asignamos el enfoque
            return "Nombre del empleado";   //Mensaje a mostrar donde a saber            
        } // Validamos que no quede sin datos y sea un valor double la cantidad de horas
        else if (txtHoras.getText().equals("") || Double.parseDouble(txtHoras.getText()) < 0) {
            txtHoras.requestFocus(); // Le asiganmos el enfoque
            return "Hora de trabajo"; // Mensaje a mostrar
        } // Validamos que no quede sin datos y sea un valor double el valor por hora
        else if (txtTarifa.getText().equals("") || Double.parseDouble(txtTarifa.getText()) < 0) {
            txtHoras.requestFocus(); // le asignamos el enfoque
            return "Monto de tarifa "; //Mensaje a mostrar            
        }else {
            return "";
        }
    }
    
    //Método para limpiar la tabla de empleados
    void limpiarTabla(){
        //Detenerminar la cantidad de filar que tiene el Jtable
        int count = tblEmpleados.getModel().getRowCount();
        
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                tblEmpleados.setValueAt("", i, 0);
                tblEmpleados.setValueAt("", i, 1);
                tblEmpleados.setValueAt("", i, 2);
                tblEmpleados.setValueAt("", i, 3);
                tblEmpleados.setValueAt("", i, 4);
            }
        }
    }
    
    //Método para listar los valores de la tabla 
    void listar(){
        limpiarTabla();
        
        //Cambiamos para implementar parte 2
        //Verificamos que el vector tenga datos almacenados
        if (vectorEmp.obtenerTamaño() > 0) {
            for (int i = 0; i < vectorEmp.obtenerTamaño(); i++) {
                modEmpleados.addRow(new Object[]{0,"",0,0,0}); //Agregamos una fila vacia al jTable
                tblEmpleados.setValueAt(vectorEmp.obtenerEmpleado(i).getCodigo(), i, 0);
                tblEmpleados.setValueAt(vectorEmp.obtenerEmpleado(i).getNombre(), i, 1);
                tblEmpleados.setValueAt(vectorEmp.obtenerEmpleado(i).getHoras(), i, 2);
                tblEmpleados.setValueAt(df.format(vectorEmp.obtenerEmpleado(i).getTarifa()), i, 3);
                tblEmpleados.setValueAt(df.format(vectorEmp.obtenerEmpleado(i).getTarifa()
                        * vectorEmp.obtenerEmpleado(i).getHoras()), i, 4);
                //para centrar el contenido de la celda del jtable
                DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
                centrar.setHorizontalAlignment(SwingConstants.CENTER);
                for (int j = 0; j < 5; j++) {
                    tblEmpleados.getColumnModel().getColumn(j).setCellRenderer(centrar);
                }
            }
        }
    }
    
    //Método para limpiar los JtextField
    void limpiarControles(){
        txtCodigo.setText("");
        txtEmpleado.setText("");
        txtHoras.setText("");
        txtTarifa.setText("");
    }
    
    
    
    
    
    

    @Override
    protected void validateTree() {
        super.validateTree(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtEmpleado = new javax.swing.JTextField();
        txtHoras = new javax.swing.JTextField();
        txtTarifa = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        pnlMantenimento = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnGuardarArchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("MATENIMIENTO EMPLEADOS");

        txtCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder("CÓDIGO"));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder("EMPLEADO"));

        txtHoras.setBorder(javax.swing.BorderFactory.createTitledBorder("HORAS"));
        txtHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorasActionPerformed(evt);
            }
        });

        txtTarifa.setBorder(javax.swing.BorderFactory.createTitledBorder("TARIFA"));

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnListar.setText("LISTAR");
        btnListar.setEnabled(false);
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        pnlMantenimento.setBorder(javax.swing.BorderFactory.createTitledBorder("MANTENIMIENTO"));

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnConsultar.setText("CONSULTAR");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGrabar.setText("GRABAR");
        btnGrabar.setEnabled(false);
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMantenimentoLayout = new javax.swing.GroupLayout(pnlMantenimento);
        pnlMantenimento.setLayout(pnlMantenimentoLayout);
        pnlMantenimentoLayout.setHorizontalGroup(
            pnlMantenimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMantenimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGrabar)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        pnlMantenimentoLayout.setVerticalGroup(
            pnlMantenimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMantenimentoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlMantenimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnConsultar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGrabar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Empleado", "Horas", "Tarifa", "Pago"
            }
        ));
        jScrollPane1.setViewportView(tblEmpleados);

        btnGuardarArchivo.setText("GUARDAR EN EL ARCHIVO");
        btnGuardarArchivo.setEnabled(false);
        btnGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtHoras, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(txtCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEmpleado)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlMantenimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo)
                    .addComponent(txtEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtHoras, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addComponent(txtTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMantenimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorasActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
           listar();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
           try {
               //si no hay errores en el ingreso de datos por el usuario
               if (validar().equals("")) {
                   //Creamos un objeto de la clase empleado
                   Empleado objEmp = new Empleado(obtenerCodigo(),obtenerEmpleado(),obtenerHoras(), obtenerTarifa());
                   
                   //Invocar el metodo para agregar empleado de la clase ArregloEmpleados
                   vectorEmp.adiciona(objEmp);
                   modEmpleados.addRow(new Object[]{0,"",0,0,0});
                   limpiarControles(); //Limpiamos el JtextField
                   listar();
                   btnListar.setEnabled(true); //Habilitamos el boton "listar"         
                   
                   //cambios complementados de la parte 2
                   btnGuardarArchivo.setEnabled(true); //habilitamos el boton "guardar en el archivo"
                   btnRegistrar.setEnabled(false); //deshabilitamos el botón "registrar"
               }else{
                   JOptionPane.showMessageDialog(null,"Falta introducir dato en " +validar());
               }
           } catch(Exception ex){
               JOptionPane.showMessageDialog(null, "Error en el tipo de datos introducido");
           }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            //solicitamos el usuario el codigo de cliente a buscar?
            int codigoBuscar = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el codigo a modificar"));
            
            //Buscar si el codigo del empleado existe en el arreglo
            int pos = vectorEmp.buscar(codigoBuscar);
            
            //Si el codigo existe en el arreglo
            if (pos != -1) {
                //Devuelve los datos del empleado encontrado
                Empleado x = vectorEmp.obtenerEmpleado(pos);
                //Habilitar el boton btnGrabar y desabilitar el boton btnModificar
                btnGrabar.setEnabled(true);
                btnModificar.setEnabled(false);
                //Se muestra el codigo del empleado y se bloquea
                txtCodigo.setText("" + codigoBuscar);
                txtCodigo.setEditable(false);
                //Se envian los valores desde el arreglo a los controles
                txtEmpleado.setText(x.getNombre());
                txtHoras.setText("" + x.getHoras());
                txtTarifa.setText("" + x.getTarifa());
                txtEmpleado.requestFocus();                
            } else{
                //Mensaje de error cuando el codigo del empleado no existe
                JOptionPane.showMessageDialog(null,"Código no existe");
            }                        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error en la aplicación..");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
          try {
            //Buscar si el codigo del empleado existe en el arreglo
            int pos = vectorEmp.buscar(obtenerCodigo());
            //Si existe, la posicion es enviada al arreglo para devolver-
            //el empleado buscado
            Empleado x = vectorEmp.obtenerEmpleado(pos);
            //Actualizamos los valores del empleado en el vector
            x.setNombre(obtenerEmpleado());
            x.setHoras(obtenerHoras());
            x.setTarifa(obtenerTarifa());
            
            //Mostramos mensaje de acción realizada
            JOptionPane.showMessageDialog(null,"Empleado actualizado correctamente",
                    "Confirmación",JOptionPane.INFORMATION_MESSAGE);
            
            //cambios para la parte 2
            //llamamos al metodo "grabar"
            vectorEmp.grabar();
            listar();
            
            //Deshabilitamos el boton btnGrabar y habilitar el boton btnModificar
            btnGrabar.setEnabled(false);
            btnModificar.setEnabled(true);            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar..", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        try {
            limpiarTabla();
            //Solicitamos el código del empleado a consultar
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese código a buscar"));
            //El código es enviado al método buscar
            int pos = vectorEmp.buscar(codigo);
            
            //Si el código no existe en el arreglo
            if (pos == -1) {
                JOptionPane.showMessageDialog(null, "COdigo del empleado no existe");
            }else{
                //Si existe el codigo, se muestran los valores en el control tblEmpleados
                tblEmpleados.setValueAt(vectorEmp.obtenerEmpleado(pos).getCodigo(),0,0);
                tblEmpleados.setValueAt(vectorEmp.obtenerEmpleado(pos).getNombre(),0,1);
                tblEmpleados.setValueAt(vectorEmp.obtenerEmpleado(pos).getHoras(),0,2);
                tblEmpleados.setValueAt(df.format(vectorEmp.obtenerEmpleado(pos).getTarifa()),0,3);
                tblEmpleados.setValueAt(df.format(vectorEmp.obtenerEmpleado(pos).getTarifa() * 
                        vectorEmp.obtenerEmpleado(pos).getHoras()),0,4);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en la aplicación..");
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
           try {
               //Solicitamos el código del empleado a eliminar
               int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el código a eliminar: "));
               
               //Ell código es enviado al método buscar
               int pos = vectorEmp.buscar(codigo);
               
               //SI el código existe en el arreglo
               if (pos != -1) {
                   //Llamamos al método eliminar del arreglo
                   vectorEmp.eliminar(codigo);
                   //Eliminamos la fila del control jTable
                   modEmpleados.removeRow(pos);
                   //Mostramos mensaje de acción realizada
                   JOptionPane.showMessageDialog(null, "Empleado eliminado...");    
                   
                   //cambios para la parte 2
                   //llamamos al metodo "grabar" y "listar"
                   vectorEmp.grabar();
                   listar();
               }else{
                   JOptionPane.showMessageDialog(null, "No existe el empleado indicado !");
               }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No existe el empleado indicado !");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Definimos una variable que almacenara el resultado de la respuesta dada por el usuario
        int respuesta = JOptionPane.showOptionDialog(this,"¿Esta seguro/a que desea salir?",
                "Mantenimiento de Empleados", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,null,null);
        //Verificamos si el usuario di+o click en el botón "YES"
        if (respuesta == 0){
            System.exit(0);
        }
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArchivoActionPerformed
        //Llamamos el método que escribe en el archivo de texto 
        vectorEmp.grabar();
        
        btnGuardarArchivo.setEnabled(false); //deshabilitamos el boton "Grabar archivo"
        btnRegistrar.setEnabled(true); //Habilitamos el botón "Registrar"
    }//GEN-LAST:event_btnGuardarArchivoActionPerformed

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
            java.util.logging.Logger.getLogger(MantenimientoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnGuardarArchivo;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlMantenimento;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtTarifa;
    // End of variables declaration//GEN-END:variables
}
