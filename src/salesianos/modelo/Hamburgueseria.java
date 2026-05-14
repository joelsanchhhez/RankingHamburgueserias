package salesianos.modelo;

/**
 * Clase que representa una hamburguesería dentro del ranking.
 * Contiene la información básica del establecimiento y su puntuación.
 */
public class Hamburgueseria {

    private String nombre;
    private String ubicacion;
    private String especialidad;
    private int puntuacion;

    public Hamburgueseria(String nombre, String ubicacion, String especialidad, int puntuacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.especialidad = especialidad;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nUbicación: " + ubicacion +
                "\nEspecialidad: " + especialidad +
                "\nPuntuación: " + puntuacion + "/5\n";
    }
}