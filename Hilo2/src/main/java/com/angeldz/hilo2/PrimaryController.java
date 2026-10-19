package com.angeldz.hilo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class PrimaryController {

    @FXML
    private Button btnIniciar;

    @FXML
    private Label lblLiebreStatus;

    @FXML
    private Label lblTortugaStatus;

    @FXML
    private ProgressBar progressLiebre;

    @FXML
    private ProgressBar progressTortuga;

    @FXML
    void iniciarCarrera(ActionEvent event) {

        btnIniciar.setDisable(true);


        progressLiebre.setProgress(0);
        progressTortuga.setProgress(0);
        lblLiebreStatus.setText("La liebre: lista");
        lblTortugaStatus.setText("La tortuga:lista");

       
        Participante liebre = new Liebre(progressLiebre, lblLiebreStatus);
        Participante tortuga = new Tortuga(progressTortuga, lblTortugaStatus);

       
        Thread hiloLiebre = new Thread(liebre);
        Thread hiloTortuga = new Thread(tortuga);

        
        hiloLiebre.setDaemon(true);
        hiloTortuga.setDaemon(true);

       
        hiloLiebre.start();
        hiloTortuga.start();
        
        
    }
}