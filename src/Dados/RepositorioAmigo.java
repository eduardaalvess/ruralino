package Dados;

import Model.Amigo;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioAmigo implements Serializable {


    private static final long serialVersionUID = 2906642554793891381L;

    private ArrayList<Amigo> amigos;
    private static RepositorioAmigo instance;

    public static RepositorioAmigo getInstance() {
        if(instance == null) {
            instance = read();
        }
        return instance;
    }

    public RepositorioAmigo(ArrayList<Amigo> amigos) {
        super();
        this.amigos = amigos;
    }

    private static RepositorioAmigo read() {
        RepositorioAmigo instanciaLocal = null;

        File in = new File("src/amigos.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Amigo> amg = new ArrayList<>();
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            instanciaLocal = (RepositorioAmigo) obj;
        } catch (Exception exception) {
            instanciaLocal = new RepositorioAmigo(amg);
        }
        finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (IOException ioException) {

                }
            }
        }

        return instanciaLocal;

    }

    public void saveFile() {
        if(instance == null) {
            return;
        }
        File out = new File("src/amigos.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException ioException) {

                }
            }
        }
    }


    public boolean salvarAmigo(Amigo a) {
       // if(verificarApelido(a) == null) {
            this.amigos.add(a);
            return true;
       // }

        /*
        else {
            System.out.println("Apelido j?? existe");
            return false;
        }

         */

    }


    /*
    public Amigo verificarApelido(Amigo apelido) {
        for(Amigo a: amigos) {
            if(a.getApelido().equals(apelido)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Apelido existente");
                alert.setContentText("Esse apelido j?? existe");
                ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/sign-error-icon.png"))));
                image.setFitHeight(45);
                image.setFitWidth(45);
                alert.getDialogPane().setGraphic(image);
                alert.showAndWait();
            } else {
                return a;
            }
        }

        return null;
    }

     */

    public List<Amigo> amigoList() {
        return amigos;
    }
}
