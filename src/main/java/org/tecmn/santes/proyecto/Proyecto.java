package org.tecmn.santes.proyecto;

import javax.swing.*;
import org.tecmn.santes.proyecto.bd.BDConexion;

public class Proyecto {
    
    /**
     * Método principal que inicia la aplicación.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Configurar look and feel nativo
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
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}

/**
 * Clase que define la ventana principal de la aplicación.
 * Esta es una ventana vacía para verificar la conexión a la base de datos.
 */
class MainFrame extends JFrame {
    
    public MainFrame() {
        // Configurar ventana
        setTitle("Sistema de Gestión de Materiales Prestados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // Ventana vacía - sin componentes adicionales
    }
}