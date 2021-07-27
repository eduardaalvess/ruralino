package GUI.Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

public class CadastroGrupoController {

    @FXML
    private Button salvarCadastroGrupo;

    @FXML
    private DatePicker dataSorteio;

    @FXML
    private TextField cadastroNomeGrupo;

    @FXML
    private Button addAmigosButton;

    @FXML
    void adicionarAmigos(ActionEvent event) throws IOException {

        Stage closeStage = (Stage) addAmigosButton.getScene().getWindow();
        closeStage.close();

        Stage addAmigos = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML/View/adicaoDeAmigo.fxml"));
        addAmigos.setTitle("Ruralino E Seus Amigos");
        addAmigos.setScene(new Scene(root, 700, 500));
        addAmigos.setResizable(false);
        addAmigos.initStyle(StageStyle.TRANSPARENT);
        addAmigos.show();

    }

    @FXML
    void salvarCadastroDoGrupo(ActionEvent event) {

        String nome = cadastroNomeGrupo.getText();
        LocalDate data = dataSorteio.getValue();

        if(nome != null && nome.length() > 0 && dataSorteio != null) {

            validarCadastroGrupo();
            clean();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campos inválidos");
            alert.setContentText("Por favor, preencha todos os campos corretamente");
            ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/sign-error-icon.png"))));
            image.setFitHeight(45);
            image.setFitWidth(45);
            alert.getDialogPane().setGraphic(image);
            alert.showAndWait();
        }
    }

    public void validarCadastroGrupo() {

    }

    public void clean() {
        this.cadastroNomeGrupo.setText("");
        this.dataSorteio.setValue(null);
    }


}

