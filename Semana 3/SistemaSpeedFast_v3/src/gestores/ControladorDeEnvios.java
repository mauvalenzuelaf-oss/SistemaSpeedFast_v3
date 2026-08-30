package gestores;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;
import model.Pedido;

/**
 * Controla las principales operaciones relacionadas
 * con la gestión de los pedidos de SpeedFast.
 *
 * Trabaja mediante la clase abstracta Pedido y sus interfaces,
 * evitando depender directamente de tipos concretos
 * como PedidoComida, PedidoEncomienda o PedidoExpress.
 */
public class ControladorDeEnvios {

    /**
     * Reserva un pedido.
     *
     * @param pedido pedido que será reservado
     */
    public void reservarPedido(Pedido pedido) {
        pedido.reservar();
    }

    /**
     * Despacha un objeto que implemente la interfaz Despachable.
     *
     * @param pedido pedido que será despachado
     */
    public void despacharPedido(Despachable pedido) {
        pedido.despachar();
    }

    /**
     * Cancela un objeto que implemente la interfaz Cancelable.
     *
     * @param pedido pedido que será cancelado
     */
    public void cancelarPedido(Cancelable pedido) {
        pedido.cancelar();
    }

    /**
     * Muestra el historial de un objeto que implemente
     * la interfaz Rastreable.
     *
     * @param pedido pedido cuyo historial será consultado
     */
    public void mostrarHistorial(Rastreable pedido) {
        pedido.verHistorial();
    }
}