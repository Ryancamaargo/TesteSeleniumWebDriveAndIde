package TemperaturaAndAmazon;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ComparacaoTemperaturaGoogle_PatoBranco {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:/Users/ryanc/OneDrive/Documentos/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//google
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("temperatura pato branco" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String temp1 = driver.findElement(By.id("wob_tm")).getText();
		System.out.println(temp1);
		
		//climatempo
		driver.get("https://www.climatempo.com.br/previsao-do-tempo/cidade/1325/patobranco-pr");
		
		String temp2 = driver.findElement(By.id("min-temp-1")).getText();
		System.out.println(temp2);
		if (temp2.length() > 0) {
			temp2 = temp2.substring (0, temp2.length() - 1);
		}
		int total;
		total = Integer.parseInt(temp1) - Integer.parseInt(temp2);
		System.out.println("A diferença entre o site do google e o a temperatura de Pato Branco é de "+total+" graus");	
		
	}
}
