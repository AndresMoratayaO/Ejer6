public class ProveedorLogistico extends Integracion implements Documentable {
    public ProveedorLogistico(String id, String nombre, String endpoint, boolean conectada, double latencia) {
        super(id, nombre, endpoint, conectada, latencia);
    }

    @Override
    public String consultar() { 
        return isConectada() ? "Estado simulado: paquete en transito." : "Proveedor sin conexion.";
     }

    @Override
    public String generarDocumento(String referencia) {
        if (!isConectada()) { return "Guia no generada: sin conexion."; }
        return "<Guia><Referencia>" + escaparXml(referencia) + "</Referencia></Guia>";
    }

    public static String escaparXml(String texto) {
        return texto.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&apos;");
    }
}
