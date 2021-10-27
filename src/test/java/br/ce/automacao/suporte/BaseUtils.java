package br.ce.automacao.suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUtils {
	
	public static WebDriver createChrome() {
		/**
		 * Nescessario extrair o executavel desse caminho src\test\resources\suporte\chromedriver_win32.zip
		 * e adicionar o caminho do mesmo abaixo, para assim executar a automação
		 */
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\leans\\Driver\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();		
		navegador.manage().window().maximize();

		return navegador;
	}

}
