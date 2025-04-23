import java.util.Objects;

public class Proveedor {

        private int id;
        private String nombre;
        private String direccion;

        public Proveedor(int id, String nombre, String direccion) {
            this.id = id;
            this.nombre = nombre;
            this.direccion = direccion;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getDireccion() {
            return direccion;
        }

        @Override
        public String toString() {
            return "Proveedor{id=" + id + ", nombre='" + nombre + "', direccion='" + direccion + "'}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Proveedor proveedor = (Proveedor) o;
            return id == proveedor.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

}
