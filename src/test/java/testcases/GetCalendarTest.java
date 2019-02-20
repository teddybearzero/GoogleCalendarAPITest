package testcases;

import base.BaseClass;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;
import java.security.GeneralSecurityException;


public class GetCalendarTest extends BaseClass {

    public GetCalendarTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){

        try {
            init();
        }
            catch (GeneralSecurityException e){
            System.out.println("General Security Exception Thrown");

        }   catch (IOException e){
            System.out.println("IO Exception thrown");
        }
    }

    @Test
    public void testGetCalendar(){

        System.out.println("What is the token" + accessToken);

        given().
                baseUri("https://www.googleapis.com/calendar/v3/calendars/").
                auth().oauth2(accessToken).
                when().get("/coopletest83@gmail.com").then()
                .log().all()
                .assertThat().statusCode(200).and().contentType(ContentType.JSON);

        given().
                baseUri(calendarUrl).
                auth().oauth2(accessToken).
                when().get(calendarID).then()
                .assertThat().body("id", equalTo("coopletest83@gmail.com"));

        given().
                baseUri(calendarUrl).
                auth().oauth2(accessToken).
                when().get(calendarID).then()
                .assertThat().body("summary", equalTo("coopletest83@gmail.com"));

        given().
                baseUri(calendarUrl).
                auth().oauth2(accessToken).
                when().get("/coopletest83@gmail.com").then()
                .assertThat().body("timeZone", equalTo("Europe/London"));
    }


}
