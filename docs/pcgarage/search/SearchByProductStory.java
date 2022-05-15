package pcgarage.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pcgarage.steps.EndUserSteps;

@RunWith(SerenityRunner.class)

public class SearchByProductStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Test
    public void searching_by_keyword_blablable_should_display_the_no_products_found() {
        anna.is_the_main_page();
        anna.looks_for("blablable");
        anna.should_see_0_results();
    }

    @Test
    public void searching_by_keyword_masina_should_display_products_select() {
        anna.is_the_main_page();
        anna.looks_for("masina");
        anna.should_see_products_select();
    }

}