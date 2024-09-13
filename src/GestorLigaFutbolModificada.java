

    import java.util.Scanner;

    // Clase Jugador
    class JugadorModificado {
        private String nombre;
        private Equipo equipo;  // Relación de agregación: un jugador puede estar en un equipo

        public JugadorModificado(String nombre) {
            this.nombre = nombre;
            this.equipo = null;  // Inicialmente sin equipo
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Equipo getEquipo() {
            return equipo;
        }

        public void setEquipo(Equipo equipo) {
            this.equipo = equipo;
        }

        // Método para mostrar información del jugador y su equipo
        public void mostrarInformacion() {
            String equipoNombre = (equipo != null) ? equipo.getNombre() : "Sin equipo";
            System.out.println("Jugador: " + nombre + " | Equipo: " + equipoNombre);
        }
    }

    // Clase Equipo
    class EquipoModificado {
        private String nombre;

        public EquipoModificado(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        // Método para mostrar los detalles del equipo
        public void mostrarInformacion() {
            System.out.println("Equipo: " + nombre);
        }
    }

    // Clase principal para gestionar el menú y la interacción
    public class GestorLigaFutbolModificada {
        private static Jugador[] listaJugadores = new Jugador[100];  // Tamaño máximo de jugadores
        private static Equipo[] listaEquipos = new Equipo[100];      // Tamaño máximo de equipos
        private static int numJugadores = 0;  // Contador de jugadores creados
        private static int numEquipos = 0;    // Contador de equipos creados
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int opcion;

            do {
                System.out.println("\n--- Gestor de Liga de Fútbol ---");
                System.out.println("1. Crear jugador");
                System.out.println("2. Crear equipo");
                System.out.println("3. Asignar jugador a equipo");
                System.out.println("4. Eliminar jugador");
                System.out.println("5. Eliminar equipo");
                System.out.println("6. Seleccionar jugador");
                System.out.println("7. Seleccionar equipo");
                System.out.println("8. Mostrar lista de jugadores");
                System.out.println("9. Mostrar lista de equipos");
                System.out.println("10. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        crearJugador();
                        break;
                    case 2:
                        crearEquipo();
                        break;
                    case 3:
                        asignarJugadorAEquipo();
                        break;
                    case 4:
                        eliminarJugador();
                        break;
                    case 5:
                        eliminarEquipo();
                        break;
                    case 6:
                        seleccionarJugador();
                        break;
                    case 7:
                        seleccionarEquipo();
                        break;
                    case 8:
                        mostrarJugadores();
                        break;
                    case 9:
                        mostrarEquipos();
                        break;
                    case 10:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 10);
        }

        // Método para crear un nuevo jugador
        public static void crearJugador() {
            if (numJugadores >= listaJugadores.length) {
                System.out.println("No se pueden agregar más jugadores. El límite ha sido alcanzado.");
                return;
            }

            System.out.print("Ingresa el nombre del jugador: ");
            String nombreJugador = scanner.nextLine();

            if (numEquipos == 0) {
                System.out.println("No hay equipos disponibles, el jugador no tendrá equipo asignado.");
                listaJugadores[numJugadores++] = new Jugador(nombreJugador);
            } else {
                mostrarEquipos();  // Mostrar equipos disponibles
                System.out.print("Selecciona el número del equipo al que pertenece el jugador o ingresa -1 para sin equipo: ");
                int indiceEquipo = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                Jugador nuevoJugador = new Jugador(nombreJugador);

                if (indiceEquipo >= 0 && indiceEquipo < numEquipos) {
                    Equipo equipoSeleccionado = listaEquipos[indiceEquipo];
                    nuevoJugador.setEquipo(equipoSeleccionado);
                } else {
                    System.out.println("El jugador no será asignado a ningún equipo.");
                }

                listaJugadores[numJugadores++] = nuevoJugador;
            }

            System.out.println("Jugador creado con éxito.");
        }

        // Método para crear un nuevo equipo
        public static void crearEquipo() {
            if (numEquipos >= listaEquipos.length) {
                System.out.println("No se pueden agregar más equipos. El límite ha sido alcanzado.");
                return;
            }

            System.out.print("Ingresa el nombre del equipo: ");
            String nombreEquipo = scanner.nextLine();
            listaEquipos[numEquipos++] = new Equipo(nombreEquipo);
            System.out.println("Equipo creado con éxito.");
        }

        // Método para asignar un jugador a un equipo
        public static void asignarJugadorAEquipo() {
            if (numJugadores == 0) {
                System.out.println("No hay jugadores disponibles.");
                return;
            }

            if (numEquipos == 0) {
                System.out.println("No hay equipos disponibles.");
                return;
            }

            mostrarJugadores();  // Mostrar jugadores disponibles
            System.out.print("Selecciona el número del jugador a asignar: ");
            int indiceJugador = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            mostrarEquipos();  // Mostrar equipos disponibles
            System.out.print("Selecciona el número del equipo al que quieres asignar el jugador: ");
            int indiceEquipo = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            if (indiceJugador >= 0 && indiceJugador < numJugadores && indiceEquipo >= 0 && indiceEquipo < numEquipos) {
                Jugador jugadorSeleccionado = listaJugadores[indiceJugador];
                Equipo equipoSeleccionado = listaEquipos[indiceEquipo];
                jugadorSeleccionado.setEquipo(equipoSeleccionado);
                System.out.println("Jugador asignado al equipo con éxito.");
            } else {
                System.out.println("Jugador o equipo no válido.");
            }
        }

        // Método para eliminar un jugador
        public static void eliminarJugador() {
            if (numJugadores == 0) {
                System.out.println("No hay jugadores disponibles para eliminar.");
                return;
            }

            mostrarJugadores();
            System.out.print("Selecciona el número del jugador a eliminar: ");
            int indiceJugador = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            if (indiceJugador >= 0 && indiceJugador < numJugadores) {
                // Eliminar jugador moviendo los elementos del array
                for (int i = indiceJugador; i < numJugadores - 1; i++) {
                    listaJugadores[i] = listaJugadores[i + 1];
                }
                listaJugadores[--numJugadores] = null;  // Reducir el contador
                System.out.println("Jugador eliminado con éxito.");
            } else {
                System.out.println("Jugador no válido.");
            }
        }

        // Método para eliminar un equipo
        public static void eliminarEquipo() {
            if (numEquipos == 0) {
                System.out.println("No hay equipos disponibles para eliminar.");
                return;
            }

            mostrarEquipos();
            System.out.print("Selecciona el número del equipo a eliminar: ");
            int indiceEquipo = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            if (indiceEquipo >= 0 && indiceEquipo < numEquipos) {
                // Eliminar equipo moviendo los elementos del array
                for (int i = indiceEquipo; i < numEquipos - 1; i++) {
                    listaEquipos[i] = listaEquipos[i + 1];
                }
                listaEquipos[--numEquipos] = null;  // Reducir el contador

                // Desasignar jugadores que pertenecían a este equipo
                for (int i = 0; i < numJugadores; i++) {
                    if (listaJugadores[i].getEquipo() == listaEquipos[indiceEquipo]) {
                        listaJugadores[i].setEquipo(null);
                    }
                }
                System.out.println("Equipo eliminado con éxito.");
            } else {
                System.out.println("Equipo no válido.");
            }
        }

        // Método para seleccionar un jugador y mostrar el submenú
        public static void seleccionarJugador() {
            if (numJugadores == 0) {
                System.out.println("No hay jugadores disponibles.");
                return;
            }

            mostrarJugadores();
            System.out.print("Selecciona el número del jugador: ");
            int indiceJugador = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            if (indiceJugador >= 0 && indiceJugador < numJugadores) {
                Jugador jugadorSeleccionado = listaJugadores[indiceJugador];
                int opcion;
                do {
                    System.out.println("\n--- Menú de Jugador ---");
                    System.out.println("1. Ver detalles");
                    System.out.println("2. Cambiar nombre");
                    System.out.println("3. Cambiar equipo");
                    System.out.println("4. Regresar al menú principal");
                    System.out.print("Elige una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer

                    switch (opcion) {
                        case 1:
                            jugadorSeleccionado.mostrarInformacion();
                            break;
                        case 2:
                            System.out.print("Ingresa el nuevo nombre del jugador: ");
                            String nuevoNombre = scanner.nextLine();
                            jugadorSeleccionado.setNombre(nuevoNombre);
                            System.out.println("Nombre del jugador actualizado.");
                            break;
                        case 3:
                            mostrarEquipos();
                            System.out.print("Selecciona el nuevo equipo para el jugador: ");
                            int indiceEquipo = scanner.nextInt();
                            scanner.nextLine();  // Limpiar el buffer
                            if (indiceEquipo >= 0 && indiceEquipo < numEquipos) {
                                Equipo nuevoEquipo = listaEquipos[indiceEquipo];
                                jugadorSeleccionado.setEquipo(nuevoEquipo);
                                System.out.println("Equipo del jugador actualizado.");
                            } else {
                                System.out.println("Equipo no válido.");
                            }
                            break;
                        case 4:
                            System.out.println("Regresando al menú principal.");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                } while (opcion != 4);
            } else {
                System.out.println("Jugador no válido.");
            }
        }

        // Método para seleccionar un equipo y mostrar el submenú
        public static void seleccionarEquipo() {
            if (numEquipos == 0) {
                System.out.println("No hay equipos disponibles.");
                return;
            }

            mostrarEquipos();
            System.out.print("Selecciona el número del equipo: ");
            int indiceEquipo = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            if (indiceEquipo >= 0 && indiceEquipo < numEquipos) {
                Equipo equipoSeleccionado = listaEquipos[indiceEquipo];
                int opcion;
                do {
                    System.out.println("\n--- Menú de Equipo ---");
                    System.out.println("1. Ver detalles");
                    System.out.println("2. Cambiar nombre");
                    System.out.println("3. Agregar jugador al equipo");
                    System.out.println("4. Mostrar jugadores del equipo");
                    System.out.println("5. Regresar al menú principal");
                    System.out.print("Elige una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer

                    switch (opcion) {
                        case 1:
                            equipoSeleccionado.mostrarInformacion();
                            break;
                        case 2:
                            System.out.print("Ingresa el nuevo nombre del equipo: ");
                            String nuevoNombre = scanner.nextLine();
                            equipoSeleccionado.setNombre(nuevoNombre);
                            // Cambiar el nombre del equipo en los jugadores también
                            for (int i = 0; i < numJugadores; i++) {
                                if (listaJugadores[i].getEquipo() == equipoSeleccionado) {
                                    listaJugadores[i].setEquipo(equipoSeleccionado);
                                }
                            }
                            System.out.println("Nombre del equipo actualizado.");
                            break;
                        case 3:
                            mostrarJugadores();
                            System.out.print("Selecciona el número del jugador a agregar al equipo: ");
                            int indiceJugador = scanner.nextInt();
                            scanner.nextLine();  // Limpiar el buffer
                            if (indiceJugador >= 0 && indiceJugador < numJugadores) {
                                Jugador jugadorSeleccionado = listaJugadores[indiceJugador];
                                jugadorSeleccionado.setEquipo(equipoSeleccionado);
                                System.out.println("Jugador agregado al equipo.");
                            } else {
                                System.out.println("Jugador no válido.");
                            }
                            break;
                        case 4:
                            System.out.println("Jugadores en el equipo " + equipoSeleccionado.getNombre() + ":");
                            for (int i = 0; i < numJugadores; i++) {
                                if (listaJugadores[i].getEquipo() == equipoSeleccionado) {
                                    listaJugadores[i].mostrarInformacion();
                                }
                            }
                            break;
                        case 5:
                            System.out.println("Regresando al menú principal.");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                } while (opcion != 5);
            } else {
                System.out.println("Equipo no válido.");
            }
        }

        // Método para mostrar la lista de jugadores
        public static void mostrarJugadores() {
            System.out.println("\n--- Lista de Jugadores ---");
            if (numJugadores == 0) {
                System.out.println("No hay jugadores registrados.");
            } else {
                for (int i = 0; i < numJugadores; i++) {
                    System.out.println(i + ". " + listaJugadores[i].getNombre());
                }
            }
        }

        // Método para mostrar la lista de equipos
        public static void mostrarEquipos() {
            System.out.println("\n--- Lista de Equipos ---");
            if (numEquipos == 0) {
                System.out.println("No hay equipos registrados.");
            } else {
                for (int i = 0; i < numEquipos; i++) {
                    System.out.println(i + ". " + listaEquipos[i].getNombre());
                }
            }
        }
    }


