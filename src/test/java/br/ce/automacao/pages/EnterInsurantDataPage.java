package br.ce.automacao.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterInsurantDataPage extends BasePage {

	public EnterInsurantDataPage(WebDriver navegador) {
		super(navegador);
	}

	public EnterInsurantDataPage escreveFirstName(String valor) {
		escreveCampo(By.id("firstname"), valor);
		return this;
	}

	public EnterInsurantDataPage escreveLastName(String valor) {
		escreveCampo(By.id("lastname"), valor);
		return this;
	}

	public EnterInsurantDataPage clicarCompomenteData() {
		clicar(By.id("opendateofmanufacturecalender"));
		return this;
	}

	public EnterInsurantDataPage selecionaData(String valor) {
		selecionaDataInformada(valor, By.id("opendateofbirthcalender"));
		return this;
	}

	public EnterInsurantDataPage clicaGender(String opcao) {
		if (opcao.toUpperCase().equals("MALE")) {
			clicar(By.xpath("//form[@id='insurance-form']/div/section[2]/div[4]/p/label[1]/span"));
		} else if (opcao.toUpperCase().equals("FEMALE")) {
			clicar(By.xpath("//form[@id='insurance-form']/div/section[2]/div[4]/p/label[2]/span"));
		} else {

		}

		return this;
	}

	public EnterInsurantDataPage escreveStreetAddress(String valor) {
		escreveCampo(By.id("streetaddress"), valor);
		return this;
	}

	public EnterInsurantDataPage selecionaCountry(String valor) {
		selectCampo(By.id("country"), valor);
		return this;
	}

	public EnterInsurantDataPage escreveZipCode(String valor) {
		escreveCampo(By.id("zipcode"), valor);
		return this;
	}

	public EnterInsurantDataPage escreveCity(String valor) {
		escreveCampo(By.id("city"), valor);
		return this;
	}

	public EnterInsurantDataPage selecionaOccupation(String valor) {
		selectCampo(By.id("occupation"), valor);
		return this;
	}

	public EnterInsurantDataPage checkboxHobbies(String valor) {
		switch (valor.toUpperCase()) {
		case "SPEEDING":
			clicar(By.xpath("//*[@id='speeding']/ancestor::label/span"));
			break;
		case "BUNGEE JUMPING":
			clicar(By.xpath("//*[@id='bungeejumping']/ancestor::label/span"));
			break;
		case "CLIFF DIVING":
			clicar(By.xpath("//*[@id='cliffdiving']/ancestor::label/span"));
			break;
		case "SKYDIVING":
			clicar(By.xpath("//*[@id='skydiving']/ancestor::label/span"));
			break;
		case "OTHER":
			clicar(By.xpath("//*[@id='other']/ancestor::label/span"));
			break;
		case "ALL":
			clicar(By.xpath("//*[@id='speeding']/ancestor::label/span"));
			clicar(By.xpath("//*[@id='bungeejumping']/ancestor::label/span"));
			clicar(By.xpath("//*[@id='cliffdiving']/ancestor::label/span"));
			clicar(By.xpath("//*[@id='skydiving']/ancestor::label/span"));
			clicar(By.xpath("//*[@id='other']/ancestor::label/span"));
			break;

		default:
			throw new IllegalArgumentException(
					"Ocupaçãp informada e invalida, informe umas das opcoes: SPEEDING, BUNGEE JUMPING, CLIFF DIVING, SKYDIVING, OTHER ou ALL");
		}

		return this;
	}
	
	public EnterInsurantDataPage escreveWebSite(String valor) {
		escreveCampo(By.id("website"), valor);
		return this;
	}

}
