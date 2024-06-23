package serenitylabs.tutorials.vetclinic;

import net.serenitybdd.screenplay.targets.Target;

public class StatusUpdatePage {

    public static final Target SERVICE_LINES =
            Target.the("Service lines").locatedBy(".service-name span");
}
