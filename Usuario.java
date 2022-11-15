public class Usuario {

    public String nombre;
    public Materias materias;
    public int codigo;


    public Usuario(String nombre){
        this.nombre = nombre;
    }

    public void addMateria(Materias materias){
        this.materias = materias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
