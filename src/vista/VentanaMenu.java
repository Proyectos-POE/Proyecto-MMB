/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import logica.Jugador;
import tipografiam.Fuentes;

/**
 * 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Yenny Rivas Tello <yenny.rivas@correounivalle.edu.co>
 */
public class VentanaMenu extends JFrame
{ 
    Color moradoClaro;
    Color morado;

    Fuentes tipoFuente;
    private FondoVentana jpFondo;
    private JPanel jpContenido;
    private JLabel lblTitulo;
    private JButton btnJugar;
    private JButton btnParaQueSirve;
    private JButton btnInstrucciones;
    private JTextField boxNombre;
    private JLabel lblNombre;
    
    
    public VentanaMenu()
    {
        inicializarComponentes();
    }

    private void inicializarComponentes() 
    {    
        setTitle("Memorabble-Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(736,489);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        
        tipoFuente= new Fuentes();
        
        jpFondo = new FondoVentana("/Fondo/FondoVentana.png");
        jpFondo.setSize(720,450);
        jpFondo.setLayout(null);
        
        jpContenido = new JPanel();
        jpContenido.setSize(736,489);        
        jpContenido.setBounds(0,0, 736, 489);
        jpContenido.setLayout(null);
        jpContenido.setOpaque(false); 
        
        moradoClaro = new Color(229,204, 255);
        morado = new Color(51,0, 102);
        
        lblTitulo = new JLabel("MEMORABBLE", SwingConstants.CENTER);
        lblTitulo.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,80));  
        lblTitulo.setBounds(0, 70, 726, 100);
        lblTitulo.setForeground(Color.white);
        jpContenido.add(lblTitulo);
        
        btnJugar = new JButton("JUGAR");
        btnJugar.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));
        btnJugar.setForeground(Color.white);
        btnJugar.setBounds(260,180,200,60);
        btnJugar.setBackground(morado);
        btnJugar.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        btnJugar.setFocusable(false);
        btnJugar.addActionListener(new ManejadoraDeEventos());
        btnJugar.addMouseListener(new ManejadoraDeMouse());
        jpContenido.add(btnJugar);
        
        lblNombre = new JLabel("nombre");
        lblNombre.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,30));
        lblNombre.setForeground(Color.white);
        lblNombre.setBounds(300,260,180,50);
        jpContenido.add(lblNombre);
                
        boxNombre = new JTextField("");
        boxNombre.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20)); 
        boxNombre.setBounds(270, 310, 180, 40);
        boxNombre.setHorizontalAlignment(JTextField.CENTER);
        boxNombre.setFocusable(true);
        boxNombre.addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent e)
            {
                if (boxNombre.getText().length()== 12)
                {
                     e.consume();
                }   
            }
        });
        
        jpContenido.add(boxNombre);
        
        btnParaQueSirve = new JButton("Para que sirve");
        btnParaQueSirve.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));
        btnParaQueSirve.setForeground(Color.white);
        btnParaQueSirve.setBounds(30,300,200,60);
        btnParaQueSirve.setBackground(morado);
        btnParaQueSirve.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        btnParaQueSirve.setFocusable(false);
        btnParaQueSirve.addActionListener(new ManejadoraDeEventos());
        btnParaQueSirve.addMouseListener(new ManejadoraDeMouse());
        jpContenido.add(btnParaQueSirve);
        
        btnInstrucciones = new JButton("Como se juega");
        btnInstrucciones.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));
        btnInstrucciones.setForeground(Color.white);
        btnInstrucciones.setBounds(490,300,200,60);
        btnInstrucciones.setBackground(morado);
        btnInstrucciones.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        btnInstrucciones.setFocusable(false);
        btnInstrucciones.addActionListener(new ManejadoraDeEventos());
        btnInstrucciones.addMouseListener(new ManejadoraDeMouse());
        jpContenido.add(btnInstrucciones);

        this.getContentPane().add(jpContenido);
        this.getContentPane().add(jpFondo);
        setVisible(true);
    }

    private void mostrarParaQueSirve() 
    {
        VentanaParaQueSirve paraQueSirve = new VentanaParaQueSirve();
        dispose();
    }
    
    private void mostrarInstrucciones() 
    {
        VentanaInstrucciones instrucciones = new VentanaInstrucciones();
        dispose();
    }
    
    private void iniciarJuego()
    { 
        boolean nombreCompleto = false;
        String nombre = boxNombre.getText();
        
        if(!nombre.trim().isEmpty())
        {
            nombreCompleto =true;
        }
        else 
        {
            JOptionPane.showMessageDialog(null,"Por favor ingrese su nombre","Advertencia", JOptionPane.ERROR_MESSAGE);
            boxNombre.requestFocusInWindow();
        }
        if(nombreCompleto)
        {
            Jugador jugador = new Jugador();
            jugador.setNombre(nombre);
            VentanaJuego ventanaJuego = new VentanaJuego(jugador);  
            dispose();
        }
    }
            
    class ManejadoraDeEventos implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evento) 
        {
            if(evento.getSource() == btnJugar)
            {                
                iniciarJuego();
            }
            if(evento.getSource() == btnInstrucciones)
            {
                mostrarInstrucciones();
            }
            if(evento.getSource() == btnParaQueSirve)
            {
                mostrarParaQueSirve();
            }  
        }  
    }

    class ManejadoraDeMouse extends MouseAdapter
    {
        @Override
        public void mouseEntered(MouseEvent arg0) 
        {
            ((JButton) arg0.getSource()).setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        }

        @Override
        public void mouseExited(MouseEvent e) 
        {  
            ((JButton) e.getSource()).setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        } 
    }
}
