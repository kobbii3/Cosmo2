import java.io.Serializable;
public class Materias implements Serializable {

    private String nombreM;
    private String profesorM;
    private String horarioM;
    private int cupos;


    public Materias(String nombreM,String profesorM, String horarioM, int cupos){
        this.nombreM = nombreM;
        this.profesorM = profesorM; 
        this.horarioM = horarioM; 
        this.cupos = cupos;  
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public String info() {
        return "Nombre: "+ nombreM + "| Profesor: "+ profesorM + " | Horario: "+ horarioM + " | cupos: "+ cupos;
    };
}
