package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

/**
 * Sample page
 */
public class HomePageHelper extends PageBase {

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  WebElement header;

  @FindBy(xpath = "//span[contains(text(),'Login')]")
  WebElement loginButton;

  @FindBy(xpath = "//span[contains(text(),'Create Account')]")
  WebElement createAccountButton;

  @FindBy(xpath = "//span[contains(text(),'Go to Event list')]")
  WebElement goToEventListButton;

  @FindBy(xpath = "//span[contains(text(),'Filters')]")
  WebElement eventsPage;


  public HomePageHelper(WebDriver webDriver) {
    super(webDriver);
  }


  public void waitUntilPageIsLoaded()
  {
    // waitUntilElementIsloaded(driver, By.xpath("//span[contains(text(),'Go to Event list')]"), 30);
    waitUntilElementIsloaded(driver, goToEventListButton, 30);
  }

  public String getHeaderText()
  {
    return header.getText();
  }

  public String getLoginButtonName()
  {
    return loginButton.getText();
  }

  public String getCreateAccountName()
  {
    return createAccountButton.getText();
  }

  public String getGoToEventsButtonName()
  {
    return goToEventListButton.getText();
  }

  public String verifyLoginButton()
  {
    loginButton.click();
    cancelButton();
    waitUntilElementIsloaded(driver,goToEventListButton,500);
    return goToEventListButton.getText();
  }

  public String verifyCreateAccountButton()
  {
    createAccountButton.click();
    cancelButton();
    waitUntilElementIsloaded(driver,goToEventListButton,500);
    return goToEventListButton.getText();
  }

  public String verifyEventListButton()
  {
    goToEventListButton.click();
    waitUntilElementIsloaded(driver,eventsPage,500);
    return eventsPage.getText();
  }

  public void cancelButton()
  {
    driver.findElement(By.xpath("//span[contains(text(),'Cancel')]")).click();
  }

  public boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
