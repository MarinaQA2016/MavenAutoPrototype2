package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFormHelper extends PageBase
{
    @FindBy(xpath = "//input[@id='inputFirstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='inputLastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='inputPhoneNumber']")
    WebElement phone;

    @FindBy(xpath = "//mat-select[@placeholder='Confession']//div[@class='mat-select-trigger']")
    WebElement confession;

    @FindBy(xpath = "//mat-datepicker-toggle[@class='mat-datepicker-toggle']//button[@type='button']")
    WebElement birthday;

        @FindBy(xpath = "//button[@class='mat-calendar-period-button mat-button']//span[@class='mat-button-wrapper']")
        WebElement selectYear;

        @FindBy(xpath = "//button[@class='mat-calendar-previous-button mat-icon-button']")
        WebElement arrow;

    @FindBy(xpath = "//mat-select[@aria-label='Marital Status']/div")
    WebElement maritalStatus;

    @FindBy(xpath = "//mat-select[@aria-label='Food Preferences']/div")
    WebElement food;

    @FindBy(xpath = "//mat-select[@aria-label='Gender']/div")
    WebElement gender;


    @FindBy(xpath = "//mat-select[@formcontrolname='languages']")
    WebElement languages;

    @FindBy(xpath = "//textarea[@id='description']")
    WebElement infoField;


    public RegistrationFormHelper(WebDriver driver)
    {
        super(driver);
    }

    public RegistrationFormHelper enterFirstName(String value)
    {
        waitUntilElementIsloaded(driver,firstName,40);
        enterValueToField(firstName, value);
        return this;
    }

    public RegistrationFormHelper enterLastName(String value)
    {
        waitUntilElementIsloaded(driver,lastName,40);
        enterValueToField(lastName, value);
        return this;
    }

    public RegistrationFormHelper enterPhone(String value)
    {
        enterValueToField(phone, value);
        return this;
    }

    public RegistrationFormHelper selectConfession(String value)
    {
        Actions action = new Actions(driver);
        action.moveToElement(confession).build().perform();
        confession.click();
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }

    public RegistrationFormHelper selectMaritalStatus(String value)
    {
        Actions action = new Actions(driver);
        action.moveToElement(maritalStatus).build().perform();
        maritalStatus.click();
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }

    public RegistrationFormHelper selectFood(String value)
    {
        Actions action = new Actions(driver);
        action.moveToElement(food).build().perform();
        food.click();
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }

    public RegistrationFormHelper selectGender(String value)
    {
        Actions action = new Actions(driver);
        action.moveToElement(gender).build().perform();
        gender.click();
     //   new Select(driver.findElement(By.xpath("//span[@class='mat-option-text']"))).selectByVisibleText(value);
        driver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
        return this;
    }

    public RegistrationFormHelper enterInfo(String value)
    {
        waitUntilElementIsloaded(driver,infoField,40);
        infoField.sendKeys(value);
        return this;
    }

    public RegistrationFormHelper selectLanguage(String value)
    {
        Actions action = new Actions(driver);
        action.moveToElement(languages).build().perform();
        languages.click();
        driver.findElement(By.xpath("//span[@class='mat-option-text'][contains(text(),'" + value + "')]")).click();
        return this;
    }

    public RegistrationFormHelper enterBirthday(String day, String month, String year) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(birthday).build().perform();
        birthday.click();

        // select the year of the User's Birthday
        selectYear.click();
        arrow.click();
        WebElement yearSign = driver.findElement(By.xpath("//button[@class='mat-calendar-period-button mat-button']//span[@class='mat-button-wrapper']"));
        waitUntilElementIsloaded(driver, yearSign,200);
        Thread.sleep(2000);

        new Select(driver.findElement(By.xpath("//div[@class='mat-calendar-body-cell-content']")))
                .selectByVisibleText(year);

        // select the month of the User's Birthday
        Thread.sleep(2000);

        new Select(driver.findElement(By.xpath("//div[@class='mat-calendar-body-cell-content']")))
                .selectByVisibleText(month);

        // select the day of the User's Birthday
        Thread.sleep(2000);
        new Select(driver.findElement(By.xpath("//div[@class='mat-calendar-body-cell-content']")))
                .selectByVisibleText(day);
        return this;
    }


}
