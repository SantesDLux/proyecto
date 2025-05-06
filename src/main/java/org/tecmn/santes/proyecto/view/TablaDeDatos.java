/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.tecmn.santes.proyecto.view;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.tecmn.santes.proyecto.controller.MaterialPrestadoController;
import org.tecmn.santes.proyecto.model.MaterialPrestado;

/**
 *
 * @author José Santes
 */
public class TablaDeDatos extends javax.swing.JFrame {

    private final MaterialPrestadoController controller;

    public TablaDeDatos() {
        initComponents();
        this.controller = new MaterialPrestadoController();
        cargarDatosEnTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        miTabla = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(944, 866));

        miTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Alumno", "Docente", "Categoria", "Materia", "Cantidad", "horario_materia", "fecha_prestamo", "fecha_devolucion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(miTabla);

        btnRemove.setText("Eliminar");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuItem1.setText("Acerca de");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemove))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemove)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Software desarrollado para la materia de programacion visual");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        String id = miTabla.getValueAt(miTabla.getSelectedRow(), 0).toString();
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar este material?\nEsta acción no se puede deshacer.",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmacion == JOptionPane.YES_OPTION) {
            // Convertir el String a ObjectId y eliminar
            org.bson.types.ObjectId objectId = new org.bson.types.ObjectId(id);

            // Llamar al método del controlador para eliminar el material
            controller.eliminarMaterial(objectId);

            JOptionPane.showMessageDialog(this,
                    "Material eliminado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

            cargarDatosEnTabla();

        }
    }//GEN-LAST:event_btnRemoveActionPerformed

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
            java.util.logging.Logger.getLogger(TablaDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaDeDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemove;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable miTabla;
    // End of variables declaration//GEN-END:variables

    /**
     * Carga los datos de los materiales prestados en la tabla
     */
    private void cargarDatosEnTabla() {
        try {
            // Verificar que el controlador esté inicializado
            if (this.controller == null) {
                System.err.println("Error: el controlador no está inicializado");
                JOptionPane.showMessageDialog(this,
                        "Error: No se pudo conectar con la base de datos",
                        "Error de conexión",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear un modelo de tabla no editable por defecto
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Hacer que las celdas no sean editables
                }
            };

            // Definir las columnas
            modelo.addColumn("ID");
            modelo.addColumn("Producto");
            modelo.addColumn("Solicitante");
            modelo.addColumn("Categoría");
            modelo.addColumn("Docente");
            modelo.addColumn("Materia");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Fecha Préstamo");
            modelo.addColumn("Hora Entrega");
            modelo.addColumn("Fecha Devolución");

            // Obtener datos de la base de datos
            List<MaterialPrestado> materiales = null;
            try {
                materiales = controller.obtenerMateriales();
                System.out.println("Cantidad de materiales obtenidos: "
                        + (materiales != null ? materiales.size() : "null"));

                // Verificar si la lista está vacía
                if (materiales == null || materiales.isEmpty()) {
                    System.out.println("No se encontraron materiales para mostrar");
                    JOptionPane.showMessageDialog(this,
                            "No hay materiales para mostrar.",
                            "Información",
                            JOptionPane.INFORMATION_MESSAGE);
                    miTabla.setModel(modelo);
                    return;
                }
            } catch (Exception e) {
                System.err.println("Error al obtener materiales: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Error al cargar datos: " + e.getMessage(),
                        "Error de Base de Datos",
                        JOptionPane.ERROR_MESSAGE);
                miTabla.setModel(modelo);
                return;
            }

            // Agregar filas al modelo
            for (MaterialPrestado m : materiales) {
                try {
                    if (m == null) {
                        System.out.println("Se encontró un material nulo, continuando...");
                        continue;
                    }

                    Object[] fila = new Object[10];
                    // Manejo seguro del ID
                    fila[0] = (m.get_id() != null) ? m.get_id().toHexString() : "N/A";
                    fila[1] = m.getNombre_producto() != null ? m.getNombre_producto() : "";
                    fila[2] = m.getNombre_solicitante() != null ? m.getNombre_solicitante() : "";
                    fila[3] = m.getCategoria() != null ? m.getCategoria() : "";
                    fila[4] = m.getNombre_docente() != null ? m.getNombre_docente() : "";
                    fila[5] = m.getNombre_materia() != null ? m.getNombre_materia() : "";
                    fila[6] = m.getCantidad();
                    fila[7] = m.getFecha_prestamo() != null ? m.getFecha_prestamo() : "";
                    fila[8] = m.getHora_entrega() != null ? m.getHora_entrega() : "";
                    fila[9] = m.getFecha_devolucion() != null ? m.getFecha_devolucion() : "";

                    modelo.addRow(fila);
                } catch (Exception e) {
                    System.err.println("Error al procesar material: " + e.getMessage());
                    e.printStackTrace();
                    // Continuar con el siguiente material
                }
            }

            // Verificar que la tabla no sea nula antes de asignarle el modelo
            if (miTabla == null) {
                System.err.println("Error: el componente de tabla no está inicializado");
                return;
            }

            // Asignar el modelo a la tabla
            miTabla.setModel(modelo);

            // Mejorar la apariencia de la tabla
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            // Configurar cada columna
            for (int i = 0; i < miTabla.getColumnCount(); i++) {
                TableColumn column = miTabla.getColumnModel().getColumn(i);
                column.setCellRenderer(centerRenderer);

                // Ajustar anchos según el tipo de columna
                switch (i) {
                    case 0: // ID
                        column.setPreferredWidth(80);
                        break;
                    case 6: // Cantidad
                        column.setPreferredWidth(70);
                        break;
                    case 7: // Fecha Préstamo
                    case 8: // Hora Entrega
                    case 9: // Fecha Devolución
                        column.setPreferredWidth(120);
                        break;
                    default:
                        column.setPreferredWidth(150);
                        break;
                }
            }

            // Configuración adicional de la tabla
            miTabla.setRowHeight(25);
            miTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            miTabla.getTableHeader().setReorderingAllowed(false);
            miTabla.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

            // Actualizar la interfaz de usuario
            miTabla.repaint();
            miTabla.revalidate();

            System.out.println("Tabla cargada con " + modelo.getRowCount() + " filas");

        } catch (Exception e) {
            System.err.println("Error general al cargar la tabla: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error en la interfaz: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
