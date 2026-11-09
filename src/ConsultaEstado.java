public class ConsultaEstado extends Integracion {
    public ConsultaEstado(String id, String nombre, String endpoint, boolean conectada, double latencia) {
        super(id, nombre, endpoint, conectada, latencia);
    }

    @Override
    public String consultar() {
        return isConectada() ? "Consulta simulada: servicio disponible." : "Servicio sin conexion."; 
    }
}
