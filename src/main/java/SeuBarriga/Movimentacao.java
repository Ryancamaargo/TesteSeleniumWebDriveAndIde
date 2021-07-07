package SeuBarriga;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Movimentacao {
	@Test
	public void cadastroReceitaPendente() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		Random random = new Random();
		int aleatorio = random.nextInt(10000);
	
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("ryan@teste123.com");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Criar Movimentação")).click();
		
		driver.findElement(By.id("descricao")).sendKeys("ReceitaPendente_"+aleatorio);
		driver.findElement(By.id("data_transacao")).sendKeys("06/07/2021");
		driver.findElement(By.id("data_pagamento")).sendKeys("06/07/2021");
		driver.findElement(By.id("interessado")).sendKeys("RyanPendente");
		driver.findElement(By.id("valor")).sendKeys("150");
		driver.findElement(By.xpath("//button[contains(.,'Salvar')]")).click();
		
		driver.findElement(By.xpath("//li[contains(.,'Movimentação adicionada com sucesso!')]")).isEnabled();
		//driver.close();//para nao ficar com muitas abas abertas eu fecho o navegador, visto que a validação anterior do "erro" do alerta, já foi validado.
	}
	@Test
	public void cadastroReceitaPago() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		Random random = new Random();
		int aleatorio = random.nextInt(10000);
	
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("ryan@teste123.com");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Criar Movimentação")).click();
		
		driver.findElement(By.id("descricao")).sendKeys("ReceitaPaga_"+aleatorio);
		driver.findElement(By.id("data_transacao")).sendKeys("06/07/2021");
		driver.findElement(By.id("data_pagamento")).sendKeys("06/07/2021");
		driver.findElement(By.id("interessado")).sendKeys("RyanClienteBom");
		driver.findElement(By.id("valor")).sendKeys("200");
		driver.findElement(By.xpath("//input[@id='status_pago']")).click();
		
		driver.findElement(By.xpath("//button[contains(.,'Salvar')]")).click();
		
		driver.findElement(By.xpath("//div[contains(.,'Movimentação adicionada com sucesso!')]")).isEnabled();
		driver.close();//para nao ficar com muitas abas abertas eu fecho o navegador, visto que a validação anterior do "erro" do alerta, já foi validado.
	}
	
	@Test
	public void cadastroDespesaPendente() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		Random random = new Random();
		int aleatorio = random.nextInt(10000);
	
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("ryan@teste123.com");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Criar Movimentação")).click();
		
		Select dropdown = new Select(driver.findElement(By.id("tipo")));
		dropdown.selectByValue("Despesa");
		
		driver.findElement(By.id("descricao")).sendKeys("DespesaPendente_"+aleatorio);
		driver.findElement(By.id("data_transacao")).sendKeys("06/07/2021");
		driver.findElement(By.id("data_pagamento")).sendKeys("06/07/2021");
		driver.findElement(By.id("interessado")).sendKeys("RForcedorR");
		driver.findElement(By.id("valor")).sendKeys("300");
		
		
		driver.findElement(By.xpath("//button[contains(.,'Salvar')]")).click();
		
		driver.findElement(By.xpath("//div[contains(.,'Movimentação adicionada com sucesso!')]")).isEnabled();
		driver.close();//para nao ficar com muitas abas abertas eu fecho o navegador, visto que a validação anterior do "erro" do alerta, já foi validado.
	}
	
	@Test
	public void cadastroDespesaPago() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		Random random = new Random();
		int aleatorio = random.nextInt(10000);
	
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("ryan@teste123.com");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Criar Movimentação")).click();
		
		Select dropdown = new Select(driver.findElement(By.id("tipo")));
		dropdown.selectByValue("Despesa");
		
		driver.findElement(By.id("descricao")).sendKeys("DespesaPendente_"+aleatorio);
		driver.findElement(By.id("data_transacao")).sendKeys("06/07/2021");
		driver.findElement(By.id("data_pagamento")).sendKeys("06/07/2021");
		driver.findElement(By.id("interessado")).sendKeys("FornecedorBBB");
		driver.findElement(By.id("valor")).sendKeys("20");
		driver.findElement(By.xpath("//input[@id='status_pago']")).click();
		
		driver.findElement(By.xpath("//button[contains(.,'Salvar')]")).click();
		
		driver.findElement(By.xpath("//div[contains(.,'Movimentação adicionada com sucesso!')]")).isEnabled();
		driver.close();//para nao ficar com muitas abas abertas eu fecho o navegador, visto que a validação anterior do "erro" do alerta, já foi validado.
	}
	
	@Test
	public void cadastroMovimentacaoErradaEexclusaoMovimentacao() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
	
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.findElement(By.id("email")).sendKeys("ryan@teste123.com");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Criar Movimentação")).click();
		
		driver.findElement(By.xpath("//button[contains(.,'Salvar')]")).click();
		
		driver.findElement(By.xpath("//li[contains(.,'Data da Movimentação é obrigatório')]")).isEnabled();
		
		driver.findElement(By.linkText("Resumo Mensal")).click();
		driver.findElement(By.xpath("//table[@id='tabelaExtrato']/tbody/tr[2]/td")).click();
		driver.findElement(By.xpath("//div[contains(.,'Movimentação removida com sucesso!')]")).isEnabled();
		driver.close();//para nao ficar com muitas abas abertas eu fecho o navegador, visto que a validação anterior do "erro" do alerta, já foi validado.
	}
}
