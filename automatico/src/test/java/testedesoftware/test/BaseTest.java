package testedesoftware.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	protected static WebDriver driver;
	private static String URL_BASE = "file:///C:/Users/36124872022.1n/Documents/selenium-lab-main/sistema/produtos.html";
	private static String PATH_DRIVE = "src/test/resources/chromedriver.exe"; // C:\\progWebster\\automatico\\
	
	@BeforeClass
	public static void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		driver = new ChromeDriver(); //abre o navegador
		driver.manage().window().maximize(); //maximiza a janela do navegador
		driver.get(URL_BASE); //injeta endereços no computador

	}
	
	@AfterClass
	public static void finalizar() {
		driver.quit();
	}
}
