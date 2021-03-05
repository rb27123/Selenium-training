package pages;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.apache.logging.log4j.LogManager.getLogger;

public class ArticlePage extends BasePage{
//    private final By articleTitle = By.id("firstHeading");

    @FindBy(id = "firstHeading")
    private WebElement articleTitle;

    private static final Logger log = getLogger(ArticlePage.class.getName());

    public ArticlePage(WebDriver driver){
        super(driver);
    }

    public String getArticleTitle(){
        log.debug("Getting article title");
        return articleTitle.getText();
    }
}
