package view;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.components.PanelButton;
import view.components.Sidebar;

public class CadCliente extends Application {

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

        Label lblTitulo = new Label("Cadastro de Cliente");
        lblTitulo.setAlignment(Pos.TOP_CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloBox = new HBox(lblTitulo, iconUser);
        tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.TOP_CENTER);
        tituloBox.setSpacing(10);

        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome");
        Label lblCPF = new Label("CPF: ");
        TextField txtCPF = criarMascaraCampo("###.###.###-##");
        txtCPF.setPromptText("CPF");
        Label lblEmail = new Label("Email: ");
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Email");
        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione");
        Label lblTel = new Label("Telefone: ");
        TextField txtTel = criarMascaraCampo("(__) _____-____");
        txtTel.setPromptText("Telefone");

        GridPane formGrid = new GridPane();
        formGrid.add(panelButton,1, 5);
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblCPF, 0, 1);
        formGrid.add(txtCPF, 1, 1);
        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(lblTel, 0, 3);
        formGrid.add(txtTel, 1, 3);
        formGrid.add(boxEmail, 2, 2);
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        VBox layout = new VBox(10, iconUser, lblTitulo, formGrid);
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