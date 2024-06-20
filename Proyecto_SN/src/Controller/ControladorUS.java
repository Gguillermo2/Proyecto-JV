package Controller;

import Model.GestorUsuarios;
import Model.Usuario;
import Model.GestionReserva;
import Model.Reserva;
import View.VistaUS;

import java.util.Date;

public class ControladorUS {

    private GestorUsuarios gestorUS;
    private VistaUS vistaUS;
    private GestionReserva gestionReserva;

    public ControladorUS(GestorUsuarios gestorUS, VistaUS vistaUS, GestionReserva gestionReserva) {
        this.gestorUS = gestorUS;
        this.vistaUS = vistaUS;
        this.gestionReserva = gestionReserva;
        gestorUS.cargarUsuarios();
        gestionReserva.cargarReservas();
    }

    public void ejecutar() {
        boolean continuar = true;

        while (continuar) {
            int opcion = vistaUS.mostrarMenu();

            switch (opcion) {
                case 1:
                    gestorUS.creacionUsuario(vistaUS.captureDatoSTR("Ingrese su nombre completo:"), vistaUS.captureDatoSTR("Ingrese su correo"), vistaUS.captureDatoSTR("Ingrese su contraseña"), vistaUS.captureDatoSTR("Ingrese su numero de celular"), vistaUS.captureDatoInt("Ingrese su edad"),vistaUS.captureDatoSTR("´¿Es Admin? true/false") );
                    gestorUS.guardarUsuarios();
                    break;
                case 2:
                    gestorUS.cargarUsuarios();
                    Usuario usuario = gestorUS.iniciarSesion(vistaUS.captureDatoSTR("Ingrese su correo"), vistaUS.captureDatoSTR("Ingrese su contraseña") );
                    if (usuario != null) {
                        if (usuario.isEsAdmin()) {
                            manejarMenuAdministrador(usuario);
                        } else {
                            manejarMenuCliente(usuario);
                        }
                    } else {
                        vistaUS.mostrarMensaje("Credenciales incorrectas. Por favor, intente nuevamente.");
                    }
                    break;
                case 3:
                    gestorUS.guardarUsuarios();
                    gestionReserva.guardarReservas();
                    continuar = false;
                    break;
                default:
                    vistaUS.mostrarMensaje("Opción no válida. Por favor, intente nuevamente.");
                    break;
            }
        }
    }

    private void manejarMenuAdministrador(Usuario usuario) {
        boolean continuar = true;

        while (continuar) {
            int opcion = vistaUS.menuAdministrador();

            switch (opcion) {
                case 1: // Ver perfil
                    vistaUS.mostrarMensaje(usuario.toString());
                    break;
                case 2: // Actualizar perfil
                    gestorUS.actualizarUsuario(usuario.getCorreoElectronico(), vistaUS.captureDatoSTR("Dijite su nombre"), vistaUS.captureDatoSTR("Dijite su nueva contrasena"), vistaUS.captureDatoSTR("Dijite su nuevo numero de celular"), vistaUS.captureDatoInt("Dijite su edad"));
                    gestorUS.guardarUsuarios();
                    break;
                case 3: // Ver clientes
                    gestorUS.mostrarClientes();
                    break;
                case 4: // Ver administradores
                    gestorUS.mostrarAdministradores();
                    break;
                case 5: // Eliminar clientes
                    String correoCliente = vistaUS.captureDatoSTR("Ingrese el correo del cliente a eliminar:");
                    gestorUS.eliminarUsuario(correoCliente);
                    gestorUS.guardarUsuarios();
                    break;
                case 6: // Hacer reservación
                    gestionReserva.creacionReserva(usuario,vistaUS.captureDatoFecha("fecha"),vistaUS.captureDatoSTR("Tipo de reserva"),false);
                    gestionReserva.guardarReservas();
                    break;
                case 7: // Actualizar reservación
                    Reserva reserva = gestionReserva.buscarReservacion(vistaUS.captureDatoInt("Dijite el id de la reserva a actualizar"));
                    if (reserva != null) {
                        gestionReserva.actualizarReserva(reserva.getId(), reserva.getUsuario(), vistaUS.captureDatoFecha("Dijite la Fecha"), vistaUS.captureDatoSTR("Nuevo tipo de reservacion"),vistaUS.captureDatoSTR("¿Ya pago la reservacion? si/no"));
                    } else {
                        vistaUS.mostrarMensaje("Reserva no encontrada.");
                    }
                    gestionReserva.guardarReservas();
                    gestionReserva.guardarReservas();
                    break;
                case 8: // Eliminar reservación
                    gestionReserva.eliminarReserva(vistaUS.captureDatoInt("Dijite la id de la reservacion a eliminar"));
                    gestionReserva.guardarReservas();
                    break;
                case 9: // Ver reservaciones
                    gestionReserva.verTodasLasReservaciones();
                    break;
                case 10: // Buscar reservación
                    reserva = gestionReserva.buscarReservacion(vistaUS.captureDatoInt("Dijite la id de la reservacion"));
                    vistaUS.mostrarReserva(reserva);
                    break;
                case 11: // Cerrar sesión
                    continuar = false;
                    break;
                default:
                    vistaUS.mostrarMensaje("Opción no válida. Por favor, intente nuevamente.");
                    break;
            }
        }
    }

