package gatling.scenario;

import gatling.steps.Steps;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.ScenarioBuilder;

public class LoadingAvatarScenario {
    public static ScenarioBuilder loadingAvatarScenario = CoreDsl.scenario("uc_loading_avatar_users")
            .exec(session -> session
                    .set("email", "manager@mail.ru")
            )
            .exec(Steps.mainPage)
            .exec(Steps.authorization)
            .exec(Steps.loadingAvatar)
            .exec(Steps.logout)
            .exec(Steps.mainPage);
}
