package pojos.utilities;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;

public class Authentication {


    public static String generateToken(){

        spec.pathParams("first", "api", "second", "authenticate");
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("password", "team88_admin1");
        expectedData.put("rememberMe", true);
        expectedData.put("username", "team_88_admin");

        Response response = given().spec((RequestSpecification) spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}/{second}");

        response.prettyPrint();

        JsonPath json = response.jsonPath();
        return json.getString("id_token");


    }



}
