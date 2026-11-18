public class Profesor extends Persona {
    private final String asignatura;

    public Profesor(String nombre, String asignatura) {
        super(nombre);
        this.asignatura = asignatura;
    }
    @Override
    public String presentarse() {
        return super.presentarse() + " y mi asignatura es: " + asignatura;
    }
}



