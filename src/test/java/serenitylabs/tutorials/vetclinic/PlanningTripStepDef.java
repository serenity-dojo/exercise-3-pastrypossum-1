package serenitylabs.tutorials.vetclinic;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Iterate;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.security.Key;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;
import static serenitylabs.tutorials.vetclinic.MenuBar.HELP_AND_CONTACTS;

@RunWith(CucumberWithSerenity.class)
public class PlanningTripStepDef {

    @Managed
    WebDriver browser;

    Actor bob = Actor.named("Bob");

    @Before
    public void setTheStage() {
        bob.can(BrowseTheWeb.with(browser));

        bob.attemptsTo(
                Open.browserOn().the(TFLHomePage.class),
                Click.on(CookiesDialog.ACCEPT_ALL_COOKIES)
        );
    }

    @When("viewing TFL main page")
    public void view_main_page() {
        bob.attemptsTo(Open.browserOn().the(TFLHomePage.class));
    }

    @When("viewing TFL status page")
    public void view_status_page() {
        bob.attemptsTo(
                Click.on(MenuBar.STATUS_UPDATES.menuOption())
        );
    }

    @Then("the title {string} will be displayed")
    public void title_will_be(String title) {
        bob.should(seeThat(TheWebPage.title(), containsString(title)));
    }

    @When("searching for the station {string}")
    public void search_for_station(String station) {
        bob.attemptsTo(
                Search.forStation(station)
        );
    }

    @Then("results will display headline {string}")
    public void search_result_headline_will_be(String headline) {
        bob.should(
                seeThat(SearchResults.heading(), equalTo(headline))
        );
    }

    @Then("results will contains items related to {string}")
    public void search_result_contain_station(String station) {
        bob.should(
                seeThat(TheTarget.textOf(SearchResultsPage.ARTICLES), containsString(station)));
    }

    @Then("it includes station names")
    public void search_result_contain_station() {
        bob.should(
                seeThat(TheTarget.textValuesOf(StatusUpdatePage.SERVICE_LINES),
                        hasItems("Central", "Bakerloo", "Circle"))
        );
    }

    @When("populating the TFL contact form")
    public void populate_contact_form() {
        bob.attemptsTo(
                SelectMenu.option(HELP_AND_CONTACTS),
                Click.on(ContactForm.CONTACT_US)
        );
        bob.attemptsTo(
                EnterContactDetails.forCustomer("Mrs", "Sarah-Jane", "Smith")
        );
    }

    @Then("the form will show entered details")
    public void show_entered_details() {
        bob.should(
                seeThat(TheContactDetails.title(), equalTo("Mrs")),
                seeThat(TheContactDetails.firstName(), equalTo("Sarah-Jane")),
                seeThat(TheContactDetails.lastName(), equalTo("Smith"))
        );
    }
}
