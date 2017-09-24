package automata.vista;

import automata.control.ControlAplicacion;
import automata.modelo.Modelo;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaAplicacion extends JFrame implements Observer {

    public VentanaAplicacion(String titulo, ControlAplicacion nuevoGestor) {
        super(titulo);
        gestorPrincipal = nuevoGestor;
        configurar();
    }

    private void configurar() {
        ajustarComponentes(getContentPane());
        setResizable(true);
        setSize(800, 600);
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void ajustarComponentes(Container c) {
        c.setLayout(new BorderLayout());
        c.add(BorderLayout.CENTER, panelPrincipal = new PanelEstados());
        ajustarMenus(c);

        itemInicial.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                panelPrincipal.addMouseListener(new MouseAdapter() {
                    String s = JOptionPane.showInputDialog("Estado Inicial");
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                        agregarEstado(e.getPoint(),1,s);
                    }

                });
                itemInicial.setEnabled(false);
                panelPrincipal.setEnabled(false);
            }
        });
        itemIntermedio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.addMouseListener(new MouseAdapter() {
                    String s = JOptionPane.showInputDialog("Estado Intermedio");
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                        agregarEstado(e.getPoint(),2,s);
                    }
                });
                panelPrincipal.setEnabled(false);
            }
            
        });

    }

    

    public void ponerTipo() {
        gestorPrincipal.ponerTipo();
    }

    private void ajustarMenus(Container c) {

        barraMenu = new JMenuBar();
        barraMenu.add(menuArchivo = new JMenu("Archivo"));
        menuArchivo.add(itemGuardar = new JMenuItem("Guardar"));
        menuArchivo.add(itemRecuperar = new JMenuItem("Recuperar"));
        menuArchivo.add(itemLimpiar = new JMenuItem("Limpiar"));

        barraMenu.add(menuEstados = new JMenu("Estados"));
        menuEstados.add(itemInicial = new JMenuItem("Inicial"));
        menuEstados.add(itemIntermedio = new JMenuItem("Intermedio"));
        menuEstados.add(itemFinal = new JMenuItem("Final"));

        barraMenu.add(menuVerificar = new JMenu("Verificar"));
        menuVerificar.add(itemHilera = new JMenuItem("nada"));

        setJMenuBar(barraMenu);

    }

    public void init() {
        gestorPrincipal.registrar(this);
        setVisible(true);
    }

    private void agregarEstado(Point loc,int tipo,String etiqueta) {
        gestorPrincipal.agregar(loc,tipo,etiqueta);
    }

    private void borrarUltimoMarcador() {
        gestorPrincipal.borrarUltimo();
    }

    private void borrarMarcadores() {
        gestorPrincipal.borrarTodos();
    }

    @Override
    public void update(Observable obs, Object evt) {
        PanelEstados pm = (PanelEstados) panelPrincipal;
        pm.definirModelo((Modelo) obs);
        pm.repaint();

    }

    private final ControlAplicacion gestorPrincipal;
    private JPanel panelPrincipal;

    private JMenuBar barraMenu;
    private JMenu menuArchivo;
    private JMenu menuEstados;
    private JMenu menuVerificar;
    private JMenuItem itemGuardar;
    private JMenuItem itemRecuperar;
    private JMenuItem itemLimpiar;

    private JMenuItem itemInicial;
    private JMenuItem itemIntermedio;
    private JMenuItem itemFinal;

    private JMenuItem itemHilera;

//hay cambios
}
