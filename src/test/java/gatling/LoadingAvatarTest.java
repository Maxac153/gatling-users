package gatling;

import gatling.scenario.LoadingAvatarScenario;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class LoadingAvatarTest extends Simulation {
    HttpProtocolBuilder httpProtocol = HttpDsl.http.baseUrl("http://users.bugred.ru");

    public LoadingAvatarTest() {
        this.setUp(
                LoadingAvatarScenario.loadingAvatarScenario.injectOpen(
                        CoreDsl.rampUsers(1).during(1)
                )
        ).protocols(httpProtocol);
    }
}
