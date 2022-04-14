package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SacolaPage {
	private WebDriver navegador;
	
	public SacolaPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	public PrincipalPage clicarNoBotaoComprarMaisProdutos() {
		navegador.findElement(By.linkText("Comprar mais produtos")).click();
		return new PrincipalPage(navegador);
	}
	
	public SacolaPage excluirItemDaSacola() {
		//Clica no botão excluir
		navegador.findElement(By.className("BasketItem-delete-label")).click();
		return this;
	}
	
	public String validarSacolaVazia() {
		//Retorna o texto referente a sacola vazia (Verificar outra forma de validar a sacola vazia)
		return navegador.findElement(By.cssSelector("div[class=EmptyBasket-title]")).getText();
	}
	
	public CredenciaisPage continuarParaPagamento() {
		//Clica no botão continuar
		navegador.findElement(By.className("BasketContinue-button")).click();
		return new CredenciaisPage(navegador);
	}
}
