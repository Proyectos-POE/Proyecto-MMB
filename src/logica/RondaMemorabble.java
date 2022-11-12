/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.Timer;

/**
 *
 * @author Nicolas Herrera <herrera.nicolas@correounivalle.edu.co>
 * @author Samuel Galindo Cuevas <samuel.galindo@correounivalle.edu.co>
 * @author Yenny Rivas Tello <yenny.rivas@correounivalle.edu.co>
 */
public class RondaMemorabble 
{
    private static int numeroRonda = 0;
    private static int nivelDificultad = 0;
    private String categoria;
    private String condicion;
    private Ficha[] listaDeFichasEnRonda;
    private int tiempoMostrar = 3;
    private int cantidadFichas = 2;
    
    public RondaMemorabble()
    {
        numeroRonda++;
    }
    
    public void elegirCategoria(String[] categorias)
    { 
        Random r = new Random();
        int numeroCategoria = r.nextInt(categorias.length);
        this.categoria = categorias[numeroCategoria]; 
    }
    
    public void elegirFichas(Ficha[] listaDeFichas)
    {
        Set<Ficha> fichasSinRepetir = new HashSet<>();
        listaDeFichasEnRonda = new Ficha[cantidadFichas];
        for(int i = 0; i < cantidadFichas; i++)
        {
            Ficha ficha = null;
            boolean fichaValida = false;
            while(!fichaValida)
            {
                Random r = new Random();
                int numeroFicha = r.nextInt(listaDeFichas.length);
                if(!fichasSinRepetir.contains(listaDeFichas[numeroFicha]))
                {
                    fichasSinRepetir.add(listaDeFichas[numeroFicha]);
                    ficha = listaDeFichas[numeroFicha];
                    fichaValida = true;
                }
            }
            listaDeFichasEnRonda[i] = ficha;
            listaDeFichasEnRonda[i].setAdivinaFicha(false);
        }     
    }
    
    public void elegirCondicion()
    {
        Random r = new Random();
        int numeroFicha = r.nextInt(listaDeFichasEnRonda.length);
        if(categoria != null)
        {
            switch (categoria) 
            {
                case "Color":
                    this.condicion = listaDeFichasEnRonda[numeroFicha].getColor();
                    break;
                case "Forma":
                    this.condicion = listaDeFichasEnRonda[numeroFicha].getForma();
                    break;
                case "FormaColor":
                    this.condicion = listaDeFichasEnRonda[numeroFicha].getForma() + listaDeFichasEnRonda[numeroFicha].getColor();
                    break;
                default:
                    break;
            }
        }  
    }
    
    public boolean esLaFicha(Ficha fichaSeleccionada)
    {   
        if(fichaSeleccionada != null)
        {
            switch (categoria) 
            {
                case "Color":
                    if(fichaSeleccionada.getColor().equals(condicion))
                    {
                        fichaSeleccionada.setAdivinaFicha(true);
                    }
                    return fichaSeleccionada.getColor().equals(condicion);
                case "Forma":
                    if(fichaSeleccionada.getForma().equals(condicion))
                    {
                        fichaSeleccionada.setAdivinaFicha(true);
                    }
                    return fichaSeleccionada.getForma().equals(condicion);
                case "FormaColor":
                    if((fichaSeleccionada.getForma() + fichaSeleccionada.getColor()).equals(condicion))
                    {
                        fichaSeleccionada.setAdivinaFicha(true);
                    }
                    return (fichaSeleccionada.getForma() + fichaSeleccionada.getColor()).equals(condicion);
                default:
                    return false;
            }
        }
        else
        {
            return false;
        }    
    }
    
    public boolean sonTodasLasFichas()
    {
        boolean adivinoTodasLasFichas = false;
        OUTER:
        for (Ficha ficha : listaDeFichasEnRonda) 
        {
            if (null != categoria) 
            {
                switch (categoria) 
                {
                    case "Color":
                        if (ficha.getColor().equals(condicion)) 
                        {
                            if (ficha.esAdivinada()) 
                            {
                                adivinoTodasLasFichas = true;
                            } 
                            else 
                            {
                                adivinoTodasLasFichas = false;
                                break OUTER;
                            }
                        }
                        break;
                    case "Forma":
                        if (ficha.getForma().equals(condicion)) 
                        {
                            if (ficha.esAdivinada()) 
                            {
                                adivinoTodasLasFichas = true;
                            } 
                            else 
                            {
                                adivinoTodasLasFichas = false;
                                break OUTER;
                            }
                        }
                        break;
                    case "FormaColor":
                        if ((ficha.getForma() + ficha.getColor()).equals(condicion)) 
                        {
                            if (ficha.esAdivinada()) 
                            {
                                adivinoTodasLasFichas = true;
                            } 
                            else 
                            {
                                adivinoTodasLasFichas = false;
                                break OUTER;
                            }
                        }
                        break;
                    default:
                        break;    
                }
            }
        }
        return adivinoTodasLasFichas;
    }
    
    public String getCondicion()
    {
        return condicion;
    }
    
    public Ficha[] getFichasEnRonda()
    {
        return listaDeFichasEnRonda;
    } 
    
    public int getTiempoMostrar()
    {
        return tiempoMostrar;
    }
    
    public void disminuirTiempoMostrar()
    {
        tiempoMostrar--;
    }
    
    public void aumentarDificultad()
    {
        if(nivelDificultad < 33)
        {
            if(numeroRonda == (3 * (nivelDificultad + 1)))
            {
                nivelDificultad++;
            }
        }
        cantidadFichas = cantidadFichas + (1 * nivelDificultad);
        tiempoMostrar = tiempoMostrar + (1 * nivelDificultad);
    }   
}
