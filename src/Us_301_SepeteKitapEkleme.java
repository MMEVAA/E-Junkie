import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Us_301_SepeteKitapEkleme extends BaseDriver {

    @Test
    public void test1() {

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement eBook = driver.findElement(By.linkText("Ebook"));
        eBook.click();

        WebElement eBookAddToCart = driver.findElement(By.xpath("//button[@class='view_product']"));
        eBookAddToCart.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));
        driver.switchTo().frame(iframe);

        WebElement addPromoCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Apply-Button Show-Promo-Code-Button']")));
        addPromoCode.click();

        WebElement promoCodeButton = driver.findElement(By.className("Promo-Code-Value"));
        promoCodeButton.sendKeys("Promo Code");

        WebElement applyPromoCode = driver.findElement(By.xpath("//button[@class='Promo-Apply']"));
        applyPromoCode.click();

        WebElement verificationMessage = driver.findElement(By.xpath("//span[text()='Invalid promo code']"));

        Assert.assertEquals(verificationMessage.getText(), "Invalid promo code");

        waitAndClose();
    }
}
