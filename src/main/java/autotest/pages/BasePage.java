package autotest.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import autotest.steps.BaseSteps;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
;

import static autotest.steps.BaseSteps.getDriver;


public class BasePage {
    WebDriverWait wait = new WebDriverWait(getDriver(), 30);


    WebDriver driver = BaseSteps.getDriver();


    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }


    public void fillField(WebElement field, String value) throws InterruptedException {
        Thread.sleep(1000);
        field.clear();
        field.sendKeys(value);
    }


}
