package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.components.PanelButton;
import view.components.Sidebar;

public class CadQuarto extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane mainPane = new BorderPane();

        Sidebar sidebar = new Sidebar();
        PanelButton panelButton = new PanelButton();
        mainPane.setLeft(sidebar);

        Image iconBtnUser = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-cliente-60.png"));
        Image iconHotel = new Image(getClass().getResourceAsStream("/view/resources/img/imagem.png"));
        ImageView iconUser = new ImageView(iconBtnUser);
        iconUser.setFitWidth(20);
        iconUser.setFitHeight(20);

        Label lblTitulo = new Label("Cadastro do Quarto");
        lblTitulo.setAlignment(Pos.TOP_CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloBox = new HBox(lblTitulo, iconUser);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.TOP_CENTER);
        tituloBox.setSpacing(10);


        Label lblNome = new Label("Nome:");
        TextField txtNome = new TextField();
        Label lblNumero = new Label("Número:");
        TextField txtNumero = new TextField();
        Label lblValor = new Label("Valor:");
        TextField txtValor= new TextField();
        Label lblQntCasal = new Label("Quarto casal:");
        TextField txtQntCasal = new TextField();
        Label lblQntSolteiro = new Label("Quarto solteiro:");
        TextField txtQntSolteiro = new TextField();
        Label lblDisponivel = new Label("Disponivel:");

        ComboBox<String> boxDisponivel = new ComboBox<>();
        boxDisponivel.getItems().addAll("Sim", "Não");
        boxDisponivel.setPromptText("Selecione");



        GridPane formGrid = new GridPane();
        formGrid.add(panelButton,1, 6);
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblNumero, 0, 1);
        formGrid.add(txtNumero, 1, 1);
        formGrid.add(lblValor, 0, 2);
        formGrid.add(txtValor, 1, 2);
        formGrid.add(lblQntCasal, 0, 3);
        formGrid.add(txtQntCasal, 1, 3);
        formGrid.add(lblQntSolteiro, 0, 4);
        formGrid.add(txtQntSolteiro, 1, 4);
        formGrid.add(lblDisponivel, 0, 5);
        formGrid.add(boxDisponivel, 1, 5);
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        VBox layout = new VBox(25, iconUser, lblTitulo, formGrid);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 650, 500);
        stage.setTitle("Grand Hotel");
        stage.getIcons().add(iconHotel);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

