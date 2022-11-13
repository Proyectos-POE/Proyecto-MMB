/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Yenny Rivas Tello <yenny.rivas@correounivalle.edu.co>
 */
public class JuegoMemorabble 
{
    private final Jugador jugador;
    private Ficha[] listaDeFichas;
    private final String[] categoriasDeJuego;
    private RondaMemorabble ronda;
    private int tiempoJuego;
    private Timer timerTiempoJuego;
    
    public JuegoMemorabble(Jugador jugador)
    {  
        this.categoriasDeJuego = new String[]{"Color", "Forma", "FormaColor"};
        crearFichas();
        contarTiempoJuego();
        this.jugador = jugador;
    }
    
    public void iniciarRonda()
    {
        ronda = new RondaMemorabble();
        ronda.aumentarDificultad();
        ronda.elegirCategoria(categoriasDeJuego);
        ronda.elegirFichas(listaDeFichas);
        ronda.elegirCondicion();  
    }
    
    private void crearFichas()
    {
        String[] formas = {"Circulo", "Diamante", "Rayo", "Triangulo", "Cuadrado", "Estrella", "Corazon"};
        String[] colores = {"Rojo", "Verde", "Morado", "Negro", "Azul"};
        listaDeFichas = new Ficha[35];
        int numeroFicha = 0;
        for (String forma : formas) 
        {
            for (String color : colores) 
            {
                listaDeFichas[numeroFicha] = new Ficha();
                listaDeFichas[numeroFicha].setForma(forma);
                listaDeFichas[numeroFicha].setColor(color);
                listaDeFichas[numeroFicha].asignarImagen();
                numeroFicha++;
            }
        }
    }
    
    public boolean esLaFicha(Ficha fichaSeleccionada)
    {   
        if(ronda.esLaFicha(fichaSeleccionada))
        {   
            jugador.aumentarPuntuacion();     
            jugador.aumentarAciertos();
            return true;
        }
        else 
        {
            jugador.disminuirVidas();
            jugador.aumentarFallos();
            return false;
        }
    }   
    
    public boolean sonTodasLasFicha()
    {   
        return ronda.sonTodasLasFichas();
    }
    
    public boolean terminoJuego()
    {
        return jugador.getVidas() == 0;
    }
    
    public String getCondicion()
    {
        return ronda.getCondicion();
    }
    
    public Ficha[] getFichasEnRonda()
    {
        return ronda.getFichasEnRonda();
    }
    
    public int getTiempoMostrar()
    {
        return ronda.getTiempoMostrar();
    }
    
    public void disminuirTiempoMostrar()
    {   
        ronda.disminuirTiempoMostrar();
    }
       
    public int getTiempoJuego()
    {
        return tiempoJuego;
    }
    
    public void contarTiempoJuego()
    {
        timerTiempoJuego = new Timer(1000, null);
        timerTiempoJuego.start();
        timerTiempoJuego.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                tiempoJuego++;   
            }
        });
    }
    
    public void pararContarTiempoJuego()
    {
        timerTiempoJuego.stop();
    }
      
    public String getNombreJugador()
    {
        return jugador.getNombre();
    }
    
    public int getVidasJugador()
    {
        return jugador.getVidas();
    }
    
    public int getPuntuacionJugador()
    {
        return jugador.getPuntuacion();
    }
    
    public int getCantidadAciertosJugador()
    {
        return jugador.getCantidadAciertos();
    }
    
    public int getCantidadFallosJugador()
    {
        return jugador.getCantidadFallos();
    } 
    
    public Jugador getJugador()
    {
     return jugador;
    }    
}
