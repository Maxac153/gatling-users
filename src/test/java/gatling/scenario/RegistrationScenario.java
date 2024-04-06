package gatling.scenario;

import common.helper.SystemProperty;
import gatling.steps.Steps;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.csv;

public class RegistrationScenario {
    public static ScenarioBuilder registration = CoreDsl.scenario("uc_registration_users")
            .exec(session -> session
                    .set("FILE_NAME_READ", SystemProperty.FILE_NAME_READ)
                    .set("FILE_NAME_ADD", SystemProperty.FILE_NAME_ADD)
            )

            // .exec(StsHelper.read)
            .feed(csv("registration/users.csv").circular())
            .exec(Steps.mainPage)
            .exec(Steps.registration)
            .exec(Steps.logout)
            .exec(Steps.mainPage);
            // .exec(StsHelper.add);
}
