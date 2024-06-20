import Model.GestionReserva;
import View.VistaUS;
import Model.GestorUsuarios;
import Controller.ControladorUS;

public class Main {
    public static void main(String[] args) {
        GestorUsuarios modelo = new GestorUsuarios();
        VistaUS vista = new VistaUS();
        GestionReserva m2 = new GestionReserva();
        ControladorUS control = new ControladorUS(modelo, vista, m2);
        control.ejecutar();
    }
}
