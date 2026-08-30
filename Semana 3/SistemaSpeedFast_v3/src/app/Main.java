package app;

import gestores.ControladorDeEnvios;
import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

/**
 * Clase principal del sistema SpeedFast.
 * Simula la gestión de distintos tipos de pedidos,
 * aplicando abstracción, herencia, polimorfismo e interfaces.
 */
public class Main {

    public static void main(String[] args) {

        // Creación del controlador
        ControladorDeEnvios controlador = new ControladorDeEnvios();

        // Creación de pedidos
        PedidoComida comida =
                new PedidoComida(101, "Av. Italia 456", 4);

        PedidoEncomienda encomienda =
                new PedidoEncomienda(102, "Av. Santa Rosa 567", 7);

        PedidoExpress express =
                new PedidoExpress(103, "Av. Apoquindo 1500", 7);

        // Arreglo de referencias polimórficas
        Pedido[] pedidos = {
                comida,
                encomienda,
                express
        };

        System.out.println("=== SISTEMA SPEEDFAST ===");
        System.out.println();

        // Mostrar resumen y tiempo estimado de todos los pedidos
        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();

            System.out.println(
                    "Tiempo estimado de entrega: "
                            + pedido.calcularTiempoEntrega()
                            + " minutos"
            );

            System.out.println();
        }

        // Caso 1: Pedido de comida
        System.out.println("=== CASO 1: PEDIDO COMIDA ===");

        controlador.reservarPedido(comida);

        // Asignación automática
        comida.asignarRepartidor();

        controlador.despacharPedido(comida);

        System.out.println();

        // Caso 2: Pedido de encomienda
        System.out.println("=== CASO 2: PEDIDO ENCOMIENDA ===");

        controlador.reservarPedido(encomienda);

        // Asignación manual
        encomienda.asignarRepartidor("Daniela Tapia");

        controlador.despacharPedido(encomienda);

        System.out.println();

        // Caso 3: Pedido express
        System.out.println("=== CASO 3: PEDIDO EXPRESS ===");

        controlador.reservarPedido(express);

        // Segunda prueba de asignación automática
        express.asignarRepartidor();

        controlador.cancelarPedido(express);

        System.out.println();

        // Historial de los pedidos
        System.out.println("=== HISTORIAL DE PEDIDOS ===");

        System.out.println("Pedido Comida:");
        controlador.mostrarHistorial(comida);

        System.out.println();

        System.out.println("Pedido Encomienda:");
        controlador.mostrarHistorial(encomienda);

        System.out.println();

        System.out.println("Pedido Express:");
        controlador.mostrarHistorial(express);

        System.out.println();

        // Prueba sugerida en la retroalimentación anterior
        System.out.println("=== PRUEBA DE LÍMITE PEDIDO EXPRESS ===");

        PedidoExpress expressLimite =
                new PedidoExpress(104, "Av. Las Condes 500", 5);

        PedidoExpress expressSuperior =
                new PedidoExpress(105, "Av. Las Condes 600", 6);

        System.out.println(
                "Distancia 5 km: "
                        + expressLimite.calcularTiempoEntrega()
                        + " minutos"
        );

        System.out.println(
                "Distancia 6 km: "
                        + expressSuperior.calcularTiempoEntrega()
                        + " minutos"
        );
    }
}