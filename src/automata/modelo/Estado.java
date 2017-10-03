package automata.modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

public class Estado {

<<<<<<< HEAD
    public Estado(Point loc, int tipo, String etiqueta) {
        this.loc = loc;
        this.n=k++;
=======
    public Estado(Point punto,int tipo,String etiqueta) {
        this.n = k++;
        this.punto = punto;
>>>>>>> 46763c89f2cfb3906e36818a3de7300264cbc40d
        this.tipo = tipo;
        this.etiqueta = etiqueta;
    }

    public Estado(int x, int y,int tipo,String etiqueta) {
        this(new Point(x, y),tipo,etiqueta);
    }
    
    public void dibujar(Graphics2D g) {

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

<<<<<<< HEAD
        g.drawString(String.format("%s%s", etiqueta,n), loc.x + 16, loc.y + 32);
=======
        g.drawString(String.format("%s", etiqueta), punto.x + 16, punto.y + 32);
>>>>>>> 46763c89f2cfb3906e36818a3de7300264cbc40d

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
<<<<<<< HEAD
    int n;
    private Point loc;
=======
    private int n;
    private Point punto;
>>>>>>> 46763c89f2cfb3906e36818a3de7300264cbc40d
    private String etiqueta;

    private int tipo;

}
