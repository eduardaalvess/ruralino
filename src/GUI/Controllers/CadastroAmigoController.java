package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class CadastroAmigoController {

    @FXML
    private TextField cadastroNome;

    @FXML
    private TextField cadastroApelido;

    @FXML
    private PasswordField cadastroSenha;

    @FXML
    private Button salvarAdicionarAmigo;

    @FXML
    private Button addPresentesButton;



    @FXML
    void adicionarPresentes(ActionEvent event) throws IOException {

        Stage closeStage = (Stage) addPresentesButton.getScene().getWindow();
        closeStage.close();

        Stage addPresentes = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML/View/adicaoDePresentes.fxml"));
        addPresentes.setTitle("Ruralino E Seus Amigos");
        addPresentes.setScene(new Scene(root, 700, 500));
        addPresentes.setResizable(false);
        addPresentes.initStyle(StageStyle.TRANSPARENT);
        addPresentes.show();

    }

    @FXML
    void salvarAdicaoDeAmigo(ActionEvent event) {

    }

    public void clean() {
        this.cadastroNome.setText("");
        this.cadastroApelido.setText("");
        this.cadastroSenha.setText("");
    }

}

