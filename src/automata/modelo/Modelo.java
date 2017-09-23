package automata.modelo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.JOptionPane;

public class Modelo extends Observable {

    public Modelo() {
        estados = new ArrayList<>();
    }

    public void agregar(Point loc) {
        if (!hayEstadoInicial()) {
            estados.add(new Estado(loc));
            System.out.println(this);

            setChanged();
            notifyObservers();
        }
    }

    public void borrarUltimo() {
        if (!estados.isEmpty()) {
            estados.remove(estados.size() - 1);
            System.out.println(this);

            setChanged();
            notifyObservers();
        }
    }

    public void borrarTodos() {
        estados.clear();
        System.out.println(this);

        setChanged();
        notifyObservers();
    }

    public void dibujar(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        Point a = null;
        for (Estado m : estados) {

//            if (a != null) {
//                g.setColor(Color.BLACK);
//                g.drawLine(a.x, a.y, m.obtenerPosicion().x, m.obtenerPosicion().y);
//            }
            m.dibujar(g);

//            a = m.obtenerPosicion();
        }
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("[");
        boolean primerElemento = true;
        for (Estado m : estados) {
            if (!primerElemento) {
                r.append(", ");
            }
            r.append(m);
            primerElemento = false;
        }
        r.append("]");
        return r.toString();
    }

    public void ponerEtiqueta(String e) {
        for (Estado m : estados) {
            m.setEtiqueta(e);

            setChanged();
            notifyObservers();
        }

    }

    public void ponerTipo() {
        for (Estado m : estados) {
            switch (m.getTipo()) {
                case 0:
                    m.setTipo(1);
                    break;
                case 1:
                    m.setTipo(2);
                    break;
                default:
                    m.setTipo(3);
                    break;
            }
            

        }
    }

    private boolean hayEstadoInicial() {
        for (Estado e : estados) {
            if (e.getTipo() == 1) {
                return true;
            }
        }
        return false;
    }

    private final List<Estado> estados;

}
