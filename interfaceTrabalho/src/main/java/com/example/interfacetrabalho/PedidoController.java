package com.example.interfacetrabalho;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PedidoController {
    @FXML
    private Label finalText;

    @FXML
    private TextField txtNome;

    @FXML
    protected void onFinalButtonClick() {
        System.out.println("Aguarde...");
        finalText.setText(txtNome.getText() + " seu pedido foi realizado com sucesso!");
    }
}