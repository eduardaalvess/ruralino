package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Grupo {

    private String nomeDoGrupo;
    private LocalDate dataSorteio;
    private ArrayList<Amigo> amigos;
    private boolean sorteados;



    public Grupo() {

    }

    public Grupo(String nomeDoGrupo, LocalDate dataSorteio){
        this.nomeDoGrupo = nomeDoGrupo;
        this.dataSorteio = dataSorteio;
    }

    public String getNomeDoGrupo() {
        return nomeDoGrupo;
    }

    public void setNomeDoGrupo(String nomeDoGrupo) {
        this.nomeDoGrupo = nomeDoGrupo;
    }

    public LocalDate getDataSorteio() {
        return dataSorteio;
    }

    public void setDataSorteio(LocalDate dataSorteio) {
        this.dataSorteio = dataSorteio;
    }

    public boolean isSorteados() {
        return sorteados;
    }

    public void setSorteados(boolean sorteados) {
        this.sorteados = sorteados;
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
            System.out.println(getAmigos().get(i).getNome());
        }

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

    public void listAmigoSecreto() {
        for(int i = 0; i < getAmigos().size(); i++) {
            if(i + 1 == getAmigos().size()) {
                System.out.println(getAmigos().get(i).getNome() + "tirou" + getAmigos().get(0).getNome());
            } else {
                System.out.println(getAmigos().get(i).getNome() + "tirou" + getAmigos().get(i + 1).getNome());
            }
        }
    }
}

