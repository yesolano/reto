package pages;

import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import util.ManejoArchivos;

public class SeleccionPage {

	WebDriver driver;
	private int[] vecPrecios;

	public SeleccionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void losMasBaratos() throws InterruptedException {
		
		Thread.sleep(5000);
		List<WebElement> bloquePrecios = driver.findElements(By.cssSelector("fare.fare-couchmark-tooltip.fare-box-container.product-NONE"));
		int cantPrecios = bloquePrecios.size();
		vecPrecios = new int[cantPrecios];
		System.out.println("Cantidad de precios capturados: " + cantPrecios);

			for(int i=1; i<=vecPrecios.length;i++) {
				WebElement elementPrecio = driver.findElement(By.xpath("//*[@id=\'clusters\']/span["+ i + "]/span/cluster/div/div/span/fare/span/span/main-fare/span/span[2]/flights-price/span/flights-price-element/span/span/em/span[2]"));
				String precio = elementPrecio.getText();
				
				precio = precio.replace(".", "");
				int iPrecio = Integer.parseInt(precio);
				vecPrecios[i-1] = iPrecio;
			}
			//Ordenar los precios de menor a mayor
			for(int j=0;j<vecPrecios.length;j++) {
	            for(int k=0;k<vecPrecios.length -k;k++) {
	                if (vecPrecios[k]>vecPrecios[k+1]) {
	                    int aux;
	                    aux=vecPrecios[k];
	                    vecPrecios[k]=vecPrecios[k+1];
	                    vecPrecios[k+1]=aux;
	                }
	            }
	        }
			
	        for(int f=0;f<vecPrecios.length;f++) {
	            System.out.println(vecPrecios[f]);
	        }
	        
	        
	    
	}

	public void exportarPrecios() {
		
		int j=0;
		String strPrecio = "";
		
		System.out.println("-------------------------");
        ManejoArchivos manejoArchivos=new ManejoArchivos();
        manejoArchivos.setNombreArchivo("Reto2.xls");
        manejoArchivos.setNombreHoja("Precios Despegar");
        manejoArchivos.leerArchivo();
        for(int i=0;i<vecPrecios.length;i++) {
        	int intPrecio = vecPrecios[i];
        	strPrecio = String.valueOf(intPrecio);
        	System.out.println(strPrecio);
        	manejoArchivos.setValorCelda(0, j, "Precio"+(i+1));
        	manejoArchivos.setValorCelda(1, j, strPrecio);
        	if(i==0) {
  
        	}
    	j++;
        }
    	manejoArchivos.fnvGuardarArchivoExcel();
	}

}
