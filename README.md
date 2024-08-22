# Selenium Cucumber Framework - Creado por Jorge Montero Ayala

# Tecnologías usadas
* Framework creado con Maven, Selenium 4, TestNG, CucumberBDD en lenguaje Java (JDK 17.0.9)
* Optimizado para ejecutarse en IntelliJ (podría tambien funcionar en VSCode)

# Estructura

* Tiene la carpeta main que contiene los page objects, driver y utilidades usadas
* Tiene la carpeta test donde esta el runner, step definitions, features y el archivo con las credenciales usadas para el login
* Posee archivo .gitignore con las carpetas y archivos a omitir al compilar y ejecutar pruebas

# Pre-requisitos
* IntelliJ Community Edition o similar (version usada 2023.1.2)
* Tener instalado JDK 17.0.9 y variables de entorno configuradas
* Tener instalado Apache Maven (versión usada 3.9.2) y variables de entorno configuradas
* Extensiones requeridas por IntelliJ como CSVReader, entre otras

# Para ejecutar pruebas
* Ejecutar limpieza de proyecto con comandos Maven (mvn clean, mvn compile y mvn test)
* Luego abrir clase MainRunner y ejecutar el metodo "public class MainRunner extends AbstractTestNGCucumberTests", deberia tener el icono play en verde para ejecutar todos los casos de pruebas
* También se puede ejecutar cada feature y/o escenario de manera individual, esto presionando el botón de ejecucion (doble play verde en cada escenario)

# Reporte de pruebas y evidencias:

* El reporte y las evidencias se generan dinámicamente en la carpeta tarjet luego de cada ejecución
* Las evidencias de cada ejecución se almacenan en tarjet/screenshots
* El reporte de cada ejecución se genera en el archivo tarjet/test/reporte-de-prueba.html
* Se crea la carpeta src/test/resources/imagenes-con-evidencias para dejar las evidencias estáticas de la última ejecución realizada
* Quedó pendiente atachar las evidencias al reporte, pero ambos registros se encuentran en las carpetas indicadas