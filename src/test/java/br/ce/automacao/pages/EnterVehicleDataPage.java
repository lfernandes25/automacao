package br.ce.automacao.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterVehicleDataPage extends BasePage {


	public EnterVehicleDataPage(WebDriver navegador) {
		super(navegador);
	}

	public EnterVehicleDataPage escolheMake(String tipo) {
		selectCampo(By.id("make"), tipo);
		return this;
	}

	public EnterVehicleDataPage escolheModel(String tipo) {
		selectCampo(By.id("model"), tipo);
		return this;
	}

	public EnterVehicleDataPage escreveCylinderCapacity(String cylinder) {
		escreveCampo(By.id("cylindercapacity"),cylinder);
		return this;

	}

	public EnterVehicleDataPage escreveEnginePerformance(String enginer) {
		escreveCampo(By.id("engineperformance"),enginer);
		return this;

	}

	public EnterVehicleDataPage informaData(String data) {
		escreveCampo(By.id("dateofmanufacture"),data);
		return this;
	}

	public EnterVehicleDataPage escolheDataComponente(String data) {
		selecionaDataInformada(data, By.id("opendateofmanufacturecalender"));
		return this;

	}

	public EnterVehicleDataPage clicarCompomenteData() {
		clicar(By.id("opendateofmanufacturecalender"));
		return this;
	}

	public EnterVehicleDataPage escolheNumberOfSeats(String tipo) {
		selectCampo(By.id("numberofseats"), tipo);
		return this;
	}

	public EnterVehicleDataPage clicaRightHandDrive(String opcao) {
		switch (opcao.toUpperCase()) {
		case "YES":
			clicar(By.xpath("//*[@id='righthanddriveyes']/ancestor::label/span"));
			break;
		case "NO":
			clicar(By.xpath("//*[@id='righthanddriveno']/ancestor::label/span"));
			break;
		default:
			throw new IllegalArgumentException(
					"Ocupaçãp informada e invalida, informe umas das opcoes: YER ou NO");
		}
		
		return this;
	}

	public EnterVehicleDataPage selecionarNumberOfSeatsMotorCycle(String valor) {
		selectCampo(By.id("numberofseatsmotorcycle"), valor);
		return this;
	}

	public EnterVehicleDataPage selecionarFuelType(String valor) {
		selectCampo(By.id("fuel"), valor);
		return this;
	}

	public EnterVehicleDataPage escrevePayloadKg(String valor) {
		escreveCampo(By.id("payload"), valor);
		return this;
	}
	
	public EnterVehicleDataPage escreveTotalWeightKg(String valor) {
		escreveCampo(By.id("totalweight"), valor);
		return this;
	}
	
	public EnterVehicleDataPage escreveListPrice(String valor) {
		escreveCampo(By.id("listprice"),valor);
		return this;
	}
	
	public EnterVehicleDataPage escreveLicensePlateNumber(String valor) {
		escreveCampo(By.id("licenseplatenumber"),valor);
		return this;
	}
	
	public EnterVehicleDataPage escreveAnnualMileage(String valor) {
		escreveCampo(By.id("annualmileage"),valor);
		return this;
	}
	
	public EnterInsurantDataPage buttonNext() {
		clicar(By.id("nextenterinsurantdata"));
		return new EnterInsurantDataPage(navegador);
	}

}
