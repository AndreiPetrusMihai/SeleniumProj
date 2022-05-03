package pcgarage.steps;

import net.thucydides.core.annotations.Step;
import org.example.pages.DictionaryPage;
import pcgarage.pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    MainPage mainPage;

    @Step
    public void enters(String keyword) {
        mainPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        mainPage.lookup_terms();
    }

    @Step
    public void should_see_0_results() {
        assert mainPage.noResultsFoundText();
    }

    @Step
    public void should_see_products_select() {
        assert mainPage.someResultsFound();
    }

    @Step
    public void is_the_main_page() {
        mainPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}