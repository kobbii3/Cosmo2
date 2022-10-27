import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Cosmos {
    ArrayList<String> listaMaterias;

    String x = JOptionPane.showInputDialog("Bienvenido al sistemas de matriculas de marteriias UNAB\nPor favor, Ingresa tu nombre: ");
    Usuario usuario1 = new Usuario(x);

    Materias calculo = new Materias("Cálculo","Ivan","6pm", 5);
    Materias mecanica = new Materias("Mecanica","Martha","10am", 5);
    Materias programación = new Materias("Programación","Johlver","8am", 5);
public static void main(String[] args) {
    Cosmos Lista = new Cosmos();
    Lista.listaMaterias = new ArrayList<String>();
    Lista.leerOpcion();
}

public void leerOpcion() {
    int opcion = 0;
    do{
        opcion = Integer.parseInt(JOptionPane.showInputDialog("1- Agregar Materia\n2- Eliminar Materia\n3- Listar Materias\n4- Salir"));
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
            default:
                System.out.println("ERROR - ENTRADA NO VALIDA.");
                break;
        }
    } while (opcion != 4);
}
public void agregarMateria() {
    int opcion2 = Integer.parseInt(JOptionPane.showInputDialog("Materias disponibles: 1) Calculo | 2) Mecanica | 3) Programación"));
    if(opcion2 == 1){
        listaMaterias.add(calculo.info());
        calculo.setCupos(calculo.getCupos()-1);
    }else{
        if(opcion2 == 2){
            listaMaterias.add(mecanica.info());
            mecanica.setCupos(mecanica.getCupos()-1);
        }else{
            if(opcion2 == 3){
                listaMaterias.add(programación.info());
                programación.setCupos(programación.getCupos()-1);
            }
        }
    }
}

public void eliminarMateria(){
    int opcion2 = Integer.parseInt(JOptionPane.showInputDialog("Eliminar: 1) Calculo | 2) Mecanica | 3) Programación"));
    if(opcion2 == 1){
        int indice = listaMaterias.indexOf(calculo.info());
        if (indice < 0){
            listaMaterias.remove(indice);
        }else{JOptionPane.showMessageDialog(null, "Dato no encontrado");}
        calculo.setCupos(calculo.getCupos()+1);
    }else{
        if(opcion2 == 2){
            listaMaterias.remove(mecanica.info());
            mecanica.setCupos(mecanica.getCupos()+1);
        }else{
            if(opcion2 == 3){
                listaMaterias.remove(programación.info());
                programación.setCupos(programación.getCupos()+1);
            }
        }
    }
}

public void listarMaterias(){
    if (!listaMaterias.isEmpty()) {
        String texto = usuario1.getNombre();
        for(int i = 0; i < listaMaterias.size(); i++){
            texto += "\n" + "[" + (i+1) + "]" + listaMaterias.get(i);
        }
        JOptionPane.showMessageDialog(null, texto);
    }else{JOptionPane.showMessageDialog(null, "No se han matriculado materias.");}
}
}