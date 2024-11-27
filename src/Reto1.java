import java.util.Scanner;

public class Reto1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        SpaceSimulator simulator = new SpaceSimulator();

        while (!exit) {
            System.out.println("----- Simulador de Viaje Interplanetario -----");
            System.out.println("1. Seleccionar planeta de destino");
            System.out.println("2. Seleccionar nave espacial");
            System.out.println("3. Ajustar recursos (combustible, oxígeno, pasajeros)");
            System.out.println("4. Iniciar simulación de viaje");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    simulator.selectPlanet();
                    break;
                case 2:
                    simulator.selectSpaceship();
                    break;
                case 3:
                    simulator.adjustResources();
                    break;
                case 4:
                    simulator.simulateTravel();
                    break;
                case 5:
                    exit = true;
                    System.out.println("¡Gracias por usar el simulador!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        scanner.close();
    }
}
