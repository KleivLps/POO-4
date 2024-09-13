package LigaDeFutbol;

import java.util.HashMap;

public class Liga {
    private HashMap<String, Equipo> equipos;

    public Liga() {
        equipos = new HashMap<>();
    }

    public void agregarEquipo(String nombre) {
        if (!equipos.containsKey(nombre)) {
            equipos.put(nombre, new Equipo(nombre));
        } else {
            System.out.println("El equipo ya existe.");
        }
    }

    public void eliminarEquipo(String nombre) {
        if (equipos.containsKey(nombre)) {
            equipos.remove(nombre);
            System.out.println("Equipo eliminado.");
        } else {
            System.out.println("El equipo no existe.");
        }
    }

    public Equipo obtenerEquipo(String nombre) {
        return equipos.get(nombre);
    }

    public void mostrarEquipos() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados.");
        } else {
            for (Equipo equipo : equipos.values()) {
                System.out.println(equipo.getNombre());
            }
        }
    }
}
