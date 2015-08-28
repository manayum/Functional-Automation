package com.cnn;

import baseApi.Base;
import org.testng.annotations.Test;

/**
 * Created by MAN on 26/08/2015.
 */
public class CnnWebPage extends Base
{
    @Test
    public void CnnHomePage()
    {
        System.out.println(driver.getCurrentUrl());
    }
}
