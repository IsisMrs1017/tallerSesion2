package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;

public class WhenDoTallerDomiciliario2Test {

    String titulo = "Tarea02_"+new Date().getTime();
    String nota ;
    Integer cuenta = 1;

    AppiumDriver android;

    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "Pixel XL API 28");
        capabilities.setCapability("appium:platformVersion", "9.0");
        capabilities.setCapability("appium:appPackage", "com.vrproductiveapps.whendo");
        capabilities.setCapability("appium:appActivity", "com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "uiautomator2");
        android = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        android.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void createATask() throws InterruptedException {

        while ( cuenta < 20) {

            // Nueva Nota
            android.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.vrproductiveapps.whendo:id/fab\"]")).click();
            //Titulo
            android.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.vrproductiveapps.whendo:id/noteTextTitle\"]")).sendKeys(titulo);
            //Notaß
            nota =  "NOTA" + Integer.toString(cuenta);
            android.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.vrproductiveapps.whendo:id/noteTextNotes\"]")).sendKeys(nota) ;
            //Guardar
            android.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Save\"]")).click();
            // verification
            cuenta++;
        }
        // click menu
        android.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).

                click();
        //android.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu\"]")).click();

        //Verificar cuantos se registraron
        android.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"com.vrproductiveapps.whendo:id/design_menu_item_text\" and @text=\"My List\"]\n")).click();
        // verification si el logout es mostrado
        //Assertions.assertTrue(android.findElement(By.xpath("//android.widget.TextView[@text=\"Logout\"]")).isDisplayed(),"ERROR! no se pudo iniciar sesion");
    }


@AfterEach
public void closeApp() {
    android.quit();
}}
