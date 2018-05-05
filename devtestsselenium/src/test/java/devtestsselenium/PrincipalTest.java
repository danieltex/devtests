package devtestsselenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
	public WebDriver driver;

	// a anotation Before é utilizada para realizar ações antes dos testes serem
	// executados
	@Before
	public void before() {
		// aqui 'setamos' a proprieadade para indicar onde esta o driver
		System.setProperty("webdriver.chrome.driver", "/home/usuario/Documentos/DriverForSelenium/chromedriver");

		// aqui criamos as opcoes para o chromedriver
		ChromeOptions options = new ChromeOptions();

		// entao adicionamos um argumento para executar os testes no modo headless
		// ou seja o navegador nao ira aparecer na tela
		options.addArguments("--headless");

		// criamos um novo driver
		driver = new ChromeDriver(options);
	}

	// a anotation Test é utilizada para os testes que serão executados
	@Test
	public void teste() throws InterruptedException {
		// aqui 'dizemos' ao driver qual página web queremos acessar
		driver.get("https://www.google.com");

		// aqui vamos fazer com que o driver preencha o campo de busca do google.
		// para encontrar as propriedades dos elemento no tela, clicamos nele com o
		// botão direito do mouse
		// e selecionamos a opção 'inspecionar elemento'
		// então, procuramos o elemento cuja propriedade 'name' seja igual a 'q'
		// e fazemos com que o driver digite 'selenium' e 'pressione' a tecla ENTER
		driver.findElement(By.name("q")).sendKeys("selenium", Keys.ENTER);

		// neste trecho comentado, demonatramos varias maneiras de clicar em elementos
		// na pagina web
		/*
		 * driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]/a")).click();
		 * driver.findElement(By.linkText("Selenium - Web Browser Auto	mation")).click(
		 * ); driver.findElement(By.partialLinkText("Selenium")).click();
		 * driver.findElement(By.cssSelector("#hdtb-msb-vis > div:nth-child(2) > a")).
		 * click();
		 */

		// utilizamos o Assert.assertTrue, para fazer uma verificação de verdadeiro ou
		// falso
		// 'pedimos' ao driver que verifique se existe algum link com o texto especifico
		// caso sim ele retornara True(verdadeiro), senão False (Falso)
		// com isso o junit 'saberá' se o teste falhou ou não
		Assert.assertTrue(driver.findElement(By.linkText("Selenium - Web Browser Automation")).isDisplayed());

		// o thread.sleep, não é a melhor opção para fazer o driver esperar um
		// determinado tempo para realizar uma ação
		// porem como este é nosso primeiro teste automatizado vamos utiliza-lo, mais
		// para frente aprenderemos como usar WebDriverWait
		// Thread.sleep(5000);
	}

	// a anotation After, serve para realizar uma ação após a execução do teste
	@After
	public void after() {
		// aqui nos fechamos o nosso driver
		driver.quit();
	}
}