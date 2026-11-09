public class PasarelaPago extends Integracion implements Transaccional {
    private final String metodo;

    public PasarelaPago(String id, String nombre, String endpoint, boolean conectada, double latencia, String metodo) {
        super(id, nombre, endpoint, conectada, latencia); this.metodo = metodo;
    }

    public String getMetodo() { return metodo; }

    @Override
    public String configuracion() { return super.configuracion() + " | Metodo: " + metodo; }

    @Override
    public String consultar() { return isConectada() ? "Pasarela disponible: " + metodo : "Pasarela sin conexion."; }

    @Override
    public String cobrar(double monto) {
        if (!isConectada()) { return "Cobro no realizado: sin conexion."; }
        if (!Double.isFinite(monto) || monto <= 0) { return "Monto invalido."; }
        return "Cobro simulado de Q" + monto + " mediante " + getNombre();
    }

    @Override
    public String reintegrar(double monto) {
        if (!isConectada()) { return "Reintegro no realizado: sin conexion."; }
        if (!Double.isFinite(monto) || monto <= 0) { return "Monto invalido."; }
        return "Reintegro simulado de Q" + monto + " mediante " + getNombre();
    }
}
