package GUI.Controllers;

import Exceptions.JaExisteEsteApelidoException;
import Model.Amigo;
import Negocio.ControladorAmigo;
import Negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

        String nome = cadastroNome.getText();
        String apelido = cadastroApelido.getText();
        String senha = cadastroSenha.getText();

        if(nome.isEmpty() || apelido.isEmpty() || senha.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setContentText("Preencha todos os campos para realizar o cadastro!");
            ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/sign-error-icon.png"))));
            image.setFitHeight(48);
            image.setFitWidth(48);
            alert.getDialogPane().setGraphic(image);
            alert.showAndWait();
        } else if (nome != null && nome.length() > 0 && apelido != null && apelido.length() > 0 && senha != null && senha.length() > 0) {
            Amigo amigo = new Amigo(nome, apelido, senha);
        }

        Amigo amg = new Amigo(this.cadastroNome.getText(), this.cadastroApelido.getText(), this.cadastroSenha.getText());

        try {
            Fachada.getInstance().inserirAmigo(amg);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/confirmacao-icon.png"))));
            image.setFitHeight(48);
            image.setFitWidth(48);
            alert.getDialogPane().setGraphic(image);
            alert.setTitle("Confirmação de Cadastro");
            alert.setContentText("Cadastro realizado com sucesso!");
            alert.showAndWait();

        } catch (JaExisteEsteApelidoException apelidoException) {

            apelidoException.getJaExisteApelido();

        }
        this.clean();

    }

    public void clean() {
        this.cadastroNome.setText("");
        this.cadastroApelido.setText("");
        this.cadastroSenha.setText("");
    }

}

