public abstract class Integracion implements Comparable<Integracion>, Auditable {
    private final String id;
    private final String nombre;
    private final String endpoint;
    private boolean conectada;
    private double latencia;

    public Integracion(String id, String nombre, String endpoint, boolean conectada, double latencia) {
        this.id = id; this.nombre = nombre; 
        this.endpoint = endpoint; 
        this.conectada = conectada; setLatencia(latencia);
    }

    public String getId() { 
        return id; 
    }
    public String getNombre() { 
        return nombre;
     }
    public String getEndpoint() { 
        return endpoint;
     }
    public boolean isConectada() { 
        return conectada;
     }
    public double getLatencia() { 
        return latencia;
     }
    public void setConectada(boolean conectada) { 
        this.conectada = conectada;
     }

    public void setLatencia(double latencia) {
        if (!Double.isFinite(latencia) || latencia < 0) {
            throw new IllegalArgumentException("Latencia invalida.");
        }
        this.latencia = latencia;
    }

    public abstract String consultar();

    public String configuracion() {
        return toString() + " | Endpoint: " + endpoint + " | Tipo: " + getClass().getSimpleName();
    }

    @Override
    public String auditar() { 
        return "Auditoria: " + configuracion(); 
    }

    @Override
    public int compareTo(Integracion otra) { 
        return Double.compare(latencia, otra.latencia); 
    }

    @Override
    public String toString() { 
        return id + " | " + nombre + " | " + (conectada ? "Conectada" : "Desconectada") + " | " + latencia + " ms"; 
    }
}
