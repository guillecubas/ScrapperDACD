import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelScraper {
    private final WebDriver driver;


    public HotelScraper() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Guille/IdeaProjects/ScrapperDACD/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36");
        driver = new ChromeDriver(options);
        System.out.println("good");
    }


    public void getComments() {
        driver.get(HotelScraperUI.url);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement cookiesbutton = new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".osano-cm-accept-all.osano-cm-buttons__button.osano-cm-button.osano-cm-button--type_accept")    ));
        executor.executeScript("arguments[0].click();", cookiesbutton);
        WebElement commentbutton = new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='uitk-link uitk-spacing uitk-spacing-padding-blockstart-two uitk-link-align-left uitk-link-layout-default uitk-link-medium']")    ));
        executor.executeScript("arguments[0].click();", commentbutton);
        while (true) {
            try {
                WebElement button =
                        new WebDriverWait(driver, 10)
                                .until(ExpectedConditions.presenceOfElementLocated(
                                        By.cssSelector("button[class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-secondary']")));
                executor.executeScript("arguments[0].click();", button);
            } catch (Exception e) {
                break;
            }
        }
        List<WebElement> comments = driver.findElements(By.cssSelector("span[itemprop='description']"));
        for (WebElement description : comments) {
            System.out.println(description.getText());
        }
    }

    public void getServices() {
        driver.get(HotelScraperUI.url);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement cookiesbutton = new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".osano-cm-accept-all.osano-cm-buttons__button.osano-cm-button.osano-cm-button--type_accept")    ));
        executor.executeScript("arguments[0].click();", cookiesbutton);
        WebElement servicesButton = new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-stid='hotel-amenities-list'] button[type='button']")));
        executor.executeScript("arguments[0].click();", servicesButton);
        WebElement page = new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable((By.cssSelector(".uitk-sheet-content.uitk-sheet-content-padded"))));
        System.out.println(page.getText());
    }

    public void getLocation(){
        driver.get(HotelScraperUI.url);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement cookiesbutton = new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".osano-cm-accept-all.osano-cm-buttons__button.osano-cm-button.osano-cm-button--type_accept")    ));
        executor.executeScript("arguments[0].click();", cookiesbutton);
        WebElement ubi = new WebDriverWait(driver,25)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".uitk-text.uitk-type-300.uitk-text-default-theme.uitk-layout-flex-item.uitk-layout-flex-item-flex-basis-full_width")));
        System.out.printf(ubi.getText());
    }
    public void getRating(){
        driver.get(HotelScraperUI.url);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement cookiesbutton = new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".osano-cm-accept-all.osano-cm-buttons__button.osano-cm-button.osano-cm-button--type_accept")    ));
        executor.executeScript("arguments[0].click();", cookiesbutton);
        WebElement rating = new WebDriverWait(driver,25)
                .until(ExpectedConditions.presenceOfElementLocated(By.tagName("h3")));
        System.out.printf(rating.getText());
    }
    boolean validate_url(String url) {
        String[] parts = url.split("\\.");
        return parts.length >= 2 && parts[1].equals("hoteles") && parts[0].equals("https://es");
    }

}

