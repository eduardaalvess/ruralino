package control;

/*
Por fins de organização, como o sistema tem muitas telas, vou organizar todas aqui.
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Telas {

    void cancelAndReturn() throws IOException {

        Stage cancelar = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/FXML/pagInicial.fxml"));
        cancelar.setTitle("Ruralino E Seus Amigos");
        Scene scene = new Scene(root);
        cancelar.setScene(scene);
        cancelar.initStyle(StageStyle.TRANSPARENT);
        cancelar.setResizable(false);
        cancelar.show();
    }


}
