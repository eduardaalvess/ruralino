package Dados;

import Model.Amigo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioAmigo implements InterfaceRepositorioAmigo {

    private List<Amigo> amigoList;
    private static RepositorioAmigo instance;

    private RepositorioAmigo() {
        amigoList = new ArrayList<Amigo>();
    }

    public static RepositorioAmigo getInstance() {
        return instance;
    }


    @Override
    public void salvarAmigo(Amigo amigo) {

        if (!this.amigoList.contains(amigo)) {
            this.amigoList.add(amigo);
        }

    }

    @Override
    public List listAmigo() {
        return Collections.unmodifiableList(this.amigoList);
    }

    @Override
    public void remove(Amigo amigo) {
        if (this.amigoList.contains(amigo)) {
            this.amigoList.remove(this.amigoList.indexOf(amigo));
        }
    }



}
