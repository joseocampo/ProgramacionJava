package automata.modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

public class Estado {

    public Estado(Point loc) {
        this.n = k++;
        this.loc = loc;
        this.tipo = 0;
        this.etiqueta = " ";
    }

    public Estado(int x, int y) {
        this(new Point(x, y));
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

        g.fillOval(loc.x - 4, loc.y - 4, 64, 64);

        g.setFont(TIPO_BASE);
        g.setColor(Color.BLACK);

        g.drawString(String.format("%s", etiqueta), loc.x + 16, loc.y + 32);

    }

    @Override
    public String toString() {
        return String.format("{%d, %d}", loc.x, loc.y);
    }

    public Point obtenerPosicion() {
        return loc;
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
    private Point loc;
    private String etiqueta;

    private int tipo;

}
