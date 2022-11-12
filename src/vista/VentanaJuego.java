/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import tipografiam.Fuentes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import logica.Ficha;
import logica.JuegoMemorabble;
import logica.Jugador;
import vista.Sonido;


/**
 *
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Yenny Rivas Tello <yenny.rivas@correounivalle.edu.co>
 */
public class VentanaJuego extends JFrame
{  
    Color moradoClaro;
    Color morado;
    
    JuegoMemorabble juegoMemorabble;
    private Fuentes tipoFuente;
    private FondoVentana jpFondo;
    private JPanel jpSeccionSuperior;
    private JPanel jpSeccionMedia;
    private JPanel jpSeccionInferior;
    private JButton btnSonido;
    private JLabel lblNombre;
    private JLabel lblPuntuacion;
    private JLabel lblVidas;
    private JButton btnFichas[][];
    private JButton btnTerminarJuego;
    private JLabel lblMensaje;
    private JLabel lblTiempoyFicha;
    Sonido sonidoCorrecto;
    Sonido sonidoIncorrecto;
    Sonido musicaContador;
    
    public VentanaJuego(Jugador jugador)
    {
        juegoMemorabble = new JuegoMemorabble(jugador);
        juegoMemorabble.iniciarRonda();
        inicializarComponentes();
    }
    
    private void inicializarComponentes()
    {
        setTitle("MERMORABBLE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(736,489);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null); 
        
        moradoClaro = new Color(229,204, 255);
        morado = new Color(51,0, 102);

        tipoFuente= new Fuentes();
        sonidoCorrecto = new Sonido();
        sonidoIncorrecto = new Sonido();
        musicaContador = new Sonido();
        musicaContador.iniciarSonido("/sonidos/musicaContador.wav");
        musicaContador.setBucle();
                
        jpFondo = new FondoVentana("/Fondo/FondoVentana.png");
        jpFondo.setSize(720,450);
        jpFondo.setLayout(null);
        
        jpSeccionSuperior = new JPanel();
        jpSeccionSuperior.setLayout(null);
        jpSeccionSuperior.setBounds(0,0,720,85);
        jpSeccionSuperior.setOpaque(false);
        
        btnSonido = new JButton();
        btnSonido.setBounds(10, 7,60, 60);
        btnSonido.setIcon(new ImageIcon(getClass().getResource("/imagenesSonido/sonidoOn.png")));
        btnSonido.setName("btnSonido");
        btnSonido.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,15));
        btnSonido.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        btnSonido.setBackground(morado);
        btnSonido.putClientProperty("encendido", true);
        btnSonido.addActionListener(new ManejadorDeEventos());
                
