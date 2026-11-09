public class Controlador {
    private final Catalogo catalogo;
    private final VistaConsola vista;
    private final MotorCheckout motor;

    public Controlador(Catalogo catalogo, VistaConsola vista, MotorCheckout motor) {
        this.catalogo = catalogo; 
        this.vista = vista; 
        this.motor = motor;
    }

    public void iniciar() {
        int opcion;
        while ((opcion = vista.menu()) != 0) {
            if (opcion == 1 || opcion == 3) {
                if (opcion == 3) { 
                    catalogo.ordenar();
                }
                for (Integracion integracion : catalogo.getIntegraciones()) { 
                    vista.mostrar(integracion.toString());
                 }
            } else if (opcion >= 2 && opcion <= 8) {
                Integracion integracion = catalogo.buscar(vista.leerTexto("Identificador de la API:"));
                if (integracion == null) { 
                    vista.mostrar("No existe esa integracion."); continue;
                }
                if (opcion == 2) { 
                    vista.mostrar(integracion.configuracion()); continue; 
                }
                double monto = 0;
                String referencia = "";
                if ((opcion == 4 || opcion == 5) && integracion instanceof Transaccional) { 
                    monto = vista.leerMonto(); 
                }
                if (opcion == 6 && integracion instanceof Documentable) { 
                    referencia = vista.leerTexto("Referencia del pedido:"); 
                }
                vista.mostrar(motor.ejecutar(integracion, opcion, monto, referencia));
            } else { 
                vista.mostrar("Opcion invalida.");
             }
        }
        vista.mostrar("Programa finalizado.");
    }
}
