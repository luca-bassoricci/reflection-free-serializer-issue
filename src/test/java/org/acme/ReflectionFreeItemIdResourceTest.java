package org.acme;

import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.QuarkusTestProfile;
import io.quarkus.test.junit.TestProfile;
import io.restassured.RestAssured;

@QuarkusTest
@TestHTTPEndpoint(ItemIdResource.class)
@TestProfile(ReflectionFreeItemIdResourceTest.class)
public class ReflectionFreeItemIdResourceTest implements QuarkusTestProfile
{
    public ReflectionFreeItemIdResourceTest() {
    }

    private final static String EXPECTED = '\"' + new ItemId(240).format() + '\"';

    public Map<String, String> getConfigOverrides() {
        return Map.of("quarkus.rest.jackson.optimization.enable-reflection-free-serializers", "true");
    }

    @Test
    void testGenerate() {
        RestAssured.given()
                .queryParam("value", 240)
                .when().post()
                .then()
                .statusCode(200)
                .body(Matchers.equalTo(EXPECTED));
    }
}
