package pcgarage.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import java.rmi.Remote;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@DefaultUrl("https://www.emag.ro")
public class MainPage extends PageObject {

    @FindBy(id = "searchboxTrigger")
    private WebElementFacade searchInput;

    @FindBy(xpath = "//*[@id=\"masthead\"]/div/div/div[2]/div/form/div[1]/div[2]/button[2]")
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

    public boolean checkFilterByTypeAndValue(String nrOfElementsToAdd) {
        List<RemoteWebElement> itemGrid = find(By.cssSelector("#card_grid")).findElements(By.cssSelector(".card-item"));
        for (RemoteWebElement item : itemGrid.subList(0, Integer.parseInt(nrOfElementsToAdd))) {
            item.findElement(By.cssSelector("button[type='submit']")).click();
            WebElementFacade xCloseButton = find(By.cssSelector("body > div.ph-modal.modal.fade.product-purchased-modal.modal-version-.in > div > div > div.modal-header > button"));
            if (!xCloseButton.isDisabled())
                xCloseButton.click();
            else {
                find(By.xpath("/html/body/div[9]/div/div/div[1]/div/div[3]/a[2]")).click();
            }
        }

        return Objects.equals(find(By.xpath("//*[@id=\"my_cart\"]/span[1]")).getText(), nrOfElementsToAdd);
    }

    public boolean cartIsEmpty(){
        List<RemoteWebElement> itemGrid = find(By.cssSelector("#card_grid")).findElements(By.cssSelector(".card-item"));
        for (RemoteWebElement item : itemGrid.subList(0, 1)) {
            item.click();
        }

        String cartSize = find(By.xpath("//*[@id=\"my_cart\"]/span[1]")).getText();
        return Objects.equals(cartSize, "") ;
    }

}