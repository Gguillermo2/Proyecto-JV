package Model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GestorUsuarios {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private HashMap<String, Usuario> clientes = new HashMap<>();
    private HashMap<String, Usuario> administradores = new HashMap<>();

    public GestorUsuarios() {
        administradores.put("andresv@gmail.com", new Usuario("Guillermo Avila", "guille13@gmail.com", "3123529714", "6969", 19, "Andres5025", true));
        clientes.put("guille@gmail.com", new Usuario("guillermo avila", "guille@gmail.com", "321456987", "12345", 18, "guille29", false));
    }

    public void creacionUsuario(String nombre, String correo, String contrasena, String numeroDeCelular, int edad, boolean esAdmin) {
        if (administradores.containsKey(correo) || clientes.containsKey(correo)) {
            System.out.println("Este correo electrónico ya está registrado.");
            return;
        }

        Usuario nuevoUsuario = new Usuario(nombre, correo, numeroDeCelular, contrasena, edad, nombre, esAdmin);
        if (esAdmin) {
            administradores.put(correo, nuevoUsuario);
        } else {
            clientes.put(correo, nuevoUsuario);
        }

        System.out.println("Usuario registrado exitosamente.");
    }

    public Usuario iniciarSesion(String correo, String contrasena) {
        Usuario usuario = administradores.get(correo);
        if (usuario == null) {
            usuario = clientes.get(correo);
        }
        if (usuario != null && usuario.getContraseña().equals(contrasena)) {
            return usuario;
        }
        return null;
    }

    public void actualizarUsuario(String correo, String nombre, String contrasena, String numeroDeCelular, int edad) {
        Usuario usuario = administradores.get(correo);
        if (usuario == null) {
            usuario = clientes.get(correo);
        }

        if (usuario != null) {
            usuario.setNombreCompleto(nombre);
            usuario.setContraseña(contrasena);
            usuario.setNumeroDeTelefono(numeroDeCelular);
            usuario.setEdad(edad);
            System.out.println("Usuario actualizado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void eliminarUsuario(String correo) {
        if (administradores.remove(correo) != null || clientes.remove(correo) != null) {
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void mostrarClientes() {
        for (Usuario cliente : clientes.values()) {
            System.out.println(cliente);
        }
    }

    public void mostrarAdministradores() {
        for (Usuario admin : administradores.values()) {
            System.out.println(admin);
        }
    }

    public void guardarUsuarios() {
        try (FileWriter writer = new FileWriter("usuarios.json")) {
            HashMap<String, HashMap<String, Usuario>> allUsers = new HashMap<>();
            allUsers.put("clientes", clientes);
            allUsers.put("administradores", administradores);
            gson.toJson(allUsers, writer);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public void cargarUsuarios() {
        File file = new File("usuarios.json");
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Type type = new TypeToken<HashMap<String, HashMap<String, Usuario>>>() {}.getType();
                HashMap<String, HashMap<String, Usuario>> allUsers = gson.fromJson(reader, type);
                clientes = allUsers.get("clientes");
                administradores = allUsers.get("administradores");
            } catch (IOException error) {
                error.printStackTrace();
            }
        } else {
            System.out.println("Archivo usuarios.json no encontrado, inicializando datos por defecto.");
        }
    }
}
