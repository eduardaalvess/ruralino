package Model;

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

    }

    public void consultarAmigo() {

        /**


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Amigo Secreto");
                ImageView image = new ImageView(new Image(String.valueOf(this.getClass().getResource("/Imagens/confirmacao-icon.png"))));
                image.setFitHeight(48);
                image.setFitWidth(48);
                alert.getDialogPane().setGraphic(image);
                alert.setContentText(" ");
                alert.showAndWait();

         **/

    }
}

