package TemperaturaAndAmazon;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CriarContaAmazon {
	public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	
	//Amazon, criar conta
	driver.get("https://www.amazon.com");
	driver.findElement(By.id("nav-cart")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.id("a-autoid-0-announce")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//criar conta
	driver.findElement(By.id("createAccountSubmit")).click();
	driver.findElement(By.id("ap_customer_name")).sendKeys("Teste123");
	Random random = new Random();
	int gerador = random.nextInt(10000);
	driver.findElement(By.id("ap_email")).sendKeys("Teste@"+gerador+".com");
	driver.findElement(By.id("ap_password")).sendKeys("123456789");
	driver.findElement(By.id("ap_password_check")).sendKeys("1234567891");
	driver.findElement(By.id("continue")).click();
	

	System.out.println("Retorno da Amazon: "+driver.findElement(By.id("auth-password-mismatch-alert")).getText());
	driver.findElement(By.id("ap_password_check")).clear();
	
	driver.findElement(By.id("ap_password_check")).sendKeys("123456789");
	driver.findElement(By.id("continue")).click();
	System.out.println("Outra tela");
}
}
