package ru.stqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.HomePageHelper;

public class HomePageTests extends TestBase {

  private HomePageHelper homepage;

  @BeforeMethod
  public void initPageObjects()
  {
    homepage = PageFactory.initElements(driver, HomePageHelper.class);
    driver.get(baseUrl);
    homepage.waitUntilPageIsLoaded();
  }


  @Test
  public void openHomePageTest()
  {

    //WebElement buttonLogin = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
    Assert.assertEquals(homepage.getHeaderText(),"Shabbat in the family circle");

  }

  @Test
  public void contentPageUnAuthTest()
  {
    int counter = 0;

    if (homepage.getHeaderText().equals("Shabbat in the family circle"))  counter++;

    if (homepage.getLoginButtonName().equals("Login")) counter++;

    if (homepage.getCreateAccountName().equals("Create Account")) counter++;

    if (homepage.getGoToEventsButtonName().equals("Go to Event list")) counter++;

    Assert.assertEquals(counter,4);

  }

  @Test
  public void verifyLoginButtonTest()
  {
    if (homepage.verifyLoginButton().equals("Go to Event list"))
    {
      System.out.println("Login button test is pass!");
    }
    else
    {
      System.out.println("Login button test is failed.");
    }
  }

  @Test ()
  public void verifyCreateAccountButton()
  {
    if (homepage.verifyCreateAccountButton().equals("Go to Event list"))
    {
      System.out.println("Create account button test is pass!");
    }
    else
    {
      System.out.println("Create account button test is failed.");
    }
  }

  @Test()
  public void verifyEventListButton()
  {
    if (homepage.verifyEventListButton().equals("Filters"))
    {
      System.out.println("Event list button test is pass!");
    }
    else
    {
      System.out.println("Event list button test is failed.");
    }

  }

  @Test
  public void navigationButtonTest()
  {
    // Three tests above in one test for result checking
    
    WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
    loginButton.click();

    WebElement cancelButton = driver.findElement(By.xpath("//span[contains(text(),'Cancel')]"));
    cancelButton.click();

    WebElement createAccount = driver.findElement(By.xpath("//span[contains(text(),'Create Account')]"));
    createAccount.click();

    cancelButton.click();

    WebElement eventListButton = driver.findElement(By.xpath("//span[contains(text(),'Go to Event list')]"));
    eventListButton.click();
  }




}
