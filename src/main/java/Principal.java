import java.util.Scanner;

public class Principal {
    Scanner scanner = new Scanner(System.in);
    GestorProducto gestorProducto = new GestorProducto();
    GestorProveedor gestorProveedor = new GestorProveedor();
    GestorSolicitud gestorSolicitud = new GestorSolicitud();

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.iniciar();
    }

    public void iniciar() {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarProveedor();
                    break;
                case 2:
                    registrarSolicitudCompra();
                    break;
                case 3:
                    listarProveedores();
                    break;
                case 4:
                    listarProductos();
                    break;
                case 5:
                    listarSolicitudesCompra();
                    break;
                case 6:
                    buscarProveedorPorId();
                    break;
                case 7:
                    buscarProductoPorNombre();
                    break;
                case 8:
                    buscarSolicitudPorNumero();
                    break;
                case 9:
                    aprobarRechazarSolicitud();
                    break;
                case 10:
                    calcularTotalSolicitud();
                    break;
                case 11:
                    System.out.println("Nos vemos :)");
                    return;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }
    }

    void mostrarMenu() {
        System.out.println("===== SISTEMA DE GESTIÓN DE COMPRAS ERP =====");
        System.out.println("1. Registrar proveedor");
        System.out.println("2. Registrar solicitud de compra");
        System.out.println("3. Listar proveedores");
        System.out.println("4. Listar productos");
        System.out.println("5. Listar solicitudes de compra");
        System.out.println("6. Buscar proveedor por ID");
        System.out.println("7. Buscar producto por nombre");
        System.out.println("8. Buscar solicitud por número");
        System.out.println("9. Aprobar / Rechazar / En revisión solicitud de compra");
        System.out.println("10. Calcular total de una solicitud");
        System.out.println("11. Salir");
        System.out.print("Seleccione una opción: ");
    }

    void registrarProveedor() {
        System.out.print("Ingrese el ID del proveedor: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (gestorProveedor.buscarProveedorPorId(id) != null) {
            System.out.println("Ya existe un proveedor con ese ID.");
            return;
        }
        System.out.print("Ingrese el nombre del proveedor: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la dirección del proveedor: ");
        String direccion = scanner.nextLine();

        Proveedor proveedor = new Proveedor(id, nombre, direccion);

        while (true) {
            System.out.print("¿Desea agregar un producto a este proveedor? (sí/no): ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("no")) {
                break;
            }

            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine();

            System.out.print("Ingrese el precio unitario: ");
            double precioUnitario = scanner.nextDouble();

            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            Producto producto = new Producto(id, nombreProducto, precioUnitario, cantidad);
            proveedor.agregarProducto(producto);

            gestorProducto.agregarProducto(producto);
            System.out.println("Producto agregado al proveedor.");
        }
        gestorProveedor.agregarProveedor(proveedor);
        System.out.println("Proveedor registrado.");
    }

    void registrarSolicitudCompra() {
        System.out.print("Ingrese el ID de la solicitud: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (gestorSolicitud.buscarSolicitudPorId(id) != null) {
            System.out.println("Ya existe una solicitud con ese ID.");
            return;
        }

        System.out.print("Ingrese el estado de la solicitud (SOLICITADA, EN_REVISION, APROBADA, RECHAZADA): ");
        String estadoString = scanner.nextLine();
        EstadoSolicitud estado = EstadoSolicitud.valueOf(estadoString.toUpperCase());

        SolicitudCompra solicitudCompra = new SolicitudCompra(id, estado);

        while (true) {
            System.out.print("¿Desea agregar un producto a la solicitud? (sí/no): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                break;
            }

            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            Producto producto = gestorProducto.buscarProductoPorNombre(nombreProducto);

            if (producto != null) {
                System.out.print("Ingrese la cantidad deseada: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();

                if (producto.getCantidad() < cantidad) {
                    System.out.println("No hay suficiente cantidad de este producto.");
                } else {
                    Producto productoSolicitud = new Producto(producto.getId(), producto.getNombre(), producto.getPrecioUnitario(), cantidad);
                    solicitudCompra.agregarProducto(productoSolicitud);
                    System.out.println("Producto agregado a la solicitud.");
                }
            } else {
                System.out.println("Producto no encontrado.");
            }
        }

        gestorSolicitud.agregarSolicitud(solicitudCompra);
        System.out.println("Solicitud de compra registrada.");
    }

     public void listarProveedores() {
        gestorProveedor.listarProveedores();
    }

     public void listarProductos() {
        gestorProducto.listarProductos();
    }

    public void listarSolicitudesCompra() {
        gestorSolicitud.listarSolicitudes();
    }

    public void buscarProveedorPorId() {
        System.out.print("Ingrese el ID del proveedor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Proveedor proveedor = gestorProveedor.buscarProveedorPorId(id);

        if (proveedor == null) {
            System.out.println("Proveedor no encontrado.");
        } else {
            System.out.println(proveedor);
        }
    }

    public void buscarProductoPorNombre() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        Producto producto = gestorProducto.buscarProductoPorNombre(nombre);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
        } else {
            System.out.println(producto);
        }
    }

    public void buscarSolicitudPorNumero() {
        System.out.print("Ingrese el ID de la solicitud: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        SolicitudCompra solicitud = gestorSolicitud.buscarSolicitudPorId(id);

        if (solicitud == null) {
            System.out.println("Solicitud no encontrada.");
        } else {
            System.out.println(solicitud);
        }
    }

    public void aprobarRechazarSolicitud() {
        System.out.print("Ingrese el ID de la solicitud: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        SolicitudCompra solicitud = gestorSolicitud.buscarSolicitudPorId(id);

        if (solicitud == null) {
            System.out.println("Solicitud no encontrada.");
            return;
        }

        System.out.print("¿Desea aprobar, rechazar o poner en revisión la solicitud? (aprobar/rechazar/en_revision): ");
        String accion = scanner.nextLine();

        switch (accion.toLowerCase()) {
            case "aprobar":
                solicitud.aprobar();
                break;
            case "rechazar":
                solicitud.rechazar();
                break;
            case "en_revision":
                solicitud.enRevision();
                break;
            default:
                System.out.println("Acción no válida.");
        }

        System.out.println("Estado de la solicitud actualizado.");
    }

    public void calcularTotalSolicitud() {
        System.out.print("Ingrese el ID de la solicitud: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        SolicitudCompra solicitud = gestorSolicitud.buscarSolicitudPorId(id);

        if (solicitud == null) {
            System.out.println("Solicitud no encontrada.");
            return;
        }

        System.out.println("Total de la solicitud: " + solicitud.calcularCostoSolicitud());
    }
}
