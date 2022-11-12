/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 * 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Yenny Rivas Tello <yenny.rivas@correounivalle.edu.co>
 */
    import fondo.FondoVentana;
    import java.awt.Color;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    import javax.swing.BorderFactory;
    import javax.swing.ImageIcon;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.SwingConstants;
    import tipografiam.Fuentes;

public class VentanaInstrucciones extends JFrame 
{
    
    Color moradoClaro;
    Color morado;

    Fuentes tipoFuente;
    private final FondoVentana jpFondo;
    private JPanel jpSeccionSuperior;
    private JPanel jpSeccionInferior;
    private JPanel jpSeccionIzquierda;
    private JPanel jpSeccionDerecha;
    private JLabel lblImagenInstrucciones;
    private JLabel lblNumeroPag;
    private JLabel textRenglon1;
    private JLabel textRenglon2;
    private JLabel textRenglon3;
    private JLabel textRenglon4;
    private JLabel textRenglon5;
    private JButton btnSiguientePag2;
    private JButton btnSiguientePag3;
    private JButton btnSiguientePag4;
    private JButton btnSiguientePag5;
    private JButton btnAtrasPag1;
    private JButton btnAtrasPag2;
    private JButton btnAtrasPag3;
    private JButton btnAtrasPag4;
    private JButton btnMenuPrincipal;
    
    public VentanaInstrucciones()
    {
        setTitle("MEMORABBLE-INSTRUCCIONES");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(736,489);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        tipoFuente = new Fuentes();
                
        moradoClaro = new Color(229,204, 255);
        morado = new Color(51,0, 102);
        
        jpFondo = new FondoVentana("/Fondo/FondoVentana.png");
        jpFondo.setSize(720,450);
        jpFondo.setLayout(null);

        btnAtrasPag1 = new JButton("ATRAS");
        botonIzquierdo(btnAtrasPag1);
        
        btnSiguientePag2 = new JButton("SIGUIENTE");
        botonDerecho(btnSiguientePag2);
        
        btnAtrasPag2 = new JButton("ATRAS");
        botonIzquierdo(btnAtrasPag2);
        
        btnSiguientePag3 = new JButton("SIGUIENTE");
        botonDerecho(btnSiguientePag3);
        
        btnAtrasPag3 = new JButton("ATRAS");
        botonIzquierdo(btnAtrasPag3);
        
        btnSiguientePag4 = new JButton("SIGUIENTE");
        botonDerecho(btnSiguientePag4);
        
        btnAtrasPag4 = new JButton("ATRAS");
        botonIzquierdo(btnAtrasPag4);
        
        btnSiguientePag5 = new JButton("SIGUIENTE");
        botonDerecho(btnSiguientePag5);
        
        inicializarComponentes();
    }

