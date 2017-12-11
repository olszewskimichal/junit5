package rest;


import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

import extensions.RestAssuredExtension;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(RestAssuredExtension.class)
public class RestAssureTest {

  @Test
  void executesGetAsExternallyConfigured() {
    get("/comments")
        .then()
        .log().all()
        .statusCode(200);
  }

  @Test
  void should_resource_returns_200_with_expected_id_and_email() {
    get("/comments/{id}", 1).
        then().
        log().all().
        statusCode(200).
        assertThat().
        body("email", equalTo("Eliseo@gardner.biz"));
  }

  @Test
  @Disabled
  void deleteItemShouldReturnNoContent() {
    when()
        .delete("/comments/{id}", 1L)
        .then()
        .statusCode(HttpStatus.SC_NO_CONTENT);
  }

  @Test
  @Disabled
  void deleteItemShouldBeBadRequestIfNonExistingID() {
    when()
        .delete("/comments/{id}", 12345L)
        .then()
        .statusCode(HttpStatus.SC_BAD_REQUEST);
  }

  @Test
  @Disabled
  void updateItemShouldReturnUpdatedItem() {
    // Given an unchecked first item
    given()
        .body(new Object()/**-> domyslne DTO**/)
        .contentType(ContentType.JSON)
        .when()
        .put("/comments/{id}", 4)
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("description", Matchers.is("description"))
        .body("active", Matchers.is(false));
  }

  @Test
  @Disabled
  void updateItemShouldReturnBadRequestWithoutBody() {
    when()
        .put("/comments/{id}", 12345L)
        .then()
        .statusCode(HttpStatus.SC_BAD_REQUEST);
  }
}

