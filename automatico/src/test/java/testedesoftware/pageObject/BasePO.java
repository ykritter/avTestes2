package testedesoftware.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Yngrid Riter
 * Classe base para criação de novas PageObjects
 * Todas as pages devem herdar esta classe
 */

public class BasePO {

	/**Driver base que será usado pelas pages*/
	protected WebDriver driver;
	
	/**
	 * Construtor base para a criação da fábrica de elementos (PageFactory)
	 * @param driver (Driver do navegador atual)
	 */
	public BasePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
}
