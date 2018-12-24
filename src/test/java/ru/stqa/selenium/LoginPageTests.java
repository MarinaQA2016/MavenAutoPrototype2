package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.HomePageHelper;

public class LoginPageTests extends TestBase
{
    private HomePageHelper homepage;
    @BeforeMethod
    public void initPageObjects()
    {
        homepage = PageFactory.initElements(driver, HomePageHelper.class);
        driver.get(baseUrl);
    }

    @Test
    public void loginPositiveTest()
    {
        homepage.waitUntilElementIsloaded(driver, By.xpath("//span[contains(text(),'Go to Event list')]"), 30);

        WebElement buttonLogin = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
        buttonLogin.click();
        homepage.waitUntilElementIsloaded(driver, By.xpath("//span[contains(text(),'Cancel')]"), 15);

        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("marina@123.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("marina");

        WebElement loginToAccount = driver.findElement(By.xpath("//button[@type='submit']/span"));
        loginToAccount.click();

        homepage.waitUntilElementIsloaded(driver, By.xpath("//button[@class='mat-raised-button']"), 30);

        WebElement icon = driver.findElement(By.cssSelector(".but.mat-icon.material-icons"));

        System.out.println("Element of the page  " + icon.getAttribute("mattooltip"));

        WebElement filter = driver.findElement(By.xpath("//span[contains(text(),'Filters')]"));

        Assert.assertTrue(filter.getText().equals("Filters"));
    }


}
