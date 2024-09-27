import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

public class US_305_OdemeIslemiOnayVeIndirme extends BaseDriver {

    @Test
    public void Us_304() throws AWTException {

        driver.get("https://shopdemo.fatfreeshop.com/?");

        Actions aksiyonlar = new Actions(driver);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='/product/1595015/Demo-eBook']")));
        WebElement demoEbook = driver.findElement(By.cssSelector("[href='/product/1595015/Demo-eBook']"));
        demoEbook.click();

        WebElement scrollTo = driver.findElement(By.className("g_btn"));
        aksiyonlar.scrollToElement(scrollTo).build().perform();
        scrollTo.click();

        WebElement iframe = driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-option='CC']")));
        WebElement creditCard = driver.findElement(By.cssSelector("[data-option='CC']"));
        creditCard.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Email']")));
        WebElement eMail = driver.findElement(By.cssSelector("[placeholder='Email']"));
        eMail.sendKeys("jiraaahesap@gmail.com");

        WebElement confirmEmail = driver.findElement(By.cssSelector("[placeholder='Confirm Email']"));
        confirmEmail.sendKeys("jiraaahesap@gmail.com");

        WebElement nameOnCard = driver.findElement(By.cssSelector("[placeholder='Name On Card']"));
        nameOnCard.sendKeys("Mazlum Oz");

        WebElement phone = driver.findElement(By.cssSelector("[autocomplete='phone']"));
        phone.sendKeys("05544332211");

        WebElement company = driver.findElement(By.cssSelector("[autocomplete='company']"));
        company.sendKeys("12.Fake Street apartman1, istanbul");

        WebElement orderNotes = driver.findElement(By.cssSelector("[class='BuyerNotes']> :nth-child(1)"));
        orderNotes.sendKeys("12.Fake Street apartman1, istanbul/Türkiye ");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name^='__privateStripeFrame']")));
        WebElement iframeCardNum = driver.findElement(By.cssSelector("[name^='__privateStripeFrame']"));

        driver.switchTo().frame(iframeCardNum);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='InputElement is-empty Input Input--empty'][name='cardnumber']")));
        WebElement cardNum = driver.findElement(By.cssSelector("[class='InputElement is-empty Input Input--empty'][name='cardnumber']"));
        cardNum.sendKeys("4242 4242 4242 4242");

        WebElement expiractionData = driver.findElement(By.cssSelector("[class='InputElement is-empty Input Input--empty'][name='exp-date']"));
        expiractionData.sendKeys("1224");

        WebElement cvc = driver.findElement(By.cssSelector("[class='InputElement is-empty Input Input--empty'][name='cvc']"));
        cvc.sendKeys("000");

        driver.switchTo().parentFrame();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='Opt-In']> :nth-child(2)")));
        WebElement optinBtn = driver.findElement(By.cssSelector("[class='Opt-In']> :nth-child(2)"));
        optinBtn.click();

        WebElement payBtn = driver.findElement(By.className("Pay-Button"));
        payBtn.click();

        driver.switchTo().parentFrame();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='green_text_margin']")));
        WebElement thankmsg = driver.findElement(By.cssSelector("[class='green_text_margin']"));
        Assert.assertTrue("Thank you! message was not displayed."
                , thankmsg.getText().contains("Thank you!"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='usd'])[2]")));
        WebElement siparisBilgisi = driver.findElement(By.xpath("(//span[@class='usd'])[2]"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='usd'])[1]")));
        WebElement toplamTutar = driver.findElement(By.xpath("(//span[@class='usd'])[1]"));
        js.executeScript("arguments[0].scrollIntoView()", toplamTutar);
        MyFunc.Bekle(2);

        if (toplamTutar.getText().contains(siparisBilgisi.getText())) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Download']")));
            WebElement indirButonu = driver.findElement(By.xpath("//span[text()='Download']"));
            indirButonu.click();
        } else
            System.out.println("Değerler birbiriyle aynı değil.");

        BekleKapat();

    }
}
