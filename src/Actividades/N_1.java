package Actividades;

import java.util.ArrayList;
import java.util.Scanner;

class Nota {
    private String catedra;
    private double notaExamen;

    public Nota(String catedra, double notaExamen) {
        this.catedra = catedra;
        this.notaExamen = notaExamen;
    }

    public String getCatedra() {
        return catedra;
    }

    public double getNotaExamen() {
        return notaExamen;
    }
}

class Alumno {
    private String nombreCompleto;
    private long legajo;
    private ArrayList<Nota> notas;

    public Alumno(String nombreCompleto, long legajo) {
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
        this.notas = new ArrayList<>();
    }

    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    public double calcularPromedio() {
        if (notas.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.getNotaExamen();
        }
        return suma / notas.size();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public long getLegajo() {
        return legajo;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }
}

public class N_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();
        boolean salirAlumno = false;

        while (!salirAlumno) {
            System.out.println("INGRESE DATOS DEL ALUMNO");
            System.out.print("INGRESE NOMBRE COMPLETO: ");
            String nombreCompleto = scanner.nextLine();
            System.out.print("INGRESE LEGAJO: ");
            long legajo = scanner.nextLong();
            scanner.nextLine(); 

            Alumno alumno = new Alumno(nombreCompleto, legajo);
            boolean salirNotas = false;

            while (!salirNotas) {
                System.out.print("INGRESE NOMBRE CATEDRA: ");
                String nombreCatedra = scanner.nextLine();
                System.out.print("INGRESE NOTA: ");
                double notaExamen = scanner.nextDouble();
                scanner.nextLine();

                Nota nota = new Nota(nombreCatedra, notaExamen);
                alumno.agregarNota(nota);

                System.out.print("DESEA SALIR DE LA CARGA DE NOTAS? (s/n): ");
                String salirNotaInput = scanner.nextLine();
                salirNotas = salirNotaInput.equalsIgnoreCase("s");
            }

            alumnos.add(alumno);

            System.out.print("DESEA SALIR DE CARGA DE ALUMNOS? (s/n): ");
            String salirAlumnoInput = scanner.nextLine();
            salirAlumno = salirAlumnoInput.equalsIgnoreCase("s");
        }

        for (Alumno alumno : alumnos) {
            System.out.println("Nombre Completo: " + alumno.getNombreCompleto());
            System.out.println("Legajo: " + alumno.getLegajo());
            System.out.println("Notas:");
            for (Nota nota : alumno.getNotas()) {
                System.out.println("  Cátedra: " + nota.getCatedra() + ", Nota: " + nota.getNotaExamen());
            }
            System.out.println("Promedio de Notas: " + alumno.calcularPromedio());
            System.out.println();
        }

        scanner.close();
    }
}

