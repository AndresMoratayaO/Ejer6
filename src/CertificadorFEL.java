public class CertificadorFEL extends Integracion implements Documentable {
    public CertificadorFEL(String id, String nombre, String endpoint, boolean conectada, double latencia) {
        super(id, nombre, endpoint, conectada, latencia);
    }

    @Override
    public String consultar() { 
        return isConectada() ? "Certificador disponible (simulacion)." : "Certificador sin conexion.";
     }

    @Override
    public String generarDocumento(String referencia) {
        if (!isConectada()) { return "Factura no generada: sin conexion."; }
        return "<FacturaSimulada><Referencia>" + ProveedorLogistico.escaparXml(referencia) + "</Referencia></FacturaSimulada>";
    }
}
