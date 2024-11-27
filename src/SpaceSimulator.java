import java.util.Random;
import java.util.Scanner;

public class SpaceSimulator {
    private String[] planets = {"Marte", "Júpiter", "Saturno", "Venus", "Urano", "Neptuno"};
    private double[] distances = {225, 778, 1433, 41, 2714, 4351}; // Distancias en millones de kilómetros (aproximadas)
    private String selectedPlanet = "";
    private double planetDistance = 0;

    private String[] spaceships = {"Nave A (50,000 km/h)", "Nave B (100,000 km/h)"};
    private double[] speeds = {50000, 100000}; // Velocidades en km/h
    private String selectedSpaceship = "";
    private double spaceshipSpeed = 0;

    private double fuel = 0; // Cantidad de combustible (en litros)
    private double oxygen = 0; // Cantidad de oxígeno (en horas)
    private int passengers = 0; // Cantidad de pasajeros

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void selectPlanet() {
        System.out.println("Planetas disponibles:");
        for (int i = 0; i < planets.length; i++) {
            System.out.printf("%d. %s (%.0f millones de km)%n", i + 1, planets[i], distances[i]);
        }
        System.out.print("Elige un planeta: ");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= planets.length) {
            selectedPlanet = planets[choice - 1];
            planetDistance = distances[choice - 1];
            System.out.printf("Has seleccionado %s (%.0f millones de km).%n", selectedPlanet, planetDistance);
        } else {
            System.out.println("Selección inválida. Intenta de nuevo.");
        }
    }

    public void selectSpaceship() {
        System.out.println("Naves disponibles:");
        for (int i = 0; i < spaceships.length; i++) {
            System.out.printf("%d. %s%n", i + 1, spaceships[i]);
        }
        System.out.print("Elige una nave: ");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= spaceships.length) {
            selectedSpaceship = spaceships[choice - 1];
            spaceshipSpeed = speeds[choice - 1];

            if (selectedSpaceship.equals("Nave A (50,000 km/h)")) {
                System.out.print("Ingresa la cantidad de pasajeros (máximo 20): ");
                passengers = scanner.nextInt();
                if (passengers > 20) {
                    System.out.println("Error: La nave A solo puede llevar hasta 20 pasajeros.");
                    return; // Sale de la función si el número de pasajeros es incorrecto
                }
            } else if (selectedSpaceship.equals("Nave B (100,000 km/h)")) {
                System.out.print("Ingresa la cantidad de pasajeros (máximo 30): ");
                passengers = scanner.nextInt();
                if (passengers > 30) {
                    System.out.println("Error: La nave B solo puede llevar hasta 30 pasajeros.");
                    return; // Sale de la función si el número de pasajeros es incorrecto
                }
            }

            System.out.printf("Has seleccionado %s con una velocidad de %.0f km/h.%n", selectedSpaceship, spaceshipSpeed);
        } else {
            System.out.println("Selección inválida. Intenta de nuevo.");
        }
    }

    public void adjustResources() {
        System.out.print("Ingresa la cantidad de combustible (en litros): ");
        fuel = scanner.nextDouble();

        System.out.print("Ingresa la cantidad de oxígeno (en horas): ");
        oxygen = scanner.nextDouble();

        // Ajustar los recursos según el destino
        double requiredFuel = planetDistance * 10; // Ejemplo: 10 litros por millón de km
        double requiredOxygen = passengers * planetDistance * 0.05; // Ejemplo: 0.05 horas de oxígeno por millón de km por pasajero

        System.out.printf("Requerido: %.2f litros de combustible y %.2f horas de oxígeno para el viaje.%n", requiredFuel, requiredOxygen);
    }

    public void simulateTravel() {
        if (selectedPlanet.isEmpty() || selectedSpaceship.isEmpty()) {
            System.out.println("Primero debes seleccionar un planeta y una nave.");
            return;
        }

        double travelTime = (planetDistance * 1_000_000) / spaceshipSpeed; // Tiempo en horas
        double remainingDistance = planetDistance * 1_000_000;
        int progress = 0;

        // Simulación del viaje
        while (remainingDistance > 0 && fuel > 0 && oxygen > 0) {
            remainingDistance -= spaceshipSpeed * 100; // Viaje de 100 km por cada iteración
            progress = (int) ((planetDistance * 1_000_000 - remainingDistance) / (planetDistance * 1_000_000) * 100);

            // Disminuir recursos cada 1% de avance
            fuel -= 5;
            oxygen -= 5;

            // Asegurarse de que no haya valores negativos
            if (fuel < 0) fuel = 0;
            if (oxygen < 0) oxygen = 0;

            // Simular eventos aleatorios cada 15% de avance
            if (progress % 15 == 0 && progress != 0) {
                simulateRandomEvents();
                askUserToFixProblem(); // Llamada para pedir al usuario que resuelva un problema
            }

            // Monitoreo de progreso
            System.out.printf("Progreso: %d%%, Tiempo restante: %.2f horas, Combustible restante: %.2f litros, Oxígeno restante: %.2f horas%n",
                    progress, travelTime - (travelTime * progress / 100), fuel, oxygen);

            try {
                Thread.sleep(500); // Pausa de medio segundo para simular progreso
            } catch (InterruptedException e) {
                System.out.println("Error en la simulación.");
            }
        }

        if (fuel <= 0 || oxygen <= 0) {
            System.out.println("¡Te has quedado sin recursos durante el viaje! El viaje ha fallado.");
        } else {
            System.out.println("¡Has llegado a tu destino!");
        }
    }

    // Método para simular eventos aleatorios
    private void simulateRandomEvents() {
        int eventChance = random.nextInt(100);

        // Reducción de recursos cada vez que ocurre un evento
        System.out.println("¡Evento de falla! Se han perdido recursos.");
        fuel -= 5;  // Se pierde 5 litros de combustible
        oxygen -= 5;  // Se pierde 5 horas de oxígeno

        // Asegurarse de que no haya valores negativos
        if (fuel < 0) fuel = 0;
        if (oxygen < 0) oxygen = 0;

        System.out.println("Evento aleatorio detectado. Responde correctamente para solucionarlo.");

        // Eventos con una probabilidad del 33% para fallos del sistema, meteoritos o cambio de rumbo
        int eventType = random.nextInt(3);
        if (eventType == 0) { // Fallo del sistema
            System.out.println("¡Un fallo en el sistema! Se pierde combustible y oxígeno.");
            System.out.print("Escribe la respuesta correcta para reparar el sistema (escribe 'reparar'): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("reparar")) {
                System.out.println("El sistema ha sido reparado. Se ha perdido algo de combustible y oxígeno.");
            } else {
                System.out.println("No se pudo reparar el sistema. Se perdió combustible y oxígeno.");
            }
        } else if (eventType == 1) { // Meteorito
            System.out.println("¡Un meteorito ha desviado la nave! Se pierde combustible y oxígeno.");
            System.out.print("Escribe la respuesta para esquivar el meteorito (escribe 'esquivar'): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("esquivar")) {
                System.out.println("El meteorito ha sido esquivado con éxito.");
            } else {
                System.out.println("El meteorito ha causado daño a la nave. Se ha perdido combustible y oxígeno.");
            }
        } else { // Cambio de rumbo
            System.out.println("¡Cambio de rumbo necesario! Se pierde más oxígeno.");
            System.out.print("Escribe la respuesta para corregir el rumbo (escribe 'corregir'): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("corregir")) {
                System.out.println("El rumbo ha sido corregido exitosamente.");
            } else {
                System.out.println("El rumbo no se ha corregido correctamente. El oxígeno se ha agotado más rápido.");
            }
        }
    }

    // Método que pide al usuario que resuelva el problema
    private void askUserToFixProblem() {
        // Llamado en cada 15% de progreso para resolver un evento
        System.out.println("¡Se ha detectado un problema! Resuelve el siguiente desafío.");
    }

    public static void main(String[] args) {
        SpaceSimulator simulator = new SpaceSimulator();
        simulator.selectPlanet();
        simulator.selectSpaceship();
        simulator.adjustResources();
        simulator.simulateTravel();
    }
}
