package View;

import Model.Usuario;
import Model.Reserva;

import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VistaUS {

    public int mostrarMenu() {
        int opcion = -1;
        while (opcion == -1) {
            try {
                String entrada = JOptionPane.showInputDialog(null,
                        "Menu de Opciones\n" +
                                "1: Registrarse\n" +
                                "2: Iniciar Sesion\n" +
                                "3: Salir\n" +
                                "Ingrese una opción",
                        "Primer Menu", JOptionPane.QUESTION_MESSAGE);
                if (entrada != null) {
                    opcion = Integer.parseInt(entrada);
                } else {
                    mostrarMensaje("Error: Ingrese una opción válida.");
                }
            } catch (Exception error) {
                mostrarMensaje("Error: No se permiten letras, elija una opción numérica.");
            }
        }
        return opcion;
    }

    public int menuAdministrador() {
        int opcion = -1;
        while (opcion == -1) {
            try {
                String entrada = JOptionPane.showInputDialog(null,
                        "Menu de Opciones Administrador\n" +
                                "1: Ver mi Perfil\n" +
                                "2: Actualizar mi perfil\n" +
                                "3: Ver clientes\n" +
                                "4: Ver administradores\n" +
                                "5: Eliminar clientes\n" +
                                "6: Hacer reservacion\n" +
                                "7: Actualizar reservacion\n" +
                                "8: Eliminar reservacion\n" +
                                "9: Ver reservaciones\n" +
                                "10: Buscar reservacion\n" +
                                "11: Cerrar Sesion\n" +
                                "Ingrese una opción",
                        "Menu Administrador", JOptionPane.QUESTION_MESSAGE);
                if (entrada != null) {
                    opcion = Integer.parseInt(entrada);
                } else {
                    mostrarMensaje("Error: Ingrese una opción válida.");
                }
            } catch (Exception error) {
                mostrarMensaje("Error: No se permiten letras, elija una opción numérica.");
            }
        }
        return opcion;
    }

    public int menuCliente() {
        int opcion = -1;
        while (opcion == -1) {
            try {
                String entrada = JOptionPane.showInputDialog(null,
                        "Menu de Opciones Cliente\n" +
                                "1: Ver mi Perfil\n" +
                                "2: Actualizar mi perfil\n" +
                                "3: Eliminar mi cuenta\n" +
                                "4: Hacer reservacion\n" +
                                "5: Actualizar reservacion\n" +
                                "6: Eliminar reservacion\n" +
                                "7: Ver mis reservaciones\n" +
                                "8: Buscar reservacion\n" +
                                "9: Cerrar Sesion\n" +
                                "Ingrese una opción",
                        "Menu Cliente", JOptionPane.QUESTION_MESSAGE);
                if (entrada != null) {
                    opcion = Integer.parseInt(entrada);
                } else {
                    mostrarMensaje("Error: Ingrese una opción válida.");
                }
            } catch (Exception error) {
                mostrarMensaje("Error: No se permiten letras, elija una opción numérica.");
            }
        }
        return opcion;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String captureDatoSTR(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }

    public int captureDatoInt(String mensaje) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
    }

    public Date captureDatoFecha(String mensaje) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        while (true) {
            String dateStr = JOptionPane.showInputDialog(null, mensaje);
            try {
                return dateFormat.parse(dateStr);
            } catch (ParseException e) {
                mostrarMensaje("Fecha inválida. Por favor, use el formato yyyy-MM-dd.");
            }
        }
    }

    public void mostrarReserva(Reserva reserva) {
        if (reserva != null) {
            mostrarMensaje(reserva.toString());
        } else {
            mostrarMensaje("Reserva no encontrada.");
        }
    }
}
