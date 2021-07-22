package App;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class Scenes {

    private Pane view;

    public Pane getPage(String fileName) {

        try {
            URL fileUrl = Main.class.getResource("/View/" + fileName + ".fxml");

            if(fileUrl == null) {
                throw new java.io.FileNotFoundException("Arquivo não encontrado!");
            }

            view = new FXMLLoader().load(fileUrl);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro!");
        }

        return view;

    }

}
