package pcgarage.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.emag.ro")
public class MainPage extends PageObject {

    @FindBy(id="searchboxTrigger")
    private WebElementFacade searchInput;

    @FindBy(xpath = "//*[@id=\"masthead\"]/div/div/div[2]/div/form/div[1]/div[2]/button[2]" )
    private WebElementFacade searchButton;

    public void enter_keywords(String keyword) {
        searchInput.type(keyword);
    }

    public void lookup_terms() {
        searchButton.click();
    }

    public boolean noResultsFoundText() {
        WebElementFacade noResultsPlaceholder = find(By.xpath("//*[ text() = ‘0 rezultate pentru:’ ]"));
        return noResultsPlaceholder != null;
    }

    public boolean someResultsFound() {
        WebElementFacade productsPerPageSelect = find(By.xpath("//*[ text() = ‘Produse:’ ]"));
        return productsPerPageSelect != null;
    }

}