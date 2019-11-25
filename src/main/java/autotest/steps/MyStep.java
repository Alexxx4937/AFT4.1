package autotest.steps;

import autotest.pages.BasePage;
import autotest.pages.IpotekaPages;
import autotest.pages.MainPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;

public class MyStep {
    MainPage mainPage=new MainPage();
    IpotekaPages ipotekaPage=new IpotekaPages();
    @Когда("^на меню \"([^\"]*)\" наведен курсор$")
    public void наМенюНаведенКурсор(String arg0)  {
        mainPage.menu();


    }

    @Тогда("^проверено, что открылось выпадающее меню$")
    public void провереноЧтоОткрылосьВыпадающееМеню()  {

        mainPage.check();

    }

    @Когда("^нажать на кнопку \"([^\"]*)\"$")
    public void нажатьНаКнопку(String arg0)   {

        mainPage.goToIpoteka();
    }





    @Когда("^заполняются поля:$")
    public void fillForm(DataTable fields) throws InterruptedException {
       /*ipotekaPage.scroll();*/
        ipotekaPage.goFrame();
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> {
                    try {
                        new SendSteps().fillField(field, value);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

    }



    @Когда("^снять галочку есть зарплатная карта сбербанка$")
    public void снятьГалочкуЕстьЗарплатнаяКартаСбербанка() throws InterruptedException {
        ipotekaPage.outFrame();
        ipotekaPage.scroll();
        ipotekaPage.goFrame();
        ipotekaPage.offSalaryCard();
    }

    @Когда("^ожидание появления есть возможность подтвердить доход справкой$")
    public void ожиданиеПоявленияЕстьВозможностьПодтвердитьДоходСправкой() {
        ipotekaPage.waitForTextReference();



}
    @Когда("^выставляем галочку молодая семья$")
    public void выставляемГалочкуМолодаяСемья() throws InterruptedException {
        ipotekaPage.outFrame();
        ipotekaPage.scroll();
        ipotekaPage.goFrame();

        ipotekaPage.onYoungFamily();
    }





    @Тогда("проверяем значение поля Сумма кредита (.*)")
    public void проверяемЗначениеПоляСуммаКредита(String arg0) {
        ipotekaPage.checkCreditSum(arg0);
    }

    @Тогда("проверяем значение поля Ежемесячный платеж (.*)")
    public void проверяемЗначениеПоляЕжемесячныйПлатеж(String arg0) {
        ipotekaPage.checkMonthlyPayment(arg0);
    }

    @Тогда("проверяем значение поля Необходимый доход (.*)")
    public void проверяемЗначениеПоляНеобходимыйДоход(String arg0) {
       ipotekaPage.checkRequiredIncome(arg0);
    }

    @Тогда("проверяем значение поля Процентная ставка (.*)")
    public void проверяемЗначениеПоляПроцентнаяСтавка(String arg0) {
        ipotekaPage.checkInterestRate(arg0);
    }

}









