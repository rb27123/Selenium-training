import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.LandingPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Runner extends Hooks{
    @Test
    public void demoTest(){
        LandingPage landing = new LandingPage(driver);
        ArticlePage article = landing.search("Endava");
        assertThat("The title was not the one that was entered in the query",
                article.getArticleTitle(), equalTo("Endava"));

    }
}
