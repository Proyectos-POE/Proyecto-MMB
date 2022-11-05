/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import tipografiam.Fuentes;

/**
 * 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Yenny Rivas Tello <yenny.rivas@correounivalle.edu.co>
 */
public class VentanaParaQueSirve extends JFrame
{
    Color moradoClaro;
    Color morado;

    Fuentes tipoFuente;
    private FondoVentana jpFondo;
    private JPanel jpContenido;
    private JLabel lblTitulo;
    private JButton btnMenuPrincipal;
    private JTextArea areaParaQue;
    
    public VentanaParaQueSirve()
    {
        inicializarComponentes();
    }

    private void inicializarComponentes() 
    {
        setTitle("Memorabble-Para Que Sirve");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(736,489);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        
        tipoFuente = new Fuentes();
        
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
        
        areaParaQue = new JTextArea( "      Un juego que te permite entrenar tu capacidad de\n codificación y recuerdo de informacion visual y espacial.\n  Este tipo de habilidades es relevante  en la practica de\n    algunos deportes, el reconocimiento de caras o para\n            recordar donde guardamos nuestras cosas");
        areaParaQue.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        areaParaQue.setBounds(50, 170, 626, 180);
        areaParaQue.setAlignmentX(RIGHT_ALIGNMENT);
        areaParaQue.setHighlighter(null);
        areaParaQue.setEditable(false);
        areaParaQue.setForeground(Color.white);
        areaParaQue.setBackground(morado);
        areaParaQue.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        areaParaQue.setFocusable(false);
        jpContenido.add(areaParaQue);
        
        
        btnMenuPrincipal = new JButton("Menu principal");
        btnMenuPrincipal.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));
        btnMenuPrincipal.setForeground(Color.white);
        btnMenuPrincipal.setBounds(253,365,200,60);
        btnMenuPrincipal.setBackground(morado);
        btnMenuPrincipal.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        btnMenuPrincipal.setFocusable(false);
        btnMenuPrincipal.addActionListener(new ManejadoraDeEventos());
        btnMenuPrincipal.addMouseListener(new ManejadoraDeMouse());
        jpContenido.add(btnMenuPrincipal);
        
        this.getContentPane().add(jpContenido);
        this.getContentPane().add(jpFondo);
        setVisible(true);
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
