import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class comments<url> {
    // This class uses a url to access a website and retrieve all the comments
    private String url;
    private List<String> comment;

    public void setUrl(String url) {
        this.url = url;
    }

    public void getComments(String url){
        // This method uses the url to access the website and add them into a list
        System.setProperty("webdriver.chrome.driver", "C:/Users/Guille/IdeaProjects/ScrapperDACD/chromedriver.exe");
        WebDriver driver = new HtmlUnitDriver();
        driver.get("url");
        WebElement cokiesButton = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='osano-cm-accept-all osano-cm-buttons__button osano-cm-button osano-cm-button--type_accept']")));
        cokiesButton.click();



    }
}
