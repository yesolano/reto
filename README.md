#Automatización Página Despegar.com
####Por: Yenifer Solano    

###**Resumen de codificación**  
Se crea un proyecto de automatización que hace una búsqueda de tiquetes de vuelo en la página [Despegar.com](http://despegar.com) y que de los resultados de la búsqueda obtiene los 7 precios de tiquetes más económicos. Los precios son ordenados de menor a mayor y son enviados a un archivo de excel resaltando en verde el menor precio.

El proyecto Reto02 se encuentra estructurado de la siguiente manera:  

**PAQUETES:**
- **Page:**  Contiene las clases ConsultaPage.java y SelecionPage.java  
- **runners:** Contiene la clase ConsultaRuner.java  
- **steDefinitions:** Contiene la clase ConsultaStep.java
- **util:** Contiene la clase ManejoArchivos.java

**Paquete Page**
- *ConsultaPage.java:*  
Acá se especifican los métodos con los objetos de la prueba que se encuentran en la página de búsqueda.  
Ej: Objeto *Número de Pasajeros*  

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
Acá se especifican los métodos para capturar los precios de los tiquetes de vuelo y enviarlos al archivo de excel.  


**Paquete runners**
- *ConsultaRunner.java:* Esta clase es la encargada de correr las pruebas funcionales.  

```java
@RunWith(Cucumber.class)
@CucumberOptions(features = "ProjectFeatures", glue = "stepDefinitions")
public class ConsultaRunner {
}
```

**Paquete stepDefinitions**
- *ConsultaStep.java:* Aquí se especifica la definición del paso a paso a ejecutar en lenguaje java.  
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
- *ManejoArchivos.java:* Aquí se encuentran codificados los métodos necesarios para el manejo de archivo de excel. 


**Carpeta ProjecFeatures:**
- Contiene el archivo Consulta.feature en el cual se encuentra la definición de la HU y los diferentes escenarios de prueba con su respectivo set de datos.  


###Herramientas
- Lenguaje de comunicación HU: Gherkin
- Lenguaje de programación: Java
- Patrón de desarrollo: Page Object
- Framework de comunicación: Cucumber
- Framework de automatización: Selenium WebDriver
- Compilador: JUnit
- Control de versión: GIT
- Repositorio: GITHub
- Automatizador de tareas: Gradle
- Navegador: Google Chrome Versión 66.0.3359.181 (Build oficial) (64 bits)


##Conclusiones
- La automatización de pruebas funcionales reduce el esfuerzo dedicado a las pruebas en productos que se encuentran en continuo mantenimiento. Son ventajas de la automatización de pruebas funcionales: Rapidez, Fiabilidad, Repetibles, Programables, Exhaustivas, Reutilizables.


- Al momento de iniciar un proyecto/prueba automatizada es importante que primero se analice la manera de cómo se va a atacar el problema y la secuencia de pasos para la resolución del mismo.  
**Derrotero:**
  - Análisis del problema
- Elección de las herramientas y lenguaje de programación a utilizar
- Realizar la identificación de los objetos de la prueba.
- En la medida de lo posible, convertir todo a variables para que el programa sea más dinámico.
- Realizar la codificación.
- Organizar el código. Dividirlo en subprocesos, actions, funciones, librerias…
- Sincronizar el código. Esto es muy importante para evitar errores en las pruebas por falta de disponibilidad de objetos cuando se está ejecutando una prueba en tiempo real.
- Se deben manejar los errores y posibles excepciones que se puedan presentar durante la ejecución de la prueba.
- Reportar los resultados de las pruebas.






