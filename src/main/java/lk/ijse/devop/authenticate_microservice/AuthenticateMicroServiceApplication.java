package lk.ijse.devop.authenticate_microservice;

import lk.ijse.devop.authenticate_microservice.Config.WeavyCloudApiClient;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthenticateMicroServiceApplication {

    public static void main(String[] args) {
        try {
            WeavyCloudApiClient weavyApiClient = new WeavyCloudApiClient();
            String result = weavyApiClient.getSomeData();
            System.out.println("Result from Weavy: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }

}
