public abstract class Documento {
        private int id;

        public Documento(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public abstract double calcularCostoTotal();
    }


