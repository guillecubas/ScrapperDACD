import java.util.Scanner;

public class HotelScraperUI {
    static String url;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the URL to scrape:");
        url = scanner.nextLine();
        HotelScraper scraper = new HotelScraper();
        if (!scraper.validate_url(url)) {
            System.out.println("The URL entered is not valid for this scraper. Please enter a URL for any hotel on es.hoteles.com.");
            return;
        }

        while (true) {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Get comments");
            System.out.println("2. Get services");
            System.out.println("3. Get location");
            System.out.println("4. Get rating");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Comments:");
                    scraper.getComments();
                }
                case 2 -> {
                    System.out.println("Services:");
                    scraper.getServices();
                }
                case 3 -> {
                    System.out.println("Location:");
                    scraper.getLocation();
                }
                case 4 -> {
                    System.out.println("Rating:");
                    scraper.getRating();
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }
}
