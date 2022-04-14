package modulos.produtos;

import java.time.Duration;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import paginas.PrincipalPage;

@DisplayName("Testes Web da Loja Magalu")
public class ProdutosTest {
	
	private WebDriver navegador;
	
	@BeforeAll
	static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	public void beforeEach() throws InterruptedException {
		//Abre navegador
		this.navegador = new ChromeDriver(); 
		//Maximiza a tela
		this.navegador.manage().window().maximize();
		//Define tempo de espera padrao de 5 esgundos
		this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//navegar para a pagina da magalu
		this.navegador.get("https://www.magazineluiza.com.br/");
		//clicar no aceite de cookies
		navegador.findElement(By.cssSelector("button[data-testid='button-message-box']")).click();
	}
	
	@Test
	@DisplayName("Busca de item")
	public void testBuscaDeItem() {
		//Teste pesquisa pelo nome de um item e faz uma assercao se o primeiro resultado encontrado tem o mesmo nome
		String nomeDoPrimeiroItemDaPesquisa = new PrincipalPage(navegador)
			.informarNomeProduto("Smartphone Samsung Galaxy A03 Core 32GB Azul 4G")
			.submeterNomeProduto()
			.capturarResultadosDaPesquisa();
	
		Assertions.assertEquals("Smartphone Samsung Galaxy A03 Core 32GB Azul 4G", nomeDoPrimeiroItemDaPesquisa);		 			
	}	
	
	@Test
	@DisplayName("Validacao do contador de itens na sacola")
	public void testValidaValorDoContadorDeItensDaSacola() {
	//Contador de itens vai sempre iniciar em zero porque cada execucao do Junit zera a sessao do navegador.
	//Teste verifica se o contador da sacola é incrementado para 1 depois de adicionar produto
		
		 String contadorDeItensDaSacola = new PrincipalPage(navegador)
			.informarNomeProduto("Smartphone Samsung Galaxy A03 Core 32GB Azul 4G")
			.submeterNomeProduto()
			.clicarNoProduto()
			.clicarEmAdicionarASacola()
			.confirmarEscolhaProduto()
			.clicarNoBotaoComprarMaisProdutos()
			.capturarValorContadorDeItensSacola();
		 
		 Assertions.assertEquals("1", contadorDeItensDaSacola);		 		
	}
	
	@Test
	@DisplayName("Validar sacola vazia")
	public void testValidarSacolaVazia() {
	//Teste adiciona um produto a sacola e depois exclui. Em seguida valida se a sacola está vazia (melhorar verificacao de sacola vazia)
		
		 String mensagemSacolaVazia = new PrincipalPage(navegador)
			.informarNomeProduto("Smartphone Samsung Galaxy A03 Core 32GB Azul 4G")
			.submeterNomeProduto()
			.clicarNoProduto()
			.clicarEmAdicionarASacola()
			.confirmarEscolhaProduto()
			.excluirItemDaSacola()
			.validarSacolaVazia();
		
		 Assertions.assertEquals("Sua sacola está vazia", mensagemSacolaVazia);
	}
	
	@Test
	@DisplayName("Validacao de necessidade de fazer login para continuar compra")
	public void testValidaCredenciaisParaComprarProduto() {
	//Ao chegar na tela de credenciais, verifica na parte superior se está na segunda etapa (verificacao)
		
		 String nomeDaEtapaAtual = new PrincipalPage(navegador)
			.informarNomeProduto("Smartphone Samsung Galaxy A03 Core 32GB Azul 4G")
			.submeterNomeProduto()
			.clicarNoProduto()
			.clicarEmAdicionarASacola()
			.confirmarEscolhaProduto()
			.continuarParaPagamento()
			.verificarSeEstaNaPaginaDeCredenciais();
		 
		 Assertions.assertEquals("Identificação", nomeDaEtapaAtual);		 		
	}
	
	@AfterEach
	public void afterEach() {
		//Fecha o navegador
		navegador.quit();
	}
}
