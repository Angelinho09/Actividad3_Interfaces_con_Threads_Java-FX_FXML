
package com.angeldz.hilo2;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;


public abstract class Participante implements Runnable {
    
    protected String nombre;
    protected ProgressBar progressBar;
    protected Label statusLabel;

    public Participante(String nombre, ProgressBar progressBar, Label statusLabel) {
        this.nombre = nombre;
        this.progressBar = progressBar;
        this.statusLabel = statusLabel;
    }


    public abstract void correr() throws InterruptedException;

    @Override
    public void run() {
        try {
            correr();
        } catch (InterruptedException e) {
            System.out.println("La carrera de " + nombre + " fue interrumpida.");
        }
    }
}
