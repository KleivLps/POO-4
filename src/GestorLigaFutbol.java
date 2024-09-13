import java.util.Scanner;

class Jugador {
    private String nombre;
    private Equipo equipo;

    public Jugador (String nombre) {
        this.nombre = nombre;
        this.equipo = null;
    }

    public String getNombre() {
        return nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void mostrarInformacion() {
        String equipoNombre =(equipo != null) ? equipo.getNombre() : "Sin equipo";
        System.out.println("Jugador: " +nombre + "| Equipo: " +equipoNombre);
    }

    public void setNombre(String nuevoNombre) {
    }
}

class Equipo {
    private String nombre;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarInformacion() {
    }

    public void setNombre(String nuevoNombre) {
    }
}

public class GestorLigaFutbol {
    private static Jugador[] listaJugadores = new Jugador[100];
    private static Equipo[] listaEquipos = new Equipo[100];
    private static int numeroJugadores = 0;
    private static int numeroEquipos = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n GESTOR DE LIGAS DE FÚTBOL");
            System.out.println("1. Crear Jugador");
            System.out.println("2. Crear Equipo");
            System.out.println("3. Asignar jugador a equipo");
            System.out.println("4. Mostrar lista de jugadores");
            System.out.println("5. Mostrar lista de equipos");
            System.out.println("6. Salir");
            System.out.println("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearJugador();
                    break;
                case 2:
                    crearEquipo();
                    break;
                case 3:
                    asignarJugadorAEquipos();
                    break;
                case 4:
                    mostrarJugadores();
                    break;
                case 5:
                    mostrarEquipos();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 6);
    }

    public static void crearJugador() {
        if (numeroJugadores >= listaJugadores.length) {
            System.out.println("No se pueden agregar mas jugadores. El limite ha sido alcanzado");
            return;
        }

        System.out.println("Ingresa el nombre del jugador: ");
        String nombreJugador = scanner.nextLine();

        if (numeroEquipos == 0) {
            System.out.println("No hay equipos disponibles, el jugador no tendra equipo asignado");
            listaJugadores[numeroJugadores++] =new Jugador(nombreJugador);
        } else {
            mostrarEquipos();
            System.out.println("Seleccione el numero del equipo al que pertenece el jugador o ingresa -1 para sin equipo: \");");
            int indiceEquipo = scanner.nextInt();
            scanner.nextLine();

            Jugador nuevoJugador = new Jugador(nombreJugador);

            if (indiceEquipo >= 0 && indiceEquipo < numeroEquipos) {
                Equipo equipoSeleccionado = listaEquipos[indiceEquipo];
                nuevoJugador.setEquipo(equipoSeleccionado);
            } else {
                System.out.println("El jugador no sera asignado a ningun equipo. ");
            }

            listaJugadores[numeroJugadores++] = nuevoJugador;
        }

        System.out.println("Jugador creado con exito. ");
    }

    public static void crearEquipo() {
        if (numeroEquipos >= listaEquipos.length) {
            System.out.println("No se pueden agregar mas equipos. El limite ha sido alcanzado.");
            return;
        }

        System.out.println("Ingresa el nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();
        listaEquipos[numeroEquipos++] = new Equipo(nombreEquipo);
        System.out.println("Equipo creado con exito. ");
    }

    public static void asignarJugadorAEquipos() {
        if (numeroJugadores == 0 ) {
            System.out.println("No hay jugadores disponibles.");
            return;
        }

        if (numeroEquipos == 0) {
            System.out.println("No hay equipos disponibles.");
            return;
        }

        if (numeroEquipos == 0 ) {
            System.out.println("No hay equipos disponibles.");
            return;
        }

        mostrarJugadores();
        System.out.println("Selecciona el numero del jugador a asignar: ");
        int indiceJugador = scanner.nextInt();
        scanner.nextLine();

        mostrarEquipos();
        System.out.println("Selecciona el número del equipo al que quieres asignar el jugador: ");
        int indiceEquipo = scanner.nextInt();
        scanner.nextLine();
        if (indiceJugador >= 0 && indiceJugador < numeroJugadores && indiceEquipo >= 0 && indiceEquipo < numeroEquipos) {
            Jugador jugadorSeleccionado = listaJugadores[indiceJugador];
            Equipo equipoSeleccionado = listaEquipos[indiceEquipo];
            jugadorSeleccionado.setEquipo(equipoSeleccionado);
            System.out.println("Jugador asignado al equipo con éxito.");
        } else {
            System.out.println("Jugador o equipo no valido.");
        }
    }

    public static void mostrarJugadores() {
        if (numeroJugadores == 0) {
            System.out.println("No hay jugadores registrados.");
        } else {
            System.out.println("\n LISTA DE JUGADORES");
            for (int i = 0; i < numeroJugadores; i++) {
                System.out.println(i + ". ");
                listaJugadores[i].mostrarInformacion();
            }
        }
    }

    public static void mostrarEquipos() {
        if (numeroEquipos == 0 ) {
            System.out.println("No hay equipos registrados. ");
        } else {
            System.out.println("\n LISTA DE EQUIPOS");
            for (int i = 0; i < numeroEquipos; i++) {
                System.out.println(i + ". " + listaEquipos[i].getNombre());
            }
        }
    }
}