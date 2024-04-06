package gatling.scenario;


import gatling.steps.Steps;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.ScenarioBuilder;

public class AuthorizationScenario {
    public static ScenarioBuilder authorizationScenario = CoreDsl.scenario("uc_authentication_users")
            .exec(Steps.mainPage)
            .exec(Steps.authorization)
            .exec(Steps.logout)
            .exec(Steps.mainPage);

    public static ScenarioBuilder authorizationAdminScenario = CoreDsl.scenario("uc_authentication_admin_users")
            .exec(session -> session
                    .set("login", "manager@mail.ru")
                    .set("password", "1")
            )
            .exec(Steps.mainPage)
            .exec(Steps.authorization)
            .exec(Steps.logout)
            .exec(Steps.mainPage);
}
