/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import tipografiam.Fuentes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import logica.Jugador;

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
    private JLabel lblMensaje;
    private JLabel lblTiempoyFicha;
    
    public VentanaJuego(Jugador jugador)
    {
        /*juegoAhorcado = new JuegoAhorcado(jugador);*/
        /*juegoAhorcado.iniciarRonda();*/
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
        
        jpFondo = new FondoVentana("/Fondo/FondoVentana.png");
        jpFondo.setSize(720,450);
        jpFondo.setLayout(null);
        
        jpSeccionSuperior = new JPanel();
        jpSeccionSuperior.setLayout(null);
        jpSeccionSuperior.setBounds(0,0,720,85);
        jpSeccionSuperior.setOpaque(false);
        
        btnSonido = new JButton();
        btnSonido.setBounds(10, 7,60, 60);
        btnSonido.setIcon(new ImageIcon(Class.class.getResource("/imagenesSonido/sonidoOn.png")));
        btnSonido.setName("btnSonido");
        btnSonido.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,15));
        btnSonido.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        btnSonido.setBackground(morado);
        btnSonido.putClientProperty("encendido", true);
        btnSonido.addActionListener(new ManejadorDeEventos());
                
        lblNombre = new JLabel("NOMBRE: " /*+ juegoMemorabb.getNombreJugador()*/,SwingConstants.CENTER);
        lblNombre.setBounds(80, 7, 240, 60);
        lblNombre.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,15));  
        lblNombre.setForeground(Color.white);
        lblNombre.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        lblNombre.setBackground(morado);
        lblNombre.setOpaque(true);
        
        lblPuntuacion = new JLabel("PUNTUACION: ", SwingConstants.CENTER);
        lblPuntuacion.setBounds(330, 7, 250, 60);
        lblPuntuacion.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,15));  
        lblPuntuacion.setForeground(Color.white);
        lblPuntuacion.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        lblPuntuacion.setBackground(morado);
        lblPuntuacion.setOpaque(true);
        
        lblVidas = new JLabel();
        lblVidas.setBounds(590, 7, 120, 60);
        lblVidas.setIcon(new ImageIcon(Class.class.getResource("/imagenesVidas/Corazones3.png")));
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
                btnFichas[fila][columna].setBackground(morado);
                //btnFichas[fila][columna].setEnabled(false);
                btnFichas[fila][columna].putClientProperty("fila", fila);
                btnFichas[fila][columna].putClientProperty("columna", columna);
                btnFichas[fila][columna].addMouseListener(new ManejadorDeMouse());
                btnFichas[fila][columna].addKeyListener(new ManejadorDeKeyBoard());
                btnFichas[fila][columna].addActionListener(new ManejadorDeEventos());
                jpSeccionMedia.add(btnFichas[fila][columna]);
            }      
        }
        
        //asignarFichas();
          
        jpSeccionInferior = new JPanel();
        jpSeccionInferior.setBounds(0,365,720,85);
        jpSeccionInferior.setLayout(null);
        jpSeccionInferior.setOpaque(false);
        
        lblMensaje = new JLabel("ELIGE UNA CASILLA",SwingConstants.CENTER);
        lblMensaje.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,15));  
        lblMensaje.setForeground(Color.white);
        lblMensaje.setBounds(10, 12, 615, 60);
        lblMensaje.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        lblMensaje.setBackground(morado);
        lblMensaje.setOpaque(true);
        
        lblTiempoyFicha = new JLabel(/*""+juegoMemorabble.getTiempoMostrar(), SwingConstants.CENTER*/);
        lblTiempoyFicha.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,15));  
        lblTiempoyFicha.setForeground(Color.white);
        lblTiempoyFicha.setBounds(635, 5, 75, 75);
        lblTiempoyFicha.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        lblTiempoyFicha.setBackground(morado);
        lblTiempoyFicha.setOpaque(true);
        
        jpSeccionInferior.add(lblMensaje);
        jpSeccionInferior.add(lblTiempoyFicha);

        this.getContentPane().add(jpSeccionSuperior);
        this.getContentPane().add(jpSeccionMedia);
        this.getContentPane().add(jpSeccionInferior); 
        this.getContentPane().add(jpFondo); 
        setVisible(true);         
        //ocultarFiguras();     
    }
     
    /*private void ocultarFiguras()
    {
        segundos = juegoMemorable.getTiempoMostar();
        Timer timer = new Timer( 1000 , null);
        timer.start();
        timer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                segundos--;   
                actualizarTiempo();
                if(segundos == 0)
                {
                    timer.stop();
                    lblMensaje.setText("Seleccione las casillas que cumplan con la siguiente condicion");
                    lblTiempoyFicha.setText("");
                    lblTiempoyFicha.setBackground(Color.white);
                    lblTiempoyFicha.setIcon(new ImageIcon(Class.class.getResource("/imagenesCondicion/"+juegoMemorabble.getCondicion()+".png")));
                    for (JButton[] btnFicha : btnFichas) 
                    {  
                        for (JButton btnFicha1 : btnFicha) 
                        {
                            btnFicha1.setBackground(morado);
                            btnFicha1.setIcon(null);
                            btnFicha1.setEnabled(true); 
                        }
                    }
                }
            }
        });
    }*/
    
    /*private void actualizarTiempo()
    {
        lblTiempoyFicha.setText(""+segundos);
    }*/
    

    /*
    private void mostrarFichas(JButton btnFichaSeleccioando, Ficha ficha)
    {
        String dirImagen = ficha.getImagen();
        btnFichaSeleccioando.setIcon(new ImageIcon(Class.class.getResource(dirImagen)));
        btnFichaSeleccioando.setDisabledIcon(new ImageIcon(Class.class.getResource(dirImagen)));
    }*/
    
    /*private void terminoJuego()
    {
        if(!JuegoMemorabble.terminoJuego())
        {
            VentanaResultados(JuegoMemorabble.getJugador());
            dispose();
        }
        else
        {
            JuegoMemorabble.iniciarRonda();
        }
    }*/
    
    /*private void noAdivinoFicha(JButton btnFichaSeleccionada)
    {
        int vidas = juegoMemorabble.getVidasJugador();
        lblVidas.setIcon(new ImageIcon(Class.class.getResource("/imagenesVidas/Corazones"+vidas+".png")));
        btnFichaSeleccionada.setBorder(BorderFactory.createLineBorder(Color.red, 5));
        for (JButton[] btnFicha : btnFichas) 
        {  
            for (JButton btnFicha1 : btnFicha) 
            {
                btnFicha1.setEnabled(false);
                btnFicha1.setBackground(Color.white);
                Ficha fichaSeleccionada = ((Ficha)btnFicha1.getClientProperty("ficha"));  
                mostrarFiguras(btnFicha1, fichaSeleccionada);
            }
        }
        terminoJuego();   
    }
    
    private void adivinoFichas(JButton btnFichaSeleccionada)
    {
        if(btnFichaSeleccionada.getClientProperty("ficha") instanceof Ficha)
        {
            Ficha fichaSeleccioanda = ((Ficha)btnFichaSeleccionada.getClientProperty("ficha"));
            if(JuegoMemorabble.esLaFicha(fichaSeleccioanda))
            {
                btnFichaSeleccionada.setEnabled(false);
                btnFichaSeleccionada.setBackground(Color.white);
                mostrarFichas(btnFichaSeleccionada, fichaSeleccioanda); 
                adivinoTodasLasFichas();
            }
            else
            {   
                noAdivinoFicha(btnFichaSeleccionada);
            }   
        }
        else
        {
            noAdivinoFicha(btnFichaSeleccionada);     
        }
    }
    
    /*private void adivinoTodasLasFichas()
    { 
        if(sonTodasLasFichas())
        {
            for (JButton[] btnFicha : btnFichas)
            {  
                for (JButton[] btnFicha : btnFichas) 
                {  
                     btnFicha1.setEnabled(false);   
                }
            }
            juegoMemorabble.iniciarRonda();
            asignarFichas();
            ocultarFichas();
        }
    }*/
    
    /*private void asignarFichas()
    {
        fichasEnRonda = juegoMemorabble.getaFichasEnRonda;
        for (Ficha fichaEnRonda : fichasEnRonda)
        {  
            for (Ficha fichaEnRonda : fichasEnRonda) 
            {
                Random r = new Random();
                int fila = r.nextInt(btnFichas.length-1);
                int columna = int fila = r.nextInt(btnFichas[0].length-1);
                btnFichas[fila][columna].setIcon[Class.class.getResource(fichaEnRonda.getImagen());+
                
            }
        }
        
    }*/
    
    /*private void asignarFichas()
    {    
        Ficha fichasEnRonda[] = JuegoMemorabble.getFichasEnRonda();
        for (int ficha = 0; ficha < fichasEnRonda.length; ficha++) 
        {
            Random r = new Random();
            int fila = r.nextInt(btnFichas.length);
            int columna = r.nextInt(btnFichas[0].length);
            btnFichas[fila][columna].putClientProperty("ficha", fichasEnRonda[ficha]);
            mostrarFichas(btnFichas[fila][columna], fichasEnRonda[ficha]);        
        }
    }*/

    class ManejadorDeMouse extends MouseAdapter
    {
        @Override       
        public void mouseEntered(MouseEvent arg0) 
        {
            if(((JButton) arg0.getSource()).isEnabled())
            {
                Component botonSeleccionado = getFocusOwner();
                if (botonSeleccionado instanceof JButton)
                {
                    JButton button = (JButton)botonSeleccionado;  
                    if(button.getName().equals("btnFicha"))
                    {
                        button.setBorder(BorderFactory.createLineBorder(moradoClaro, 5));
                    }               
                }
                ((JButton) arg0.getSource()).setBorder(BorderFactory.createLineBorder(Color.black, 5));
                ((JButton) arg0.getSource()).requestFocus();   
            } 
        }

        @Override
        public void mouseExited(MouseEvent e) 
        {  
            if(((JButton) e.getSource()).isEnabled())
            {
                ((JButton) e.getSource()).setBorder(BorderFactory.createLineBorder(moradoClaro, 5)); 
            }
        } 
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
                   btnSonido.setIcon(new ImageIcon(Class.class.getResource("/imagenesSonido/sonidoOff.png"))); 
                   btnSonido.putClientProperty("encendido", false);
                }
                else
                {
                    btnSonido.setIcon(new ImageIcon(Class.class.getResource("/imagenesSonido/sonidoOn.png"))); 
                    btnSonido.putClientProperty("encendido", true);
                }
                
            }
            //else if (ae.getSource() instanceof JButton)  
        }
    }
    
    class ManejadorDeKeyBoard extends KeyAdapter
    {  
        @Override
        public void keyPressed(KeyEvent e) 
        {
            int columna;
            int fila;
            Component botonSeleccionado = getFocusOwner();
            if (botonSeleccionado instanceof JButton)
            {
                JButton button = (JButton)botonSeleccionado;
                columna = (int)button.getClientProperty("columna");
                fila = (int)button.getClientProperty("fila");
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
                            ((JButton)botonSeleccionado).setBorder(BorderFactory.createLineBorder(moradoClaro, 5));;
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
                if (botonSeleccionado instanceof JButton)
                { 
                    ((JButton)botonSeleccionado).doClick();
                    
                }
            }
        }
    }    
}
