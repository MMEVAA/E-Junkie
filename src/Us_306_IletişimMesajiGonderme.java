import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Us_306_IletişimMesajiGonderme extends BaseDriver {

    @Test
    public void US_306(){

        driver.get("https://shopdemo.fatfreeshop.com/?");

        WebElement contactUs=driver.findElement(By.className("ion-md-mail"));
        contactUs.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sender_name")));
        WebElement name=driver.findElement(By.id("sender_name"));
        name.sendKeys("Mazlum Oz");

        WebElement email=driver.findElement(By.id("sender_email"));
        email.sendKeys("jiraaahesap@gmail.com");

        WebElement subject=driver.findElement(By.id("sender_subject"));
        subject.sendKeys("DemoEbook");

        WebElement message=driver.findElement(By.id("sender_message"));
        message.sendKeys("sipariş bilgilerim");

        driver.switchTo().frame(0);
        WebElement reCaptcha=driver.findElement(By.className("recaptcha-checkbox-border"));
        reCaptcha.click();


        driver.switchTo().defaultContent();


        WebElement sendMessageBtn=driver.findElement(By.id("send_message_button"));
        sendMessageBtn.click();
        sendMessageBtn.click();

        wait.until(ExpectedConditions.alertIsPresent());
        String uyariMsj=driver.switchTo().alert().getText();


        Assert.assertTrue("Mesaj bulunamadı", uyariMsj.contains("Recaptcha didn't match"));

        BekleKapat();

    }
}
