package org.tecmn.santes.proyecto;

import javax.swing.*;
import org.tecmn.santes.proyecto.bd.BDConexion;
import org.tecmn.santes.proyecto.view.Menu;

public class Proyecto {
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Inicializar la conexión a la base de datos
        try {
            // Llamar a getCollection() para inicializar la conexión
            BDConexion.getCollection();
            System.out.println("Conexión a MongoDB establecida correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Error al conectar con la base de datos: " + e.getMessage(),
                "Error de conexión", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1);
        }
        
        // Lanzar GUI en el Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            Menu mainFrame = new Menu();
            mainFrame.setVisible(true);
        });
    }
}
