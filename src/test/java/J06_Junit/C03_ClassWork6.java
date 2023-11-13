package J06_Junit;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_ClassWork6 extends TestBase {
    @Test
    public void dragDrop() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        Actions actions = new Actions(driver);
        frameIndex(0);
        WebElement drag = driver.findElement(By.xpath("//*[.='Drag me to my target']"));
        WebElement drop = driver.findElement(By.xpath("//*[.='Drop here']"));
        actions.dragAndDrop(drag , drop).perform();

        //Homework Drog webelementinin drop webelemenitinin uzerine birakildigini dogrulayin
        WebElement dropped = driver.findElement(By.xpath("//*[.='Dropped!']"));
        String expected = "Dropped!";
        String actual = dropped.getText();
        Assert.assertEquals( "expected ve actual birbirine eşit değil" ,expected , actual);
    }
}
