![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🧠 Semana 3 - Actividad Sumativa - Desarrollo Orientado a Objetos II

## 👤 Autor del proyecto

* **Nombre completo:** Mauricio Francisco Valenzuela Fuentes
* **Carrera:** Analista Programador Computacional
* **Sede:** Online

---

## 📘 Descripción general del sistema

Este proyecto corresponde a la **Actividad Sumativa de la Semana 3** de la asignatura **Desarrollo Orientado a Objetos II**.

Se trata de la tercera etapa de **SistemaSpeedFast**, una aplicación desarrollada en Java que representa la gestión de distintos tipos de pedidos para la empresa SpeedFast, dedicada al reparto a domicilio.

En esta versión se integran los conceptos desarrollados durante las semanas anteriores, incorporando:

* Herencia.
* Clases abstractas.
* Polimorfismo.
* Sobrescritura de métodos.
* Sobrecarga de métodos.
* Interfaces.
* Encapsulamiento.
* Reutilización de código.
* Desacoplamiento de responsabilidades.

El sistema permite gestionar tres tipos de pedidos:

* **Pedido de comida:** considera un tiempo base de 15 minutos más 2 minutos por cada kilómetro de distancia.
* **Pedido de encomienda:** considera un tiempo base de 20 minutos más 1,5 minutos por cada kilómetro, ajustando el resultado a un valor entero mediante redondeo.
* **Pedido express:** considera un tiempo base de 10 minutos y agrega 5 minutos adicionales cuando la distancia supera los 5 kilómetros.

Además, el sistema permite realizar operaciones como:

* Reservar pedidos.
* Asignar repartidores de forma automática.
* Asignar repartidores de forma manual.
* Calcular tiempos estimados de entrega.
* Despachar pedidos.
* Cancelar pedidos.
* Consultar el historial de cada pedido.

---

## 🧱 Estructura general del proyecto

```text
📁 SistemaSpeedFast_v3/
│
├── 📁 src/
│   ├── 📁 app/
│   │   └── Main.java
│   │
│   ├── 📁 gestores/
│   │   └── ControladorDeEnvios.java
│   │
│   ├── 📁 interfaces/
│   │   ├── Cancelable.java
│   │   ├── Despachable.java
│   │   └── Rastreable.java
│   │
│   └── 📁 model/
│       ├── Pedido.java
│       ├── PedidoComida.java
│       ├── PedidoEncomienda.java
│       └── PedidoExpress.java
│
├── 📁 docs/
│   └── diagrama_clases_speedfast.png
│
├── 📄 .gitignore
├── 📄 SistemaSpeedFast_v3.iml
└── 📄 README.md
```

---

## 🧩 Organización por paquetes

El proyecto se encuentra organizado en cuatro paquetes principales:

### 1. `app`

Contiene la clase encargada de iniciar y ejecutar el programa.

#### `Main.java`

Instancia los distintos tipos de pedidos y utiliza referencias del tipo base `Pedido` para demostrar el uso de polimorfismo.

También simula distintos casos de funcionamiento del sistema, incluyendo:

* Reserva de pedidos.
* Asignación automática y manual de repartidores.
* Cálculo del tiempo estimado.
* Despacho.
* Cancelación.
* Consulta de historiales.
* Prueba del límite de distancia para pedidos express.

---

### 2. `model`

Contiene las clases que representan la jerarquía de pedidos.

#### `Pedido.java`

Clase abstracta base que concentra los atributos y comportamientos comunes:

* `idPedido`
* `direccionEntrega`
* `distanciaKm`
* `repartidorAsignado`
* `historial`

Contiene métodos comunes como:

* `mostrarResumen()`
* `asignarRepartidor()`
* `asignarRepartidor(String nombre)`
* `reservar()`

Además, declara el método abstracto:

```java
calcularTiempoEntrega()
```

Cada subclase implementa este método según sus propias reglas de negocio.

#### `PedidoComida.java`

Representa los pedidos de comida.

Su tiempo estimado se calcula considerando:

```text
15 minutos + 2 minutos por kilómetro.
```

También especializa la asignación de repartidores para este tipo de pedido.

#### `PedidoEncomienda.java`

Representa los pedidos de encomienda.

Su tiempo estimado se calcula considerando:

```text
20 minutos + 1,5 minutos por kilómetro.
```

El resultado se ajusta a un número entero mediante redondeo.

También incorpora una lógica específica para la asignación del repartidor.

#### `PedidoExpress.java`

Representa los pedidos express.

Considera un tiempo base de:

```text
10 minutos.
```

Cuando la distancia supera los 5 kilómetros, se agregan 5 minutos adicionales.

También prioriza la asignación de un repartidor cercano y con disponibilidad inmediata.

---

### 3. `interfaces`

Contiene las interfaces utilizadas para separar responsabilidades específicas del sistema.

#### `Despachable.java`

Define el método:

```java
despachar()
```

#### `Cancelable.java`

Define el método:

```java
cancelar()
```

#### `Rastreable.java`

Define el método:

```java
verHistorial()
```

Las clases concretas de pedido implementan estas interfaces, permitiendo tratar las distintas operaciones de manera desacoplada.

---

### 4. `gestores`

Contiene la clase encargada de coordinar las operaciones sobre los pedidos.

#### `ControladorDeEnvios.java`

Permite gestionar operaciones de reserva, despacho, cancelación y consulta de historial.

El controlador utiliza referencias de los tipos `Despachable`, `Cancelable` y `Rastreable`, evitando depender directamente de una clase concreta de pedido.

---

## 📐 Diagrama de clases

El siguiente diagrama representa la estructura principal del sistema y las relaciones existentes entre la clase abstracta `Pedido`, sus subclases, las interfaces y el controlador de envíos.

![Diagrama de clases SpeedFast](docs/diagrama_clases_speedfast.png)

---

## ♻️ Escalabilidad, reutilización y mantenibilidad

### Escalabilidad

La estructura permite incorporar nuevos tipos de pedidos sin modificar la clase base ni alterar el funcionamiento de los tipos existentes.

Una nueva clase puede heredar de `Pedido`, implementar su propia lógica para `calcularTiempoEntrega()` y utilizar las interfaces que correspondan.

### Reutilización

La clase abstracta `Pedido` concentra atributos y comportamientos comunes, evitando repetirlos en `PedidoComida`, `PedidoEncomienda` y `PedidoExpress`.

Cada subclase reutiliza esta estructura y solamente implementa o sobrescribe los comportamientos que necesita especializar.

### Mantenibilidad

Las interfaces `Despachable`, `Cancelable` y `Rastreable` separan distintas responsabilidades del sistema.

Además, `ControladorDeEnvios` trabaja mediante estas interfaces, reduciendo la dependencia respecto de las clases concretas y facilitando futuras modificaciones.

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/mauvalenzuelaf-oss/SistemaSpeedFast_v3.git
```

2. Abre **IntelliJ IDEA**.

3. Selecciona la opción `Open`.

4. Dentro del repositorio clonado, busca la siguiente carpeta:

```text
semana 3/SistemaSpeedFast_v3
```

5. Selecciona `SistemaSpeedFast_v3` como proyecto.

6. Verifica que el código fuente se encuentre dentro de la carpeta `src`.

7. Confirma que dentro de `src` se encuentren los paquetes:

```text
app
gestores
interfaces
model
```

8. Abre la clase principal:

```text
src/app/Main.java
```

9. Ejecuta el método `main()`.

---

## 🖥️ Ejemplo de funcionamiento

```text
=== SISTEMA SPEEDFAST ===

PedidoComida #101
Dirección: Av. Italia 456
Distancia: 4 km
Tiempo estimado de entrega: 23 minutos

PedidoEncomienda #102
Dirección: Av. Santa Rosa 567
Distancia: 7 km
Tiempo estimado de entrega: 31 minutos

PedidoExpress #103
Dirección: Av. Apoquindo 1500
Distancia: 7 km
Tiempo estimado de entrega: 15 minutos

=== CASO 1: PEDIDO COMIDA ===
Pedido #101 reservado correctamente.
[Pedido Comida]
Buscando repartidor con mochila térmica...
Repartidor asignado automáticamente: Luis Díaz
Pedido despachado correctamente.

=== CASO 2: PEDIDO ENCOMIENDA ===
Pedido #102 reservado correctamente.
[Pedido Encomienda]
Validando peso y embalaje... OK
Repartidor asignado: Daniela Tapia
Pedido despachado correctamente.

=== CASO 3: PEDIDO EXPRESS ===
Pedido #103 reservado correctamente.
[Pedido Express]
Buscando repartidor cercano con disponibilidad inmediata...
Repartidor asignado automáticamente: Camila Soto
Pedido cancelado exitosamente.

=== HISTORIAL DE PEDIDOS ===

Pedido Comida:
- PedidoComida #101 - pedido reservado
- PedidoComida #101 - entregado por Luis Díaz

Pedido Encomienda:
- PedidoEncomienda #102 - pedido reservado
- PedidoEncomienda #102 - entregado por Daniela Tapia

Pedido Express:
- PedidoExpress #103 - pedido reservado
- PedidoExpress #103 - pedido cancelado

=== PRUEBA DE LÍMITE PEDIDO EXPRESS ===
Distancia 5 km: 10 minutos
Distancia 6 km: 15 minutos
```

---

**Repositorio GitHub:** https://github.com/mauvalenzuelaf-oss/SistemaSpeedFast_v3

**Fecha de entrega:** 31/08/2026
