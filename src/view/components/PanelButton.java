package view.components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PanelButton extends HBox{

    public Button btnCad = new Button("Cadastrar");
    public Button btnAtualizar = new Button("Atualizar");
    public Button btnExcluir = new Button("Excluir");

    public PanelButton() {

        Image iconBtnCad = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-mais-50.png"));
        Image iconBtnAtualizar = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-atualizar-96.png"));
        Image iconBtnExcluir = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-lixeira.gif"));

        ImageView iconCad = new ImageView(iconBtnCad);
        iconCad.setFitWidth(20);
        iconCad.setFitHeight(20);
        iconCad.setOpacity(0.5);

        ImageView iconAtt = new ImageView(iconBtnAtualizar);
        iconAtt.setFitWidth(20);
        iconAtt.setFitHeight(20);
        iconAtt.setOpacity(0.5);

        ImageView iconExc = new ImageView(iconBtnExcluir);
        iconExc.setFitWidth(20);
        iconExc.setFitHeight(20);
        iconExc.setOpacity(0.5);


        GridPane formGrid = new GridPane();
        formGrid.add(btnAtualizar, 0, 0);
        formGrid.add(btnCad, 1, 0);
        formGrid.add(btnExcluir, 2, 0);
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        String styleButton = "-fx-background-color: transparent; " +
                "-fx-border-color: transparent; " +
                "-fx-graphic-text-gap: 10px;" +
                "-fx-alignment: center;" +
                "-fx-cursor: hand;";
        btnAtualizar.setStyle(styleButton);
        btnCad.setStyle(styleButton);
        btnExcluir.setStyle(styleButton);

        btnAtualizar.setOnMouseEntered(evento ->
                btnAtualizar.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnAtualizar.setOnMouseExited(evento -> btnAtualizar.setStyle(styleButton));
        btnCad.setOnMouseEntered(evento ->
                btnCad.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnCad.setOnMouseExited(evento -> btnCad.setStyle(styleButton));
        btnExcluir.setOnMouseEntered(evento ->
                btnExcluir.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnExcluir.setOnMouseExited(evento -> btnExcluir.setStyle(styleButton));


        getChildren().addAll(formGrid);
    }

}
