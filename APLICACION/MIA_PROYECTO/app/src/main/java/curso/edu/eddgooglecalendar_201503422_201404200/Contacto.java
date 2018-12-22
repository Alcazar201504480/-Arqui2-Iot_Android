package curso.edu.eddgooglecalendar_201503422_201404200;

/**
 * Created by denis on 1/01/18.
 */

public class Contacto {

    private int id;
    private int cantidad;
    private int precio;


    // Constructor de un objeto Contactos
    public Contacto(int id, int cantidad,int precio) {
        this.id = id;
        this.cantidad=cantidad;
        this.precio=precio;
    }

    // Recuperar/establecer ID
    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
