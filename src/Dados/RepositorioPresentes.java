package Dados;

import Model.Presente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPresentes implements Serializable {

    private ArrayList<Presente> presentes;
    private static RepositorioPresentes instance;

    public static RepositorioPresentes getInstance() {
        if(instance == null) {
            instance = read();
        }
        return instance;
    }

    public RepositorioPresentes(ArrayList<Presente> presentes) {
        this.presentes = presentes;
    }

    public static RepositorioPresentes read() {
        RepositorioPresentes instanciaLocal = null;

        File in = new File("src/presentes.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Presente> pres = new ArrayList<>();

        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
        } catch (Exception e) {
            instanciaLocal = new RepositorioPresentes(pres);
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

    public boolean salvarPresente(Presente p) {
        try {
            this.presentes.add(p);
        } catch (Exception e) {
            System.out.println("Erro.");
            return false;
        }
        return true;
    }

    public boolean deletarPresente(String d) {
        for(int i = 0; i < presentes.size(); i++) {
            if(presentes.get(i).getDescricao().equals(d)) {
                presentes.remove(i);
                return true;
            }
        }

        return false;

    }

    public List<Presente> presenteList() {
        return this.presentes;
    }

}
