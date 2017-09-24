package automata;

import automata.control.ControlAplicacion;
import automata.modelo.Modelo;
import automata.vista.VentanaAplicacion;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class automata {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | UnsupportedLookAndFeelException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mostrarInterfaz();
            }

        });
    }

    public static void mostrarInterfaz() {
        new VentanaAplicacion("Ejemplo marcadores",
                new ControlAplicacion(new Modelo())).init();
    }
//probando cambios en git
}
