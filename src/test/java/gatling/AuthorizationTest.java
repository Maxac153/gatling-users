package gatling;

import gatling.scenario.AuthorizationScenario;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;


public class AuthorizationTest extends Simulation {
    HttpProtocolBuilder httpProtocol = HttpDsl.http.baseUrl("http://users.bugred.ru");

    public AuthorizationTest() {
        this.setUp(
                AuthorizationScenario.authorizationAdminScenario.injectOpen(
                        constantUsersPerSec(1).during(10),
                        constantUsersPerSec(4).during(20),
                        constantUsersPerSec(1).during(10)

                )
        ).protocols(httpProtocol);
    }

}
