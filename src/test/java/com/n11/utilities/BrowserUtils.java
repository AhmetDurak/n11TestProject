package com.n11.utilities;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
 *This is the class, which we're going to store reusable methods to use in our projects
 *All methods are static, so you don't need to create an object, but it uses some memory!
 *You can add and create any method for reusing
 */
public class BrowserUtils {

    public static void sleep(int second){
        try {
            Thread.sleep(second*1000);
        }catch (InterruptedException ignored){}
    }

    /*
    * This method accepts 2 arguments.
    * Arg1: expectedInUrl : for verify if the url contains given String
        - if condition matches, will break loop.
    * Arg2: expectedTitle to be compared against actualTitle
    */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){
        Set<String> allWindows = Driver.get().getWindowHandles();

        for (String each: allWindows){
            Driver.get().switchTo().window(each);
            //System.out.println("Current URL: " + Driver.get().getCurrentUrl());
            if (Driver.get().getCurrentUrl().contains(expectedInUrl))break;
        }
        String actualTitle = Driver.get().getTitle();
        //System.out.println("Actual Title = " + actualTitle);

        Assert.assertTrue(actualTitle.toLowerCase().contains(expectedTitle.toLowerCase()));
    }

    // This method accepts  a String  "expectedTitle" and asserts if it is true
    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.get().getTitle(), expectedTitle);
    }


    // These two methods are for test cases of the task in day 7
    public static void crm_login(){
        Driver.get().get("http://login1.nextbasecrm.com/ ");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement username = Driver.get().findElement(new By.ByCssSelector("input[name='USER_LOGIN']"));
        WebElement password = Driver.get().findElement(new By.ByCssSelector("input[name='USER_PASSWORD']"));
        WebElement login = Driver.get().findElement(new By.ByCssSelector("input[type='submit'"));

        username.click();
        username.sendKeys("helpdesk1@cybertekschool.com");
        password.click();
        password.sendKeys("UserUser");
        login.click();
    }

    public static void crm_login(String username, String password){
        Driver.get().get("http://login1.nextbasecrm.com/ ");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement username1 = Driver.get().findElement(new By.ByCssSelector("input[name='USER_LOGIN']"));
        WebElement password1 = Driver.get().findElement(new By.ByCssSelector("input[name='USER_PASSWORD']"));
        WebElement login = Driver.get().findElement(new By.ByCssSelector("input[type='submit'"));

        username1.click();
        username1.sendKeys(username);
        password1.click();
        password1.sendKeys(password);
        login.click();
    }

}
