package com.kesehatan.pbotubes;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;

public class MenuController {

    @FXML
    private Label namaPasienLabel;

    public void setNamaPasien(String namaPasien) {
        namaPasienLabel.setText(namaPasien);
    }

    @FXML
    private TextField suhuTubuhField;
    @FXML
    private TextField detakJantungField;
    @FXML
    private TextField tekananDarahField;

    @FXML
    private TextArea hasilDiagnosaPasien;

    @FXML
    public void diagnosePenyakit(ActionEvent event) {
        double suhuTubuh = Double.parseDouble(suhuTubuhField.getText());
        int detakJantung = Integer.parseInt(detakJantungField.getText());
        int tekananDarah = Integer.parseInt(tekananDarahField.getText());
        String hasilDiagnosa = lakukanDiagnosa(suhuTubuh, detakJantung, tekananDarah);
        hasilDiagnosaPasien.setText(hasilDiagnosa);

        animasiProgressBar();
    }
    @FXML
    private ProgressBar progressBar;
    private void animasiProgressBar() {
        if (progressBar != null) {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), 0)),
                    new KeyFrame(Duration.seconds(3), new KeyValue(progressBar.progressProperty(), 1))
            );
            timeline.play();
        }
    }

    private String lakukanDiagnosa(double suhuTubuh, int detakJantung, int tekananDarah) {
        String hasilDiagnosa;

        if (suhuTubuh >= 36.0 && detakJantung > 120 && tekananDarah > 140) {
            hasilDiagnosa = "Gejala demam";
        } else if (suhuTubuh >= 37.0 && detakJantung > 120 && tekananDarah > 140) {
            hasilDiagnosa = "Mencret";
        } else if (suhuTubuh >= 38.0 && detakJantung > 120 && tekananDarah > 140) {
            hasilDiagnosa = "DarahTinggi";
        } else if (suhuTubuh >= 39.0 && detakJantung > 120 && tekananDarah > 140) {
            hasilDiagnosa = "Penyakit darah tinggi";
        } else {
            hasilDiagnosa = "Tidak ada gejala spesifik";
        }

        return hasilDiagnosa;
    }


}
