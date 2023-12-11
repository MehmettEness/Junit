package practice;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class screenShoot extends TestBase {

    @Test
    public void testtt() {

        String date = DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss").format(LocalDateTime.now());
        driver.get("https://www.kamrusepa.com");
        String yol = "src/test/java/screenShots/" + date + "kamrusepa.jpeg";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(yol), takesScreenshot.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void adidas() throws IOException {

        String date = DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss").format(LocalDateTime.now());
        driver.get("https://adidas.com");
        String yol = "src/test/java/screenShots/" + date + "adidas.jpeg";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Files.write(Paths.get(yol), takesScreenshot.getScreenshotAs(OutputType.BYTES));

    }

    @Test
    public void gudul() throws IOException {

        String date = DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss").format(LocalDateTime.now());
        driver.get("https://google.com");
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("güdül" , Keys.ENTER);
        String yol = "src/test/java/screenShots/" + date + "güdülAramaSonucu.jpeg";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Files.write(Paths.get(yol), takesScreenshot.getScreenshotAs(OutputType.BYTES));

    }

    @Test
    public void gudul2() {
        driver.get("https://google.com");
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("güdül" , Keys.ENTER);
        screenShot("güdül2");
        WebElement element = driver.findElement(By.xpath("//div[@class='SDkEP']"));
        screenShotOfWebElement(element , "güdülaramasonucu");

    }
}
