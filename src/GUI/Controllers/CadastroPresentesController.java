package GUI.Controllers;

import Dados.ConnectionFactory;
import Dados.DAO.PresenteDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Connection;

public class CadastroPresentesController {

    @FXML
    private TextField categoriaPresentes;

    @FXML
    private TextField precoPresentes;

    @FXML
    private TextField descricaoPresentes;

    @FXML
    private Button salvarCadastroPresentes;

    @FXML
    void salvarPresentes(ActionEvent event) {

        String categoria = categoriaPresentes.getText();
        String descricao = descricaoPresentes.getText();
        String preco = precoPresentes.getText();

        if (categoria.isEmpty() || descricao.isEmpty() || preco.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campos inválidos");
            alert.setContentText("Por favor, preencha todos os campos corretamente");
            ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/sign-error-icon.png"))));
            image.setFitHeight(45);
            image.setFitWidth(45);
            alert.getDialogPane().setGraphic(image);
            alert.showAndWait();

        } else {

            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection connection = connectionFactory.getConnection();
            PresenteDAO presenteDAO = new PresenteDAO();

            if (presenteDAO.create(categoriaPresentes.getText(), descricaoPresentes.getText(), precoPresentes.getText())) {

                System.out.println("Os presentes foram salvos com sucesso");

            }

        }

    }

}

