/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import javax.swing.ImageIcon;

/**
 * 
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Yenny Rivas Tello <yenny.rivas@correounivalle.edu.co>
 */
public class Ficha 
{
    private String forma;
    private String color;
    private ImageIcon imagen;
    private boolean adivinada;
    
    public Ficha()
    {
        forma = "";
        color = "";
        imagen = null;
        adivinada = false;
    }
    
    public void setColor(String color)
    {
        this.color = color;
    }
    
    public String getColor()
    {
        return color;
    }
    
    public void setForma(String forma)
    {
        this.forma = forma;
    }
    
    public String getForma()
    {
        return forma;
    }
    
    public void asignarImagen()
    {
       this.imagen = new ImageIcon(getClass().getResource("/imagenesFichas/"+forma+color+".png"));
    }
    
    public ImageIcon getImagen()
    {
        return imagen;
    }
    
    public void setAdivinaFicha(boolean adivinoFicha)
    {
         this.adivinada = adivinoFicha;
    }
    
    public boolean esAdivinada()
    {
        return adivinada;
    }
}
