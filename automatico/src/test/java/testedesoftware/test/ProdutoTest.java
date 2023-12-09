package testedesoftware.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testedesoftware.pageObject.LoginPO;
import testedesoftware.pageObject.ProdutoPO;

public class ProdutoTest extends BaseTest {
	
	private static final String String = null;
	private static ProdutoPO produtoPage;
	
	@BeforeClass
	public static void prepararTestes() {
		ProdutoPO produtoPage = new ProdutoPO(driver);
		
	}
	
	@Test
	public static void TC001_deveExcluirOProdutoAoclicarExcluir() {
		
		produtoPage.buttonElement.click(); //clica no botão excluir
		
		List<WebElement> tdElements = driver.findElements(By.xpath("//td")); //seleciona os elementos td
		
		assert tdElements.isEmpty();
			
	}

	@Test
	public static void TC002_deveAbrirAMensagemDeErroCerta() {
		
		produtoPage.escrever(produtoPage.inputCodigo, "");
		produtoPage.escrever(produtoPage.inputNome, "");
		produtoPage.escrever(produtoPage.inputQuantidade, "");
		produtoPage.escrever(produtoPage.inputValor, "");
		
		produtoPage.buttonSalvar.click();
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
		
		
	}
	
	@Test 
	public static void TC003_DeveCriarUmProduto1() {
		
//		produtoPage.executarAcaoDeCriarProduto(PATH_DRIVE, PATH_DRIVE, PATH_DRIVE, PATH_DRIVE);
		
		List<WebElement> tdElements = driver.findElements(By.xpath("//td")); //seleciona os elementos td
		
		
		produtoPage.buttonSalvar.click();
		
		assert tdElements.size() > 0;
		
	}
	
//	

}
