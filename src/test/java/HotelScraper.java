import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelScraper {
    static {
        // Configurar nivel de registro de todos los controladores de Selenium a "SEVERE"
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }
    private String url;
    private List<String> comment;

    public HotelScraper(String url, List<String> comment) {
        this.url = url;
        this.comment = comment;
    }

    public void getComments(String url) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Guille/IdeaProjects/ScrapperDACD/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement cookiesbutton = new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='osano-cm-accept-all osano-cm-buttons__button osano-cm-button osano-cm-button--type_accept']")    ));
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
            System.out.println(description.getText());;
        }
        driver.quit();
    }
    public String getServices(String url) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Guille/IdeaProjects/ScrapperDACD/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement cookiesbutton = new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='osano-cm-accept-all osano-cm-buttons__button osano-cm-button osano-cm-button--type_accept']")    ));
        executor.executeScript("arguments[0].click();", cookiesbutton);
        WebElement servicesButton = new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-stid='hotel-amenities-list']//button[@type='button']")));
        executor.executeScript("arguments[0].click();", servicesButton);
        WebElement page = new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"app-layer-amenities-dialog\"]/section/div[3]"))));
        driver.quit();
        return page.getText();
    }

    public  String getLocation(String url){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Guille/IdeaProjects/ScrapperDACD/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement cookiesbutton = new WebDriverWait(driver, 25)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='osano-cm-accept-all osano-cm-buttons__button osano-cm-button osano-cm-button--type_accept']")    ));
        executor.executeScript("arguments[0].click();", cookiesbutton);
        WebElement ubi = new WebDriverWait(driver,25)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='uitk-text uitk-type-300 uitk-text-default-theme uitk-layout-flex-item uitk-layout-flex-item-flex-basis-full_width']")));
        driver.quit();
        return ubi.getText();
    }

}

