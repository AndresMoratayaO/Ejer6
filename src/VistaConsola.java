import java.util.Scanner;

public class VistaConsola {
    private final Scanner entrada = new Scanner(System.in);

    public void mostrar(String texto) { System.out.println(texto); }

    public String leerTexto(String mensaje) {
        mostrar(mensaje);
        return entrada.hasNextLine() ? entrada.nextLine().trim() : "0";
    }

    public int leerEntero(String mensaje) {
        while (true) {
            try { return Integer.parseInt(leerTexto(mensaje)); }
            catch (NumberFormatException e) { mostrar("Ingrese un numero entero."); }
        }
    }

    public double leerMonto() {
        while (true) {
            try {
                double monto = Double.parseDouble(leerTexto("Monto en quetzales:"));
                if (Double.isFinite(monto) && monto > 0) { return monto; }
            }
            catch (NumberFormatException e) { mostrar("Formato numerico incorrecto."); }
            if (!entrada.hasNextLine()) { return 0; }
            mostrar("Ingrese un monto positivo y finito.");
        }
    }

    public int menu() {
        return leerEntero("\n1. Listar integraciones\n2. Buscar configuracion\n3. Ordenar por latencia\n4. Cobrar\n5. Reintegrar\n6. Generar documento\n7. Consultar estado\n8. Auditar\n0. Salir");
    }
}
