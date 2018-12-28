package ru.stqa.selenium;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.HomePageHelper;
import ru.stqa.selenium.pages.LoginPageHelper;
import ru.stqa.selenium.pages.UnAuthEventsPageHelper;

public class HomePageTests extends TestBase {

  private HomePageHelper homepage;
  private UnAuthEventsPageHelper unAuthEventsPage;
  private LoginPageHelper loginPage;

  @BeforeMethod
  public void initPageObjects()
  {
    homepage = PageFactory.initElements(driver, HomePageHelper.class);
    unAuthEventsPage = PageFactory.initElements(driver, UnAuthEventsPageHelper.class);
    loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
    driver.get(baseUrl);
  }


  @Test
  public void openHomePageTest()
  {
    homepage.waitUntilPageIsLoaded();
    //WebElement buttonLogin = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
    Assert.assertEquals(homepage.getHeaderText(),"Shabbat in the family circle");

  }

  @Test
  public void contentPageUnAuthTest()
  {
    homepage.waitUntilPageIsLoaded();
    int counter = 0;

    if (homepage.getHeaderText().equals("Shabbat in the family circle"))  counter++;

    if (homepage.getLoginButtonName().equals("Login")) counter++;

    if (homepage.getCreateAccountName().equals("Create Account")) counter++;

    if (homepage.getGoToEventsButtonName().equals("Go to Event list")) counter++;

    Assert.assertEquals(counter,4);

  }

  @Test
  public void AgoToEventsPageTest()
  {
      homepage.waitUntilPageIsLoaded();
      homepage.pressGoToEventButton();
      unAuthEventsPage.waitUntilPageIsLoaded();

      Assert.assertTrue(unAuthEventsPage.isHeaderCorrect("Find event"));
  }

  @Test
  public void goLoginPageTest()
  {
      homepage.waitUntilPageIsLoaded();
      homepage.pressLoginButton();
      loginPage.waitUntilElementIsloaded();

      Assert.assertTrue(loginPage.isLoginPageOpened());


  }



//  @Test
//  public void verifyLoginButtonTest()
//  {
//      homepage.waitUntilPageIsLoaded();
//    if (homepage.verifyLoginButton().equals("Go to Event list"))
//    {
//      System.out.println("Login button test is pass!");
//    }
//    else
//    {
//      System.out.println("Login button test is failed.");
//    }
//  }
//
//  @Test ()
//  public void verifyCreateAccountButton()
//  {
//      homepage.waitUntilPageIsLoaded();
//      if (homepage.verifyCreateAccountButton().equals("Go to Event list"))
//    {
//      System.out.println("Create account button test is pass!");
//    }
//    else
//    {
//      System.out.println("Create account button test is failed.");
//    }
//  }
//
//  @Test()
//  public void verifyWEventListButton()
//  {
//      homepage.waitUntilPageIsLoaded();
//
//    if (homepage.verifyEventListButton().equals("Filters"))
//      //if (homepage.verifyEventListButton().equals("Go to Event list"))
//    {
//      System.out.println("Event list button test is pass!");
//
//    }
//    else
//    {
//      System.out.println("Event list button test is failed.");
//    }
//
//  }

}
