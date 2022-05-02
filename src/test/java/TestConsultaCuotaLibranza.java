import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestConsultaCuotaLibranza {


    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bancodeoccidente.com.co/solicitarcredito/#/simuladorLibranza");
    }
    @Test
    public void testConsultaCuotaLibranza() throws InterruptedException {
        String convenio = "POLICIA NACIONAL";

        WebElement nombreConvenio = driver.findElement(By.id("nombreEmpresaSimulador"));
        nombreConvenio.click();
        Thread.sleep(1000);
        nombreConvenio.sendKeys(convenio);
        WebElement nombreConvenioElement = new WebDriverWait(driver, Long.parseLong("10"))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='ng-binding']")));

        //WebElement nombreConvenioElement = driver.findElement(By.cssSelector("a[class='ng-binding']"));
        nombreConvenioElement.click();

        WebElement monto = driver.findElement(By.name("valorSolicitado"));
        monto.sendKeys("50000000");

        WebElement plazo = driver.findElement(By.name("plazo"));
        plazo.sendKeys("24 Meses");


        WebElement seguroCuotaProtegida = driver.findElement(By.cssSelector("label[for='cmn-toggle-1']"));
        seguroCuotaProtegida.click();


        WebElement valorCuota = driver.findElement(By.cssSelector("b[class='ng-binding']"));
        System.out.println("Valor Cuota: "+valorCuota.getText());
   }
    @After
    public void tearDown() {
         driver.quit();
    }


}