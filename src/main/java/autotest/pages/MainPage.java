package autotest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static autotest.steps.BaseSteps.getDriver;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[.='Ипотека']")
    public WebElement menu;

    @FindBy(xpath = "//li[contains(@class, 'lg-menu__item_hovered')]//a[.='Ипотека на готовое жильё']")
    public WebElement ipoteka;





    public void menu(){
        Actions builder = new Actions(getDriver());
        builder.moveToElement(menu).build().perform();
    }



    public void check() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.pollingEvery(1, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(ipoteka));
    }

    public void goToIpoteka()  {


        ipoteka.click();


    }
}
