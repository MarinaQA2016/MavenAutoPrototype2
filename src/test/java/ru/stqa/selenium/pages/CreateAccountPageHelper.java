package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPageHelper extends PageBase
{
    @FindBy(xpath ="//button[@aria-label='Close dialog']")
    WebElement cancelButton;

    @FindBy(xpath = "//div[@class='reg']/span")
    WebElement regAccountControl;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailField;

    @FindBy (xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy (xpath = "//input[@placeholder='Repeat password']")
    WebElement passConfirmationField;

    @FindBy(xpath = "//button[@type='submit']/span")
    WebElement registrationButton;

    @FindBy(xpath = "//h1[@class='classCentr']")
    WebElement registrationForm;

    public CreateAccountPageHelper(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPageHelper waitUntilElementIsloaded()
    {
        waitUntilElementIsloaded(driver,cancelButton,40);
        return this;
    }

    public CreateAccountPageHelper waitUntilRegistrationFormIsloaded()
    {
        waitUntilElementIsloaded(driver, registrationForm,40);
        return this;
    }

    public boolean isHeaderCorrect(String text)
    {
        return registrationForm.getText().equals(text);
    }


    public boolean isCreateAccountPageOpened()
    {
        System.out.println(regAccountControl.getText());
        return regAccountControl.getText().equals("Has already account?");
    }

    public CreateAccountPageHelper enterEmail(String value)
    {
        enterValueToField(emailField, value);
        return this;
    }

    public CreateAccountPageHelper enterPassword(String value)
    {
        enterValueToField(passwordField, value);
        return this;
    }

    public CreateAccountPageHelper enterPassConfirmation(String value)
    {
        enterValueToField(passConfirmationField, value);
        return this;
    }

    public CreateAccountPageHelper submitCreateAccount()
    {
        registrationButton.click();
        return this;
    }
}
