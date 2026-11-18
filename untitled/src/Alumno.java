public class Alumno extends Persona {


    private double nota;

    public Alumno(String nombre, double nota) {
        super(nombre);
        this.nota = nota;

    }

    public boolean estaAprobado() {

        return nota >= 5;
    }

    public String calificar() {

        if (nota < 5) {
            return"Suspenso";
        } else if (nota < 7) {
            return"Aprobado";
        } else if (nota < 9) {
            return"Notable";
        } else {
            return"Sobresaliente";
        }

    }

    @Override
    public String presentarse() {
        return super.presentarse() + " y mi nota es " + nota;
    }


    public double getNota() {
        return nota;
    }

}
