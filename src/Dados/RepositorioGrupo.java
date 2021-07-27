package Dados;

import Model.Amigo;
import Model.Grupo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioGrupo {
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

    public boolean salvarGrupo(Grupo g) {
        try {
            this.grupos.add(g);
        } catch (Exception e) {
            System.out.println("Erro");
            return false;
        }
        return true;
    }

    public boolean deletarGrupo(String g) {
        for (Grupo gp : grupos) {
            if(gp.getNomeDoGrupo().equals(g)) {
                this.grupos.remove(g);
                return true;
            }
        }
        return false;
    }

    public List<Grupo> grupoList(Grupo grupo) {
        List<Grupo> list = new ArrayList<Grupo>();
        for(Grupo g : grupos) {
            if(g.getNomeDoGrupo().equals(grupo)) {
                list.add(g);
            }
        }
        return list;
    }
}
