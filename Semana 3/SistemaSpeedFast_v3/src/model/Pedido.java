package model;

import java.util.ArrayList;

/**
 * Representa un pedido genérico del sistema SpeedFast.
 * Contiene los datos y comportamientos comunes de los distintos
 * tipos de pedidos y define la estructura para calcular
 * su tiempo estimado de entrega.
 */
public abstract class Pedido {

    // Atributos
    private int idPedido;
    private String direccionEntrega;
    private int distanciaKm;
    private String repartidorAsignado;
    private ArrayList<String> historial = new ArrayList<>();

    /**
     * Construye un pedido con sus datos principales.
     *
     * @param idPedido identificador del pedido
     * @param direccionEntrega dirección donde se entregará el pedido
     * @param distanciaKm distancia de entrega expresada en kilómetros
     */
    public Pedido(int idPedido, String direccionEntrega, int distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    /**
     * Muestra un resumen con los datos básicos del pedido.
     */
    public void mostrarResumen() {
        System.out.println(
                getClass().getSimpleName()
                        + " #" + String.format("%03d", idPedido)
        );

        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
    }

    /**
     * Realiza una asignación automática genérica de repartidor.
     * Las subclases pueden sobrescribir este comportamiento.
     */
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor automáticamente...");
    }

    /**
     * Permite asignar manualmente un repartidor mediante su nombre.
     *
     * @param nombre nombre del repartidor asignado
     */
    public void asignarRepartidor(String nombre) {
        this.repartidorAsignado = nombre;
        System.out.println("Repartidor asignado: " + nombre);
    }

    /**
     * Reserva el pedido y registra el evento en su historial.
     */
    public void reservar() {
        System.out.println(
                "Pedido #" + String.format("%03d", idPedido)
                        + " reservado correctamente."
        );

        registrarEvento(
                getClass().getSimpleName()
                        + " #" + String.format("%03d", idPedido)
                        + " - pedido reservado"
        );
    }

    /**
     * Calcula el tiempo estimado de entrega.
     * Cada tipo de pedido debe implementar su propia lógica.
     *
     * @return tiempo estimado de entrega en minutos
     */
    public abstract int calcularTiempoEntrega();

    /**
     * Registra un evento asociado al pedido.
     *
     * @param evento descripción del evento ocurrido
     */
    protected void registrarEvento(String evento) {
        historial.add(evento);
    }

    /**
     * Procesa el despacho del pedido y registra el evento
     * en su historial.
     */
    protected void procesarDespacho() {
        if (repartidorAsignado != null) {
            System.out.println("Pedido despachado correctamente.");

            registrarEvento(
                    getClass().getSimpleName()
                            + " #" + String.format("%03d", idPedido)
                            + " - entregado por "
                            + repartidorAsignado
            );
        } else {
            System.out.println(
                    "No se puede despachar el pedido: "
                            + "no tiene repartidor asignado."
            );
        }
    }

    /**
     * Procesa la cancelación del pedido
     * y registra el evento en su historial.
     */
    protected void procesarCancelacion() {
        System.out.println("Pedido cancelado exitosamente.");

        registrarEvento(
                getClass().getSimpleName()
                        + " #" + String.format("%03d", idPedido)
                        + " - pedido cancelado"
        );
    }

    /**
     * Muestra los eventos registrados en el historial del pedido.
     */
    protected void mostrarHistorialEventos() {
        if (historial.isEmpty()) {
            System.out.println("No existen eventos registrados.");
            return;
        }

        for (String evento : historial) {
            System.out.println("- " + evento);
        }
    }

    // Getters y Setters

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(int distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public String getRepartidorAsignado() {
        return repartidorAsignado;
    }

    public void setRepartidorAsignado(String repartidorAsignado) {
        this.repartidorAsignado = repartidorAsignado;
    }
}
