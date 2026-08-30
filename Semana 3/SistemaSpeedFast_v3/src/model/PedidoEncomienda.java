package model;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;

/**
 * Representa un pedido de encomienda del sistema SpeedFast.
 * Este tipo de pedido requiere validar peso y embalaje
 * antes de asignar un repartidor.
 */
public class PedidoEncomienda extends Pedido
        implements Despachable, Cancelable, Rastreable {

    // Constantes propias
    private static final int TIEMPO_BASE = 20;
    private static final double MINUTOS_POR_KM = 1.5;

    /**
     * Construye un pedido de encomienda.
     *
     * @param idPedido identificador del pedido
     * @param direccionEntrega dirección donde se entregará el pedido
     * @param distanciaKm distancia de entrega expresada en kilómetros
     */
    public PedidoEncomienda(
            int idPedido,
            String direccionEntrega,
            int distanciaKm
    ) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /**
     * Realiza la asignación automática de un repartidor
     * para un pedido de encomienda.
     */
    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido Encomienda]");
        System.out.println("Validando peso y embalaje... OK");

        setRepartidorAsignado("Daniela Tapia");

        System.out.println(
                "Repartidor asignado automáticamente: "
                        + getRepartidorAsignado()
        );
    }

    /**
     * Realiza la asignación manual de un repartidor
     * después de validar peso y embalaje.
     *
     * @param nombre nombre del repartidor asignado
     */
    @Override
    public void asignarRepartidor(String nombre) {
        System.out.println("[Pedido Encomienda]");
        System.out.println("Validando peso y embalaje... OK");

        setRepartidorAsignado(nombre);

        System.out.println("Repartidor asignado: " + nombre);
    }

    /**
     * Calcula el tiempo estimado para una encomienda
     * y ajusta el resultado a un número entero.
     *
     * @return tiempo estimado de entrega en minutos
     */
    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(
                TIEMPO_BASE
                        + (MINUTOS_POR_KM * getDistanciaKm())
        );
    }

    /**
     * Despacha el pedido de encomienda.
     */
    @Override
    public void despachar() {
        procesarDespacho();
    }

    /**
     * Cancela el pedido de encomienda.
     */
    @Override
    public void cancelar() {
        procesarCancelacion();
    }

    /**
     * Muestra el historial del pedido de encomienda.
     */
    @Override
    public void verHistorial() {
        mostrarHistorialEventos();
    }
}