package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterContactDetails implements Performable {

    private String title;
    private String firstName;
    private String lastName;

    public EnterContactDetails(String title, String firstName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Performable forCustomer(String title, String firstName, String lastName) {
        return instrumented(EnterContactDetails.class, title, firstName, lastName);
    }

    @Override
    @Step("{0} enters contact information")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                SelectFromOptions.byVisibleText(title).from(ContactForm.TITLE),
                Enter.theValue(firstName).into(ContactForm.FIRST_NAME),
                Enter.theValue(lastName).into(ContactForm.LAST_NAME)
        );
    }
}
