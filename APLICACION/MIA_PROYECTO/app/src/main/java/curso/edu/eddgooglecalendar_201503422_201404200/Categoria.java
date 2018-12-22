package curso.edu.eddgooglecalendar_201503422_201404200;


public class Categoria {
    private int imagen;
    private String nombre;

    public Categoria(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    public int getImagen() {
        return imagen;
    }
}
