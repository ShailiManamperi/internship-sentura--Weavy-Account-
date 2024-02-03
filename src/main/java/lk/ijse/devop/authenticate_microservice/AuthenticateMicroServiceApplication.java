package lk.ijse.devop.authenticate_microservice;

import lk.ijse.devop.authenticate_microservice.Config.WeavyCloudApiClient;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AuthenticateMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticateMicroServiceApplication.class, args);
    }
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
