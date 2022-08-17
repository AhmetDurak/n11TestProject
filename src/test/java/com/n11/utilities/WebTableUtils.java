package com.n11.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class WebTableUtils {

    public static String returnOrderDate(String customerName) {
        String locator = "//td[.='" + customerName + "']/following-sibling::td[3]";
        WebElement orderDate = Driver.get().findElement(By.xpath(locator));
        return orderDate.getText();
    }

    public static void orderVerify(String customerName, String expectedOrderDate) {
        String actualOrderDate = returnOrderDate(customerName);
        try {
            Assert.assertEquals(actualOrderDate, expectedOrderDate);
        } catch (NoSuchElementException ignored) {
            System.out.println("No Such Element Exception");
        }
    }

    public static String getTableGetEmail(int tableNum, String firstName) {
        String locator = "//table[@id='table" + tableNum + "']//td[.='" + firstName + "']/following-sibling::td[1]";
        return Driver.get().findElement(By.xpath(locator)).getText();
    }
}
