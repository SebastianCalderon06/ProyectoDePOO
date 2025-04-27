public class Producto implements Calculable {

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

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Precio Unitario: " + precioUnitario + "\n" +
                "Cantidad: " + cantidad + "\n";
    }
}
