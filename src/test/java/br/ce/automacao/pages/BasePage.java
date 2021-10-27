package br.ce.automacao.pages;

import java.util.Calendar;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.automacao.suporte.DataConverter;

public class BasePage {

	protected static WebDriver navegador;
	protected static WebDriverWait waitBasePage;

	public BasePage(WebDriver navegador) {
		this.navegador = navegador;
		this.waitBasePage = new WebDriverWait(navegador, 10);
	}

	public void escreveCampo(By by, String valor) {
		navegador.findElement(by).sendKeys(valor);
	}

	public void clicar(By by) {
		navegador.findElement(by).click();
	}

	public void esperaEClica(By by) {
		WebElement op = waitBasePage.until(ExpectedConditions.elementToBeClickable(by));
		op.click();
	}

	public void selectCampo(By by, String valor) {
		WebElement campoType = navegador.findElement(by);
		new Select(campoType).selectByVisibleText(valor);

	}
	
	public String pegarTexto(By by) {
		WebElement texto = waitBasePage.until(ExpectedConditions.elementToBeClickable(by));
		return texto.getText();
	}

	public void selecionaDataInformada(String valor, By byIconeCalendario) {
		Calendar cal = Calendar.getInstance();
		DataConverter dtc = new DataConverter();
		cal.setTime(dtc.transform(valor));
		int calAno = cal.get(Calendar.YEAR);
		int contadorMeses = 0;
		String mesAnoInformado = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH) + " " + calAno;

		esperaEClica(byIconeCalendario);

		do {

			int anoCompomente = Integer.parseInt(
					pegarTexto(By.xpath("//div[@id='ui-datepicker-div']/div/div//span[@class='ui-datepicker-year']")));

			if (calAno < anoCompomente) {
				clicar(By.xpath("//div[@id='ui-datepicker-div']/div/a[@title='Prev']"));
			} else if (calAno > anoCompomente) {
				clicar(By.xpath("//div[@id='ui-datepicker-div']/div/a[@title='Next']"));
			} else {

				if (contadorMeses < 12) {
					if (pegarTexto(
							By.xpath("//div[@id='ui-datepicker-div']/div/div//span[@class='ui-datepicker-month']"))
									.equals("January")) {
						contadorMeses += 12;
					} else {
						clicar(By.xpath("//div[@id='ui-datepicker-div']/div/a[@title='Prev']"));
					}

				} else {
					clicar(By.xpath("//div[@id='ui-datepicker-div']/div/a[@title='Next']"));

				}

			}

		} while (!mesAnoInformado
				.equals(pegarTexto(By.xpath("//div[@id='ui-datepicker-div']/div/div[@class='ui-datepicker-title']"))));

		esperaEClica(By.xpath(
				"//div[@id='ui-datepicker-div']/table//a[contains(text(),'" + cal.get(Calendar.DAY_OF_MONTH) + "')]"));

	}

}
