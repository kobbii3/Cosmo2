import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Cosmos {
    public static ArrayList<Materias> listaMaterias;
    String x = JOptionPane.showInputDialog("Bienvenido al sistemas de matriculas de marteriias UNAB\nPor favor, Ingresa tu nombre: ");
    Usuario usuario1 = new Usuario(x);
    public static String fichero = "archivos.dat";
    public static Materias materias;

public static void main(String[] args) {
    Cosmos Lista = new Cosmos();
    Cosmos.listaMaterias = new ArrayList<Materias>();
    Lista.leerOpcion();
}

public void leerOpcion() {
    int opcion = 0;
    listaMaterias = cargarMaterias();
    do{
        opcion = Integer.parseInt(JOptionPane.showInputDialog("1- Agregar Materia\n2- Eliminar Materia\n3- Listar Materias\n4- Guardar y salir"));
        switch (opcion){
            case 1:
                agregarMateria();
                break;
            case 2:
                eliminarMateria();
                break;
            case 3:
                listarMaterias();
                break;
            case 4:
                guardaMaterias();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Número no valido.");
                break;
        }
    } while (opcion != 4);
    JOptionPane.showMessageDialog(null, "Adios!");
}

public void agregarMateria() {
    int opcion2 = Integer.parseInt(JOptionPane.showInputDialog("Materias disponibles: 1) Calculo | 2) Mecanica | 3) Programación"));
    if(opcion2 == 1){
        materias = new Materias("Cálculo","Ivan","6pm", 5);
        listaMaterias.add(materias);
        //materias.setCupos(materias.getCupos()-1);
    }else{
        if(opcion2 == 2){
            materias = new Materias("Mecanica","Martha","10am", 5);
            listaMaterias.add(materias);
        }else{
            if(opcion2 == 3){
                materias = new Materias("Programación","Johlver","8am", 5);
                listaMaterias.add(materias);
            }
        }
    }
}

public void eliminarMateria(){
    int indice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número en la lista de la materia que desea eliminar:"));
    listaMaterias.remove(indice-1);
    JOptionPane.showMessageDialog(null,"La materia ha sido eliminada.");
}

public void listarMaterias(){
    if (!listaMaterias.isEmpty()) {
        String texto = usuario1.getNombre();
        for(int i = 0; i < listaMaterias.size(); i++){
            texto += "\n" + "[" + (i+1) + "]" + (listaMaterias.get(i)).info();
        }
        JOptionPane.showMessageDialog(null, texto);
    }else{JOptionPane.showMessageDialog(null, "No se han matriculado materias.");}
}

public static void guardaMaterias() {
    try {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
        for (Materias materias : listaMaterias) {
            oos.writeObject(materias);
        }
        oos.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static ArrayList<Materias> cargarMaterias() {
    ArrayList<Materias> materias = new ArrayList<Materias>();
    try {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        Object aux = ois.readObject();
        while (aux != null) {
            if (aux instanceof Materias)
                materias.add((Materias) aux);
            aux = ois.readObject();

        }
        ois.close();
    } catch (FileNotFoundException e) {
        try {
            File archivo = new File(fichero);
            archivo.createNewFile();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    } catch (Exception e) {
    }
    return materias;
}
}
