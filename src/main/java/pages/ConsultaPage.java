package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConsultaPage {

	WebDriver driver;
	private int mesDeseadoP = 0;

	public ConsultaPage(WebDriver driver) {

		this.driver = driver;
	}

	public void popUp() {

		WebElement windowPopUp = driver.findElement(By.xpath("/html/body/div[16]/div/div[1]/span"));
		boolean window = windowPopUp.isDisplayed();
		if (window) {
			windowPopUp.click();
		}
		driver.manage().window().maximize();
	}

	public void btnVuelos() {

		WebElement btnVuelos = driver.findElement(By.className("nevo-icon-flights"));
		btnVuelos.click();
	}

	public void rbTipoVuelo() {

		WebElement rbTipoVuelo = driver.findElement(By.xpath("//*[contains(text(),'Ida y vuelta')]"));
		rbTipoVuelo.click();
	}

	public void txtOrigen(String ciudadOrigen) throws InterruptedException {

		WebElement txtOrigen = driver.findElement(By.xpath("//input[contains(@placeholder, 'Ingresa desde dónde viajas')]"));
		txtOrigen.clear();
		txtOrigen.sendKeys(ciudadOrigen);
		Thread.sleep(1000);
		txtOrigen.sendKeys(Keys.ENTER);
	}

	public void txtDestino(String ciudadDestino) throws InterruptedException {

		WebElement txtDestino = driver.findElement(By.xpath("//input[contains(@placeholder, 'Ingresa hacia dónde viajas')]"));
		txtDestino.clear();
		txtDestino.sendKeys(ciudadDestino);
		Thread.sleep(1000);
		txtDestino.sendKeys(Keys.ENTER);
	}

	public void txtPasajeros(int numeroPasajeros) {

		WebElement txtPasajero = driver.findElement(By.xpath("//*[@id=\'searchbox-sbox-all-boxes\']/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[2]/div[6]/div[2]"));
		txtPasajero.click();
		WebElement btnSumPas = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]"));
		for (int i = 1; i < numeroPasajeros; i++) {
			btnSumPas.click();
		}
	}

	public void txtFechaPartida(String fechaPartida) {

		// Capturo la fecha actual
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		String string1 = date1;
		String[] fechaAct = string1.split("/");
		String sMesAct = fechaAct[1];
		int mesActual = Integer.parseInt(sMesAct);

		// Convirto la fecha que me entregan
		String string = fechaPartida;
		String[] fecha = string.split("/");
		String sDia = fecha[0];
		String sMes = fecha[1];
		int diaDeseadoP = Integer.parseInt(sDia);
		mesDeseadoP = Integer.parseInt(sMes);

		// Para sacar el mes paramétrico
		int difMes = mesDeseadoP - mesActual;
		int mes = difMes + 1;

		WebElement xCalendarioP = driver.findElement(By.xpath("//*[@id=\'searchbox-sbox-all-boxes\']/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]"));
		WebElement xSigMesP = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/i"));
		xCalendarioP.click();
		for (int i = mesActual; i < mesDeseadoP; i++) {
			xSigMesP.click();
		}
		WebElement xDiaP = driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div[" + mes + "]/div[4]/span[" + diaDeseadoP + "]"));
		xDiaP.click();
	}

	public void txtFechaRegreso(String fechaRegreso) throws InterruptedException {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		String string1 = date1;
		String[] fechaAct = string1.split("/");
		String sMesAct = fechaAct[1];
		int mesActual = Integer.parseInt(sMesAct);

		Thread.sleep(1000);
		String stringR = fechaRegreso;
		String[] fechaR = stringR.split("/");
		String diaR = fechaR[0];
		String mesR = fechaR[1];

		int diaDeseadoR = Integer.parseInt(diaR);
		int mesDeseadoR = Integer.parseInt(mesR);

		int difMes = mesDeseadoR - mesDeseadoP;
		int mes = difMes + mesActual;

		WebElement xSigMesR = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/i"));

		if (mesDeseadoP < mesDeseadoR) {
			for (int i = mesDeseadoP; i < mesDeseadoR; i++) {
				xSigMesR.click();
			}
		}
		WebElement xDiaR = driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div[" + mes + "]/div[4]/span[" + diaDeseadoR + "]"));
		xDiaR.click();
	}

	public void btnBuscar() {

		WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\'searchbox-sbox-all-boxes\']/div/div/div/div[3]/div[2]/div[4]/div/a"));
		boolean bBusca = btnBuscar.isDisplayed();
		if (bBusca) {
			btnBuscar.click();
		}
	}

	public String verificaPage() {
		return driver.getTitle();
	}

	public String mensajeErrorDestino() throws InterruptedException {

		WebElement msjDestino = driver.findElement(By.cssSelector("span.validation-msg.sbox-bind-show-error-tooltip-segment-1-destination-empty"));
		Thread.sleep(1000);
		return msjDestino.getText();
	}

	public String mensajeErrorCiudadIgual() throws InterruptedException {
		WebElement msjCiudades = driver.findElement(By.cssSelector("span.validation-msg.sbox-bind-show-error-tooltip-segment-1-equal-destination"));
		Thread.sleep(1000);
		return msjCiudades.getText();
	}

}
