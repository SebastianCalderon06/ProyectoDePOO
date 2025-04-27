import java.util.ArrayList;
import java.util.List;
public class GestorProveedor {
    private List<Proveedor> proveedores = new ArrayList<>();

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public void agregarProveedor(Proveedor proveedor) {

        proveedores.add(proveedor);
    }

    public void listarProveedores() {
        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedor);
        }
    }
    // cambiamos para que el metodo muestre un mensaje en caso de no encontrar lo que buscamos

    public String buscarProveedorPorId(int id) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId() == id) {
                return "Proveedor " +proveedor;
            }
        }
        return "El proveedor no encuentra o no existe";
    }
}

