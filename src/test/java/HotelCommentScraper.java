import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelCommentScraper {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Guille/IdeaProjects/ScrapperDACD/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://es.hoteles.com/ho582207/only-you-hotel-atocha-madrid-espana/?chkin=2023-02-19&chkout=2023-02-22&x_pwa=1&rfrr=HSR&pwa_ts=1676286497978&referrerUrl=aHR0cHM6Ly9lcy5ob3RlbGVzLmNvbS9Ib3RlbC1TZWFyY2g%3D&useRewards=false&rm1=a2&regionId=178281&destination=Madrid+%28y+alrededores%29%2C+Comunidad+de+Madrid%2C+Espa%C3%B1a&destType=MARKET&neighborhoodId=553248633935944946&selected=804778&trackingData=AAAAEDzFEA5xb3TDbKLkiIC0E0NDMUE5AuDLnRpb7ktK4lsV9oZ4bobwZdpEqjtQwzdwsMbbbimYxfXIKr5W7qQuXWhd0UzWmjcu6hBL8cbcbaT2E7VrJSkNBYJPfIhmMKZ5Z3HS7X1ZFGJFlKSbC-t3JqNkb2369h7Se1J5CMuBBUpKLt6Q5yNFhn0o_rYev6pI_Ogy6ntuh98-PraorkugBMcBjOp_CgrNO8lfDJespu4RDS6zmJLsCc1i-N13h2wOFgwQDi8GPkSlheM4QqJnpjkb00U_RyZF8C7PZLwwVxCPyAWnm5oswaRJFcHel1Y1awadVvzyc0ct_57FM09HzefinaQD-BJ8bXLACATWbrue8FJl9Q7tSelUAItOfvJubdWsV9tQEdasMc92mqJqjdh3KCcrlJCNc548wRlMIwIR4OoVNhKuewID5IkpJCjvPNz4kzwgwdcW4LnUKlfnyuublF_BW8wjMoYCHdfqEaCRcpdw4g2C_Ai7U2Ey9PaklpK4ZaKk_Gn-WxAmq-WGD4KE584sn0tmSilqdsjIEH3xk3WfjgjvcuEy1zbWunw_mmU3kCCZqNHB0Tst4YjzJktQQOLul_MpApiHquw5anwcWO19Uz1_J2LrTbimbdeXdra1pwABwt9b60JG70fh8vPbtPl8hqLtTX5rEDSRvke0y5a50t8RI2jRIrKlaEAdIFw82Mc8k83GIum6Ltm2-dHSdy5_n17blc1W73cApyGCP5mBMnyDGIfiBHOOyYZVcI5wRz0w1UG2Cn7qNu0ApBezMz9nLvjRLyWV-d7XT--b7psLAITbPsgUKUURrdQNx4fYgTmTiXGwVtw8UkCHQ-Im3db8fDNeAnVfqhWCIFZfWRvfabQwzI2jMWZwzs3-I3hwj43R10IXoJhQqbN_Y8mfIDJa0g152LBYDUb4EklObQoMaERCVYYZ2UQ9GpdIRL8vfhb1rTXpDPuiTEd3dMjeYQEKowfNW8W6-2PMX4TkV48b5XvT-oUXOs8QzCrFLjRSFJu7zn99jLznNocFxMY%3D&rank=1&testVersionOverride=Buttercup%2C45803.0.0%2C44204.0.0%2C44203.0.0%2C43549.129874.3%2C43550.0.0%2C31936.102311.0%2C33775.98848.1%2C38414.114301.0%2C39483.0.0%2C38427.115718.1%2C42444.0.0%2C42589.0.0%2C42876.124673.0%2C42973.0.0%2C42974.0.0%2C42975.0.0%2C42976.0.0%2C42802.125960.1%2C33739.99567.0%2C37898.109354.0%2C37930.0.0%2C37949.0.0%2C37354.0.0%2C43435.128144.0&slots=&position=2&beaconIssued=2023-02-13T11%3A08%3A15&sort=RECOMMENDED&top_dp=566&top_cur=EUR&userIntent=&selectedRoomType=201484654&selectedRatePlan=207411756&expediaPropertyId=14725875");
        System.out.printf(driver.getTitle());
        driver.quit();
    }
}
