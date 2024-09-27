import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_302 extends BaseDriver {

    @Test
    public void Test1()
    {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCart=driver.findElement(By.xpath("(//i[@class='ion-ios-cart cart_icon'])[2]"));
        addToCart.click();

        WebElement IFrame=driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']"));

        driver.switchTo().frame(IFrame);

        WebElement eBookText=driver.findElement(By.xpath("//div[@class='Col2 Product-Desc']"));
        Assert.assertTrue("Demo eBook sepete eklenemedi.",eBookText.getText().contains("Demo"));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Payment-Button CC']")));
        WebElement bankaKarti=driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        bankaKarti.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Pay-Button']")));
        WebElement odeme=driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        odeme.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Invalid Email']")));
        WebElement InvalidEmail=driver.findElement(By.xpath("//*[text()='Invalid Email']"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Invalid Billing Name']")));
        WebElement InvalidBillingName=driver.findElement(By.xpath("//*[text()='Invalid Billing Name']"));


        Assert.assertTrue("Beklenen mesaj bulunamadı.", InvalidEmail.getText().contains("Invalid Email"));
        Assert.assertTrue("Beklenen mesaj bulunamadı." ,InvalidBillingName.getText().contains("Invalid Billing Name"));

         BekleKapat();


    }
}
