package Model;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Date;

public class Grupo {

    private String nomeDoGrupo;
    private Date dataSorteio;
    private ArrayList<Amigo> amigos;

    public Grupo() {

    }

    public Grupo(String nomeDoGrupo, Date dataSorteio){
        this.nomeDoGrupo = nomeDoGrupo;
        this.dataSorteio = dataSorteio;
    }

    public String getNomeDoGrupo() {
        return nomeDoGrupo;
    }

    public void setNomeDoGrupo(String nomeDoGrupo) {
        this.nomeDoGrupo = nomeDoGrupo;
    }

    public Date getDataSorteio() {
        return dataSorteio;
    }

    public void setDataSorteio(Date dataSorteio) {
        this.dataSorteio = dataSorteio;
    }

    public ArrayList<Amigo> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Amigo> amigos) {
        this.amigos = amigos;
    }

    public void addAmigo(Amigo amigo) {
        this.amigos.add(amigo);
    }

    public void removeAmigo(Amigo amigo) {
        this.amigos.remove(amigo);
    }

    public void listAmigos() {
        for (int i = 0; i < getAmigos().size(); i++) {
            System.out.println(getAmigos().get(i).getApelido());
        }
    }

    public void consultarAmigo() {
        for (int i = 0; i < getAmigos().size(); i++) {
            if (i + 1 == getAmigos().size()) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Amigo Secreto");
                ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/confirmacao-icon.png"))));
                image.setFitHeight(48);
                image.setFitWidth(48);
                alert.getDialogPane().setGraphic(image);
                alert.setContentText("O amigo secreto de " + getAmigos().get(i).getApelido() + " é " + getAmigos().get(0).getApelido() + "!" );
                alert.showAndWait();

                System.out.println( getAmigos().get(i).getApelido() + " é amigo secreto de " + getAmigos().get(0).getApelido() );
            }
        }
    }

}
