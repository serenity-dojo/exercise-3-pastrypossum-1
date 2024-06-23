package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class Search {

    public static Performable forStation(String station) {
        return Task.where("search for #station",
        Enter.theValue(station).into(TFLHomePage.SEARCH).thenHit(Keys.ENTER));
    }
}
