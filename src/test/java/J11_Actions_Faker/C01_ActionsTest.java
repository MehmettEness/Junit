package J11_Actions_Faker;

import Utilities.TestBase;
import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_ActionsTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.navigate().refresh();

        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        Actions actions = new Actions(driver);
        WebElement acountList = driver.findElement(By.cssSelector("#nav-link-accountList"));
        actions.moveToElement(acountList).perform();

        driver.findElement(By.xpath("//span[.='Account']")).click();

        //Acilan sayfanin Title in "Your Account" icerdigini dogrula
        String expecteddata ="Your Account";
        String actualdata = driver.getTitle();
        Thread.sleep(3000);
        Assert.assertEquals( expecteddata , actualdata);



    }
}
