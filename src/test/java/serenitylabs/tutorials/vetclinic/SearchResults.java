package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;

import static org.hamcrest.Matchers.equalTo;

public class SearchResults {

    public static Question<String> heading() {
        return TheTarget.textOf(SearchResultsPage.SEARCH_RESULTS_HEADING);
    }
}
