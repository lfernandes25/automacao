package br.ce.automacao.steps;

import org.openqa.selenium.WebDriver;

import br.ce.automacao.pages.EnterInsurantDataPage;
import br.ce.automacao.pages.EnterVehicleDataPage;
import br.ce.automacao.suporte.BaseUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.it.Data;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;

public class AutomacaoTrincetisSteps {

	private WebDriver navegador;

	@Before
	public void setUp() {
		navegador = BaseUtils.createChrome();
	}

	@Dado("ao acessar o site da Trincetis")
	public void aoAcessarOSiteDaTrincetis() {
		navegador.get("http://sampleapp.tricentis.com/101/app.php");
	}

	@Quando("preenchido os campos na aba Enter Vehicle Data")
	public void preenchidoOsCampos(io.cucumber.datatable.DataTable dataTable) {
		new EnterVehicleDataPage(navegador).escolheMake(dataTable.cell(0, 1)).escolheModel(dataTable.cell(1, 1))
				.escreveCylinderCapacity(dataTable.cell(2, 1)).escreveEnginePerformance(dataTable.cell(3, 1))
				.escolheDataComponente(dataTable.cell(4, 1)).escolheNumberOfSeats(dataTable.cell(5, 1))
				.clicaRightHandDrive(dataTable.cell(6, 1)).selecionarNumberOfSeatsMotorCycle(dataTable.cell(7, 1))
				.selecionarFuelType(dataTable.cell(8, 1)).escrevePayloadKg(dataTable.cell(9, 1))
				.escreveTotalWeightKg(dataTable.cell(10, 1)).escreveListPrice(dataTable.cell(11, 1))
				.escreveLicensePlateNumber(dataTable.cell(12, 1)).escreveAnnualMileage(dataTable.cell(13, 1))
				.buttonNext();
	}

	@Quando("preenchido os campo na aba Enter Insurant Data")
	public void preenchidoOsCampoNaAbaEnterInsurantData(io.cucumber.datatable.DataTable dataTable) {
		new EnterInsurantDataPage(navegador).escreveFirstName(dataTable.cell(0, 1))
				.escreveLastName(dataTable.cell(1, 1)).selecionaData(dataTable.cell(2, 1))
				.clicaGender(dataTable.cell(3, 1)).escreveStreetAddress(dataTable.cell(4, 1))
				.selecionaCountry(dataTable.cell(5, 1)).escreveZipCode(dataTable.cell(6, 1))
				.escreveCity(dataTable.cell(7, 1)).selecionaOccupation(dataTable.cell(8, 1))
				.checkboxHobbies(dataTable.cell(9, 1));
	}

	@After
	public void tearDown() {
		// navegador.quit();
	}

}