        lblNombre = new JLabel("NOMBRE: " + juegoMemorabble.getNombreJugador(),SwingConstants.CENTER);
        lblNombre.setBounds(80, 7, 240, 60);
        lblNombre.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,15));  
        lblNombre.setForeground(Color.white);
        lblNombre.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        lblNombre.setBackground(morado);
        lblNombre.setOpaque(true);
        
        lblPuntuacion = new JLabel("PUNTUACION: " + juegoMemorabble.getPuntuacionJugador(), SwingConstants.CENTER);
        lblPuntuacion.setBounds(330, 7, 250, 60);
        lblPuntuacion.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,15));  
        lblPuntuacion.setForeground(Color.white);
        lblPuntuacion.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        lblPuntuacion.setBackground(morado);
        lblPuntuacion.setOpaque(true);
        
        lblVidas = new JLabel();
        lblVidas.setBounds(590, 7, 120, 60);
        lblVidas.setIcon(new ImageIcon(getClass().getResource("/imagenesVidas/Corazones3.png")));
        lblVidas.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,15));  
        lblVidas.setForeground(Color.white);
        lblVidas.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        lblVidas.setBackground(morado);
        lblVidas.setOpaque(true);
        
        jpSeccionSuperior.add(btnSonido);
        jpSeccionSuperior.add(lblNombre);
        jpSeccionSuperior.add(lblPuntuacion);
        jpSeccionSuperior.add(lblVidas);
        
        jpSeccionMedia = new JPanel();
        jpSeccionMedia.setBounds(40,75,640,290);
        jpSeccionMedia.setLayout(new GridLayout(4,9,0,0));
        jpSeccionMedia.setBorder(new LineBorder(moradoClaro, 5));
        jpSeccionMedia.setOpaque(false);
        
        btnFichas = new JButton[4][9];
        for(int fila = 0; fila < btnFichas.length; fila++)
        {
            for(int columna = 0; columna < btnFichas[fila].length; columna++)
            {
                btnFichas[fila][columna] = new JButton();
                btnFichas[fila][columna].setName("btnFicha");
                btnFichas[fila][columna].setBorder(BorderFactory.createLineBorder(moradoClaro, 5));
                btnFichas[fila][columna].setBackground(Color.white);
                btnFichas[fila][columna].setEnabled(false);
                btnFichas[fila][columna].putClientProperty("fila", fila);
                btnFichas[fila][columna].putClientProperty("columna", columna);
                btnFichas[fila][columna].addMouseListener(new ManejadorDeMouse());
                btnFichas[fila][columna].addKeyListener(new ManejadorDeKeyBoard());
                btnFichas[fila][columna].addActionListener(new ManejadorDeEventos());
                jpSeccionMedia.add(btnFichas[fila][columna]);
            }      
        }
        
        
          
        jpSeccionInferior = new JPanel();
        jpSeccionInferior.setBounds(0,365,720,85);
        jpSeccionInferior.setLayout(null);
        jpSeccionInferior.setOpaque(false);
        
        btnTerminarJuego = new JButton();
        btnTerminarJuego.setBounds(10, 12,60, 60);
        btnTerminarJuego.setIcon(new ImageIcon(getClass().getResource("/imagenesCerrar/cerrarJuego.png")));
        btnTerminarJuego.setName("btnTerminarJuego");
        btnTerminarJuego.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,15));
        btnTerminarJuego.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        btnTerminarJuego.setBackground(morado);
        btnTerminarJuego.addActionListener(new ManejadorDeEventos());
        
        lblMensaje = new JLabel("OBSERVE LAS FIGURAS DETENIDAMENTE",SwingConstants.CENTER);
        lblMensaje.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,15));  
        lblMensaje.setForeground(Color.white);
        lblMensaje.setBounds(80, 12, 545, 60);
        lblMensaje.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        lblMensaje.setBackground(morado);
        lblMensaje.setOpaque(true);
        
        lblTiempoyFicha = new JLabel(""+juegoMemorabble.getTiempoMostrar(), SwingConstants.CENTER);
        lblTiempoyFicha.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,15));  
        lblTiempoyFicha.setForeground(Color.white);
        lblTiempoyFicha.setBounds(635, 5, 75, 75);
        lblTiempoyFicha.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        lblTiempoyFicha.setBackground(morado);
        lblTiempoyFicha.setOpaque(true);
        
        jpSeccionInferior.add(btnTerminarJuego);
        jpSeccionInferior.add(lblMensaje);
        jpSeccionInferior.add(lblTiempoyFicha);

        this.getContentPane().add(jpSeccionSuperior);
        this.getContentPane().add(jpSeccionMedia);
        this.getContentPane().add(jpSeccionInferior); 
        this.getContentPane().add(jpFondo); 
        setVisible(true);      
        asignarFichas();
        ocultarFichas();     
    }
    
    class ManejadorDeEventos implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource() == btnSonido)
            {
                if((boolean)btnSonido.getClientProperty("encendido"))
                {
                   btnSonido.setIcon(new ImageIcon(getClass().getResource("/imagenesSonido/sonidoOff.png"))); 
                   btnSonido.putClientProperty("encendido", false);
                   musicaContador.pararSonido();
                   sonidoCorrecto.pararSonido();
                   sonidoIncorrecto.pararSonido();
                   musicaContador.setEstado(false);
                   sonidoCorrecto.setEstado(false);
                   sonidoIncorrecto.setEstado(false);
                }
                else
                {
                    btnSonido.setIcon(new ImageIcon(getClass().getResource("/imagenesSonido/sonidoOn.png"))); 
                    btnSonido.putClientProperty("encendido", true);
                    
                    
                    musicaContador.setEstado(true);
                    sonidoCorrecto.setEstado(true);
                    sonidoIncorrecto.setEstado(true);
                    if(juegoMemorabble.getTiempoMostrar()!=0)
                    {
                     musicaContador.continuarSonido();   
                    }
                    
                    sonidoCorrecto.continuarSonido();
                    sonidoIncorrecto.continuarSonido();
                }
                       
            }
            else if(ae.getSource() == btnTerminarJuego)
            {
                cerrarJuego();
            }
            else if (ae.getSource() instanceof JButton)
            {
                JButton botonSeleccionado = ((JButton)ae.getSource());
                Ficha fichaSeleccioanda = (Ficha)botonSeleccionado.getClientProperty("ficha");
                if(juegoMemorabble.esLaFicha(fichaSeleccioanda))
                { 
                    actulizarLabelPuntuacion();
                    actualizarBotonCorrecto(botonSeleccionado, fichaSeleccioanda);
                sonidoCorrecto.iniciarSonido("/sonidos/sonidoCorrecto.wav");

                    if(juegoMemorabble.sonTodasLasFicha())
                    { 
                        actualizarTodosLosBotones();
                        inicializarComponentesRonda();
                    }
                }
                else
                {   
                    actualizarBotonIncorrecto(botonSeleccionado);
                    actualizarLabelVidas();
                    actualizarTodosLosBotones();
                    sonidoIncorrecto.iniciarSonido("/sonidos/sonidoIncorrecto.wav");
                    
                    if(juegoMemorabble.terminoJuego())
                    {
                        juegoMemorabble.pararContarTiempoJuego();
                        mostrarResultados();
                    }
                    else
                    {
                        inicializarComponentesRonda();
                    }
                }   
            }
        }
    }
    
    class ManejadorDeMouse extends MouseAdapter
    {
        @Override       
        public void mouseEntered(MouseEvent arg0) 
        { 
            if(arg0.getSource() instanceof JButton)
            {
                JButton botonMouseEntered = (JButton) arg0.getSource();
                if(botonMouseEntered.isEnabled())
                {
                    if(botonMouseEntered == btnSonido)
                    {
                        botonMouseEntered.setBorder(BorderFactory.createLineBorder(Color.black, 10)); 
                    }
                    else if(botonMouseEntered == btnTerminarJuego)
                    {
                        botonMouseEntered.setBorder(BorderFactory.createLineBorder(Color.black, 10)); 
                    }
                    else
                    {
                        Component componenteFoucs = getFocusOwner();
                        if (componenteFoucs instanceof JButton)
                        {
                            JButton botonFocus = (JButton)componenteFoucs;  
                            if(botonFocus.getName().equals("btnFicha"))
                            {
                                botonFocus.setBorder(BorderFactory.createLineBorder(moradoClaro, 5));
                            }
                        }
                        botonMouseEntered.setBorder(BorderFactory.createLineBorder(Color.black, 5)); 
                        botonMouseEntered.requestFocus();
                    }
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) 
        {    
            if(e.getSource() instanceof JButton)
            {
                if(((JButton) e.getSource()).isEnabled())
                {
                    if(e.getSource() == btnSonido)
                    {
                        ((JButton) e.getSource()).setBorder(BorderFactory.createLineBorder(moradoClaro, 10)); 
                    }
                    else if(e.getSource() == btnTerminarJuego)
                    {
                        ((JButton) e.getSource()).setBorder(BorderFactory.createLineBorder(moradoClaro, 10)); 
                    }
                    else
                    {
                        ((JButton) e.getSource()).setBorder(BorderFactory.createLineBorder(moradoClaro, 5)); 
                    }
                }
            }
        }
    }
    
    class ManejadorDeKeyBoard extends KeyAdapter
    {  
        @Override
        public void keyPressed(KeyEvent e) 
        {
            int columna;
            int fila;
            Component botonFocus = getFocusOwner();
            if (botonFocus instanceof JButton)
            {
                JButton botonSeleccionado = (JButton)botonFocus;
                columna = (int)botonSeleccionado.getClientProperty("columna");
                fila = (int)botonSeleccionado.getClientProperty("fila");
            }
            else
            {
                columna = 0;
                fila = 0;
            }
            
            int c = e.getKeyCode();
            switch (c) 
            {
                case KeyEvent.VK_UP:
                    if(fila > 0)
                    {
                        if(btnFichas[fila-1][columna].isEnabled())
                        {
                            btnFichas[fila][columna].setBorder(BorderFactory.createLineBorder(moradoClaro, 5));;
                            btnFichas[fila-1][columna].setBorder(BorderFactory.createLineBorder(Color.black, 5));
                            btnFichas[fila-1][columna].requestFocus();
                        }
                        else
                        {
                            if(fila > 1)
                            {
                                btnFichas[fila][columna].setBorder(BorderFactory.createLineBorder(moradoClaro, 5));
                                btnFichas[fila-2][columna].setBorder(BorderFactory.createLineBorder(Color.black, 5));
                                btnFichas[fila-2][columna].requestFocus();
                            }
                        }
                    }
                    else if(fila == 0)
                    {
                        btnFichas[fila][columna].setBorder(BorderFactory.createLineBorder(Color.black, 5));
                    }   
                    break;
                case KeyEvent.VK_DOWN:
                    if(fila < 3)
                    {
                        if(btnFichas[fila+1][columna].isEnabled())
                        {
                            btnFichas[fila][columna].setBorder(BorderFactory.createLineBorder(moradoClaro, 5));
                            btnFichas[fila+1][columna].setBorder(BorderFactory.createLineBorder(Color.black, 5));
                            btnFichas[fila+1][columna].requestFocus();
                        }   
                    }
                    else if(fila == 3)
                    {
                        btnFichas[fila][columna].setBorder(BorderFactory.createLineBorder(Color.black, 5));
                    }   
                    break;
                case KeyEvent.VK_RIGHT:
                    if(columna < 8)
                    {
                        if(btnFichas[fila][columna+1].isEnabled())
                        {
                            btnFichas[fila][columna].setBorder(BorderFactory.createLineBorder(moradoClaro, 5));
                            btnFichas[fila][columna+1].setBorder(BorderFactory.createLineBorder(Color.black, 5));
                            btnFichas[fila][columna+1].requestFocus();
                        } 
                    }
                    else if(fila == 8)
                    {
                        btnFichas[fila][columna].setBorder(BorderFactory.createLineBorder(Color.black, 5));
                    }   
                    break;
                case KeyEvent.VK_LEFT:
                    if(columna > 0)
                    {
                        if(btnFichas[fila][columna-1].isEnabled())
                        {
                            btnFichas[fila][columna].setBorder(BorderFactory.createLineBorder(moradoClaro, 5));
                            btnFichas[fila][columna-1].setBorder(BorderFactory.createLineBorder(Color.black, 5));
                            btnFichas[fila][columna-1].requestFocus();
                        }
                    }
                    else if(fila == 0)
                    {
                        btnFichas[fila][columna].setBorder(BorderFactory.createLineBorder(Color.black, 5));
                    }   
                    break;
                default:
                    break;  
            }
            
            if(c == KeyEvent.VK_ENTER || c == KeyEvent.VK_SPACE)
            {
                if (botonFocus instanceof JButton)
                { 
                    ((JButton)botonFocus).doClick();
                    
                }
            }
        }
    }
     
    private void actualizarBotonCorrecto(JButton botonSeleccionado,  Ficha fichaSeleccioanda)
    {
        botonSeleccionado.setEnabled(false);
        botonSeleccionado.setBackground(Color.white);
        botonSeleccionado.setBorder(BorderFactory.createLineBorder(Color.green.darker(), 5));
        mostrarFicha(botonSeleccionado, fichaSeleccioanda);
    }
    
    private void actualizarBotonIncorrecto(JButton botonSeleccionado)
    {
        botonSeleccionado.setBorder(BorderFactory.createLineBorder(Color.red.darker(), 5));
    }
    
    private void actualizarTodosLosBotones()
    {
        for (JButton[] btnFicha : btnFichas) 
        {  
            for (JButton btnFicha1 : btnFicha) 
            {
                btnFicha1.setEnabled(false);
                btnFicha1.setBackground(Color.white);
                Ficha fichaSeleccionada = ((Ficha)btnFicha1.getClientProperty("ficha"));
                if(fichaSeleccionada != null)
                {
                    mostrarFicha(btnFicha1, fichaSeleccionada);
                    btnFicha1.putClientProperty("ficha", null);
                }            
            }
        }
    }
    
    private void actualizarTiempo()
    {
        lblTiempoyFicha.setText(""+juegoMemorabble.getTiempoMostrar());
    }
    
    private void actulizarLabelPuntuacion()
    {
        lblPuntuacion.setText("PUNTUACION: " + juegoMemorabble.getPuntuacionJugador());
    }
    
    private void actualizarLabelVidas()
    {
        lblVidas.setIcon(new ImageIcon(getClass().getResource("/imagenesVidas/Corazones" + juegoMemorabble.getVidasJugador() + ".png")));
    }
    
    private void actualizarLabelMensaje()
    {
        lblMensaje.setText("SELECCIONE LAS CASILLAS CORRECTA");
    }
    
    private void asignarFichas()
    {       
        Ficha[] fichasEnRonda = juegoMemorabble.getFichasEnRonda();
        Random r = new Random();
        for (int ficha = 0; ficha < fichasEnRonda.length; ficha++) 
        {
            int fila = r.nextInt(btnFichas.length);
            int columna = r.nextInt(btnFichas[0].length);
            boolean seRepite = true;
            while(seRepite)
            {
                if(btnFichas[fila][columna].getClientProperty("ficha") == null)
                {
                    btnFichas[fila][columna].putClientProperty("ficha", fichasEnRonda[ficha]);
                    seRepite = false;
                }
                else
                {
                    fila = r.nextInt(btnFichas.length);
                    columna = r.nextInt(btnFichas[0].length);
                    seRepite = true;
                }
            }
            mostrarFicha(btnFichas[fila][columna], fichasEnRonda[ficha]);        
        }
    }
    
    private void mostrarFicha(JButton botonSeleccionado, Ficha fichaSeleccionada)
    {
        String dirImagen = fichaSeleccionada.getDirImagen();
        botonSeleccionado.setIcon(new ImageIcon(getClass().getResource(dirImagen)));
        botonSeleccionado.setDisabledIcon(new ImageIcon(getClass().getResource(dirImagen)));
    }
    
    private void ocultarFichas()
    {
        Timer timer = new Timer( 1000 , null);
        timer.start();
        timer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                juegoMemorabble.disminuirTiempoMostrar();
                actualizarTiempo();
                if(juegoMemorabble.getTiempoMostrar() == 0)
                {
                    timer.stop();
                musicaContador.pararSonido();
                    actualizarLabelMensaje();
                    lblTiempoyFicha.setText("");
                    lblTiempoyFicha.setBackground(Color.white);
                    lblTiempoyFicha.setIcon(new ImageIcon(getClass().getResource("/imagenesCondicion/"+juegoMemorabble.getCondicion()+".png")));
                    for (JButton[] btnFicha : btnFichas) 
                    {  
                        for (JButton btnFicha1 : btnFicha) 
                        {
                            btnFicha1.setBorder(BorderFactory.createLineBorder(moradoClaro, 5));
                            btnFicha1.setBackground(morado);
                            btnFicha1.setIcon(null);
                            btnFicha1.setEnabled(true); 
                        }
                    }
                    btnFichas[0][0].requestFocus();
                }
            }
        });
    }
    
    private void inicializarComponentesRonda()
    {
        Timer timer = new Timer( 1000 , null);
        timer.start();
        timer.setRepeats(false);
        timer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                juegoMemorabble.iniciarRonda();
                for (JButton[] btnFicha : btnFichas) 
                {
                    for (JButton btnFicha1 : btnFicha) 
                    {
                        btnFicha1.setBorder(BorderFactory.createLineBorder(moradoClaro, 5));
                        btnFicha1.setIcon(null);
                        btnFicha1.setDisabledIcon(null);
                    }
                }
                musicaContador.continuarSonido();
                lblTiempoyFicha.setIcon(null);
                lblTiempoyFicha.setBackground(morado);
                lblTiempoyFicha.setText(""+juegoMemorabble.getTiempoMostrar());
                lblMensaje.setText("OBSERVE LAS FIGURAS DETENIDAMENTE");
                asignarFichas();
                ocultarFichas();
            }
        });
    }
        
    private void cerrarJuego()
    {
        int respuesta;
        respuesta = JOptionPane.showConfirmDialog(null,"¿Desea terminar el juego?", "Información",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION)
        {
            juegoMemorabble.pararContarTiempoJuego();
            mostrarResultados();
        }
    }
    
    private void mostrarResultados()
    {
        if(juegoMemorabble.getVidasJugador() != 0)
        {
            //VentanaResultados(JuegoMemorabble.getJugador());
            cerrarSonidos();
            dispose();
        }
        else
        {
            
            Timer timer = new Timer( 1000 , null);
            timer.start();
            timer.setRepeats(false);
            timer.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                    //VentanaResultados(JuegoMemorabble.getJugador());
                    cerrarSonidos();
                    dispose();
                }
            });   
        }   
    }
    
    private void cerrarSonidos()
    {
     musicaContador.cerrarSonido();
     sonidoCorrecto.cerrarSonido();
     sonidoIncorrecto.cerrarSonido();
    }
    }
                  

