package com.ufu.aulafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField textField01;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application! " + textField01.getText());
    }

    public void onNextButtonClick(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("next_view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 150, 150));
            stage.show();
            // Hide this current window (if this is what you want)
            //((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}