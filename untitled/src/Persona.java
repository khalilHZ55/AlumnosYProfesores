public class Persona {
    protected String nombre;
    public Persona(String nombre) {

        this.nombre = nombre;

    }

    public String presentarse() {
        return "Hola, me llamo " + nombre;
    }
    public String getNombre() {
        return nombre;
    }


}
