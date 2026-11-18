import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el nombre y la nota de tus alumnos");
        System.out.println("Escribe fin al acabar");
        ArrayList<Alumno> aula = new ArrayList<>();
        ArrayList<Persona> instituto = new ArrayList<>();

        instituto.add(new Alumno("Lucia", 7.5));
        instituto.add(new Profesor("Pepe", "Lengua"));

        for (Persona p : instituto) {
            System.out.println(p.presentarse());
        }

        boolean seguir = true;

        while(seguir) {

            System.out.println("Nombre del alumno ");
            String nombre = sc.nextLine();

            if (nombre.equalsIgnoreCase("fin")) {

                seguir = false;
            } else {

                System.out.println("Nota de " + nombre);
                double calificacion = pedirNotaValida(sc);
                aula.add(new Alumno(nombre, calificacion));

            }

        }

        if (aula.isEmpty()) {

            System.out.println("No hay alumnos que mostrar");
        } else {

            for (Alumno a : aula) {
                System.out.println(a.presentarse());
            }
            System.out.println("Nota media de la clase: " + notaMedia(aula));
            int elAlumnoTop = mejorNota(aula);
            System.out.println("El mejor alumno es " + aula.get(elAlumnoTop).getNombre() + " con un "+ aula.get(elAlumnoTop).getNota());
            System.out.println("Alumnos aprobados: " + aprueban(aula));

        }

    }



    public static double pedirNotaValida(Scanner sc) {

        double verificar = 0;

        while (true) {

            try {
                verificar = sc.nextDouble();
                sc.nextLine();
                if (verificar >= 0 && verificar <= 10) {

                    return verificar;
                }
                System.out.println("Nota no válida, debe estar entre 0 y 10, vuelve a poner la nota");

            } catch (InputMismatchException e) {
                System.out.println("Eso no es un número, inténtalo de nuevo");
                sc.nextLine();   // limpia lo que quedó escrito
            }
        }
    }

    public static double notaMedia(ArrayList<Alumno> aula) {

        double suma = 0;
        double media = 0;
        for (int i = 0; i < aula.size() ; i++ ) {
            suma += aula.get(i).getNota();

        }

        media = (suma / aula.size());

        return media;
    }

    public static int mejorNota(ArrayList<Alumno> aula) {

        int topAlumno = 0;

        for (int i = 1; i < aula.size() ; i++ ) {
            if (aula.get(topAlumno).getNota() < aula.get(i).getNota()) {
                topAlumno = i;
            }

        }

        return topAlumno;
    }

    public static int aprueban(ArrayList<Alumno> aula) {



        int aprobados = 0;

        for (int i = 0; i < aula.size() ; i++ ) {
            if (aula.get(i).estaAprobado()) {
                aprobados++;

            }

        }
        return aprobados;


    }
}