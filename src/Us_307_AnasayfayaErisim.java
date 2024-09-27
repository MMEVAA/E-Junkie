import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Us_307_AnasayfayaErisim extends BaseDriver {
    @Test
    public void Test1(){
        driver.get("https://shopdemo.fatfreeshop.com/?");

        WebElement homepageTitle=driver.findElement(By.xpath("//span[text()='Example E-junkie Shop']"));
        System.out.println("homepageTitle.getText() = " + homepageTitle.getText());

        WebElement linkText=driver.findElement(By.linkText("E-commerce by E-junkie"));
        js.executeScript("arguments[0].scrollIntoView()",linkText);

        wait.until(ExpectedConditions.elementToBeClickable(linkText));
        linkText.click();

        WebElement homepageLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/wiki/user/themes/Wiki/images/logo.svg?123']")));
        homepageLogo.click();

        //Written to check the true URL
        System.out.println(driver.getCurrentUrl().equals("https://www.e-junkie.com/"));

        //if URL is wrong, given error message
        Assert.assertTrue("Unexpected Page",driver.getCurrentUrl().equals("https://www.e-junkie.com/"));

        driver.close();
    }
}
