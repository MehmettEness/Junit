package J11_Actions_Faker;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_ActionsTest extends TestBase {

    @Test
    public void test01() {

        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım

        Actions actions = new Actions(driver);
        frameIndex(0); //testbase de oluşturduğumuz yeni obje
        WebElement dragElement = driver.findElement(By.xpath("//p[.='Drag me to my target']"));
        WebElement dropElement = driver.findElement(By.xpath("//p[.='Drop here']"));
        actions.dragAndDrop(dragElement , dropElement).perform();


    }

    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım

        Actions actions = new Actions(driver);
        frameIndex(0); //testbase de oluşturduğumuz yeni obje
        WebElement dragElement = driver.findElement(By.xpath("//p[.='Drag me to my target']"));
        WebElement dropElement = driver.findElement(By.xpath("//p[.='Drop here']"));
        actions.clickAndHold(dragElement) //drag webelementini tut ve bekle demektir.
                .moveToElement(dropElement)//drag webelemntini tutup drop webelementinin üstüne götürdü.
                .release() //basılı tuttuğumuz webelementi serbest bırakır.
                .perform();//action işleme aldık


    }
    @Test
    public void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım

        Actions actions = new Actions(driver);
        frameIndex(0); //testbase de oluşturduğumuz yeni obje
        WebElement dragElement = driver.findElement(By.xpath("//p[.='Drag me to my target']"));
        WebElement dropElement = driver.findElement(By.xpath("//p[.='Drop here']"));
        actions.clickAndHold(dragElement) //drag webelementini tut ve bekle demektir.
                .moveByOffset(186,48) //istedğimiz sayfanın konumuna bırakmaya yarar.
                .release()
                .perform();


    }
}
