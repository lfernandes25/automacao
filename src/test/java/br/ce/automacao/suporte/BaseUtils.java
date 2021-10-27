package br.ce.automacao.suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUtils {
	
	public static WebDriver createChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\leans\\Driver\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();		
		navegador.manage().window().maximize();

		return navegador;
	}

}
