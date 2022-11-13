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
import javax.swing.SwingConstants;
import logica.Jugador;
import tipografiam.Fuentes;

/**
 * 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Yenny Rivas Tello <yenny.rivas@correounivalle.edu.co>
 */
public class VentanaResultados extends JFrame
{
    Color moradoClaro;
    Color morado;
    Fuentes tipoFuente;
    private FondoVentana jpFondo;
    private JPanel jpSeccionSuperior;
    private JPanel jpSeccionCentral;
    private JPanel jpSeccionInferior;
    private JLabel lblTitulo;
    private JLabel lblAciertos;
    private JLabel lblFallos;
    private JLabel lblPuntaje;
    private JLabel lblTiempo;
    private JButton btnVolverJugar;
    private JButton btnFinalizar;
            
    public VentanaResultados(Jugador jugador,int tiempoJuego)
    {
        inicializarComponentes(jugador, tiempoJuego);
    }
    
    private void inicializarComponentes(Jugador jugador, int tiempoJuego)
    {
        setTitle("MEMORABBLE-RESULTADOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(736,489);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        
        moradoClaro = new Color(229,204, 255);
        morado = new Color(51,0, 102);
        
        tipoFuente = new Fuentes();
        
        jpFondo = new FondoVentana("/Fondo/FondoVentana.png");
        jpFondo.setSize(720,450);
        jpFondo.setLayout(null);

        jpSeccionSuperior = new JPanel();
        jpSeccionSuperior.setSize(736,200);        
        jpSeccionSuperior.setBounds(0,0, 736, 200);
        jpSeccionSuperior.setLayout(null);
        jpSeccionSuperior.setOpaque(false); 
        
        lblTitulo = new JLabel("RESULTADOS", SwingConstants.CENTER);
        lblTitulo.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,80));  
        lblTitulo.setBounds(0, 30, 726, 100);
        lblTitulo.setForeground(Color.white);
        jpSeccionSuperior.add(lblTitulo);
        
        jpSeccionCentral = new JPanel();
        jpSeccionCentral.setSize(606,190);        
        jpSeccionCentral.setBounds(65,150, 606, 190);
        jpSeccionCentral.setLayout(null);
        jpSeccionCentral.setBackground(morado);
        jpSeccionCentral.setBorder(BorderFactory.createLineBorder(moradoClaro,10));
        
        lblAciertos = new JLabel("CANTIDAD DE ACIERTOS: "+jugador.getCantidadAciertos(), SwingConstants.CENTER);
        lblAciertos.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        lblAciertos.setBounds(0, 20, 606, 30);
        lblAciertos.setForeground(Color.white);
        jpSeccionCentral.add(lblAciertos);
        
        lblFallos = new JLabel("CANTIDAD DE FALLOS: "+jugador.getCantidadFallos(), SwingConstants.CENTER);
        lblFallos.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        lblFallos.setBounds(0, 60, 606, 30);
        lblFallos.setForeground(Color.white);
        jpSeccionCentral.add(lblFallos);
        
        lblPuntaje = new JLabel("PUNTAJE TOTAL: "+jugador.getPuntuacion(), SwingConstants.CENTER);
        lblPuntaje.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        lblPuntaje.setBounds(0, 100, 606, 30);
        lblPuntaje.setForeground(Color.white);
        jpSeccionCentral.add(lblPuntaje);
        
        lblTiempo = new JLabel("TIEMPO JUGADO: "+ convertirTiempo(tiempoJuego), SwingConstants.CENTER);
        lblTiempo.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));  
        lblTiempo.setBounds(0, 140, 606, 30);
        lblTiempo.setForeground(Color.white);
        jpSeccionCentral.add(lblTiempo);
        
        jpSeccionInferior = new JPanel();
        jpSeccionInferior.setSize(606,190);        
        jpSeccionInferior.setBounds(65,360, 606, 80);
        jpSeccionInferior.setLayout(null);
        jpSeccionInferior.setOpaque(false);
        
        btnFinalizar = new JButton("FINALIZAR");
        btnFinalizar.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));
        btnFinalizar.setForeground(Color.white);
        btnFinalizar.setBounds(30,0,233,80);
        btnFinalizar.setBackground(morado);
        btnFinalizar.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        btnFinalizar.setFocusable(false);
        btnFinalizar.addActionListener(new ManejadoraDeEventos());
        btnFinalizar.addMouseListener(new ManejadoraDeMouse());
        jpSeccionInferior.add(btnFinalizar);
        
        btnVolverJugar = new JButton("VOLVER A JUGAR");
        btnVolverJugar.setFont(tipoFuente.fuente(tipoFuente.Marcador,1,20));
        btnVolverJugar.setForeground(Color.white);
        btnVolverJugar.setBounds(343,0,233,80);
        btnVolverJugar.setBackground(morado);
        btnVolverJugar.setBorder(BorderFactory.createLineBorder(moradoClaro, 10));
        btnVolverJugar.setFocusable(false);
        btnVolverJugar.addActionListener(new ManejadoraDeEventos());
        btnVolverJugar.addMouseListener(new ManejadoraDeMouse());
        jpSeccionInferior.add(btnVolverJugar);
        
        this.getContentPane().add(jpSeccionSuperior);
        this.getContentPane().add(jpSeccionCentral);
        this.getContentPane().add(jpSeccionInferior);
        this.getContentPane().add(jpFondo);
        setVisible(true);  
    }
  
  class ManejadoraDeEventos implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evento) 
        {
            if(evento.getSource() == btnVolverJugar)
            {                
                volverJugar();
            }
            if(evento.getSource() == btnFinalizar)
            {
                finalizarJuego();
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
    
    private void volverJugar()
    {
        VentanaMenu ventanMenu = new VentanaMenu();
        dispose();
    }
    
    private void finalizarJuego()
    {
        dispose();
    }
    
    private String convertirTiempo(int tiempo)
    {
        String tiempoJugado;
        if(tiempo < 61)
        {
            tiempoJugado = tiempo + " SEGUNDOS";
        }
        else
        {
            int minutos = tiempo/60;
            int segundos = (int)((((float)tiempo/(float)60) - (float)minutos)*60);
            tiempoJugado = minutos + " MINUTOS " + segundos + " SEGUNDOS";
        }
        return tiempoJugado;
    }
}
