import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Us_303_Debit_KrediKartıBasarısızOdeme extends BaseDriver {
@Test
    public void Test1(){

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
    nameOnCard.sendKeys("Ali Veli");



    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name^='__privateStripeFrame']")));
    WebElement iframeCardNum = driver.findElement(By.cssSelector("[name^='__privateStripeFrame']"));
    driver.switchTo().frame(iframeCardNum);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='cardnumber']")));
    WebElement cardNum = driver.findElement(By.cssSelector("[name='cardnumber']"));
    cardNum.sendKeys("1111 1111 1111 1111");

    driver.switchTo().parentFrame();

    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='Opt-In'] > :nth-child(2)")));
    WebElement optinBtn = driver.findElement(By.cssSelector("[class='Opt-In'] > :nth-child(2)"));
    optinBtn.click();

    WebElement payBtn = driver.findElement(By.className("Pay-Button"));
    payBtn.click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Kart numaranız geçersiz.']")));
    WebElement kartnoGecersiz=driver.findElement(By.xpath("//*[text()='Kart numaranız geçersiz.']"));

Assert.assertTrue("Beklen mesaj bulunamadı.", kartnoGecersiz.getText().contains("Kart numaranız geçersiz."));

    BekleKapat();
}
}