package practice;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action02 extends TestBase {
    @Test
    public void test01() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        waitForSecond(3);
        actions.dragAndDrop(drag , drop).perform();
        waitForSecond(3);

    }

    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.clickAndHold(drag).moveToElement(drop).release().perform();


    }

    @Test
    public void test03() {
        //Google anasayfasına gidelim
        driver.get("https://www.google.com");
        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement searchBox= driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys(Keys.SHIFT , "selenium" ,"  " +  Keys.SHIFT , "java" , Keys.ENTER);

    }
}
