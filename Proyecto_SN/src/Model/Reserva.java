package Model;

import java.util.Date;

public class Reserva {

    private int id;
    private Usuario usuario;
    private Date fecha;
    private String detalle;
    private boolean pagada;

    public Reserva(int id, Usuario usuario, Date fecha, String detalle, boolean pagada) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.detalle = detalle;
        this.pagada = pagada;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", fecha=" + fecha +
                ", detalle='" + detalle + '\'' +
                ", pagada=" + pagada +
                '}';
    }
}
