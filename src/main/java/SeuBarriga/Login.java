package SeuBarriga;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
	@Test
	public void validarLoginErrado() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("ryan@teste.com");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[contains(.,'Problemas com o login do usuário')]")).isEnabled();
		driver.close();//para nao ficar com muitas abas abertas..., visto que a validação anterior do "erro" do alerta, já foi validado.
	}
	
	@Test
	public void validarLoginCerto() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//mudar o caminho, se for executar na maquina de voces... o arquivo está junto com o projeto.
		
		driver.manage().window().maximize();
		
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("ryan@teste123.com");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector(".alert")).isEnabled();
		
	}
}
