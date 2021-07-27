package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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


            }

           clean();

        }

    public void clean() {
        this.categoriaPresentes.setText("");
        this.precoPresentes.setText("");
        this.descricaoPresentes.setText("");
    }

}

