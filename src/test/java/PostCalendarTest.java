import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.junit.Test;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class PostCalendarTest extends BassClass {

    @Test
    public void postCalendar()throws IOException, GeneralSecurityException {

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        String accessToken = getCredentials(HTTP_TRANSPORT).getAccessToken();


    }

}
