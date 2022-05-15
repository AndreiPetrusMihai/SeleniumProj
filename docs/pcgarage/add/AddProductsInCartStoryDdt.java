package pcgarage.add;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pcgarage.steps.EndUserSteps;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/EmagAddData.csv")
public class AddProductsInCartStoryDdt {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Qualifier
    public String getQualifier() {
        return Value;
    }

    @Steps
    public EndUserSteps endUser;

    public String Value;

    @Issue("#Emag-filter-1")
    @Test
    public void add_products_from_one_line_products_should_be_in_cartDDT() {
        endUser.is_the_main_page();
        endUser.looks_for("masina");
        endUser.checkCart(getValue());
    }

    @Issue("#Emag-filter-2")
    @Test
    public void not_add_products_products_will_not_be_in_cartDDT() {
        endUser.is_the_main_page();
        endUser.looks_for("masina");
        endUser.checkCartFail();
    }


    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
