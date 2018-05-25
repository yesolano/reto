#Automatizaci�n P�gina Despegar.com
####Por: Yenifer Solano    

###**Resumen de codificaci�n**  
Se crea un proyecto de automatizaci�n que hace una b�squeda de tiquetes de vuelo en la p�gina [Despegar.com](http://despegar.com) y que de los resultados de la b�squeda obtiene los 7 precios de tiquetes m�s econ�micos. Los precios son ordenados de menor a mayor y son enviados a un archivo de excel resaltando en verde el menor precio.

El proyecto Reto02 se encuentra estructurado de la siguiente manera:  

**PAQUETES:**
- **Page:**  Contiene las clases ConsultaPage.java y SelecionPage.java  
- **runners:** Contiene la clase ConsultaRuner.java  
- **steDefinitions:** Contiene la clase ConsultaStep.java
- **util:** Contiene la clase ManejoArchivos.java

**Paquete Page**
- *ConsultaPage.java:*  
Ac� se especifican los m�todos con los objetos de la prueba que se encuentran en la p�gina de b�squeda.  
Ej: Objeto *N�mero de Pasajeros*  

```java

	public void txtPasajeros(int numeroPasajeros) {

		WebElement txtPasajero = driver.findElement(By.xpath("//*[@id=\'searchbox-sbox-all-boxes\']/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[2]/div[6]/div[2]"));
		txtPasajero.click();
		WebElement btnSumPas = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]"));
		for (int i = 1; i < numeroPasajeros; i++) {
			btnSumPas.click();
		}
	}
```

- *SeleccionPage.java:*  
Ac� se especifican los m�todos para capturar los precios de los tiquetes de vuelo y enviarlos al archivo de excel.  


**Paquete runners**
- *ConsultaRunner.java:* Esta clase es la encargada de correr las pruebas funcionales.  

```java
@RunWith(Cucumber.class)
@CucumberOptions(features = "ProjectFeatures", glue = "stepDefinitions")
public class ConsultaRunner {
}
```

**Paquete stepDefinitions**
- *ConsultaStep.java:* Aqu� se especifica la definici�n del paso a paso a ejecutar en lenguaje java.  
Se instancia las Pages y el webdriver a utilizar. 

```java
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		consultaPage = new ConsultaPage(driver);
		seleccionPage = new SeleccionPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
```

**Paquete Util**
- *ManejoArchivos.java:* Aqu� se encuentran codificados los m�todos necesarios para el manejo de archivo de excel. 


**Carpeta ProjecFeatures:**
- Contiene el archivo Consulta.feature en el cual se encuentra la definici�n de la HU y los diferentes escenarios de prueba con su respectivo set de datos.  


###Herramientas
- Lenguaje de comunicaci�n HU: Gherkin
- Lenguaje de programaci�n: Java
- Patr�n de desarrollo: Page Object
- Framework de comunicaci�n: Cucumber
- Framework de automatizaci�n: Selenium WebDriver
- Compilador: JUnit
- Control de versi�n: GIT
- Repositorio: GITHub
- Automatizador de tareas: Gradle
- Navegador: Google Chrome Versi�n 66.0.3359.181 (Build oficial) (64 bits)


##Conclusiones
- La automatizaci�n de pruebas funcionales reduce el esfuerzo dedicado a las pruebas en productos que se encuentran en continuo mantenimiento. Son ventajas de la automatizaci�n de pruebas funcionales: Rapidez, Fiabilidad, Repetibles, Programables, Exhaustivas, Reutilizables.


- Al momento de iniciar un proyecto/prueba automatizada es importante que primero se analice la manera de c�mo se va a atacar el problema y la secuencia de pasos para la resoluci�n del mismo.  
**Derrotero:**
  - An�lisis del problema
- Elecci�n de las herramientas y lenguaje de programaci�n a utilizar
- Realizar la identificaci�n de los objetos de la prueba.
- En la medida de lo posible, convertir todo a variables para que el programa sea m�s din�mico.
- Realizar la codificaci�n.
- Organizar el c�digo. Dividirlo en subprocesos, actions, funciones, librerias�
- Sincronizar el c�digo. Esto es muy importante para evitar errores en las pruebas por falta de disponibilidad de objetos cuando se est� ejecutando una prueba en tiempo real.
- Se deben manejar los errores y posibles excepciones que se puedan presentar durante la ejecuci�n de la prueba.
- Reportar los resultados de las pruebas.






