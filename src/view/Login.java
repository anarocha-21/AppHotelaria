package view;

import controller.UsuarioController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import model.Usuario;

import javax.swing.*;

public class Login extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();

        Image iconBtnUser = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-cliente-60.png"));
        ImageView iconUser = new ImageView(iconBtnUser);
        iconUser.setFitWidth(25);
        iconUser.setFitHeight(25);

        Image sidebarHotel = new Image(getClass().getResourceAsStream("/view/resources/img/hotel2.jpg"));
        ImageView hotelImage = new ImageView(sidebarHotel);
        hotelImage.setFitHeight(600);
        hotelImage.setFitWidth(350);

        Label Titulo = new Label("Faça seu Login");
        Titulo.setAlignment(Pos.TOP_CENTER);
        Titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");

        HBox tituloBox = new HBox(Titulo, iconUser);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.TOP_CENTER);
        tituloBox.setSpacing(10);
        Button btnLogin = new Button("Login");
        String styleButton = "-fx-background-color: transparent; " +
                "-fx-border-color: transparent; " +
                "-fx-graphic-text-gap: 10px;" +
                "-fx-alignment: center;" +
                "-fx-cursor: hand;";


        btnLogin.setStyle(styleButton);
        btnLogin.setOnMouseEntered(evento -> btnLogin.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnLogin.setOnMouseExited(evento -> btnLogin.setStyle(styleButton));
        btnLogin.setAlignment(Pos.CENTER);


        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("E-mail");
        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione");
        Label lblSenha = new Label("Senha: ");
        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Senha");

        btnLogin.setOnAction(evento -> {
            String usuario = txtEmail.getText();
            String senha = txtSenha.isVisible() ? txtSenha.getText() : "";
            UsuarioController usuarioController = new UsuarioController();
            boolean loginSucesso = usuarioController.verificarCredenciais(usuario, senha);
            if (loginSucesso) {
                System.out.println("Login efetuado com sucesso");
                //codigo para abrir a proxima janela
            }else {
                System.out.println("Login invalido");
            }
        });

        GridPane formGrid = new GridPane();
        formGrid.add(lblEmail, 0, 0);
        formGrid.add(txtEmail, 1, 0);
        formGrid.add(lblSenha, 0, 1);
        formGrid.add(txtSenha, 1, 1);
        formGrid.add(boxEmail, 2, 0);
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        VBox imgHotel = new VBox(hotelImage);
        mainPane.setLeft(imgHotel);
        imgHotel.setAlignment(Pos.CENTER_LEFT);
        imgHotel.setSpacing(10);


        VBox layout = new VBox(10, iconUser, tituloBox, formGrid, btnLogin);
        mainPane.setRight(layout);
        layout.setAlignment(Pos.CENTER);


        Scene scene = new Scene(mainPane, 700, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }




public static void main(String[] args) {
    launch(args);
}
}