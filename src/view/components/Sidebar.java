package view.components;

import javafx.scene.Node;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.awt.event.MouseEvent;

public class Sidebar extends VBox {
    public Button btnCliente = new Button("Clientes");
    public Button btnFuncionario = new Button("Funcionários");
    public Button btnQuarto = new Button("Quartos");
    public Button btnReserva = new Button("Reservas");
    public Button btnRelatorio = new Button("Relatórios");

    public Sidebar() {
        Image iconFuncionario = new Image(getClass().getResourceAsStream("/view/resources/img/icon-funcionario.png"));
        Image iconCliente = new Image(getClass().getResourceAsStream("/view/resources/img/icon-cliente.png"));
        Image iconQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/icon-quarto.png"));
        Image iconRelatorio = new Image(getClass().getResourceAsStream("/view/resources/img/icon-relatorio.png"));
        Image iconReserva = new Image(getClass().getResourceAsStream("/view/resources/img/icon-reserva.png"));

        //carregamento de fontes
        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" + "Commissioner-Bold.ttf"), 15);
        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" + "Commissioner-Regular.ttf"), 14);

        //objeto p manipular dimensoes da imagem ja carregada
        ImageView viewIconFuncionario = new ImageView(iconFuncionario);
        viewIconFuncionario.setFitHeight(30); //altura
        viewIconFuncionario.setFitWidth(30); //largura

        ImageView viewIconCliente = new ImageView(iconCliente);
        viewIconCliente.setFitHeight(30); //altura
        viewIconCliente.setFitWidth(30); //largura

        ImageView viewIconQuarto = new ImageView(iconQuarto);
        viewIconQuarto.setFitHeight(30); //altura
        viewIconQuarto.setFitWidth(30); //largura

        ImageView viewIconRelatorio = new ImageView(iconRelatorio);
        viewIconRelatorio.setFitHeight(30); //altura
        viewIconRelatorio.setFitWidth(30); //largura

        ImageView viewIconReserva = new ImageView(iconReserva);
        viewIconReserva.setFitHeight(30); //altura
        viewIconReserva.setFitWidth(30); //largura

        // estilização dos botoes (fundo e borda transparente)
        String styleButton = "-fx-background-color: transparent; " +
                "-fx-border-color: transparent; " +
                "-fx-graphic-text-gap: 10px;" +
                "-fx-alignment: center;" +
                "-fx-cursor: hand;";

        btnCliente.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);

        //obejtivo: ao passar o mouse, trocar o fundo do botao p uma cor quie desejar
        btnCliente.setOnMouseEntered(evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));

        btnFuncionario.setOnMouseEntered(evento ->
                btnFuncionario.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));

        btnQuarto.setOnMouseEntered(evento ->
                btnQuarto.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnQuarto.setOnMouseExited(evento -> btnQuarto.setStyle(styleButton));

        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));

        btnRelatorio.setOnMouseEntered(evento ->
                btnRelatorio.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnRelatorio.setOnMouseExited(evento -> btnRelatorio.setStyle(styleButton));


        Label lblMenu = new Label("Grand Hotel");
        lblMenu.setStyle("-fx-text-fill: #a87e08;");  // cor


        //espaçamento externo (margem) do componente label ate o botao
        setMargin(lblMenu, new Insets( 0, 0, 20, 0));
        lblMenu.setFont(Font.font(fonteNegrito.getFamily(), 25));
        setStyle("-fx-background-color: #dad8d8; -fx-padding: 40px");
        setSpacing(12); //metodo setSpacing p espaçar todos os componentes que fazem parte do menu
        getChildren().addAll(lblMenu, btnCliente, btnFuncionario, btnQuarto, btnReserva, btnRelatorio);

    }
}
