package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutoPage {
	private WebDriver navegador;
	
	public ProdutoPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	public ConfirmarProdutoEscolhidoPage clicarEmAdicionarASacola() {
		//clica no botao 'Adicionar a sacola'
		navegador.findElement(By.cssSelector("button[class=\"button__buy button__buy-product-detail js-add-cart-button js-main-add-cart-button js-add-box-prime\"]")).click();
		return new ConfirmarProdutoEscolhidoPage(navegador);
	}
	
	
}
