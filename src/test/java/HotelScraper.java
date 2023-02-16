import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelScraper {
    private WebDriver driver;


    public HotelScraper(String url) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Guille/IdeaProjects/ScrapperDACD/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        System.setProperty("webdriver.chrome.silentOutput", "true");

    }

    public void close() {
        driver.quit();
    }

    private WebElement findElement(By locator) {
        return new WebDriverWait(driver, 25).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<String> getComments() {
        driver.get(HotelScraperUI.url);
        findElement(By.xpath("//button[@class='osano-cm-accept-all osano-cm-buttons__button osano-cm-button osano-cm-button--type_accept']")).click();
        findElement(By.cssSelector("button[class='uitk-link uitk-spacing uitk-spacing-padding-blockstart-two uitk-link-align-left uitk-link-layout-default uitk-link-medium']")).click();
        for (int i = 0; i < 10; i++) {
            try {
                findElement(By.cssSelector("button[class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-secondary']")).click();
            } catch (TimeoutException e) {
                break;
            }
        }
        List<String> comments = driver.findElements(By.cssSelector("span[itemprop='description']")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return comments;
    }

    public String getServices() {
        driver.get(HotelScraperUI.url);
        findElement(By.xpath("//button[@class='osano-cm-accept-all osano-cm-buttons__button osano-cm-button osano-cm-button--type_accept']")).click();
        findElement(By.xpath("//div[@data-stid='hotel-amenities-list']//button[@type='button']")).click();
        String services = findElement(By.xpath("//*[@id=\"app-layer-amenities-dialog\"]/section/div[3]"))
                .getText();
        return services;
    }

    public String getLocation(){
        driver.get(HotelScraperUI.url);
        findElement(By.xpath("//button[@class='osano-cm-accept-all osano-cm-buttons__button osano-cm-button osano-cm-button--type_accept']")).click();
        String location = findElement(By.xpath("//div[@class='uitk-text uitk-type-300 uitk-text-default-theme uitk-layout-flex-item uitk-layout-flex-item-flex-basis-full_width']"))
                .getText();
        return location;
    }
}
