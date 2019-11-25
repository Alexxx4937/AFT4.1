package autotest.pages;

import autotest.steps.BaseSteps;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;


public class IpotekaPages extends  BasePage{

 WebDriver driver= BaseSteps.getDriver();

    public JavascriptExecutor jse = (JavascriptExecutor)driver;


    @FindBy(xpath = "//*[contains(@class,'dcCalc_textfield')][contains(@id, 'estateCost')]")
    public WebElement propertyPrice;
    @FindBy(xpath = "//*[contains(@class,'dcCalc_textfield')][contains(@id, 'initialFee')]")
    public WebElement initialFee;
    @FindBy(xpath = "//input[@id='creditTerm']")
    public WebElement creditTerm;


    @FindBy(xpath = "//div[contains(@class, 'discounts')]//label[contains(@class, 'switch_checked')]")
    public WebElement salaryCard;
    @FindBy(xpath = "//div[@class='dcCalc_switch-tablet'][5]//span[@class='dcCalc_switch__control']")
    public WebElement youngFamily;


    //input[@data-test-id='youngFamilyDiscount']"


    @FindBy(xpath = "//*[contains(@data-test-id, 'amountOfCredit')]")
    static public WebElement creditSum;
    @FindBy(xpath = "//*[contains(@data-test-id, 'monthlyPayment')]")
    public WebElement monthlyPayment;
    @FindBy(xpath = "//*[contains(@data-test-id, 'requiredIncome')]")
    static public WebElement requiredIncome;
    @FindBy(xpath = "//*[contains(@data-test-id, 'rate')]")
    public WebElement interestRate;




public void  goFrame() throws InterruptedException {
    driver.switchTo().frame(0);
    Thread.sleep(2000);
    }
    public void outFrame(){
        driver.switchTo().defaultContent();
    }

public void
scroll() throws InterruptedException {
    jse.executeScript("window.scrollBy(0,300)");
    Thread.sleep(1000);

    }
    public void scrollUp() throws InterruptedException {
        jse.executeScript("window.scrollBy(0,-600)");
        Thread.sleep(1000);

    }


    public void fillField(String fieldName, String value) throws InterruptedException {
        switch (fieldName) {
            case "Стоимость недвижимости":
                fillField(propertyPrice, value);
                break;
            case "Первоначальный взнос":
                fillField(initialFee, value);
                break;
            case "Срок кредита":
                fillField(creditTerm, value);
                break;

            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }



    public void offSalaryCard() throws InterruptedException {


        if(driver.findElement(By.xpath("//input[@data-test-id='paidToCard']")).isSelected()) {
            salaryCard.click();

        }
        Thread.sleep(1500);
    }


        public void waitForTextReference() {

            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.xpath("//div[contains(text(), 'Есть возможность подтвердить доход справкой')]")).isDisplayed();
                }
            });
        }



   public void onYoungFamily() throws InterruptedException {


       if(!driver.findElement(By.xpath("//input[@data-test-id='youngFamilyDiscount']")).isSelected()) {
           youngFamily.click();

       }

           Thread.sleep(1500);



   }


    public void checkCreditSum(String creditSumVal){



        assertEquals("Сумма кредита не соотвествует ожидаемой сумме", creditSumVal, creditSum.getText());
    }


    public void checkMonthlyPayment(String monthlyPaymentVal){
        assertEquals("Ежемесячный платеж не соотвествует ожидаемому платежу", monthlyPaymentVal, monthlyPayment.getText());
    }


    public void checkRequiredIncome(String requiredIncomeVal){
        assertEquals("Необходимый доход не соотвествует ожидаемому доходу", requiredIncomeVal, requiredIncome.getText());
    }


    public void checkInterestRate(String interestRateVal){
        assertEquals("Процентная ставка не соотвествует ожидаемой ставке", interestRateVal, interestRate.getText());
    }

   }
