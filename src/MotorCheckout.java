public class MotorCheckout {
    public String procesar(Transaccional servicio, double monto, boolean reintegro) {
        return reintegro ? servicio.reintegrar(monto) : servicio.cobrar(monto);
    }

    public String procesar(Documentable servicio, String referencia) { return servicio.generarDocumento(referencia); }
    public String procesar(Auditable servicio) { return servicio.auditar(); }

    public String ejecutar(Integracion servicio, int operacion, double monto, String referencia) {
        if (operacion == 4 || operacion == 5) {
            if (servicio instanceof Transaccional) { return procesar((Transaccional) servicio, monto, operacion == 5); }
            return "Peticion ignorada: la integracion no admite operaciones financieras.";
        }
        if (operacion == 6) {
            if (servicio instanceof Documentable) { return procesar((Documentable) servicio, referencia); }
            return "Peticion ignorada: la integracion no genera documentos.";
        }
        if (operacion == 7) { return servicio.consultar(); }
        if (operacion == 8) { return procesar((Auditable) servicio); }
        return "Operacion no reconocida.";
    }
}
