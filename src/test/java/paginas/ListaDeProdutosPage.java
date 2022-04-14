package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage {
	private WebDriver navegador;
	
	public ListaDeProdutosPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	public String capturarResultadosDaPesquisa() {
		//Pega o nome do primeiro produto da lista de produtos
		return navegador.findElement(By.cssSelector("h2[data-testid=\"product-title\"]")).getText();
	}
	
	public ProdutoPage clicarNoProduto() {
		//Clica no primeiro produto da lista
		navegador.findElement(By.cssSelector("a[data-testid=\"product-card-container\"]")).click();
		return new ProdutoPage(navegador);
	}
	
}
