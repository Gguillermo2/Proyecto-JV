package View;
import  javax.swing.JOptionPane;
import java.util.concurrent.RecursiveTask;

public class VistaUS {

    public  int mostrarMenu(){
        int opcion =-1;
        while (opcion ==-1){
            try {
                String entrada = JOptionPane.showInputDialog(null,
                        "Menu de Opciones\n"+
                                "1  Registrase\n"+
                                "2: Iniciar Sesion\n"+
                                "3: Salir\n"+
                                "Ingrese Una opcion",
                            "Primer Menu", JOptionPane.QUESTION_MESSAGE);
                if (entrada != null){
                    opcion = Integer.parseInt(entrada);
                }else {
                    mostrarMensaje("Error: Ingrese una Opcion valida ");
                }
            }catch (Exception error){
                mostrarMensaje("Error:No se permiten letras elija una opcion numerica");
            }
        }
        return opcion;

    }

    public  int menuAdministrador(){
        int opcion =-1;
        while (opcion ==-1){
            try {
                String entrada = JOptionPane.showInputDialog(null,
                        "Menu de Opciones Administrador\n"+
                                "1  Ver mi Perfil\n"+
                                "2: Actualizar mi perfil\n"+
                                "3: Ver clientes\n"+
                                "4: Ver administradores\n"+
                                "5: Eliminar clientes\n"+
                                "6: cerrar sesion\n"+
                                "Ingrese Una opcion",
                        "Primer Menu", JOptionPane.QUESTION_MESSAGE);
                if (entrada != null){
                    opcion = Integer.parseInt(entrada);
                }else {
                    mostrarMensaje("Error: Ingrese una Opcion valida ");
                }
            }catch (Exception error){
                mostrarMensaje("Error:No se permiten letras elija una opcion numerica");
            }
        }
        return opcion;
    }


    public  int menuCliente(){
        int opcion =-1;
        while (opcion ==-1){
            try {
                String entrada = JOptionPane.showInputDialog(null,
                        "Menu de Opciones Cliente\n"+
                                "1  Ver mi Perfil\n"+
                                "2: Actualizar mi perfil\n"+
                                "3: Eliminar Mi cuenta\n"+
                                "4: Cerrar sesion\n"+
                                "Ingrese Una opcion",
                        "Primer Menu", JOptionPane.QUESTION_MESSAGE);
                if (entrada != null){
                    opcion = Integer.parseInt(entrada);
                }else {
                    mostrarMensaje("Error: Ingrese una Opcion valida ");
                }
            }catch (Exception error){
                mostrarMensaje("Error:No se permiten letras elija una opcion numerica");
            }
        }
        return opcion;
    }

    public String captureDatoSTR(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje, "Entrada de Datos", JOptionPane.QUESTION_MESSAGE);
    }

    public int captureDatoInt(String mensaje) {
        int dato = -1;
        while (dato == -1) {
            try {
                String input = JOptionPane.showInputDialog(null, mensaje, "Entrada de Datos", JOptionPane.QUESTION_MESSAGE);
                if (input != null) {
                    dato = Integer.parseInt(input);
                } else {
                    mostrarMensaje("Debe ingresar un número entero válido.");
                }
            } catch (Exception error) {
                mostrarMensaje("Error: ingrese un número entero válido.");
            }
        }
        return dato;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
}
