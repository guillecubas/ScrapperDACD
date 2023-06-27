package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scrapper implements HotelScrapper {
    private WebDriver driver;
    @Override
    public void setUp(String url) {
        url = validate_url(url);
        System.setProperty("webdriver.chrome.driver", "C:/Users/Guille/IdeaProjects/ScrapperDACD/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36");
        driver = new ChromeDriver(options);
        driver.get(url);

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement cookiesbutton = new WebDriverWait(driver,  Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".osano-cm-accept-all.osano-cm-buttons__button.osano-cm-button.osano-cm-button--type_accept")    ));
        executor.executeScript("arguments[0].click();", cookiesbutton);
    }



    @Override
    public String getComments(String url) throws JsonProcessingException {
        url = validate_url(url);
        driver.get(url);
        List<String> commentsText = new ArrayList<>();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement commentbutton = new WebDriverWait(driver,  Duration.ofSeconds(25))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app-layer-base\"]/div[1]/div[2]/div[1]/div[3]/div/div[1]/div[1]/div[2]/div[2]/button")));
        executor.executeScript("arguments[0].click();", commentbutton);
        while (true) {
            try {
                WebElement button =
                        new WebDriverWait(driver, Duration.ofSeconds(10))
                                .until(ExpectedConditions.presenceOfElementLocated(
                                        By.xpath("//*[@id=\"app-layer-summary-reviews-property-summary-1\"]/section/div[3]/div/div[2]/div[2]/section/div[2]/button")));
                executor.executeScript("arguments[0].click();", button);
            } catch (Exception e) {
                break;
            }
        }
        List<WebElement> comments = driver.findElements(By.cssSelector("span[itemprop='description']"));
        for (WebElement description : comments) {
            commentsText.add(description.getText());
        }
        return new ObjectMapper().writeValueAsString(commentsText);
    }
    @Override
    public String getServices(String url) throws JsonProcessingException {
        url = validate_url(url);
        driver.get(url);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement servicesButton = new WebDriverWait(driver,  Duration.ofSeconds(25))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-stid='hotel-amenities-list'] button[type='button']")));
        executor.executeScript("arguments[0].click();", servicesButton);
        WebElement page = new WebDriverWait(driver,  Duration.ofSeconds(25))
                .until(ExpectedConditions.elementToBeClickable((By.cssSelector(".uitk-sheet-content.uitk-sheet-content-padded"))));
        String texto = page.getText();
        String[] lineas = texto.split("\n");
        List<String> lista = Arrays.asList(lineas);
        return new ObjectMapper().writeValueAsString(lista);
    }
    @Override
    public String getLocation(String url) throws JsonProcessingException {
        url = validate_url(url);
        driver.get(url);

        WebElement ubi = new WebDriverWait(driver, Duration.ofSeconds(25))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".uitk-text.uitk-type-300.uitk-text-default-theme.uitk-layout-flex-item.uitk-layout-flex-item-flex-basis-full_width")));
        System.out.printf(ubi.getText());
        return new ObjectMapper().writeValueAsString(ubi.getText());
    }
    @Override
    public String getRating(String url) throws JsonProcessingException {
        url = validate_url(url);
        driver.get(url);
        WebElement rating = new WebDriverWait(driver, Duration.ofSeconds(25))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-layer-base\"]/div[1]/div[2]/div[1]/div[3]/div/div[1]/div[1]/div[2]/div[2]/div/div/div/div/div")));
        System.out.printf(rating.getText());
        return new ObjectMapper().writeValueAsString(rating.getText());
    }

    private String validate_url(String url) {

        return "https://es.hoteles.com/" + url;
    }

}

