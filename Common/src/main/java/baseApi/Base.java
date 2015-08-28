package baseApi;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by MAN on 26/08/2015.
 */
public class Base
{
    public WebDriver driver;

    @Parameters({"url"})
    @BeforeMethod
    public void setUp(String url)
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to(url);
        
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void cleanUp()
    {
        driver.quit();
    }
    public void typeByCssSecector(String locator,String value)
    {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }
    public void sleepFor(int second)throws InterruptedException
    {
       Thread.sleep(second * 1000);
    }

    public List<String> getTextByCss(String locator)
    {
        List<WebElement> element = driver.findElements(By.cssSelector(locator));
        List<String> text = new ArrayList<String>();
        for(WebElement st:element)
        {
            text.add(st.getText());

        }
        return text;
    }
    public void displayText(List<String> text)
    {
        for(String st:text)
        {
            System.out.println(st);
        }

    }
}
