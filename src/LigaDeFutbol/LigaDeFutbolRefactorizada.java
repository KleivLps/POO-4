package LigaDeFutbol;


import java.util.Scanner;

public class LigaDeFutbolRefactorizada {
    private static Liga liga = new Liga();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Crear equipo");
            System.out.println("2. Crear jugador");
            System.out.println("3. Eliminar equipo");
            System.out.println("4. Mostrar lista de equipos");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearEquipo(scanner);
                    break;
                case 2:
                    // Lógica de crear jugador
                    break;
                case 3:
                    eliminarEquipo(scanner);
                    break;
                case 4:
                    liga.mostrarEquipos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void crearEquipo(Scanner scanner) {
        System.out.print("Introduce el nombre del equipo: ");
        String nombre = scanner.nextLine();
        liga.agregarEquipo(nombre);
    }

    private static void eliminarEquipo(Scanner scanner) {
        System.out.print("Introduce el nombre del equipo a eliminar: ");
        String nombre = scanner.nextLine();
        liga.eliminarEquipo(nombre);
    }
}
