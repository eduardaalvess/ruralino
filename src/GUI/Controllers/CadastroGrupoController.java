package GUI.Controllers;


import Dados.ConnectionFactory;
import Dados.DAO.GrupoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

        }
    }

    public void validarCadastroGrupo() {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        GrupoDAO grupoDAO = new GrupoDAO();

        String d = dataSorteio.getEditor().getText();

        if(grupoDAO.create(cadastroNomeGrupo.getText(), dataSorteio.getValue())) {

            System.out.println("Os dados do grupo foram salvos com sucesso");

        }
    }

    public void clean() {
        this.cadastroNomeGrupo.setText("");
        this.dataSorteio.setValue(null);
    }


}

