package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class BuscadorSteps {
    private WebDriver driver;

    @BeforeScenario
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeStory
    public void before() {
        ChromeOptions options = new ChromeOptions();

        // options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterStory
    public void after() {
        driver.quit();
    }

    @Given("uma página de busca $url")
    public void acessarPaginaDeBusca(String urlPagina) {
        driver.get(urlPagina);
    }

    @When("usamos o campo de busca para procurar por '$texto'")
    public void buscarPor(String texto) {
        driver.findElement(By.name("q"))
              .sendKeys(texto, Keys.ENTER);
    }

    @Then("conseguimos encontrar uma página como '$tituloPagina'")
    public void verificarResultado(String tituloPagina) {
        assertTrue(driver.findElement(By.linkText(tituloPagina)).isDisplayed());
    }
}