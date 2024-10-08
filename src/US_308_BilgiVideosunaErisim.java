import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class US_308_BilgiVideosunaErisim extends BaseDriver {
    @Test
    public void Test1() throws AWTException {
        driver.get("https://www.e-junkie.com/");

        Robot rbt=new Robot();
        driver.switchTo().window(driver.getWindowHandle());

        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);

        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        WebElement buttonHowItsWork=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@onclick='toggleYoutubeModal(true)']")));
        buttonHowItsWork.click();

        System.out.println("driver.getCurrentUrl().equalsIgnoreCase(https://www.e-junkie.com/) = "
                + driver.getCurrentUrl().equalsIgnoreCase("https://www.e-junkie.com/"));

        WebElement iframe= driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/kODFTdj9Ifc']"));
        driver.switchTo().frame(iframe);

        WebElement mediaPlayerButton= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        mediaPlayerButton.click();
        MyFunc.Bekle(10);

        driver.switchTo().defaultContent();
        WebElement closeButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='modal-close is-large']")));
        js.executeScript("arguments[0].click();", closeButton);
        driver.close();
    }
}