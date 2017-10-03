package automata.modelo;


import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class Modelo extends Observable {

    public Modelo() {
        estados = new ArrayList<>();
    }

    public void agregar(Point loc, int tipo, String etiqueta) {
<<<<<<< HEAD
       if (!hayEstadoInicial() || tipo==2 || tipo == 3) {
        estados.add(new Estado(loc, tipo, etiqueta));
        System.out.println(this);

        setChanged();
        notifyObservers();
=======
        if (!existeInicial()) {
            estados.add(new Estado(loc, tipo, etiqueta));
            System.out.println(this);

            setChanged();
            notifyObservers();
>>>>>>> 46763c89f2cfb3906e36818a3de7300264cbc40d
        }
    }

    public void borrarUltimo() {
        if (!existeInicial()) {
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

        for (Estado m : estados) {
            m.dibujar(g);
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

<<<<<<< HEAD
//    public void ponerEtiqueta(String e) {
//        for (Estado m : estados) {
//            m.setEtiqueta(e);
//        }

//        setChanged();
//        notifyObservers();
//    }
=======
    public boolean existeInicial() {
        if (!estados.isEmpty()) {
            return estados.get(0).getTipo() == 1;
        }
        return false;
    }

    public void ponerTipo() {
        for (Estado m : estados) {
            if (estados.get(0).getTipo() == 0) {
                m.setTipo(1);
            } else if (estados.get(0).getTipo() == 1) {
                return;
            }
>>>>>>> 46763c89f2cfb3906e36818a3de7300264cbc40d

//    public void ponerTipo(int t) {
//        for (Estado m : estados) {
//            m.setTipo(t);
//
//        }
//    }

    public boolean hayEstadoInicial() {
        for (Estado e : estados) {
            if (estados.get(0).getTipo() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean hayEstado2(){
     for (Estado e : estados) {
            if (e.getTipo() == 2) {
                return true;
            }
        }
        return false;
    }
    
    public final List<Estado> estados;
}
