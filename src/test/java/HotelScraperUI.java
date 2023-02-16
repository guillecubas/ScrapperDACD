import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelScraperUI {
    static String url;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the URL to scrape:");
        url = scanner.nextLine();

        HotelScraper scraper = new HotelScraper(url);

        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Get comments");
            System.out.println("2. Get services");
            System.out.println("3. Get location");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<String> comments = scraper.getComments();
                    System.out.println("Comments:");
                    for (String comment : comments) {
                        System.out.println(comment);
                    }
                    break;
                case 2:
                    String services = scraper.getServices();
                    System.out.println("Services:");
                    System.out.println(services);
                    break;
                case 3:
                    String location = scraper.getLocation();
                    System.out.println("Location:");
                    System.out.println(location);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }
    }
}
