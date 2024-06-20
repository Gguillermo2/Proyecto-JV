import View.VistaUS;
import Model.GestorUsuarios;
import Controller.ControladorUS;

public class Main {
    public static void main(String[] args) {
        GestorUsuarios modelo = new GestorUsuarios();
        VistaUS vista = new VistaUS();
        ControladorUS control = new ControladorUS(modelo, vista);
        control.ejecutar();
    }
}
