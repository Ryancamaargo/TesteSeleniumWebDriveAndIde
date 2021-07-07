package SeuBarriga;

import java.util.Random;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Contas {

	
	@Test
	public void cadastroandAlteracaoDeContaSucesso() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//mudar o caminho, se for executar na maquina de voces... o arquivo está junto com o projeto.
		
		driver.manage().window().maximize();
		
		driver.get("https://seubarriga.wcaquino.me/login");
		
		Random random = new Random();
		int aleatorio = random.nextInt(10000);
		
		driver.findElement(By.id("email")).sendKeys("ryan@teste123.com");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
		driver.findElement(By.linkText("Contas")).click();
		driver.findElement(By.xpath("//a[contains(@href, '/addConta')]")).click();
		driver.findElement(By.id("nome")).sendKeys("testeNova"+aleatorio);
		driver.findElement(By.xpath("//button[contains(.,'Salvar')]")).click();
		//pegar mensagem de retorno (o alert)
		driver.findElement(By.xpath("//div[contains(.,'Conta adicionada com sucesso!')]")).isEnabled();
		
		//editando o cadastro de conta
		driver.findElement(By.xpath("//table[@id='tabelaContas']/tbody/tr/td[2]/a/span")).click();
		driver.findElement(By.cssSelector("#nome")).sendKeys("testeAlterada"+aleatorio);
		driver.findElement(By.xpath("//button[contains(.,'Salvar')]")).click();
		driver.findElement(By.xpath("//div[contains(.,'Conta alterada com sucesso!')]")).isEnabled();
		driver.close();
	}
	
	@Test
	public void validacaoContaExistente() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//mudar o caminho, se for executar na maquina de voces... o arquivo está junto com o projeto.
		
		driver.manage().window().maximize();
		
		driver.get("https://seubarriga.wcaquino.me/login");
		
		driver.findElement(By.id("email")).sendKeys("ryan@teste123.com");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
		driver.findElement(By.linkText("Contas")).click();
		driver.findElement(By.xpath("//a[contains(@href, '/addConta')]")).click();
		driver.findElement(By.id("nome")).sendKeys("ContaMovimentacao");
		driver.findElement(By.xpath("//button[contains(.,'Salvar')]")).click();
		//pegar mensagem de retorno (o alert)
		driver.findElement(By.xpath("//div[contains(.,'Já existe uma conta com esse nome!')]")).isEnabled();
		driver.close();
	}
	
	@Test
	public void uexcluirConta() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("ryan@teste123.com");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Contas')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Listar')]")).click();
		
		driver.findElement(By.cssSelector(".glyphicon-remove-circle")).click();
		//pegar mensagem de retorno (o alert)
		driver.findElement(By.xpath("//div[contains(.,'Conta removida com sucesso!')]")).isEnabled();
		driver.close();
	}
	

	@Test
	public void excluirContaMovimentacaoFalha() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("ryan@teste123.com");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Contas')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Listar')]")).click();
		
		driver.findElement(By.xpath("//table[@id='tabelaContas']/tbody/tr/td[2]/a[2]/span")).click();
		
		//pegar mensagem de retorno (o alert)
		driver.findElement(By.xpath("//div[contains(.,'Conta em uso na movimentações')]")).isEnabled();
		driver.close();
	}
	
}
