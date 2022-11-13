/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import fondo.FondoVentana;
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
import logica.JuegoMemorabble;
import logica.Jugador;
import tipografiam.Fuentes;

/**
 *
 * @author Usuario
 */
public class VentanaResultados extends JFrame{
    
    
    
        Color moradoClaro;
    Color morado;

    Fuentes tipoFuente;
    private FondoVentana jpFondo;
    private JPanel jpSuperior;
    private JPanel jpCentral;
    private JPanel jpInferior;
    private JLabel lblTitulo;
    private JLabel lblAciertos;
    private JLabel lblFallos;
    private JLabel lblPuntaje;
    private JLabel lblTiempo;
    private JButton btnMenuPrincipal;
    private JButton btnFinalizar;
            
    
    
    public VentanaResultados(Jugador jugador,int tiempo){
        
        inicializarComponentes( jugador, tiempo);
    }
    
  
  private void inicializarComponentes(Jugador jugador, int tiempoJuego){
      setTitle("MEMORABBLE-RESULTADOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(736,489);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        
        tipoFuente = new Fuentes();
        
        jpFondo = new FondoVentana("/Fondo/FondoVentana.png");
        jpFondo.setSize(720,450);
        jpFondo.setLayout(null);

        jpSuperior = new JPanel();
        jpSuperior.setSize(736,200);        
        jpSuperior.setBounds(0,0, 736, 200);
        jpSuperior.setLayout(null);
        jpSuperior.setOpaque(false); 
        
        moradoClaro = new Color(229,204, 255);
        morado = new Color(51,0, 102);
        
        lblTitulo = new JLabel("RESULTADOS", SwingConstants.CENTER);
        lblTitulo.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,80));  
        lblTitulo.setBounds(0, 30, 726, 100);
        lblTitulo.setForeground(Color.white);
        jpSuperior.add(lblTitulo);
        
        jpCentral = new JPanel();
        jpCentral.setSize(606,190);        
        jpCentral.setBounds(65,150, 606, 190);
        jpCentral.setLayout(null);
        jpCentral.setBackground(morado);
        jpCentral.setBorder(BorderFactory.createLineBorder(moradoClaro,10));
        
        lblAciertos = new JLabel("CANTIDAD DE ACIERTOS: "+jugador.getCantidadAciertos(), SwingConstants.CENTER);
        lblAciertos.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,30));  
        lblAciertos.setBounds(0, 20, 606, 30);
        lblAciertos.setForeground(Color.white);
        jpCentral.add(lblAciertos);
        
        lblFallos = new JLabel("CANTIDAD DE FALLOS: "+jugador.getCantidadFallos(), SwingConstants.CENTER);
        lblFallos.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,30));  
        lblFallos.setBounds(0, 60, 606, 30);
        lblFallos.setForeground(Color.white);
        jpCentral.add(lblFallos);
        
        lblPuntaje = new JLabel("PUNTAJE TOTAL: "+jugador.getPuntuacion(), SwingConstants.CENTER);
        lblPuntaje.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,30));  
        lblPuntaje.setBounds(0, 100, 606, 30);
        lblPuntaje.setForeground(Color.white);
        jpCentral.add(lblPuntaje);
        
        lblTiempo = new JLabel("TIEMPO JUGADO: "+tiempoJuego+" SEGUNDOS", SwingConstants.CENTER);
        lblTiempo.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,30));  
        lblTiempo.setBounds(0, 140, 606, 30);
        lblTiempo.setForeground(Color.white);
        jpCentral.add(lblTiempo);
        
        jpInferior = new JPanel();
        jpInferior.setSize(606,190);        
        jpInferior.setBounds(65,360, 606, 80);
        jpInferior.setLayout(null);
        jpInferior.setOpaque(false);
        
        btnFinalizar = new JButton("FINALIZAR");
        btnFinalizar.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));
        btnFinalizar.setForeground(Color.white);
        btnFinalizar.setBounds(30,0,233,80);
        btnFinalizar.setBackground(morado);
        btnFinalizar.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        btnFinalizar.setFocusable(false);
        btnFinalizar.addActionListener(new ManejadoraDeEventos());
        btnFinalizar.addMouseListener(new ManejadoraDeMouse());
        jpInferior.add(btnFinalizar);
        
        btnMenuPrincipal = new JButton("VOLVER A JUGAR");
        btnMenuPrincipal.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));
        btnMenuPrincipal.setForeground(Color.white);
        btnMenuPrincipal.setBounds(343,0,233,80);
        btnMenuPrincipal.setBackground(morado);
        btnMenuPrincipal.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        btnMenuPrincipal.setFocusable(false);
        btnMenuPrincipal.addActionListener(new ManejadoraDeEventos());
        btnMenuPrincipal.addMouseListener(new ManejadoraDeMouse());
        jpInferior.add(btnMenuPrincipal);
        
        this.getContentPane().add(jpSuperior);
        this.getContentPane().add(jpCentral);
        this.getContentPane().add(jpInferior);
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
                VentanaMenu ventanMenu = new VentanaMenu();
                dispose();
            }
            if(evento.getSource() == btnFinalizar)
            {
                dispose();
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
