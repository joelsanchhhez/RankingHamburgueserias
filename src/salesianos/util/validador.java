package salesianos.util;

import javax.swing.JOptionPane;

/**
 * Clase de utilidad que contiene métodos estáticos para validar datos
 * y convertir entradas introducidas por el usuario.
 */
public class validador {

    public static boolean textoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static int pedirPuntuacion(String mensaje) {
        int puntuacion = 0;
        boolean valido = false;

        while (!valido) {
            try {
                String entrada = JOptionPane.showInputDialog(null, mensaje);

                if (entrada == null) {
                    JOptionPane.showMessageDialog(null, "No puedes cancelar esta acción.");
                } else {
                    puntuacion = Integer.parseInt(entrada);

                    if (puntuacion >= 1 && puntuacion <= 5) {
                        valido = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "La puntuación debe estar entre 1 y 5.");
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes introducir un número válido.");
            }
        }

        return puntuacion;
    }

    public static String pedirTexto(String mensaje) {
        String texto = "";

        while (!textoValido(texto)) {
            texto = JOptionPane.showInputDialog(null, mensaje);

            if (!textoValido(texto)) {
                JOptionPane.showMessageDialog(null, "Este campo no puede estar vacío.");
            }
        }

        return texto.trim();
    }
}