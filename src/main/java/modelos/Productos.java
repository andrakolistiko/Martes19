package modelos;

public class Productos {

    //defina las variables del producto
    private int idProducto;
    private String nombre;
    private String categoria;
    private double precio;

    //implementamos un constructor vacio
    public Productos() {

    }

    //implementamos un constructor con todos los atributos
    public Productos(int idProducto, String nombre, String categoria, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }
    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
