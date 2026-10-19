
package com.angeldz.hilo2;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Liebre extends Participante {

    public Liebre(ProgressBar progressBar, Label statusLabel) {
        super("Liebre", progressBar, statusLabel);
    }

    @Override
    public void correr() throws InterruptedException {
        for (double i = 0.0; i <= 1.0; i += 0.02) {
            final double avance = i;
            

            if (Math.abs(avance - 0.50) < 0.01) {
                Platform.runLater(() -> statusLabel.setText("La liebre:se durmio"));
                Thread.sleep(4000); 
                Platform.runLater(() -> statusLabel.setText("La liebre: desperto, esta corriendo"));
            } else if (avance < 0.50) {
                Platform.runLater(() -> statusLabel.setText("La liebre: esta corriendo"));
            } else {
                Platform.runLater(() -> statusLabel.setText("La liebre: corre desesperada"));
            }

          
            Platform.runLater(() -> progressBar.setProgress(avance));
            
            Thread.sleep(100); 
        }
        Platform.runLater(() -> statusLabel.setText("La liebre: llegoo a la meta"));
    }
}