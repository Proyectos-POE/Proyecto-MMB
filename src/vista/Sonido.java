/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author sazuk
 */
public class Sonido {
    
    private Clip audio;
    private InputStream  ruta;
    private boolean estado=true;
    
    public Sonido(){

    }
    
    public void iniciarSonido(String nombreSonido){
       try {
            if(estado==true)
            {
            ruta =getClass().getResourceAsStream(nombreSonido);
            audio = AudioSystem.getClip();
            audio.open(AudioSystem.getAudioInputStream(ruta));
            audio.start();
            }
       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
         System.out.println("Error al reproducir el sonido.");}
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
    public void pararSonido(){
        if(audio!=null)
        {
            audio.stop();
        }
    }
    
    public void setEstado(boolean estadoBoton){
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
       
    

