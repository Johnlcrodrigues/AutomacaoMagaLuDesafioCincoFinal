package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PrincipalPage {
	private WebDriver navegador;
	
	public PrincipalPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	public PrincipalPage informarNomeProduto(String nomeProduto) {
		//Escreve o nome do produto na barra de pesquisa
		navegador.findElement(By.cssSelector("label[for='input-search']")).click();
		navegador.findElement(By.id("input-search")).sendKeys(nomeProduto);
		return this;
	}
	
	public ListaDeProdutosPage submeterNomeProduto() {
		//Aperta enter para enviar os dados 
		navegador.findElement(By.id("input-search")).sendKeys(Keys.ENTER);
		return new ListaDeProdutosPage(navegador);
	}
	
	public String capturarValorContadorDeItensSacola() {
		//Com css selector captura o valor do contador da sacola
		return navegador.findElement(By.cssSelector("div[data-testid=\"numbered-btn-counter\"]")).getText();
	}
	
	
}
