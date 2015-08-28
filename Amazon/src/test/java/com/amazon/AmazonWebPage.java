package com.amazon;

import baseApi.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by MAN on 26/08/2015.
 */
public class AmazonWebPage extends Base {
    @Test
    public void AmazonHomePage()throws InterruptedException{
        System.out.println(driver.getCurrentUrl());
        typeByCssSecector("#twotabsearchtextbox", "books");
        sleepFor(2);
        driver.findElement(By.cssSelector("#nav-subnav .nav-a")).click();
        sleepFor(1);
        List<String> list = getTextByCss("#nav-subnav .nav-a");//driver.findElements(By.cssSelector("#nav-subnav .nav-a"));
        sleepFor(1);
        displayText(list);
        for(int i=0;i<list.size();i++)
        {

            try {

                Assert.assertEquals(list.get(i), list.get(i));
                driver.findElement(By.linkText(list.get(i))).click();
            }
            catch(Throwable e){

                driver.navigate().back();
                driver.findElement(By.linkText(list.get(i))).click();
            }
        }


        sleepFor(1);



    }
}