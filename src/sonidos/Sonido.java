/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sonidos;

import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Yenny Rivas Tello <yenny.rivas@correounivalle.edu.co>
 */
public class Sonido 
{  
    private Clip audio;
    private InputStream  ruta;
    private boolean estado=true;
    
    public Sonido()
    {

    }
    
    public void iniciarSonido(String nombreSonido)
    {
       try 
       {
            if(estado==true)
            {
                ruta =getClass().getResourceAsStream(nombreSonido);
                audio = AudioSystem.getClip();
                audio.open(AudioSystem.getAudioInputStream(ruta));
                audio.start();
            }
       } 
       catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) 
       {
            System.out.println("Error al reproducir el sonido.");
       }
    }
    
    public void continuarSonido(){
        if(audio!=null)
        {
            if(estado==true)
            {
                audio.start();
            }
        }
    }
    public void pararSonido()
    {
        if(audio!=null)
        {
            audio.stop();
        }
    }
    
    public void setEstado(boolean estadoBoton)
    {
        this.estado = estadoBoton;
    }
    
    public void setBucle()
    {
        audio.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void cerrarSonido()
    {
        if(audio!=null)
        {
            audio.close();
        }
    }
}
       
    

