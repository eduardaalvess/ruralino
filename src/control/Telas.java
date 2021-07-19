package control;

/*

Organizando as cenas do sistema.

 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Telas {

    /*
    Retorna a página inicial.
     */

    public void cancelAndReturn() throws IOException {

        Stage cancelar = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/FXML/pagInicial.fxml"));
        cancelar.setTitle("Ruralino E Seus Amigos");
        Scene scene = new Scene(root);
        cancelar.setScene(scene);
        cancelar.initStyle(StageStyle.TRANSPARENT);
        cancelar.setResizable(false);
        cancelar.close();
        cancelar.show();

    }

    /*
    Retorna a página de cadastro de pessoas.
     */

    public void pessoasScene() throws IOException {

        Stage pessoas = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/FXML/cadastroPessoas.fxml"));
        Scene scene = new Scene(root);
        pessoas.setTitle("Ruralino E Seus Amigos");
        pessoas.setResizable(false);
        pessoas.initStyle(StageStyle.TRANSPARENT);
        pessoas.setScene(scene);
        pessoas.show();
    }

    /*
    Retorna a página de cadastro de grupos.
     */

    public void gruposScene() throws IOException {


        Stage grupos = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/FXML/cadastroGrupos.fxml"));
        Scene scene = new Scene(root);
        grupos.setTitle("Ruralino E Seus Amigos");
        grupos.setResizable(false);
        grupos.initStyle(StageStyle.TRANSPARENT);
        grupos.setScene(scene);
        grupos.show();
    }

    /*
    Retorna a página de cadastro de presentes.
     */

    public void presentesScene() throws IOException {

        Stage presentes = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/FXML/cadastroPresentes.fxml"));
        Scene scene = new Scene(root);
        presentes.setTitle("Ruralino E Seus Amigos");
        presentes.setResizable(false);
        presentes.initStyle(StageStyle.TRANSPARENT);
        presentes.setScene(scene);
        presentes.show();
    }

    /*
    Retorna a página de realização de sorteio.
     */

    public void sorteioScene() throws IOException {

        Stage sorteio = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/FXML/sorteioAmigoSecreto.fxml"));
        Scene scene = new Scene(root);
        sorteio.setTitle("Ruralino E Seus Amigos");
        sorteio.setResizable(false);
        sorteio.initStyle(StageStyle.TRANSPARENT);
        sorteio.setScene(scene);
        sorteio.show();
    }

    public void adcPresentes() throws IOException {

        Stage adcGift = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/FXML/cadastroPresentesPessoas.fxml"));
        Scene scene = new Scene(root);
        adcGift.setTitle("Ruralino E Seus Amigos");
        adcGift.setResizable(false);
        adcGift.initStyle(StageStyle.TRANSPARENT);
        adcGift.setScene(scene);
        adcGift.show();
    }

    public void consultarAmigoSecreto() throws IOException {

        Stage consulta = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("gui/FXML/consultaAmigoSecreto.fxml"));
        Scene scene = new Scene(root);
        consulta.setTitle("Ruralino E Seus Amigos");
        consulta.setResizable(false);
        consulta.initStyle(StageStyle.TRANSPARENT);
        consulta.setScene(scene);
        consulta.show();
    }

    public void adcPessoas() throws IOException {

        Stage addPessoas = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("gui/FXML/adcPessoasGrupos.fxml"));
        Scene scene = new Scene(root);
        addPessoas.setTitle("Ruralino E Seus Amigos");
        addPessoas.setResizable(false);
        addPessoas.initStyle(StageStyle.TRANSPARENT);
        addPessoas.setScene(scene);
        addPessoas.show();
    }



}
