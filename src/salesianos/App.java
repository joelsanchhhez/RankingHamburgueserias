package salesianos;

import salesianos.servicio.GestorHamburgueserias;

import javax.swing.JOptionPane;

/**
 * Clase principal de la aplicación.
 * Muestra el menú principal y controla la ejecución del programa.
 */
public class App {

    public static void main(String[] args) {

        GestorHamburgueserias gestor = new GestorHamburgueserias();
        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    null,
                    "MENÚ PRINCIPAL\n\n" +
                            "1. Añadir hamburguesería\n" +
                            "2. Editar hamburguesería\n" +
                            "3. Mostrar hamburgueserías\n" +
                            "4. Eliminar hamburguesería\n" +
                            "5. Salir\n\n" +
                            "Elige una opción:");

            if (opcion == null) {
                JOptionPane.showMessageDialog(null, "Debes salir usando la opción 5.");
                continue;
            }

            switch (opcion) {
                case "1":
                    gestor.añadirHamburgueseria();
                    break;

                case "2":
                    gestor.editarHamburgueseria();
                    break;

                case "3":
                    gestor.mostrarHamburgueserias();
                    break;

                case "4":
                    gestor.eliminarHamburgueseria();
                    break;

                case "5":
                    JOptionPane.showMessageDialog(null, "Programa finalizado.");
                    salir = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta. Elige una opción del 1 al 5.");
                    break;
            }
        }
    }
}