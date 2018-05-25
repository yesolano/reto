package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import pages.ConsultaPage;
import pages.SeleccionPage;

public class ConsultaStep {

	WebDriver driver;
	ConsultaPage consultaPage;
	SeleccionPage seleccionPage;

	String urlPage = "https://www.despegar.com.co";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		consultaPage = new ConsultaPage(driver);
		seleccionPage = new SeleccionPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("el usuario esta en la pagina Despegar")
	public void usuarioEstaEnPaginaDespegar() {
		driver.get(urlPage);
		consultaPage.popUp();
	}

	@When("el usuario selecciona el menu vuelos")
	public void usuarioSeleccionaMenuVuelos() {
		consultaPage.btnVuelos();
	}

	@And("el usuario ingresa el tipo de vuelo")
	public void usuarioIngresaTipoVuelo() {
		consultaPage.rbTipoVuelo();
	}

	@And("^el usuario ingresa el origen \"(.*)\"$")
	public void usuarioIngresaOrigen(String ciudadOrigen) throws InterruptedException {
		consultaPage.txtOrigen(ciudadOrigen);
	}

	@And("^el usuario ingresa el destino \"(.*)\"$")
	public void usuarioIngresaDestino(String ciudadDestino) throws InterruptedException {
		consultaPage.txtDestino(ciudadDestino);
	}

	@And("^el usuario selecciona fecha partida \"(.*)\"$")
	public void usuarioSeleccionaFechaPartida(String fechaPartida) {
		consultaPage.txtFechaPartida(fechaPartida);
	}

	@And("^el usuario selecciona fecha de regreso \"(.*)\"$")
	public void usuarioSeleccionaFechaRegreso(String fechaRegreso) throws InterruptedException {
		consultaPage.txtFechaRegreso(fechaRegreso);
	}

	@And("^el usuario selecciona el numero de pasajeros \"(.*)\"$")
	public void usuarioSeleccionaNumeroPasajeros(int numeroPasajeros) {
		consultaPage.txtPasajeros(numeroPasajeros);
	}

	@And("el usuario presiona boton buscar")
	public void usuarioPresionaBoton() {
		consultaPage.btnBuscar();
	}

	@And("el usuario esta en la pagina de resultado de vuelos")
	public void usuarioEstaEnPaginaDeResultados() {
		String result = consultaPage.verificaPage();
		assertEquals("Despegar.com . Resultados de Vuelos", result);
	}

	@And("se seleccionan y ordenan los precios de vuelos")
	public void seleccionarLosPreciosMasBaratos() throws InterruptedException {
		seleccionPage.losMasBaratos();
	}

	@Then("Se exportan los precios a un archivo excel")
	public void exportarPreciosAExcel() {
		seleccionPage.exportarPrecios();
	}

	@Then("el usuario visualiza mensaje error ingrese ciudad destino")
	public void usuarioVeErrorCiudadDestino() throws InterruptedException {
		String msj = consultaPage.mensajeErrorDestino();
		assertEquals("Ingresa un destino", msj);
	}

	@Then("el usuario visualiza mensaje error ciudades iguales")
	public void usuarioVeErrorCiudadesIguales() throws InterruptedException {
		String msj = consultaPage.mensajeErrorCiudadIgual();
		assertEquals("El destino debe ser diferente del origen", msj);
	}
	
	@Then("Se muestra mensaje de error fecha regreso menor")
	public void mensajeErrorFechas() {
		consultaPage.mensajeErrorFechaRegresoMenor();
	}

}
