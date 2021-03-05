package pages;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.apache.logging.log4j.LogManager.getLogger;

public class LandingPage extends BasePage{
    private final By searchBar = By.id("searchInput");
    private final By suggestedSearches = By.cssSelector(".suggestions-dropdown a");

    private static final Logger log = getLogger(LandingPage.class.getName());

    public LandingPage(WebDriver driver){
        super(driver);
    }

    public ArticlePage search(String query){
        log.debug("Typing " + query+ " in the searchbar");
        driver.findElement(searchBar).sendKeys(query);
        log.debug("Waiting for dropdown menu to show");
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(suggestedSearches, 1));
        log.debug("Clicking the first article");
        driver.findElements(suggestedSearches).get(0).click();
        log.info("Article found");
        if(!query.equals("Colombia")){
            log.error("The query was not found");
        }
        return new ArticlePage(driver);
    }
}
