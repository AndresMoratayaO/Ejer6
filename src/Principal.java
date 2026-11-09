public class Principal {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        cargar(catalogo);
        new Controlador(catalogo, new VistaConsola(), new MotorCheckout()).iniciar();
    }

    public static void cargar(Catalogo catalogo) {
        catalogo.agregar(new PasarelaPago("P01", "Tarjeta Uno", "https://tarjeta1.example", true, 140, "Tarjeta"));
        catalogo.agregar(new PasarelaPago("P02", "Tarjeta Dos", "https://tarjeta2.example", true, 190, "Tarjeta"));
        catalogo.agregar(new PasarelaPago("P03", "Banco Uno", "https://banco.example", true, 220, "Transferencia"));
        catalogo.agregar(new PasarelaPago("P04", "Billetera Uno", "https://billetera.example", true, 85, "Billetera digital"));
        catalogo.agregar(new ProveedorLogistico("L01", "Envios Uno", "https://envios1.example", true, 160));
        catalogo.agregar(new ProveedorLogistico("L02", "Envios Dos", "https://envios2.example", false, 350));
        catalogo.agregar(new ProveedorLogistico("L03", "Ultima Milla", "https://milla.example", true, 110));
        catalogo.agregar(new CertificadorFEL("F01", "Certificador Uno", "https://fel1.example", true, 260));
        catalogo.agregar(new CertificadorFEL("F02", "Certificador Dos", "https://fel2.example", true, 180));
        catalogo.agregar(new ConsultaEstado("C01", "Rastreo Uno", "https://rastreo.example", true, 70));
    }
}
