package extensions;


import io.restassured.RestAssured;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class RestAssuredExtension implements BeforeAllCallback,AfterAllCallback {

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    RestAssured.port = 80;
    RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    RestAssured.reset();
  }
}