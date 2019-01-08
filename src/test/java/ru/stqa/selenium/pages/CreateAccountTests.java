package ru.stqa.selenium.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.TestBase;

public class CreateAccountTests extends TestBase
{
    private HomePageHelper homepage;
    private CreateAccountPageHelper createAccountPage;
    private AuthEventsPageHelper authEventsPage;
    private RegistrationFormHelper registForm;

    private int a = 0;
    private int b = 1000;
    private int count = a + (int)(Math.random()*b);

    @BeforeMethod
    public void initPageObject()
    {
        homepage = PageFactory.initElements(driver,HomePageHelper.class);
        createAccountPage = PageFactory.initElements(driver,CreateAccountPageHelper.class);
        authEventsPage = PageFactory.initElements(driver,AuthEventsPageHelper.class);
        registForm = PageFactory.initElements(driver,RegistrationFormHelper.class);

        driver.get(baseUrl);
        homepage.waitUntilPageIsLoaded();
        homepage.pressCreateAccountButton();
        createAccountPage.waitUntilElementIsloaded();

    }
    @Test
    public void createAccountPositiveTest() throws InterruptedException {
        String email = "darya"+count+"@gmail.com";

        createAccountPage.enterEmail(email)
                .enterPassword("darya"+count)
                .enterPassConfirmation("darya"+count)
                .submitCreateAccount()
                .waitUntilRegistrationFormIsloaded();

        Assert.assertTrue(createAccountPage.isHeaderCorrect("Registration"));
        Assert.assertTrue(authEventsPage.isDisplayedIconMenu());

        registForm.enterFirstName("Darya")
                .enterLastName("Dom")
                .enterPhone("052-000-0000")
                .selectConfession("Religious")
                .selectMaritalStatus("Married")
                .selectFood("Any")
                .selectGender("Female")
                .enterInfo("Hello!");
  //              .selectLanguage("Russian");
  //              .enterBirthday("10","JAN","2000");

    }


}
