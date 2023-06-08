package com.example.interfacetrabalho;

import Model.Recheio;
import Model.Tamanho;
import Model.Tipo;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class PedidoController {
    @FXML
    private Text txtHello;


    private List<Tipo> tipo = new ArrayList<>();
    private ObservableList<Tipo> obsTipo;

    private List<Recheio> recheio = new ArrayList<>();
    private ObservableList<Recheio> obsRecheio;

    private List<Tamanho> tamanho;
    private ObservableList<Tipo> obsTamanho;

    @FXML
    private TextField txtNome;

    @FXML
    private Text txtLanche;

    @FXML
    private ComboBox<?> cbType;

    @FXML
    private ComboBox<?> cbRecheio;

    @FXML
    private ComboBox<?> cbTamanho;

    @FXML
    private Label finalText;

    public PedidoController() {
        tamanho = new ArrayList<>();
    }

    @FXML
    protected void onFinalButtonClick() {
        System.out.println("Aguarde...");
        finalText.setText(txtNome.getText() + " seu pedido foi realizado com sucesso!");
    }

    public void initialize(URL, url, ResourceBundle rb){
        carregarTamanho();
        carregarRecheio();
        carregarTipo();
    }

    public void carregarTamanho(){
        Tamanho tamanho1 = new Tamanho(1, "Pequeno");
        Tamanho tamanho2 = new Tamanho(2, "Médio");
        Tamanho tamanho3 = new Tamanho(3, "Grande");

        tamanho.add(tamanho1);
        tamanho.add(tamanho2);
        tamanho.add(tamanho3);

        cbTamanho.setItems(value);
        obsTamanho = FXCollections.observableArrayList(tamanho);
    }

    public void carregarRecheio(){
        Recheio recheio1 = new Recheio(1, "Mussarela");
        Recheio recheio2 = new Recheio(2, "Almondegas");
        Recheio recheio3 = new Recheio(3, "Vegetariano");

        recheio.add(recheio1);
        recheio.add(recheio2);
        recheio.add(recheio3);

        cbRecheio.setItems(value);
        obsRecheio = FXCollections.observableArrayList(recheio);
    }

    public void carregarTipo(){
        Tipo tipo1 = new Tipo(1, "Pastel");
        Tipo tipo2 = new Tipo(2, "Sanduiche");
        Tipo tipo3 = new Tipo(3, "Pizza");

        tipo.add(tipo1);
        tipo.add(tipo2);
        tipo.add(tipo3);

        cbTipo.setItems(value);
        obsTipo = FXCollections.observableArrayList(tipo);
    }
}
