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
    
    public void agregar(Point loc,int tipo,String etiqueta) {
        datos.agregar(loc,tipo,etiqueta);
    }
    
    public void borrarUltimo() {
        datos.borrarUltimo();
    }
    
    public void borrarTodos() {
        datos.borrarTodos();
    }

    public void ponerEtiqueta(String e) {
        datos.ponerEtiqueta(e);
    }
    public void ponerTipo(int t){
        datos.ponerTipo(t);
    }
    private Modelo datos;
}
