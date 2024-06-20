package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class GestionReserva {

    private Gson gson;
    private HashMap<Integer, Reserva> reservas;
    private int nextId;

    public GestionReserva() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        reservas = new HashMap<>();
        nextId = 1;
    }

    public void creacionReserva(Usuario usuario, Date fecha, String detalle, boolean pagada) {
        Reserva nuevaReserva = new Reserva(nextId, usuario, fecha, detalle, pagada);
        reservas.put(nextId, nuevaReserva);
        nextId++;
    }

    public Reserva buscarReservacion(int id) {
        return reservas.get(id);
    }


    public Reserva buscarReservacionUs(int id, Usuario usuario) {
        Reserva reserva = reservas.get(id);
        if (reserva != null && reserva.getUsuario().equals(usuario)) {
            return reserva;
        }
        return null;
    }


    public void actualizarReserva(int id, Usuario usuario, Date fecha, String detalle, String pagada) {
        Reserva reserva = reservas.get(id);
        if (reserva != null) {
            reserva.setUsuario(usuario);
            reserva.setFecha(fecha);
            reserva.setDetalle(detalle);
            if (pagada.toLowerCase().equals("si")){
                reserva.setPagada(true);
            }else {
                reserva.setPagada(false);
            }
        }
    }

    public void eliminarReserva(int id) {
        reservas.remove(id);
    }

    public void verTodasLasReservaciones() {
        for (Reserva reserva : reservas.values()) {
            System.out.println(reserva);
        }
    }

    public void verTodasLasReservacionesCliente(String nombreDeUsuario) {
        for (Reserva reserva : reservas.values()) {
            if (reserva.getUsuario().getNombre().equals(nombreDeUsuario)) {
                System.out.println(reserva);
            }
        }
    }

    public void guardarReservas() {
        try (FileWriter writer = new FileWriter("reservas.json")) {
            gson.toJson(reservas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarReservas() {
        File file = new File("reservas.json");
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Type type = new TypeToken<HashMap<Integer, Reserva>>() {}.getType();
                reservas = gson.fromJson(reader, type);
                nextId = reservas.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Archivo reservas.json no encontrado, inicializando datos por defecto.");
        }
    }
}
