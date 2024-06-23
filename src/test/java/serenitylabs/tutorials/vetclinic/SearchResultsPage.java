package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class SearchResultsPage extends PageObject {

    public static final Target SEARCH_RESULTS_HEADING =
            Target.the("Search headline").located(By.className("hero-headline"));

    public static final Target ARTICLES =
            Target.the("First article").located(By.className("search-results"));

    public static final Target SERVICE_LINES =
            Target.the("Service lines").locatedBy(".service-name span");
}
