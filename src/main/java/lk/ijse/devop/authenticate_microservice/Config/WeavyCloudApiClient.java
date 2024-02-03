package lk.ijse.devop.authenticate_microservice.Config;

import okhttp3.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.io.IOException;
@CrossOrigin
@Controller
public class WeavyCloudApiClient {
    private static final String BASE_URL = "https://201f546784d14d05a028450762a6fa15.weavy.io/api";
    private final String apiKey = "wys_gQHOQp9r8sGv4YM8TB2g65nAruN8Xw3TN3tI";

    private final OkHttpClient client = new OkHttpClient();

    public String getSomeData() throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "/some-endpoint")
                .header("Authorization", "Bearer " + apiKey)  // Add authorization header
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            return response.body().string();
        }
    }


}
