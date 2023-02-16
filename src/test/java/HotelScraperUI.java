import java.util.ArrayList;
import java.util.Scanner;

public class HotelScraperUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al scraper de hoteles");
        System.out.print("Ingrese la URL del hotel: ");
        String url = scanner.nextLine();
        HotelScraper scraper = new HotelScraper(url, new ArrayList<>());
        while (true) {
            System.out.println("¿Qué información desea obtener?");
            System.out.println("1. Comentarios");
            System.out.println("2. Servicios");
            System.out.println("3. Ubicación");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Comentarios:");
                    scraper.getComments(url);
                    break;
                case 2:
                    String servicios = scraper.getServices(url);
                    System.out.println("Servicios:");
                    System.out.println(servicios);
                    break;
                case 3:
                    String ubicacion = scraper.getLocation(url);
                    System.out.println("Ubicación:");
                    System.out.println(ubicacion);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
        }
    }
}
