package automata.modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

public class Estado {

    public Estado(Point punto,int tipo,String etiqueta) {
        this.n = k++;
        this.punto = punto;
        this.tipo = tipo;
        this.etiqueta = etiqueta;
    }

    public Estado(int x, int y,int tipo,String etiqueta) {
        this(new Point(x, y),tipo,etiqueta);
    }

    public void dibujar(Graphics2D g) {

//        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
        switch (tipo) {
            case 1:
                g.setColor(Color.BLUE);

                break;
            case 2:
                g.setColor(Color.GREEN);

                break;
            default:
                g.setColor(Color.RED);

                break;
        }

        g.fillOval(punto.x - 4, punto.y - 4, 64, 64);

        g.setFont(TIPO_BASE);
        g.setColor(Color.BLACK);

        g.drawString(String.format("%s", etiqueta), punto.x + 16, punto.y + 32);

    }

    @Override
    public String toString() {
        return String.format("{%d, %d}", punto.x, punto.y);
    }

    public Point obtenerPosicion() {
        return punto;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
    private static final Font TIPO_BASE
            = new Font(Font.SANS_SERIF, Font.PLAIN, 20);

    private static int k = 0;
    private int n;
    private Point punto;
    private String etiqueta;

    private int tipo;

}
