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
    import javax.swing.JTextArea;
    import javax.swing.JTextPane;
    import javax.swing.SwingConstants;
    import javax.swing.SwingUtilities;
    import tipografiam.Fuentes;
    import javax.swing.*;

public class VentanaInstrucciones extends JFrame {
    
    Color moradoClaro;
    Color morado;

    Fuentes tipoFuente;
    private FondoVentana jpFondo;
    private JPanel jpImagen;
    private JPanel jpInferior;
    private JLabel text1;
    private JLabel text2;
    private JLabel text3;
    private JLabel text4;
    private JLabel text5;
    private JButton btnSiguiente1;
    private JButton btnSiguiente2;
    private JButton btnSiguiente3;
    private JButton btnSiguiente4;
    private JButton btnAtras1;
    private JButton btnAtras2;
    private JButton btnAtras3;
    private JButton btnAtras4;
    private JButton btnMenuPrincipal;
    private JLabel lblImg;
    private JPanel jpizq;
    private JPanel jpder;
    private JLabel numero;

    
    public VentanaInstrucciones()
    
    {
        setTitle("Memorabble-Instrucciones");
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

        btnAtras1 = new JButton("ATRAS");
        botonIzquierdo(btnAtras1);
        btnSiguiente1 = new JButton("SIGUIENTE");
        botonDerecho(btnSiguiente1);
        btnAtras2 = new JButton("ATRAS");
        botonIzquierdo(btnAtras2);
        btnSiguiente2 = new JButton("SIGUIENTE");
        botonDerecho(btnSiguiente2);
        btnAtras3 = new JButton("ATRAS");
        botonIzquierdo(btnAtras3);
        btnSiguiente3 = new JButton("SIGUIENTE");
        botonDerecho(btnSiguiente3);
        btnAtras4 = new JButton("ATRAS");
        botonIzquierdo(btnAtras4);
        btnSiguiente4 = new JButton("SIGUIENTE");
        botonDerecho(btnSiguiente4);
        inicializarComponentes();
    }

