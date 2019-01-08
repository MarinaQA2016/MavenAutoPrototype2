package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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

  @FindBy(xpath = "//button[@class='mat-stroked-button']/span[@class='mat-button-wrapper']")
  WebElement goToEventListButton;

  @FindBy(xpath = "//span[contains(text(),'Filters')]")
  WebElement eventsPage;


  public HomePageHelper(WebDriver webDriver) {
    super(webDriver);
  }


  public HomePageHelper waitUntilPageIsLoaded()
  {
    // waitUntilElementIsloaded(driver, By.xpath("//span[contains(text(),'Go to Event list')]"), 30);
    waitUntilElementIsloaded(driver, goToEventListButton, 100);
    return this;
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
    //goToEventListButton.click();
    //driver.findElement(By.xpath("//button[@class='mat-stroked-button']/span[@class='mat-button-wrapper']")).click();
    System.out.println(driver.findElement(By.xpath("//button[@class='mat-stroked-button']/span[@class='mat-button-wrapper']")).getText());

    // position on one special element
    Actions action = new Actions(driver);
    action.moveToElement(goToEventListButton).build().perform();

    goToEventListButton.click();
    //driver.findElement(By.xpath("//button[@class='mat-stroked-button']/span[@class='mat-button-wrapper']")).click();
    //return driver.findElement(By.xpath("//button[@class='mat-stroked-button']/span[@class='mat-button-wrapper']")).getText();
     waitUntilElementIsloaded(driver,eventsPage,500);
    return eventsPage.getText();
  }

  public HomePageHelper cancelButton()
  {
    driver.findElement(By.xpath("//span[contains(text(),'Cancel')]")).click();
    return this;
  }

  public boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public HomePageHelper pressGoToEventButton()
  {
    goToEventListButton.click();
    return this;
  }

  public HomePageHelper pressLoginButton()
  {
    loginButton.click();
    return this;
  }

  public HomePageHelper pressCreateAccountButton()
  {
    createAccountButton.click();
    return this;
  }
}
