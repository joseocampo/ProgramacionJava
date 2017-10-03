package automata.control;

import automata.modelo.Modelo;
import java.awt.Point;
import java.util.Observer;

public class ControlAplicacion {

    public ControlAplicacion(Modelo datos) {
        this.datos = datos;
    }

    public ControlAplicacion() {
        this(new Modelo());
    }

    public void registrar(Observer obs) {
        datos.addObserver(obs);
    }

    public void agregar(Point loc, int tipo, String etiqueta) {
        datos.agregar(loc, tipo, etiqueta);
    }

    public void borrarUltimo() {
        datos.borrarUltimo();
    }

    public void borrarTodos() {
        datos.borrarTodos();
    }

<<<<<<< HEAD
    public Modelo getModelo() {
        return datos;
=======
    
    public void ponerTipo(){
        datos.ponerTipo();
>>>>>>> 46763c89f2cfb3906e36818a3de7300264cbc40d
    }

//    public void ponerEtiqueta(String e) {
//        datos.ponerEtiqueta(e);
//    }

//    public void ponerTipo(int t) {
//        datos.ponerTipo(t);
//    }
    private Modelo datos;
}
