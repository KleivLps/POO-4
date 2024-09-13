package LigaDeFutbol;



import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
        jugador.setEquipo(this);
    }

    public void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);
        jugador.setEquipo(null); // Romper relación con el equipo
    }

    public void mostrarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("Este equipo no tiene jugadores.");
        } else {
            System.out.println("Jugadores del equipo " + nombre + ":");
            for (Jugador jugador : jugadores) {
                System.out.println("- " + jugador.getNombre());
            }
        }
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
}

