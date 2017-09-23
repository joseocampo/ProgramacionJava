package automata.vista;

import automata.modelo.Modelo;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PanelEstados extends JPanel {

    public PanelEstados() {
        super();
        this.modelo = null;
        configurar();
    }

    private void configurar() {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void definirModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public void paintComponent(Graphics bg) {
        super.paintComponent(bg);
        if (modelo != null) {
            modelo.dibujar((Graphics2D) bg);
        }
    }

    private Modelo modelo;
}
