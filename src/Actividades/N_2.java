package Actividades;

import java.util.ArrayList;
import java.util.Scanner;

class Ingrediente {
    private String nombre;
    private double cantidad;
    private String unidadMedida;

    public Ingrediente(String nombre, double cantidad, String unidadMedida) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }
}

class Plato {
    private String nombreCompleto;
    private double precio;
    private boolean esBebida;
    private ArrayList<Ingrediente> ingredientes;

    public Plato(String nombreCompleto, double precio, boolean esBebida) {
        this.nombreCompleto = nombreCompleto;
        this.precio = precio;
        this.esBebida = esBebida;
        this.ingredientes = new ArrayList<>();
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEsBebida() {
        return esBebida;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }
}

public class N_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Plato> platosMenu = new ArrayList<>();
        boolean salirMenu = false;

        while (!salirMenu) {
            System.out.println("INGRESE DATOS DEL PLATO");
            System.out.print("INGRESE NOMBRE DEL PLATO: ");
            String nombreCompleto = scanner.nextLine();
            System.out.print("INGRESE PRECIO: ");
            double precio = scanner.nextDouble();
            System.out.print("¿ES BEBIDA? (s/n): ");
            boolean esBebida = scanner.next().equalsIgnoreCase("s");
            scanner.nextLine(); 

            Plato plato = new Plato(nombreCompleto, precio, esBebida);

            if (!esBebida) {
                boolean salirIngredientes = false;
                while (!salirIngredientes) {
                    System.out.print("INGRESE NOMBRE DEL INGREDIENTE: ");
                    String nombreIngrediente = scanner.nextLine();
                    System.out.print("INGRESE CANTIDAD: ");
                    double cantidad = scanner.nextDouble();
                    System.out.print("INGRESE UNIDAD DE MEDIDA: ");
                    String unidadMedida = scanner.next();
                    scanner.nextLine(); 

                    Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidad, unidadMedida);
                    plato.agregarIngrediente(ingrediente);

                    System.out.print("¿DESEA AGREGAR OTRO INGREDIENTE? (s/n): ");
                    salirIngredientes = scanner.next().equalsIgnoreCase("n");
                    scanner.nextLine(); 
                }
            }

            platosMenu.add(plato);

            System.out.print("¿DESEA AGREGAR OTRO PLATO? (s/n): ");
            salirMenu = scanner.next().equalsIgnoreCase("n");
            scanner.nextLine(); 
        }

        System.out.println("\n-----------MENU----------------");
        for (Plato plato : platosMenu) {
            System.out.println(plato.getNombreCompleto());
            System.out.printf("Precio: $ %.2f%n", plato.getPrecio());
            if (!plato.isEsBebida()) {
                System.out.println("Ingredientes:");
                System.out.println("Nombre\t\tCantidad\tUnidad de Medida");
                for (Ingrediente ingrediente : plato.getIngredientes()) {
                    System.out.printf("%s\t\t%.2f\t\t%s%n", ingrediente.getNombre(), ingrediente.getCantidad(), ingrediente.getUnidadMedida());
                }
            }
            System.out.println("----------------------------------");
        }

        scanner.close();
    }
}
