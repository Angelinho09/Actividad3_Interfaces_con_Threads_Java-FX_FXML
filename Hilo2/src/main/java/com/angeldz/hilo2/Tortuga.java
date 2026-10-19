
package com.angeldz.hilo2;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Tortuga extends Participante {

    public Tortuga(ProgressBar progressBar, Label statusLabel) {
        super("Tortuga", progressBar, statusLabel);
    }

    @Override
    public void correr() throws InterruptedException {
        for (double i = 0.0; i <= 1.0; i += 0.01) {
            final double avance = i;
            
            Platform.runLater(() -> {
                statusLabel.setText("La tortuga:Est corriendo");
                progressBar.setProgress(avance);
            });
            
            Thread.sleep(120);
        }
        Platform.runLater(() -> statusLabel.setText("La tortuga: llego a la meta"));
    }
}
