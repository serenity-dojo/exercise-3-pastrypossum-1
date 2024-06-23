package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class SelectMenu {

    public static Performable option(MenuBar option) {
        return Task.where("select #option from menu",
                Click.on(MenuBar.HELP_AND_CONTACTS.menuOption()));
    }
}