    private void inicializarComponentes() 
    {   
        jpSeccionIzquierda = new JPanel();
        jpSeccionIzquierda.setSize(245,245);        
        jpSeccionIzquierda.setBounds(0,0, 170, 245);
        jpSeccionIzquierda.setLayout(null);
        jpSeccionIzquierda.setOpaque(false); 
        
        btnMenuPrincipal = new JButton("MENU PRINCIPAL");
        btnMenuPrincipal.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,12));
        btnMenuPrincipal.setForeground(Color.white);
        btnMenuPrincipal.setBounds(10,40,150,50);
        btnMenuPrincipal.setBackground(Color.ORANGE.darker());
        btnMenuPrincipal.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        btnMenuPrincipal.setFocusable(false);
        btnMenuPrincipal.addActionListener(new ManejadoraDeEventos());
        btnMenuPrincipal.addMouseListener(new ManejadoraDeMouse());
        jpSeccionIzquierda.add(btnMenuPrincipal);
        
        jpSeccionSuperior = new JPanel();
        jpSeccionSuperior.setSize(736,293);        
        jpSeccionSuperior.setBounds(170,10, 380, 245);
        jpSeccionSuperior.setLayout(null);
        jpSeccionSuperior.setOpaque(false); 
        
        lblImagenInstrucciones = new JLabel();
        lblImagenInstrucciones.setBounds(0,0, 380, 245);
        lblImagenInstrucciones.setIcon(new ImageIcon(getClass().getResource("/imagenesInstrucciones/imagen1.png")));
        lblImagenInstrucciones.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        jpSeccionSuperior.add(lblImagenInstrucciones);
        
        jpSeccionInferior = new JPanel();
        jpSeccionInferior.setSize(720,196);        
        jpSeccionInferior.setBounds(40,260, 640, 190);
        jpSeccionInferior.setLayout(null);
        jpSeccionInferior.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        jpSeccionInferior.setBackground(morado);
        
        textRenglon1 = new JLabel( "En Memorabble aparecerán una serie de",SwingConstants.CENTER);
        textRenglon1.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        textRenglon1.setBounds(0, 25, 650, 25);
        textRenglon1.setForeground(Color.white);
        textRenglon1.setBackground(morado);
        jpSeccionInferior.add(textRenglon1);
        
        textRenglon2 = new JLabel( "figuras de distintos colores sobre unas fichas.",SwingConstants.CENTER);
        textRenglon2.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        textRenglon2.setBounds(0, 55, 650, 25);
        textRenglon2.setForeground(Color.white);
        textRenglon2.setFocusable(false);
        jpSeccionInferior.add(textRenglon2);
        
        textRenglon3 = new JLabel( "Al cabo de unos segundos, las figuras",SwingConstants.CENTER);
        textRenglon3.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        textRenglon3.setBounds(0, 85, 650, 25);
        textRenglon3.setForeground(Color.white);
        textRenglon3.setFocusable(false);
        jpSeccionInferior.add(textRenglon3);
        
        textRenglon4 = new JLabel( "desaparecerán y tendras que responder una",SwingConstants.CENTER);
        textRenglon4.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        textRenglon4.setBounds(0, 115, 650, 25);
        textRenglon4.setForeground(Color.white);
        textRenglon4.setFocusable(false);
        jpSeccionInferior.add(textRenglon4);
        
        textRenglon5 = new JLabel( "pregunta",SwingConstants.CENTER);
        textRenglon5.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        textRenglon5.setBounds(0, 145, 650, 25);
        textRenglon5.setForeground(Color.white);
        textRenglon5.setFocusable(false);
        jpSeccionInferior.add(textRenglon5);
        
        jpSeccionDerecha = new JPanel();
        jpSeccionDerecha.setSize(170,245);        
        jpSeccionDerecha.setBounds(550,0, 170, 245);
        jpSeccionDerecha.setLayout(null);
        jpSeccionDerecha.setOpaque(false); 
        
        btnSiguientePag2.setVisible(true);
        
        lblNumeroPag = new JLabel("1/5");
        lblNumeroPag.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,30));  
        lblNumeroPag.setBounds(110, 0, 65, 65);
        lblNumeroPag.setForeground(Color.white);
        lblNumeroPag.setFocusable(false);
        lblNumeroPag.setOpaque(false);
        jpSeccionDerecha.add(lblNumeroPag);
        
        btnSiguientePag2.setVisible(true);
        jpSeccionDerecha.add(btnSiguientePag2);
        
        this.getContentPane().add(jpSeccionIzquierda);
        this.getContentPane().add(jpSeccionDerecha);
        this.getContentPane().add(jpSeccionSuperior);
        this.getContentPane().add(jpSeccionInferior);
        this.getContentPane().add(jpFondo);
        setVisible(true);
    }
    private void inicializarComponentesPag1()
    {
        btnSiguientePag3.setVisible(false);
        btnSiguientePag4.setVisible(false);
        btnSiguientePag5.setVisible(false);
        btnAtrasPag1.setVisible(false);
        btnAtrasPag2.setVisible(false);
        btnAtrasPag3.setVisible(false);
        btnAtrasPag4.setVisible(false);
        btnSiguientePag2.setVisible(true);
        
        lblImagenInstrucciones.setIcon(new ImageIcon(getClass().getResource("/imagenesInstrucciones/imagen1.png")));
        
        textRenglon1.setText("En Memorabble aparecerán una serie de");
        textRenglon2.setText("figuras de distintos colores sobre unas fichas.");
        textRenglon3.setText("Al cabo de unos segundos, las figuras");
        textRenglon4.setText("desaparecerán y tendras que responder una");
        textRenglon5.setText("pregunta");
        
        lblNumeroPag.setText("1/5");    
    }
    private void inicializarComponentesPag2()
    { 
        btnSiguientePag2.setVisible(false);
        btnSiguientePag4.setVisible(false);
        btnSiguientePag5.setVisible(false);
        
        btnAtrasPag2.setVisible(false);
        btnAtrasPag3.setVisible(false);
        btnAtrasPag4.setVisible(false);
        
        btnSiguientePag3.setVisible(true);
        btnAtrasPag1.setVisible(true);
        
        jpSeccionDerecha.add(btnSiguientePag3);
        jpSeccionIzquierda.add(btnAtrasPag1);

        lblImagenInstrucciones.setIcon(new ImageIcon(getClass().getResource("/imagenesInstrucciones/imagen2.png")));
        jpSeccionSuperior.add(lblImagenInstrucciones);
            
        textRenglon1.setText("La pregunta aparecerá en la parte inferior de la");
        textRenglon2.setText("pantalla cuando las figuras hayan");
        textRenglon3.setText("desaparecido.");
        textRenglon4.setText("Debes pulsar sobre la ficha que cumpla la");
        textRenglon5.setText("condición expresada en la pregunta");
        
        lblNumeroPag.setText("2/5");   
    }
    
    private void inicializarComponentesPag3()
    {
        
        btnSiguientePag2.setVisible(false);
        btnSiguientePag3.setVisible(false);
        btnSiguientePag5.setVisible(false);
        
        btnAtrasPag1.setVisible(false);
        btnAtrasPag3.setVisible(false);
        btnAtrasPag4.setVisible(false);
        btnSiguientePag4.setVisible(true);
        btnAtrasPag2.setVisible(true);
        
        jpSeccionDerecha.add(btnSiguientePag4);
        jpSeccionIzquierda.add(btnAtrasPag2);
        
        lblImagenInstrucciones.setIcon(new ImageIcon(getClass().getResource("/imagenesInstrucciones/imagen3.png")));
        jpSeccionSuperior.add(lblImagenInstrucciones);
        
        textRenglon1.setText("¡OJO! Es posible que haya que pulsar más de");
        textRenglon2.setText("una ficha...");
        textRenglon3.setText("");
        textRenglon4.setText("");
        textRenglon5.setText(""); 
        
        lblNumeroPag.setText("3/5");   
    }
        
    private void inicializarComponentesPag4()
    { 
        btnSiguientePag2.setVisible(false);
        btnSiguientePag3.setVisible(false);
        btnSiguientePag4.setVisible(false);
        
        btnAtrasPag1.setVisible(false);
        btnAtrasPag2.setVisible(false);
        btnAtrasPag4.setVisible(false);
        
        btnSiguientePag5.setVisible(true);
        btnAtrasPag3.setVisible(true);
        
        jpSeccionDerecha.add(btnSiguientePag5);
        jpSeccionIzquierda.add(btnAtrasPag3);
        
        lblImagenInstrucciones.setIcon(new ImageIcon(getClass().getResource("/imagenesInstrucciones/imagen4.png")));
        jpSeccionSuperior.add(lblImagenInstrucciones);
        
        textRenglon1.setText("En el ejemplo propuesto se nos pide que pulsemos");
        textRenglon2.setText("sobre las 3 fichas que contienen figuras");
        textRenglon3.setText("de color azul");
        textRenglon4.setText("");
        textRenglon5.setText("");

        lblNumeroPag.setText("4/5");
    }
    
    private void inicializarComponentesPag5()
    {
        btnSiguientePag2.setVisible(false);
        btnSiguientePag3.setVisible(false);
        btnSiguientePag4.setVisible(false);
        btnSiguientePag5.setVisible(false);
        
        btnAtrasPag1.setVisible(false);
        btnAtrasPag2.setVisible(false);
        btnAtrasPag3.setVisible(false);
        
        btnAtrasPag4.setVisible(true);
        
        jpSeccionIzquierda.add(btnAtrasPag4);
    
        lblImagenInstrucciones.setIcon(new ImageIcon(getClass().getResource("/imagenesInstrucciones/imagen5.png")));
        jpSeccionSuperior.add(lblImagenInstrucciones);
        
        textRenglon1.setText("Es importante que memorices formas,");
        textRenglon2.setText("colores y posiciones de cada ficha.");
        textRenglon3.setText("");
        textRenglon4.setText("¡APROVECHA CADA SEGUNDO");
        textRenglon5.setText("Y HAZ ALGO MEMORRABLE!");
        
        lblNumeroPag.setText("5/5");    
    }
        
    private void botonDerecho(JButton boton)
    {
        if(boton!=null)
        {
            boton.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,12));
            boton.setForeground(Color.white);
            boton.setBounds(10,140,150,50);
            boton.setBackground(Color.ORANGE.darker());
            boton.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
            boton.setFocusable(false);
            boton.addActionListener(new ManejadoraDeEventos());
            boton.addMouseListener(new ManejadoraDeMouse());
            boton.setVisible(false);
        }
    }
    
    private void botonIzquierdo(JButton boton)
    {
        if(boton!=null)
        {
            boton.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,12));
            boton.setForeground(Color.white);
            boton.setBounds(10,140,150,50);
            boton.setBackground(Color.ORANGE.darker());
            boton.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
            boton.setFocusable(false);
            boton.addActionListener(new ManejadoraDeEventos());
            boton.addMouseListener(new ManejadoraDeMouse());
            boton.setVisible(false);
        }
    }
    
    class ManejadoraDeEventos implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evento) 
        {
            if(evento.getSource() == btnMenuPrincipal)
            {                
                volverMenuPrincipal();
            }
            else if(evento.getSource() == btnAtrasPag1)
            {
                inicializarComponentesPag1();
                repaint();
            }
            else if(evento.getSource() == btnSiguientePag2)
            {
                inicializarComponentesPag2();
                repaint();
            }
            else if(evento.getSource() == btnAtrasPag2)
            {
                inicializarComponentesPag2();
                repaint();
            }   
            else if(evento.getSource() == btnSiguientePag3)
            {
                inicializarComponentesPag3();
                repaint();
            }           
            else if(evento.getSource() == btnAtrasPag3)
            {
                inicializarComponentesPag3();
                repaint();
            }          
            else if(evento.getSource() == btnSiguientePag4)
            {
                inicializarComponentesPag4();
                repaint();
            }
            else if(evento.getSource() == btnAtrasPag4)
            {
                inicializarComponentesPag4();
                repaint();
            }
            else if(evento.getSource() == btnSiguientePag5)
            {
                inicializarComponentesPag5();
                repaint();
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
    
    private void volverMenuPrincipal() 
    {
        VentanaMenu menu = new VentanaMenu();
        dispose();
    }    
}
 

