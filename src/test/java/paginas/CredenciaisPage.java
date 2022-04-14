package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CredenciaisPage {
	private WebDriver navegador;
	
	public CredenciaisPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	
	public String verificarSeEstaNaPaginaDeCredenciais() {
		//Retorna o nome do titulo da tela
		return navegador.findElement(By.cssSelector("div[class=\"LoginPage-title\"]")).getText();
	}
}
