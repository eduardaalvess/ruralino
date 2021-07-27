package Dados;

import Model.Amigo;
import Model.Grupo;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioGrupo implements IRepositorioGrupo {
    private ArrayList<Grupo> grupos;
    private static RepositorioGrupo instance;

    public static RepositorioGrupo getInstance() {
        if(instance == null) {
            instance = read();
        }
        return instance;
    }

    public RepositorioGrupo(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public static RepositorioGrupo read() {
        RepositorioGrupo instanciaLocal = null;

        File in = new File("src/grupos.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Grupo> gp = new ArrayList<>();

        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
        } catch (Exception e) {
            instanciaLocal = new RepositorioGrupo(gp);
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

        return instanciaLocal;

    }

    public void saveFile() {
        if(instance == null) {
            return;
        }
        File out = new File("src/grupos.dat");
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
                    ioException.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean salvarGrupo(Grupo g) {
        if(verificarNomeGrupo(g) == null) {
            this.grupos.add(g);
            return true;
        } else {
            System.out.println("Nome já existe");
        }
        return false;
    }

    @Override
    public boolean deletarGrupo(String g) {
        for (Grupo gp : grupos) {
            if(gp.getNomeDoGrupo().equals(g)) {
                this.grupos.remove(g);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Grupo> grupoList() {
        return grupos;
    }

    public Grupo verificarNomeGrupo(Grupo nome) {
        for(Grupo g : grupos) {
            if(g.getNomeDoGrupo().equals(nome)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nome existente");
                alert.setContentText("Esse nome já existe");
                ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/sign-error-icon.png"))));
                image.setFitHeight(45);
                image.setFitWidth(45);
                alert.getDialogPane().setGraphic(image);
                alert.showAndWait();
            } else {
                return g;
            }
        }

        return null;

    }
}
