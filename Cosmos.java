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
    String x = JOptionPane.showInputDialog("Bienvenido al sistema de matriculas de materias UNAB\nPor favor, Ingresa tu nombre y tu ID: ");
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
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1- Agregar Materia\n2- Cancelar Materia\n3- Mostrar materias matriculadas\n4- Guardar materias y salir"));
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
        JOptionPane.showMessageDialog(null, "Adios!\nSuerte en tu semestre!");
    }

    public void agregarMateria() {
        int opcion2 = Integer.parseInt(JOptionPane.showInputDialog("Materias disponibles: 1) Ecuaciones diferenciales | 2) Inteligencia artificial | 3) Estadística General | 4) Base de datos I | 5) Desarrollo Multimedia | 6) Tecnologías Móviles"));
        if(opcion2 == 1){
            materias = new Materias("Ecuaciones diferenciales","Ivan Vega","6pm-8pm Lunes, 4pm-6pm Martes", 25);
            listaMaterias.add(materias);
            //materias.setCupos(materias.getCupos()-1);
        }else if(opcion2 == 2){
            materias = new Materias("Inteligencia artificial","Leonardo","10am-12pm Martes, 8am-10pm Jueves", 15);
            listaMaterias.add(materias);
        }else if(opcion2 == 3){
            materias = new Materias("Estadística General","Javier Pinzón","6am-8am Martes, 7pm-10pm Jueves", 20);
            listaMaterias.add(materias);
        }else if(opcion2 == 4){
            materias = new Materias("Base de datos I","Julián Santoyo","8am-10am Martes, 10am-12pm Jueves", 20);
            listaMaterias.add(materias);
        }else if(opcion2 == 5){
            materias = new Materias("Desarrollo Multimedia","Johlver Pardo","1pm-4pm Miércoles", 15);
            listaMaterias.add(materias);
        }else if(opcion2 == 6){
            materias = new Materias("Tecnologías Móviles","Yamid Gamba","10am-1pm Viernes", 15);
            listaMaterias.add(materias);
        }
    }

    public void eliminarMateria(){
        int indice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número en la lista de la materia que desea eliminar:"));
        listaMaterias.remove(indice-1);
        JOptionPane.showMessageDialog(null,"La materia ha sido eliminada.");
    }

    public void listarMaterias(){
        if (!listaMaterias.isEmpty()) {
            String texto = "";
            int id = usuario1.getCodigo();
            for(int i = 0; i < listaMaterias.size(); i++){
                texto += "\n" + "[" + (i+1) + "]" + (listaMaterias.get(i)).info();
            }
            JOptionPane.showMessageDialog(null, "El usuario " + usuario1.getNombre() + usuario1.getCodigo() +" ha matriculado: " + texto);
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
