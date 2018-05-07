package devtestsselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * DevTests Campinas
 * 
 * @author marcos12cruz@hotmail.com
 * 
 *         Neste meetup aprendemos a como comecar um projeto em maven Como
 *         importar as bibliotecas no pom.xml E criamos nosso primeiro teste
 *         automatizado E2E, o qual realiza uma pesquisa no google
 */

public class PrincipalTest {
	private WebDriver driver;

	// a annotation BeforeClass é realiza ações gerais antes da inicialização da classe de testes
	// é utilizada para configurações que são comuns a todos os testes da classe
	// geralmente ações de configuração como o Setup do WebDriveManager a seguir
	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	// a anotation Before é utilizada para realizar ações antes da execução do teste
	@Before
	public void before() {
		// aqui 'setamos' a proprieadade para indicar onde esta o driver
		// (agora executada pelo WebDriveManager)
		// System.setProperty("webdriver.chrome.driver", "/home/usuario/Documentos/DriverForSelenium/chromedriver");

		// aqui criamos as opcoes para o chromedriver
		ChromeOptions options = new ChromeOptions();

		// então adicionamos um argumento para executar os testes no modo headless
		// ou seja o navegador não irá aparecer na tela
		// options.addArguments("--headless");

		// criamos um novo driver
		driver = new ChromeDriver(options);
	}

	// a annotation After serve para realizar ações após a execução do teste
	@After
	public void after() {
		// aqui nós fechamos o nosso driver
		driver.quit();
	}

	@Test
	public void conseguimosAcessarUmBuscadorEEncontrarUmaPagina() {
		// Vamos acessar uma página de busca 'https://www.google.com'
		driver.get("https://www.google.com");

		// usamos o campo de busca para procurar por 'selenium'
		driver.findElement(By.name("q")).sendKeys("selenium", Keys.ENTER);

		// conseguimos encontrar uma página como 'Selenium - Web Browser Automation'
		Assert.assertTrue(driver.findElement(By.linkText("Selenium - Web Browser Automation")).isDisplayed());
	}
}