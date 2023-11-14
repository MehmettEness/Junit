package practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Frame extends TestBase {
    /*
    Bir HTML dokümanı içinde başka bir HTML dokümanı olabilir. Bu duruma iframe denir
    3 farklo şekilde locate alabiliriz;
        --driver.switchTo.frame(index)
        --driver.switchTo.frame(<iframe> tagındaki id/name)
        --driver.switchTo.frame(iframe locate)

        Tekrar ana sayfaya geçmeke içinnnnn defaultContent() iel anasayafaya gideriz.
        Bir üst iframe gemenk içinnnn Parentiframe()
     */

    @Test
    public void name() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
        String actualIframe = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();

        Assert.assertTrue(actualIframe.contains("black border"));

        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);
        WebElement appYazisi= driver.findElement(By.xpath("//*[.='Applications lists']"));
        Assert.assertEquals("Applications lists" , appYazisi.getText());

        //Son olarak sayfa başınlığında iframe yazısının olduğunu test ediniz
        driver.switchTo().parentFrame();
         WebElement iframeYazisi =driver.findElement(By.xpath("//h3"));
         Assert.assertEquals("iframe" , iframeYazisi.getText());

    }
}
