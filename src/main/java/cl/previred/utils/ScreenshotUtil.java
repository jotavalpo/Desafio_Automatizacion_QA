package cl.previred.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String stepName) {
        // Obtener la captura de pantalla como un archivo
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Crear el nombre del archivo con la fecha y nombre del step
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotName = stepName + "_" + timestamp + ".png";

        // Especificar la ruta para guardar la captura de pantalla
        File destinationFile = new File("target/screenshots/" + screenshotName);

        try {
            // Guardar la captura de pantalla en la ruta especificada
            FileUtils.copyFile(screenshot, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
