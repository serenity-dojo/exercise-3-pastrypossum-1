package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContactForm {

    public static final Target CONTACT_US =
            Target.the("Contact us about").located(By.linkText("Contact us about Oyster"));

    public static final Target TITLE =
            Target.the("Title dropdown").located(By.name("PersonalDetails.Title"));

    public static final Target FIRST_NAME =
            Target.the("First name").located(By.name("PersonalDetails.FirstName"));

    public static final Target LAST_NAME =
            Target.the("Last name").located(By.name("PersonalDetails.LastName"));
}
