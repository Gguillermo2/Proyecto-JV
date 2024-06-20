package Controller;

import Model.GestorUsuarios;
import Model.Usuario;
import View.VistaUS;

public class ControladorUS {

    private GestorUsuarios gestorUS;
    private VistaUS vistaUS;

    // Constructor que acepta los parámetros
    public ControladorUS(GestorUsuarios gestorUS, VistaUS vistaUS) {
        this.gestorUS = gestorUS;
        this.vistaUS = vistaUS;
        gestorUS.cargarUsuarios();
    }

    public void ejecutar() {
        boolean continuar = true;

        while (continuar) {
            int opcion = vistaUS.mostrarMenu();

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    gestorUS.guardarUsuarios();
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
                    actualizarUsuario(usuario.getCorreoElectronico());
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
                    break;
                case 6: // Cerrar sesión
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
                case 1:
                    vistaUS.mostrarMensaje(usuario.toString());
                    break;
                case 2:
                    actualizarUsuario(usuario.getCorreoElectronico());
                    break;
                case 3:
                    gestorUS.eliminarUsuario(usuario.getCorreoElectronico());
                    continuar = false;
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    vistaUS.mostrarMensaje("Opción no válida. Por favor, intente nuevamente.");
                    break;
            }
        }
    }



    private void actualizarUsuario(String correo) {
        String nuevoNombre = vistaUS.captureDatoSTR("Ingrese su nuevo nombre completo:");
        String nuevaContrasena = vistaUS.captureDatoSTR("Ingrese su nueva contraseña:");
        String nuevoNumeroDeCelular = vistaUS.captureDatoSTR("Ingrese su nuevo número de teléfono:");
        int nuevaEdad = vistaUS.captureDatoInt("Ingrese su nueva edad:");

        gestorUS.actualizarUsuario(correo, nuevoNombre, nuevaContrasena, nuevoNumeroDeCelular, nuevaEdad);
        gestorUS.guardarUsuarios();
    }
    private void registrarUsuario() {
        String nombre = vistaUS.captureDatoSTR("Ingrese su nombre completo:");
        String correo = vistaUS.captureDatoSTR("Ingrese su correo electrónico:");
        String contrasena = vistaUS.captureDatoSTR("Ingrese su contraseña:");
        String numeroDeCelular = vistaUS.captureDatoSTR("Ingrese su número de teléfono:");
        int edad = vistaUS.captureDatoInt("Ingrese su edad:");
        boolean esAdmin = vistaUS.captureDatoInt("Ingrese 1 si es administrador, 0 si es cliente:") == 1;

        gestorUS.creacionUsuario(nombre, correo, contrasena, numeroDeCelular, edad, esAdmin);
        gestorUS.guardarUsuarios();
    }

    private void iniciarSesion() {
        String correo = vistaUS.captureDatoSTR("Ingrese su correo electrónico:");
        String contrasena = vistaUS.captureDatoSTR("Ingrese su contraseña:");
        Usuario usuario = gestorUS.iniciarSesion(correo, contrasena);

        if (usuario != null) {
            if (usuario.isEsAdmin()) {
                manejarMenuAdministrador(usuario);
            } else {
                manejarMenuCliente(usuario);
            }
        } else {
            vistaUS.mostrarMensaje("Credenciales incorrectas. Por favor, intente nuevamente.");
        }
    }
}
