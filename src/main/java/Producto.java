public class Producto implements Calcular {

    private int id;
    private String nombre;
    private double precioUnitario;
    private int cantidad;

    public Producto(int id, String nombre, double precioUnitario, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    @Override
    public double calcularCostoTotal() {
        return precioUnitario * cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precioUnitario=" + precioUnitario + ", cantidad=" + cantidad +
        "}";

    }
}

