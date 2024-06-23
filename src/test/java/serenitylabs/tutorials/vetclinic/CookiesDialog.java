package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CookiesDialog extends PageObject {

    public static final Target ACCEPT_ALL_COOKIES =
            Target.the("Accept all cookies").located(
                    By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
}
