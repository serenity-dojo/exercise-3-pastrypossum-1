package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;

public class TheContactDetails {

    public static Question<String> title() {
        return TheTarget.selectedValueOf(ContactForm.TITLE);
    }

    public static Question<String> firstName() {
        return TheTarget.valueOf(ContactForm.FIRST_NAME);
    }

    public static Question<String> lastName() {
        return TheTarget.valueOf(ContactForm.LAST_NAME);
    }
}
