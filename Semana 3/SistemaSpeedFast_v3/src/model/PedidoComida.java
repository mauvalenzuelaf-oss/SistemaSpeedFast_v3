package model;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;

/**
 * Representa un pedido de comida del sistema SpeedFast.
 * Este tipo de pedido requiere un repartidor con mochila térmica
 * y calcula su tiempo de entrega según la distancia.
 */
public class PedidoComida extends Pedido
        implements Despachable, Cancelable, Rastreable {

    // Constantes propias
    private static final int TIEMPO_BASE = 15;
    private static final int MINUTOS_POR_KM = 2;

    /**
     * Construye un pedido de comida.
     *
     * @param idPedido identificador del pedido
     * @param direccionEntrega dirección donde se entregará el pedido
     * @param distanciaKm distancia de entrega expresada en kilómetros
     */
    public PedidoComida(
            int idPedido,
            String direccionEntrega,
            int distanciaKm
    ) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /**
     * Realiza la asignación automática de un repartidor
     * para un pedido de comida.
     */
    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido Comida]");
        System.out.println("Buscando repartidor con mochila térmica...");

        setRepartidorAsignado("Luis Díaz");

        System.out.println(
                "Repartidor asignado automáticamente: "
                        + getRepartidorAsignado()
        );
    }

    /**
     * Realiza la asignación manual de un repartidor
     * y verifica el requisito de mochila térmica.
     *
     * @param nombre nombre del repartidor asignado
     */
    @Override
    public void asignarRepartidor(String nombre) {
        System.out.println("[Pedido Comida]");
        System.out.println("Verificando mochila térmica... OK");

        setRepartidorAsignado(nombre);

        System.out.println("Repartidor asignado: " + nombre);
    }

    /**
     * Calcula el tiempo estimado para un pedido de comida.
     *
     * @return tiempo estimado de entrega en minutos
     */
    @Override
    public int calcularTiempoEntrega() {
        return TIEMPO_BASE
                + (MINUTOS_POR_KM * getDistanciaKm());
    }

    /**
     * Despacha el pedido de comida.
     */
    @Override
    public void despachar() {
        procesarDespacho();
    }

    /**
     * Cancela el pedido de comida.
     */
    @Override
    public void cancelar() {
        procesarCancelacion();
    }

    /**
     * Muestra el historial del pedido de comida.
     */
    @Override
    public void verHistorial() {
        mostrarHistorialEventos();
    }
}
