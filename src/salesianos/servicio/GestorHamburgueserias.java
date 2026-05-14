package salesianos.servicio;

import salesianos.modelo.Hamburgueseria;
import salesianos.util.validador;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Clase encargada de gestionar el CRUD de hamburgueserías.
 * Permite añadir, editar, mostrar y eliminar registros almacenados en memoria.
 */
public class GestorHamburgueserias {

    private ArrayList<Hamburgueseria> hamburgueserias;

    public GestorHamburgueserias() {
        hamburgueserias = new ArrayList<>();
    }

    public void añadirHamburgueseria() {
        String nombre = validador.pedirTexto("Introduce el nombre de la hamburguesería:");
        String ubicacion = validador.pedirTexto("Introduce la ubicación:");
        String especialidad = validador.pedirTexto("Introduce la especialidad:");
        int puntuacion = validador.pedirPuntuacion("Introduce la puntuación del 1 al 5:");

        Hamburgueseria nueva = new Hamburgueseria(nombre, ubicacion, especialidad, puntuacion);
        hamburgueserias.add(nueva);

        JOptionPane.showMessageDialog(null, "Hamburguesería añadida correctamente.");
    }

    public void mostrarHamburgueserias() {
        if (hamburgueserias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay hamburgueserías registradas.");
            return;
        }

        hamburgueserias.sort(Comparator.comparingInt(Hamburgueseria::getPuntuacion).reversed());

        StringBuilder resultado = new StringBuilder("Ranking de hamburgueserías:\n\n");

        for (int i = 0; i < hamburgueserias.size(); i++) {
            resultado.append(i + 1).append(". ")
                    .append(hamburgueserias.get(i).toString())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public void editarHamburgueseria() {
        if (hamburgueserias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay hamburgueserías para editar.");
            return;
        }

        mostrarHamburgueserias();

        int indice = pedirIndice("Introduce el número de la hamburguesería que quieres editar:");

        if (indice == -1) {
            return;
        }

        Hamburgueseria hamburgueseria = hamburgueserias.get(indice);

        String nuevoNombre = validador.pedirTexto("Nuevo nombre:");
        String nuevaUbicacion = validador.pedirTexto("Nueva ubicación:");
        String nuevaEspecialidad = validador.pedirTexto("Nueva especialidad:");
        int nuevaPuntuacion = validador.pedirPuntuacion("Nueva puntuación del 1 al 5:");

        hamburgueseria.setNombre(nuevoNombre);
        hamburgueseria.setUbicacion(nuevaUbicacion);
        hamburgueseria.setEspecialidad(nuevaEspecialidad);
        hamburgueseria.setPuntuacion(nuevaPuntuacion);

        JOptionPane.showMessageDialog(null, "Hamburguesería editada correctamente.");
    }

    public void eliminarHamburgueseria() {
        if (hamburgueserias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay hamburgueserías para eliminar.");
            return;
        }

        mostrarHamburgueserias();

        int indice = pedirIndice("Introduce el número de la hamburguesería que quieres eliminar:");

        if (indice == -1) {
            return;
        }

        hamburgueserias.remove(indice);

        JOptionPane.showMessageDialog(null, "Hamburguesería eliminada correctamente.");
    }

    private int pedirIndice(String mensaje) {
        try {
            String entrada = JOptionPane.showInputDialog(null, mensaje);

            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return -1;
            }

            int numero = Integer.parseInt(entrada);
            int indice = numero - 1;

            if (indice < 0 || indice >= hamburgueserias.size()) {
                JOptionPane.showMessageDialog(null, "No existe ningún registro con ese número.");
                return -1;
            }

            return indice;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes introducir un número válido.");
            return -1;
        }
    }
}