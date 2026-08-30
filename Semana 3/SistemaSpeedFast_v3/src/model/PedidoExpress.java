package model;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;

/**
 * Representa un pedido express del sistema SpeedFast.
 * Este tipo de pedido prioriza repartidores cercanos
 * y con disponibilidad inmediata.
 */
public class PedidoExpress extends Pedido
        implements Despachable, Cancelable, Rastreable {

    // Constantes propias
    private static final int TIEMPO_BASE = 10;
    private static final int LIMITE_DISTANCIA = 5;
    private static final int TIEMPO_EXTRA = 5;

    /**
     * Construye un pedido express.
     *
     * @param idPedido identificador del pedido
     * @param direccionEntrega dirección donde se entregará el pedido
     * @param distanciaKm distancia de entrega expresada en kilómetros
     */
    public PedidoExpress(
            int idPedido,
            String direccionEntrega,
            int distanciaKm
    ) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /**
     * Realiza la asignación automática buscando un repartidor
     * cercano y disponible inmediatamente.
     */
    @Override
    public void asignarRepartidor() {
        System.out.println("[Pedido Express]");
        System.out.println(
                "Buscando repartidor cercano "
                        + "con disponibilidad inmediata..."
        );

        setRepartidorAsignado("Camila Soto");

        System.out.println(
                "Repartidor asignado automáticamente: "
                        + getRepartidorAsignado()
        );
    }

    /**
     * Realiza la asignación manual de un repartidor
     * verificando cercanía y disponibilidad.
     *
     * @param nombre nombre del repartidor asignado
     */
    @Override
    public void asignarRepartidor(String nombre) {
        System.out.println("[Pedido Express]");
        System.out.println(
                "Verificando cercanía y disponibilidad inmediata... OK"
        );

        setRepartidorAsignado(nombre);

        System.out.println("Repartidor asignado: " + nombre);
    }

    /**
     * Calcula el tiempo estimado para un pedido express.
     * Si la distancia supera los 5 kilómetros,
     * agrega 5 minutos al tiempo base.
     *
     * @return tiempo estimado de entrega en minutos
     */
    @Override
    public int calcularTiempoEntrega() {
        if (getDistanciaKm() > LIMITE_DISTANCIA) {
            return TIEMPO_BASE + TIEMPO_EXTRA;
        }

        return TIEMPO_BASE;
    }

    /**
     * Despacha el pedido express.
     */
    @Override
    public void despachar() {
        procesarDespacho();
    }

    /**
     * Cancela el pedido express.
     */
    @Override
    public void cancelar() {
        procesarCancelacion();
    }

    /**
     * Muestra el historial del pedido express.
     */
    @Override
    public void verHistorial() {
        mostrarHistorialEventos();
    }
}
