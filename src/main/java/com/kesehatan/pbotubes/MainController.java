package com.kesehatan.pbotubes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {

    @FXML
    private Button masukButton;
    @FXML
    private TextField namaPasienField;

    @FXML
    private void goToMenu(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            String namaPasien = namaPasienField.getText();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml")); // Sesuaikan path menu.fxml
            Parent root = loader.load();

            MenuController menuController = loader.getController();
            menuController.setNamaPasien(namaPasien);

            stage.setTitle("Menu Utama");
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
