package testedesoftware.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO {
	
	
	@FindBy(id = "codigo")
	public WebElement inputCodigo; //padrão da variável: nome do elemento html + o que ele representa
	
	@FindBy(id = "nome")
	public WebElement inputNome;
	
	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;
	
	@FindBy(id = "valor")
	public WebElement inputValor;
	
	@FindBy(id = "btn-salvar")
	public WebElement buttonSalvar;
	
	public WebElement buttonElement = driver.findElement(By.xpath("//button[text()='Excluir']"));
	
	
	//document.querySelector('form>div.alert>span')
	//document.querySelector('form.form-login>div.alert>span').textContent
	@FindBy(css = "form.form-login>div.alert>span")
	public WebElement spanMensagem;
	//capturar a mensagem funciona por id também
	
	/**
	 * Construtor padrão para criação de uma nova instância da página de login
	 * @param driver Driver da página de login
	 * */
	public ProdutoPO(WebDriver driver) {
		super(driver);
	}
	
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	
	
	public String obterTituloPagina() {
		return driver.getTitle();
	}
	
	/**
	 * Método que tenta executar a ação no sistema
	 * @param inputNome Nome do produto para cadastro
	 * @param inputCodigo Codigo do produto para cadastro
	 * @param inputQuantidade Quantidade do produto para cadastro
	 * @param inputValor Valor do produto para cadastro
	 * @param dia Dia na data
	 * @param mês Mês na data
	 * @param ano Ano na data
	 * */
	public void executarAcaoDeCriarProduto(String codigo, String nome, String quantidade, String valor) {
		escrever(inputCodigo, codigo);
		escrever(inputNome, nome);
		escrever(inputQuantidade, quantidade);
		escrever(inputValor, valor);
		selecionarData(0, 0, 0);
		buttonSalvar.click();
	}
	
    public void selecionarData(int dia, int mes, int ano) {
        // Obtém o elemento do calendário
        WebElement calendario = driver.findElement(By.className("datepicker"));

        // Obtém o elemento do mês
        WebElement mesElemento = calendario.findElement(By.className("month"));
        String mesTexto = mesElemento.getText();

        // Obtém o elemento do ano
        WebElement anoElemento = calendario.findElement(By.className("year"));
        String anoTexto = anoElemento.getText();

        // Verifica se o mês e o ano estão corretos
        if (!mesTexto.equals(String.valueOf(mes))) {
            // Seleciona o mês
            mesElemento.findElement(By.xpath(".//a[text()='" + "02" + "']")).click();
        }

        if (!anoTexto.equals(String.valueOf(ano))) {
            // Seleciona o ano
            anoElemento.findElement(By.xpath(".//a[text()='" + "1995" + "']")).click();
        }

        // Obtém o elemento do dia
        WebElement diaElemento = calendario.findElement(By.xpath(".//td[text()='" + "23" + "']"));

        // Seleciona o dia
        diaElemento.click();
    	
	
}
	
	public String obterTituloDaPagina() {
		return driver.getTitle();
	}

}
