import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import org.junit.Test;
import java.io.IOException;
import java.security.GeneralSecurityException;


public class GetCalendarTest extends BassClass {

    @Test
    public void testGetCalendar() throws IOException, GeneralSecurityException {

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        String accessToken = getCredentials(HTTP_TRANSPORT).getAccessToken();

        System.out.println("What is the token" + accessToken);

        given().
                baseUri("https://www.googleapis.com/calendar/v3/calendars/").
                auth().oauth2(accessToken).
                when().get("/coopletest83@gmail.com").then()
                .log().all()
                .assertThat().statusCode(200).and().contentType(ContentType.JSON);
/*
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

                */
    }


}
