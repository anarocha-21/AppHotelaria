package view;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.components.PanelButton;
import view.components.Sidebar;

public class CadUsuario extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Sidebar sidebar = new Sidebar();
        PanelButton panelButton = new PanelButton();

        Image iconBtnUser = new Image(getClass().getResourceAsStream("/view/resources/img/icons8-cliente-60.png"));
        Image iconHotel = new Image(getClass().getResourceAsStream("/view/resources/img/imagem.png"));
        ImageView iconUser = new ImageView(iconBtnUser);
        iconUser.setFitWidth(20);
        iconUser.setFitHeight(20);

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(sidebar);


        Label lblTitulo = new Label("Cadastro do Funcionário");
        lblTitulo.setAlignment(Pos.TOP_CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloBox = new HBox(lblTitulo, iconUser);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.TOP_CENTER);
        tituloBox.setSpacing(10);

        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        Label lblSetor = new Label("Setor: ");
        TextField txtSetor = new TextField();
        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione");
        Label lblSenha = new Label("Senha: ");
        TextField txtSenha = new TextField();

        GridPane formGrid = new GridPane();
        formGrid.add(panelButton,1, 5);
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblSetor, 0, 1);
        formGrid.add(txtSetor, 1, 1);
        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(lblSenha, 0, 3);
        formGrid.add(txtSenha, 1, 3);
        formGrid.add(boxEmail, 2,2);
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        VBox layout = new VBox(10, iconUser, tituloBox, formGrid);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 650, 500);
        stage.setTitle("Grand Hotel");
        stage.getIcons().add(iconHotel);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
        {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;
            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    } else {
                        break;
                    }

                } else {
                    formatacaoCampo.append(caracter);
                }
            }

            txtMascara.setText(formatacaoCampo.toString());
        });

        return txtMascara;
    }





    public static void main(String[] args) {
        launch(args);
    }
}