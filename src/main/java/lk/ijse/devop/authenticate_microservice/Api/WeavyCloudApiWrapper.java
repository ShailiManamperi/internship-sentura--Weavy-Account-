package lk.ijse.devop.authenticate_microservice.Api;
import lk.ijse.devop.authenticate_microservice.Config.WeavyCloudApiClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weavy-cloud")
public class WeavyCloudApiWrapper {

    private final WeavyCloudApiClient weavyCloudApiClient;

    public WeavyCloudApiWrapper(WeavyCloudApiClient weavyCloudApiClient) {
        this.weavyCloudApiClient = weavyCloudApiClient;
    }

    @GetMapping("/some-data")
    public ResponseEntity<String> getSomeData() {
        try {
            String result = weavyCloudApiClient.getSomeData();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching data from Weavy cloud");
        }
    }
}

