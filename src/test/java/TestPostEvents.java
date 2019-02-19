import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static io.restassured.RestAssured.given;

public class TestPostEvents extends BassClass {

    public Event event(){

        Event event = new Event()
                .setSummary("Birthday Party Test")
                .setLocation("Shoreditch High Street")
                .setDescription("A chance to test and talk and test....");

        DateTime startDateTime = new DateTime("2019-05-28T09:00:00-07:00");
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("Europe/London");
        event.setStart(start);

        DateTime endDateTime = new DateTime("2019-05-28T17:00:00-07:00");
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone("Europe/London");
        event.setEnd(end);

        return event;
    }

    @Test
    public void testPostEvents()throws IOException, GeneralSecurityException {

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        String accessToken = BassClass.getCredentials(HTTP_TRANSPORT).getAccessToken();

        Response response = given().
                baseUri(calendarUrl).
                contentType(ContentType.JSON).
                        auth().oauth2(accessToken).
                        body(event()).
                        when().post("coopletest83@gmail.com/events");

        System.out.println("POST Response\n" + response.asString());

    }

}
