package lk.ijse.devop.user_mircoservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserMircoserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMircoserviceApplication.class, args);
    }
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
