package Dados;

import Exceptions.JaExisteEsteApelidoException;
import Model.Amigo;
import Model.Presente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioAmigo<A> implements InterfaceRepositorioAmigo<A> {

    private List<Amigo> amigoList;
    private static RepositorioAmigo instance;

    public RepositorioAmigo() {
        amigoList = new ArrayList<Amigo>();
    }

    public static RepositorioAmigo getInstance() {
        return instance;
    }

    @Override
    public void salvarAmigo(Amigo amigo) throws JaExisteEsteApelidoException {

        if (!this.amigoList.contains(amigo)) {
            this.amigoList.add((Amigo) amigo);
        } else {
            throw new JaExisteEsteApelidoException(amigo);
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

    @Override
    public void addPresentes(Amigo amigo, Presente presentes) {

    }

    @Override
    public void removePresentes(Amigo amigo, Presente presentes) {

    }

}
