package LigaDeFutbol;

import java.util.ArrayList;
import java.util.Scanner;

public class LigaDeFutbolRelComp {
    private static ArrayList<Equipo> equipos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Crear equipo");
            System.out.println("2. Crear jugador");
            System.out.println("3. Eliminar equipo");
            System.out.println("4. Mostrar lista de equipos");
            System.out.println("5. Mostrar lista de jugadores");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearEquipo(scanner);
                    break;
                case 2:
                    crearJugador(scanner);
                    break;
                case 3:
                    eliminarEquipo(scanner);
                    break;
                case 4:
                    mostrarEquipos();
                    break;
                case 5:
                    mostrarJugadores();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private static void crearEquipo(Scanner scanner) {
        System.out.print("Introduce el nombre del equipo: ");
        String nombre = scanner.nextLine();
        equipos.add(new Equipo(nombre));
        System.out.println("Equipo creado exitosamente.");
    }

    private static void crearJugador(Scanner scanner) {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos disponibles. Crea un equipo primero.");
            return;
        }

        System.out.print("Introduce el nombre del jugador: ");
        String nombreJugador = scanner.nextLine();

        System.out.println("Elige un equipo para el jugador:");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
        }
        int indiceEquipo = scanner.nextInt() - 1;
        scanner.nextLine();  // Limpiar el buffer

        if (indiceEquipo >= 0 && indiceEquipo < equipos.size()) {
            Equipo equipoSeleccionado = equipos.get(indiceEquipo);
            equipoSeleccionado.agregarJugador(new Jugador(nombreJugador, equipoSeleccionado));
            System.out.println("Jugador creado y asignado al equipo " + equipoSeleccionado.getNombre());
        } else {
            System.out.println("Selección de equipo no válida.");
        }
    }

    private static void eliminarEquipo(Scanner scanner) {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos disponibles para eliminar.");
            return;
        }

        System.out.println("Elige un equipo para eliminar:");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
        }
        int indiceEquipo = scanner.nextInt() - 1;
        scanner.nextLine();  // Limpiar el buffer

        if (indiceEquipo >= 0 && indiceEquipo < equipos.size()) {
            Equipo equipoSeleccionado = equipos.get(indiceEquipo);
            equipos.remove(indiceEquipo);  // Elimina el equipo
            System.out.println("Equipo " + equipoSeleccionado.getNombre() + " y sus jugadores han sido eliminados.");
        } else {
            System.out.println("Selección de equipo no válida.");
        }
    }

    private static void mostrarEquipos() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados.");
        } else {
            System.out.println("Equipos registrados:");
            for (Equipo equipo : equipos) {
                System.out.println("- " + equipo.getNombre());
            }
        }
    }

    private static void mostrarJugadores() {
        boolean hayJugadores = false;
        for (Equipo equipo : equipos) {
            if (!equipo.getJugadores().isEmpty()) {
                hayJugadores = true;
                equipo.mostrarJugadores();
            }
        }
        if (!hayJugadores) {
            System.out.println("No hay jugadores registrados.");
        }
    }
}
