package LigaDeFutbol;



public class Jugador {
    private String nombre;
    private Equipo equipo;

    public Jugador(String nombre, Equipo equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
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

    public void mostrarDetalles() {
        System.out.println("Nombre del jugador: " + nombre);
        if (equipo != null) {
            System.out.println("Equipo: " + equipo.getNombre());
        } else {
            System.out.println("Este jugador no tiene equipo asignado.");
        }
    }
}

