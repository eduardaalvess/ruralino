package Dados;

import Model.Grupo;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioGrupo implements Serializable, IRepositorioGrupo {

    private static final long serialVersionUID = 2906642554793891381L;

    private ArrayList<Grupo> grupos;

    private static RepositorioGrupo instance;

    public static RepositorioGrupo getInstance() {
        if(instance == null) {
            instance = read();
        }
        return instance;
    }

    public RepositorioGrupo(ArrayList<Grupo> grupos) {
        super();
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
    public boolean atualizarGrupo(Grupo grupo) {
        for (Grupo g : grupos) {
            if(g.getNomeDoGrupo().equals(grupo.getNomeDoGrupo())) {
                grupos.remove(g);
                grupos.add(grupo);
                return true;
            }
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

    public void amigosSecretos(Grupo grupo) {
        for(int i = 0; i < grupo.getAmigos().size(); i++) {
            if(i + 1 == grupo.getAmigos().size()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sorteio do grupo " + grupo.getNomeDoGrupo());
                alert.setContentText(grupo.getAmigos().get(i).getNome() + " tirou " + grupo.getAmigos().get(0).getNome());
                ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/wrapped-gift.png"))));
                image.setFitWidth(30);
                image.setFitHeight(30);
                alert.getDialogPane().setGraphic(image);
                alert.showAndWait();
            }
        }
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