    private void manejarMenuCliente(Usuario usuario) {
        boolean continuar = true;

        while (continuar) {
            int opcion = vistaUS.menuCliente();

            switch (opcion) {
                case 1: // Ver perfil
                    vistaUS.mostrarMensaje(usuario.toString());
                    break;
                case 2: // Actualizar perfil
                    gestorUS.actualizarUsuario(usuario.getCorreoElectronico(), vistaUS.captureDatoSTR("Dijite su nombre"), vistaUS.captureDatoSTR("Dijite su nueva contrasena"), vistaUS.captureDatoSTR("Dijite su nuevo numero de celular"), vistaUS.captureDatoInt("Dijite su edad"));
                    gestorUS.guardarUsuarios();
                    break;
                case 3: // Eliminar cuenta
                    gestorUS.eliminarUsuario(usuario.getCorreoElectronico());
                    continuar = false;
                    gestorUS.guardarUsuarios();
                    break;
                case 4: // Hacer reservación
                    gestionReserva.creacionReserva(usuario,vistaUS.captureDatoFecha("fecha"),vistaUS.captureDatoSTR("Tipo de reserva"),false);
                    gestionReserva.guardarReservas();
                    break;
                case 5: // Actualizar reservación
                    Reserva reserva = gestionReserva.buscarReservacion(vistaUS.captureDatoInt("Dijite el id de la reserva a actualizar"));
                    if (reserva != null) {
                        gestionReserva.actualizarReserva(reserva.getId(), reserva.getUsuario(), vistaUS.captureDatoFecha("Dijite la Fecha"), vistaUS.captureDatoSTR("Nuevo tipo de reservacion"),vistaUS.captureDatoSTR("¿Ya pago la reservacion? si/no"));
                    } else {
                        vistaUS.mostrarMensaje("Reserva no encontrada.");
                    }
                    gestionReserva.guardarReservas();
                    break;
                case 6: // Eliminar reservación
                    gestionReserva.eliminarReserva(vistaUS.captureDatoInt("Dijite la id de la reservacion a eliminar"));
                    gestionReserva.guardarReservas();
                    break;
                case 7: // Ver reservaciones
                    gestionReserva.verTodasLasReservacionesCliente(usuario.getNombre());
                    break;
                case 8: // Buscar reservación
                    reserva = gestionReserva.buscarReservacionUs(vistaUS.captureDatoInt("Dijite al id de la reserva"),usuario);
                    vistaUS.mostrarReserva(reserva);
                    break;
                case 9: // Cerrar sesión
                    continuar = false;
                    break;
                default:
                    vistaUS.mostrarMensaje("Opción no válida. Por favor, intente nuevamente.");
                    break;
            }
        }
    }



}
