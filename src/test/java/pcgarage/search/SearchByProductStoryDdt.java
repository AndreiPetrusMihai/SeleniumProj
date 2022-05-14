package pcgarage.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pcgarage.steps.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/EmagTestData.csv")
public class SearchByProductStoryDdt {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    @Steps
    public EndUserSteps endUser;

    public String name;
    public String definition;

    @Issue("#Emag-1")
    @Test
    public void searching_by_keyword_blablable_should_display_the_no_products_foundDDT() {
        System.out.println(getName());
        endUser.is_the_main_page();
        endUser.looks_for(getName());
        endUser.should_see_0_results();
    }

    @Issue("#Emag-2")
    @Test
    public void searching_by_keyword_masina_should_display_products_selectDDT() {
        System.out.println(getName());
        endUser.is_the_main_page();
        endUser.looks_for(getName());
        endUser.should_see_products_select();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
