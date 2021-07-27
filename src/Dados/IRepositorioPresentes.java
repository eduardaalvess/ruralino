package Dados;

import Model.Presente;

import java.util.List;

public interface IRepositorioPresentes {
    boolean salvarPresente(Presente p);

    boolean deletarPresente(String d);

    List<Presente> presenteList();
}