    private void inicializarComponentes() 
    {
        
        jpizq = new JPanel();
        jpizq.setSize(245,245);        
        jpizq.setBounds(0,0, 170, 245);
        jpizq.setLayout(null);
        jpizq.setOpaque(false); 
        
        btnMenuPrincipal = new JButton("MENU PRINCIPAL");
        btnMenuPrincipal.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,12));
        btnMenuPrincipal.setForeground(Color.white);
        btnMenuPrincipal.setBounds(10,40,150,50);
        btnMenuPrincipal.setBackground(Color.ORANGE.darker());
        btnMenuPrincipal.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        btnMenuPrincipal.setFocusable(false);
        btnMenuPrincipal.addActionListener(new ManejadoraDeEventos());
        btnMenuPrincipal.addMouseListener(new ManejadoraDeMouse());
        jpizq.add(btnMenuPrincipal);
        

       
        
        jpImagen = new JPanel();
        jpImagen.setSize(736,293);        
        jpImagen.setBounds(170,10, 380, 245);
        jpImagen.setLayout(null);
        jpImagen.setOpaque(false); 
        
        lblImg = new JLabel();
        lblImg.setBounds(0,0, 380, 245);
        lblImg.setIcon(new ImageIcon(getClass().getResource("/imagenesInstrucciones/imagen1.png")));
        lblImg.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        jpImagen.add(lblImg);
        
        jpInferior = new JPanel();
        jpInferior.setSize(720,196);        
        jpInferior.setBounds(40,260, 640, 190);
        jpInferior.setLayout(null);
        //jpInferior.setOpaque(false); 
        jpInferior.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        jpInferior.setBackground(morado);

        
        text1 = new JLabel( "En Memorabble aparecerán una serie de",SwingConstants.CENTER);
        text1.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        text1.setBounds(0, 25, 650, 25);
        text1.setForeground(Color.white);
        text1.setBackground(morado);
        //text1.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        //text1.setFocusable(false);
        jpInferior.add(text1);
        
        text2 = new JLabel( "figuras de distintos colores sobre unas fichas.",SwingConstants.CENTER);
        text2.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        text2.setBounds(0, 55, 650, 25);
        text2.setForeground(Color.white);
        text2.setBackground(morado);
        //text2.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        text2.setFocusable(false);
        jpInferior.add(text2);
        
        text3 = new JLabel( "Al cabo de unos segundos, las figuras",SwingConstants.CENTER);
        text3.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        text3.setBounds(0, 85, 650, 25);
        text3.setForeground(Color.white);
        //text3.setBackground(morado);
        //text3.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        text3.setFocusable(false);
        jpInferior.add(text3);
        
        text4 = new JLabel( "desaparecerán y tendras que responder una",SwingConstants.CENTER);
        text4.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        text4.setBounds(0, 115, 650, 25);
        text4.setForeground(Color.white);
        //text4.setBackground(morado);
        //text4.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        text4.setFocusable(false);
        jpInferior.add(text4);
        
        text5 = new JLabel( "pregunta",SwingConstants.CENTER);
        text5.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        text5.setBounds(0, 145, 650, 25);
        text5.setForeground(Color.white);
        //text5.setBackground(morado);
        //text5.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        text5.setFocusable(false);
        jpInferior.add(text5);
        
        jpder = new JPanel();
        jpder.setSize(170,245);        
        jpder.setBounds(550,0, 170, 245);
        jpder.setLayout(null);
        jpder.setOpaque(false); 
        
        btnSiguiente1.setVisible(true);
        
        numero = new JLabel("1/5");
        numero.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,30));  
        numero.setBounds(110, 0, 65, 65);
        numero.setForeground(Color.white);
        //text3.setBackground(morado);
        //text3.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        numero.setFocusable(false);
        numero.setOpaque(false);
        jpder.add(numero);
        
        btnSiguiente1.setVisible(true);
        jpder.add(btnSiguiente1);
        
        
        this.getContentPane().add(jpizq);
        this.getContentPane().add(jpder);
        this.getContentPane().add(jpImagen);
        this.getContentPane().add(jpInferior);
        this.getContentPane().add(jpFondo);
        setVisible(true);

        
    }
    private void inicializarComponentes1()
        {

        btnSiguiente2.setVisible(false);
        btnSiguiente3.setVisible(false);
        btnSiguiente4.setVisible(false);
        btnAtras1.setVisible(false);
        btnAtras2.setVisible(false);
        btnAtras3.setVisible(false);
        btnAtras4.setVisible(false);
        btnSiguiente1.setVisible(true);
        
        lblImg.setIcon(new ImageIcon(getClass().getResource("/imagenesInstrucciones/imagen1.png")));
        
        text1.setText("En Memorabble aparecerán una serie de");
        text2.setText("figuras de distintos colores sobre unas fichas.");
        text3.setText("Al cabo de unos segundos, las figuras");
        text4.setText("desaparecerán y tendras que responder una");
        text5.setText("pregunta");
        text4.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20)); 
        text5.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20)); 
        
        numero.setText("1/5");
        
    }
    private void inicializarComponentes2()
        {
        
        btnSiguiente1.setVisible(false);
        btnSiguiente3.setVisible(false);
        btnSiguiente4.setVisible(false);
        btnAtras2.setVisible(false);
        btnAtras3.setVisible(false);
        btnAtras4.setVisible(false);
        btnSiguiente2.setVisible(true);
        btnAtras1.setVisible(true);
        jpder.add(btnSiguiente2);
        jpizq.add(btnAtras1);

        lblImg.setIcon(new ImageIcon(getClass().getResource("/imagenesInstrucciones/imagen2.png")));
        jpImagen.add(lblImg);
            
        text1.setText("La pregunta aparecerá en la parte inferior de la");
        text2.setText("pantalla cuando las figuras hayan");
        text3.setText("desaparecido.");
        text4.setText("Debes pulsar sobre la ficha que cumpla la");
        text5.setText("condición expresada en la pregunta");
        text4.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20)); 
        text5.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20)); 
        
        numero.setText("2/5");
        
        
    }
    
        private void inicializarComponentes3()
        {
        
        btnSiguiente1.setVisible(false);
        btnSiguiente2.setVisible(false);
        btnSiguiente4.setVisible(false);
        btnAtras1.setVisible(false);
        btnAtras3.setVisible(false);
        btnAtras4.setVisible(false);
        btnSiguiente3.setVisible(true);
        btnAtras2.setVisible(true);
        jpder.add(btnSiguiente3);
        jpizq.add(btnAtras2);
        
    
        lblImg.setIcon(new ImageIcon(getClass().getResource("/imagenesInstrucciones/imagen3.png")));
        jpImagen.add(lblImg);
        
        text1.setText("¡OJO! Es posible que haya que pulsar más de");
        text2.setText("una ficha...");
        text3.setText("");
        text4.setText("");
        text5.setText("");
        text4.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20)); 
        text5.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20)); 
        
        numero.setText("3/5");
        
        
    }
        
    private void inicializarComponentes4()
        {
        
        btnSiguiente1.setVisible(false);
        btnSiguiente2.setVisible(false);
        btnSiguiente3.setVisible(false);
        btnAtras1.setVisible(false);
        btnAtras2.setVisible(false);
        btnAtras4.setVisible(false);
        btnSiguiente4.setVisible(true);
        btnAtras3.setVisible(true);
        jpder.add(btnSiguiente4);
        jpizq.add(btnAtras3);
        
    
        lblImg.setIcon(new ImageIcon(getClass().getResource("/imagenesInstrucciones/imagen4.png")));
        jpImagen.add(lblImg);
        
        text1.setText("En el ejemplo propuesto se nos pide que pulsemos");
        text2.setText("sobre las 3 fichas que contienen figuras");
        text3.setText("de color azul");
        text4.setText("");
        text5.setText("");
        text4.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20)); 
        text5.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20)); 

        numero.setText("4/5");

    }
    
   private void inicializarComponentes5()
        {
        
        btnSiguiente1.setVisible(false);
        btnSiguiente2.setVisible(false);
        btnSiguiente3.setVisible(false);
        btnSiguiente4.setVisible(false);
        btnAtras1.setVisible(false);
        btnAtras2.setVisible(false);
        btnAtras3.setVisible(false);
        btnAtras4.setVisible(true);
        jpizq.add(btnAtras4);
        
    
        lblImg.setIcon(new ImageIcon(getClass().getResource("/imagenesInstrucciones/imagen5.png")));
        jpImagen.add(lblImg);
        
        
        text1.setText("Es importante que memorices formas,");
        text2.setText("colores y posiciones de cada ficha.");
        text3.setText("");
        text4.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,30)); 
        text4.setText("¡APROVECHA CADA SEGUNDO");
        text5.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,30)); 
        text5.setText("Y HAZ ALGO MEMORRABLE!");
        
        numero.setText("5/5");
        
    }
        
        private void botonDerecho(JButton boton)
        {
            if(boton!=null){
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
            if(boton!=null){
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
                abrirMenuPrincipal();
            }
            
            else if(evento.getSource() == btnAtras1)
            {
                inicializarComponentes1();
                repaint();

            }
            
            else if(evento.getSource() == btnSiguiente1)
            {
                inicializarComponentes2();
                repaint();
            }
            else if(evento.getSource() == btnAtras2)
            {
                inicializarComponentes2();
                repaint();
 
            }
            
            else if(evento.getSource() == btnSiguiente2)
            {
                inicializarComponentes3();
                repaint();
            }
            
            else if(evento.getSource() == btnAtras3)
            {
                inicializarComponentes3();
                repaint();

            }
            
            else if(evento.getSource() == btnSiguiente3)
            {
                inicializarComponentes4();
                repaint();
            }
            else if(evento.getSource() == btnAtras4)
            {
                inicializarComponentes4();
                repaint();
 
            }
            
            else if(evento.getSource() == btnSiguiente4)
            {
                inicializarComponentes5();
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
    
    private void abrirMenuPrincipal() 
    {
        VentanaMenu ventana = new VentanaMenu();
        dispose();
    }
    
}
 

