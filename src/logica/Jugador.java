/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 * 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Yenny Rivas Tello <yenny.rivas@correounivalle.edu.co>
 */
public class Jugador 
{ 
    private String nombre;
    private int puntuacion;
    private int vidas;
    private int cantidadAciertos;
    private int cantidadFallos;
    
    public Jugador() 
    {
        puntuacion = 0;
        vidas = 3;
        cantidadAciertos = 0;
        cantidadFallos = 0;
    }
    
    public String getNombre()
    { 
        return nombre;
    }   
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public int getVidas()
    {
        return vidas;
    }
    
    public void disminuirVidas()
    { 
        vidas--;
    }
    
    public int getPuntuacion()
    {
        return puntuacion;
    }
    
    public void aumentarPuntuacion()
    {
        puntuacion=puntuacion+100;
    }
    
    public int getCantidadAciertos()
    {
        return cantidadAciertos;
    }

    private void aumentarAciertos()
    {
        cantidadAciertos++;   
    }
    
    public int getCantidadFallos()
    {
        return cantidadFallos;
    }
    
    public void aumentarFallos()
    {
        cantidadFallos++;
    }
}
