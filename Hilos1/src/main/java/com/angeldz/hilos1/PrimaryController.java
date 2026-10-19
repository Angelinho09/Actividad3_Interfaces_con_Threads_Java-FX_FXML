package com.angeldz.hilos1;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {


    @FXML private TextField txtConteo;
    @FXML private ProgressBar barraProgreso;
    @FXML private Button btnEsperar;


    private int numeroDeClics = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        barraProgreso.setProgress(0.0);
    }


    @FXML
    private void accionContar(ActionEvent event) {
        numeroDeClics++; 
        txtConteo.setText(String.valueOf(numeroDeClics)); 
    }


    @FXML
    private void accionEsperar(ActionEvent event) {
        
        btnEsperar.setDisable(true);
        
       
        TrabajadorBarra miTrabajador = new TrabajadorBarra();
        Thread hiloSecundario = new Thread(miTrabajador);
        hiloSecundario.start();
    }

    
    private class TrabajadorBarra implements Runnable {
        @Override
        public void run() {
            
            for (double i = 0; i <= 1.0; i += 0.01) {
                final double progreso = i;

                
                Platform.runLater(() -> {
                    barraProgreso.setProgress(progreso);
                });

                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

           
            Platform.runLater(() -> {
                btnEsperar.setDisable(false);
            });
        }
    }
}