package gatling.steps;


import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.http.HttpDsl;

import static io.gatling.javaapi.core.CoreDsl.ElFileBody;
import static io.gatling.javaapi.http.HttpDsl.RawFileBodyPart;

public class Steps {
    public static ChainBuilder mainPage = CoreDsl.exec(
            HttpDsl.http("ur_open_main_page")
                    .get("/")
    );

    public static ChainBuilder logout = CoreDsl.exec(
            HttpDsl.http("ur_logout")
                    .get("/user/logout.html")
    );

    public static ChainBuilder authorization = CoreDsl.exec(
            HttpDsl.http("ur_authentication")
                    .post("/user/login/index.html")
                    .header("Content-Type", "application/json")
                    .body(ElFileBody("authorization/authorization.json")).asJson()
    );

    public static ChainBuilder registration = CoreDsl.exec(
            HttpDsl.http("ur_registration")
                    .post("/tasks/rest/doregister")
                    .body(ElFileBody("registration/registration.json")).asJson()
    );

    public static ChainBuilder loadingAvatar = CoreDsl.exec(
            HttpDsl.http("ur_loading_avatar")
                    .post("/tasks/rest/addavatar")
                    .queryParam("email", "#{email}")
                    .bodyPart(RawFileBodyPart("avatar", "loading_avatar/images/g-12.jpg").contentType("image/jpeg"))
    );

    public static ChainBuilder deleteAvatar = CoreDsl.exec(
            HttpDsl.http("ur_delete_avatar")
                    .delete("/tasks/rest/deleteavatar")
                    .queryParam("email", "#{email}")
    );

    public static ChainBuilder searchUser = CoreDsl.exec(
            HttpDsl.http("ur_search_user")
                    .get("/user/admin/index")
                    .formParam("date_start", "")
                    .formParam("date_end", "")
                    .formParam("d", "#{user_name}")
    );

    public static ChainBuilder deleteUser = CoreDsl.exec(
            HttpDsl.http("ur_delete_user")
                    .get("/user/admin/index")
                    .formParam("q", "#{user_name}")
                    .formParam("date_start", "")
                    .formParam("date_end", "")
                    .formParam("path_grid_asd", "/delete/#{user_id}")
    );
}
