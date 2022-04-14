package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmarProdutoEscolhidoPage {
	private WebDriver navegador;
	
	public ConfirmarProdutoEscolhidoPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	public SacolaPage confirmarEscolhaProduto() {
		//clica no botao 'Continuar'
		navegador.findElement(By.linkText("continuar")).click();
		return new SacolaPage(navegador);
	}
	

}
