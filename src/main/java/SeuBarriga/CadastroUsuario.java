package SeuBarriga;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CadastroUsuario {
	@Test
	public void validarCadastroErrado() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
	
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.xpath("//a[contains(text(),'Novo usuário?')]")).click();
		driver.findElement(By.id("nome")).sendKeys("ryan");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.xpath("//input[@value='Cadastrar']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[contains(.,'Email é um campo obrigatório')]")).isEnabled();
		driver.close();//para nao ficar com muitas abas abertas eu fecho o navegador, visto que a validação anterior do "erro" do alerta, já foi validado.
	}
	
	@Test
	public void validarCadastroCerto() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//mudar o caminho, se for executar na maquina de voces... o arquivo está junto com o projeto.
		
		driver.manage().window().maximize();
		
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.xpath("//a[contains(text(),'Novo usuário?')]")).click();
		Random random = new Random();
		int aleatorio = random.nextInt(10000);
		driver.findElement(By.id("email")).sendKeys("ryan@teste123.com"+aleatorio);
		driver.findElement(By.id("nome")).sendKeys("ryan"+aleatorio);
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.xpath("//input[@value='Cadastrar']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[contains(.,'Usuário inserido com sucesso')]")).isEnabled();
		
		driver.close();
	}
}
