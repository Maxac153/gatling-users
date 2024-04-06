package gatling;

import gatling.scenario.RegistrationScenario;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class RegistrationTest extends Simulation {
    HttpProtocolBuilder httpProtocol = HttpDsl.http.baseUrl("http://users.bugred.ru/");

    public RegistrationTest() {
        this.setUp(
                RegistrationScenario.registration.injectOpen(
                        CoreDsl.constantUsersPerSec(1).during(1)
                )
        ).protocols(httpProtocol);
    }
}
