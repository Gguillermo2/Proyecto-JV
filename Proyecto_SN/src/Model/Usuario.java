package Model;

public class Usuario {
    //Atributos
    private String nombreCompleto;
    private String correoElectronico;
    private String numeroDeTelefono;
    private String contraseña;
    private int edad;
    private String nombreDeUsuario;
    private boolean esAdmin;

    // Constructor
    public  Usuario(String nombreCompleto, String correoElectronico, String numeroDeTelefono,  String contraseña, int edad , String nombreDeUsuario, boolean esAdmin){
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.numeroDeTelefono = numeroDeTelefono;
        this.contraseña = contraseña;
        this.edad = edad;
        this.nombreDeUsuario = nombreDeUsuario;
        this.esAdmin = esAdmin;
    }

    // Metodos get y set

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }
    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }
    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }
    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "esAdmin=" + esAdmin +
                ", nombreDeUsuario='" + nombreDeUsuario + '\'' +
                ", edad=" + edad +
                ", numeroDeTelefono='" + numeroDeTelefono + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '}';
    }


}
