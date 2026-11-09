import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Catalogo {
    private final List<Integracion> integraciones = new ArrayList<>();

    public void agregar(Integracion integracion) {
        if (integracion == null || buscar(integracion.getId()) != null) {
            throw new IllegalArgumentException("Integracion nula o identificador duplicado.");
        }
        integraciones.add(integracion);
    }

    public Integracion buscar(String id) {
        for (Integracion integracion : integraciones) {
            if (integracion.getId().equalsIgnoreCase(id.trim())) { return integracion; }
        }
        return null;
    }

    public Iterable<Integracion> getIntegraciones() { 
        return Collections.unmodifiableList(integraciones);
     }
    public void ordenar() { 
        Collections.sort(integraciones);
    }
}
