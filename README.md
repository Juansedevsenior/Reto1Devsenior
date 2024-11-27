# Simulador de Viaje Interplanetario

Este es un simulador de viaje interplanetario donde el usuario puede elegir un planeta de destino y una nave espacial. Durante el viaje, los recursos como el combustible y el oxígeno se agotan, y el usuario debe interactuar con el programa para resolver eventos aleatorios que pueden afectar el viaje.

## Requisitos

- **Java 8 o superior**.
- **Consola o terminal** para ejecutar el programa.

## Instalación

1. Clona el repositorio o descarga el código fuente.

   ```bash
   git clone <URL>
Abre el proyecto en tu editor de código favorito (por ejemplo, Visual Studio Code).

Asegúrate de tener Java 8 o superior instalado en tu sistema.

Compila los archivos .java:

bash
Copiar código
javac src/*.java
Ejecución
Para ejecutar el simulador, usa el siguiente comando:

bash
Copiar código
java -cp src Reto1
El programa iniciará en la consola, y te permitirá elegir el planeta de destino, la nave espacial, y ajustar los recursos (combustible, oxígeno y pasajeros) antes de comenzar el viaje.

Opciones del menú:
Seleccionar planeta de destino: Elige entre varios planetas, como Marte, Júpiter, Venus, etc.
Seleccionar nave espacial: Elige entre dos naves con diferentes velocidades y capacidades de pasajeros.
Ajustar recursos: Ingresa la cantidad de combustible, oxígeno y el número de pasajeros.
Iniciar simulación: Comienza el viaje interplanetario. Durante el viaje, se simulan eventos aleatorios (fallos en el sistema, asteroides, desviaciones de rumbo) que el usuario debe resolver escribiendo una respuesta correcta.
Cómo funciona
Reducción de recursos: Cada 1% de avance en el viaje, se reducirá el combustible y el oxígeno en 5 unidades.
Eventos aleatorios: Cada vez que el progreso llega a un múltiplo de 15% (15%, 30%, 45%, etc.), se presentará un evento aleatorio (fallo en el sistema, asteroides, cambio de rumbo). El usuario debe escribir una respuesta para solucionar el problema y continuar el viaje.
Ejemplo de Ejecución
plaintext
Copiar código
----- Simulador de Viaje Interplanetario -----
1. Seleccionar planeta de destino
2. Seleccionar nave espacial
3. Ajustar recursos (combustible, oxígeno, pasajeros)
4. Iniciar simulación de viaje
5. Salir
Elige una opción: 1

Planetas disponibles:
1. Marte (225 millones de km)
2. Júpiter (778 millones de km)
3. Saturno (1433 millones de km)
4. Venus (41 millones de km)
5. Urano (2714 millones de km)
6. Neptuno (4351 millones de km)
Elige un planeta: 1
Has seleccionado Marte (225 millones de km).

Elige una nave: 1
Ingresa la cantidad de pasajeros (máximo 20): 10
Has seleccionado Nave A con una velocidad de 50,000 km/h.
Ingresa la cantidad de combustible (en litros): 100
Ingresa la cantidad de oxígeno (en horas): 50

Iniciando simulación...
Progreso: 15%, Tiempo restante: 9.0 horas, Combustible restante: 95 litros, Oxígeno restante: 45 horas
¡Evento de falla! Se han perdido recursos.
¡Un fallo en el sistema! Se pierde combustible y oxígeno.
Escribe la respuesta correcta para reparar el sistema (escribe 'reparar'): reparar
El sistema ha sido reparado. Se ha perdido algo de combustible y oxígeno.