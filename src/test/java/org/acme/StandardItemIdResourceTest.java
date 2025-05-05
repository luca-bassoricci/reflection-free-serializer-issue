package org.acme;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
@TestHTTPEndpoint(ItemIdResource.class)
class StandardItemIdResourceTest {
    private final static String EXPECTED = '\"' + new ItemId(240).format() + '\"';

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
