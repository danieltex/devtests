package jbehave.steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class BuscadorSteps {
    private WebDriver driver;

    @BeforeStory
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeScenario
    public void before() {
        ChromeOptions options = new ChromeOptions();

        // options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterScenario
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("uma página de busca $url")
    public void acessarPaginaDeBusca(String urlPagina) {
        driver.get(urlPagina);
    }

    @When("usamos o campo de busca $nome para procurar por '$texto'")
    public void buscarPor(String nomeInput, String texto) {
        driver.findElement(By.name(nomeInput))
              .sendKeys(texto, Keys.ENTER);
    }

    @Then("conseguimos encontrar uma página como '$tituloPagina'")
    public void verificarResultado(String tituloPagina) {
        final WebElement element = driver.findElement(By.partialLinkText(tituloPagina));
        assertTrue(element.isDisplayed());
        System.out.println("Texto do link: " + element.getText());
    }
}