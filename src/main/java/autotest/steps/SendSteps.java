package autotest.steps;

import autotest.pages.IpotekaPages;
import ru.yandex.qatools.allure.annotations.Step;

public class SendSteps {

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value) throws InterruptedException {

        new IpotekaPages().fillField(field, value);
    }
}
