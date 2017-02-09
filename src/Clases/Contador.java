/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author MGC
 */
public class Contador {
    String numSerie;
    String nombrePila;
    
    public Contador(String numSerie, String nombrePila){
        this.numSerie = numSerie;
        this.nombrePila = nombrePila;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public String getNombrePila() {
        return nombrePila;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public void setNombrePila(String nombrePila) {
        this.nombrePila = nombrePila;
    }
    
    
    
}
